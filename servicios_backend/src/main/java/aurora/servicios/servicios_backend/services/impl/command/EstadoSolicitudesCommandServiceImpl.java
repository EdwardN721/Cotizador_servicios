package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import aurora.servicios.servicios_backend.repository.impl.command.EstadoSolicitudCommandRepositoryImpl;
import aurora.servicios.servicios_backend.repository.interfaces.command.EstadosSolicitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.EstadosSolicitudReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.EstadosSolicitudesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoSolicitudesCommandServiceImpl implements EstadosSolicitudesCommandService {
    private final EstadosSolicitudesCommandRepository repositorio;
    private final EstadosSolicitudReadModelRepository  readRepository;

    @Autowired
    public EstadoSolicitudesCommandServiceImpl(EstadosSolicitudesCommandRepository repositorio, EstadosSolicitudReadModelRepository readRepository){
        this.repositorio = repositorio;
        this.readRepository = readRepository;
    }

    @Override
    public EstadosSolicitudDto crearEstadoSolicitud(EstadosSolicitud estadosSolicitud) {
        if (estadosSolicitud == null) {
            throw new IllegalArgumentException("El estado solicitud no puede ser nulo");
        }

        repositorio.crearEstadoSolicitud(estadosSolicitud);
        return new EstadosSolicitudDto(
                estadosSolicitud.getId(),
                estadosSolicitud.getNombre(),
                estadosSolicitud.getDescripcion(),
                estadosSolicitud.getColor(),
                estadosSolicitud.getOrden(),
                estadosSolicitud.getActivo()
        );
    }

    @Override
    public EstadosSolicitudDto actualizarEstadoSolicitud(EstadosSolicitud estadosSolicitud) {
        EstadosSolicitudDto estadosSolicitudDto = readRepository.obtenerEstadoSolicitudPorId(estadosSolicitud.getId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con el ID: " + estadosSolicitud.getId()));
        EstadosSolicitud estadoActualziado = new EstadosSolicitud();

        estadoActualziado.setId(estadosSolicitudDto.getId());
        estadoActualziado.setNombre(estadosSolicitud.getNombre() != null ?  estadosSolicitud.getNombre() : estadosSolicitudDto.getNombre());
        estadoActualziado.setDescripcion(estadosSolicitud.getDescripcion() != null ? estadosSolicitud.getDescripcion() : estadosSolicitudDto.getDescripcion());
        estadoActualziado.setOrden(estadosSolicitud.getColor() != null ? estadosSolicitud.getOrden() : estadosSolicitudDto.getOrden());
        estadoActualziado.setActivo(estadosSolicitud.getActivo() != null ?  estadosSolicitud.getActivo() : estadosSolicitudDto.getActivo());

        return repositorio.actualizarEstadoSolicitud(estadoActualziado);
    }

    @Override
    public void eliminarEstadoSolicitud(Long id) {
        EstadosSolicitudDto estadosSolicitudDto = readRepository.obtenerEstadoSolicitudPorId(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con el ID: " + id));

        if (estadosSolicitudDto == null) {
            throw new IllegalArgumentException("El estado solicitud no puede ser nulo");
        }

        repositorio.eliminarEstadoSolicitud(estadosSolicitudDto.getId());
    }
}
