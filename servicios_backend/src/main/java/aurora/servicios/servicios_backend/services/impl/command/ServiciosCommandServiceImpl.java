package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import aurora.servicios.servicios_backend.models.Servicios;
import aurora.servicios.servicios_backend.repository.interfaces.command.ServiciosCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ServiciosReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.EstadosSolicitudesCommandService;
import aurora.servicios.servicios_backend.services.interfaces.command.ServiciosCommandService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiciosCommandServiceImpl implements ServiciosCommandService {
    private final ServiciosCommandRepository repositorio;
    private final ServiciosReadModelRepository readRepository;

    public  ServiciosCommandServiceImpl(ServiciosCommandRepository repositorio, ServiciosReadModelRepository readRepository) {
        this.repositorio = repositorio;
        this.readRepository = readRepository;
    }

    @Override
    public ServiciosDto crearServicio(Servicios servicio) {
        if(servicio==null){
            throw new IllegalArgumentException("Servicios no pudo ser nulo.");
        }

        repositorio.crearServicio(servicio);
        return new ServiciosDto(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getCategoria(),
                servicio.getPrecio_estimado(),
                servicio.getTiempo_estimado_dias(),
                servicio.getActivo(),
                servicio.getCreatedAt(),
                servicio.getUpdatedAt()
        );
    }

    @Override
    public ServiciosDto actualizarServicio(Servicios servicio) {
        ServiciosDto dto = readRepository.obtenerServicio(servicio.getId())
                .orElseThrow(() -> new RuntimeException("El servicio no se encontró con el ID: " + servicio.getId()));
        Servicios servicioActualizado = new  Servicios();

        servicioActualizado.setId(dto.getId());
        servicioActualizado.setNombre(servicio.getNombre() != null ? servicio.getNombre() : dto.getNombre());
        servicioActualizado.setDescripcion(servicio.getDescripcion() != null ? servicio.getDescripcion() : dto.getDescripcion());
        servicioActualizado.setCategoria(servicio.getCategoria() != null ? servicio.getCategoria() : dto.getCategoria());
        servicioActualizado.setPrecio_estimado(servicio.getPrecio_estimado() != null ? servicio.getPrecio_estimado() : dto.getPrecio_estimado());
        servicioActualizado.setTiempo_estimado_dias(servicio.getTiempo_estimado_dias() != null ? servicio.getTiempo_estimado_dias() : dto.getTiempo_estimado_dias());
        servicioActualizado.setActivo(servicio.getActivo() != null ? servicio.getActivo() : dto.getActivo());
        servicioActualizado.setCreatedAt(dto.getCreatedAt());
        servicioActualizado.setUpdatedAt(dto.getUpdatedAt());

        return repositorio.actualizarServicio(servicioActualizado);
    }

    @Override
    public void eliminarServicio(UUID id) {
        ServiciosDto dto = readRepository.obtenerServicio(id)
                .orElseThrow(() -> new RuntimeException("El servicio no se encontró con el ID: " + id));

        if(dto.getActivo()==null){
            throw new RuntimeException("El servicio no se encontró.");
        }

        repositorio.eliminarServicio(dto.getId());
    }
}
