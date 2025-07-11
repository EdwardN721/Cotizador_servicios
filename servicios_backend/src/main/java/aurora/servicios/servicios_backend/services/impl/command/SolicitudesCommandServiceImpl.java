package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.repository.interfaces.command.SolicitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.SolicitudesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.SolicitudesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SolicitudesCommandServiceImpl implements SolicitudesCommandService {
    private final SolicitudesCommandRepository repositorio;
    private final SolicitudesReadModelRepository readRepository;

    @Autowired
    public SolicitudesCommandServiceImpl(SolicitudesCommandRepository repositorio, SolicitudesReadModelRepository readRepository) {
        this.repositorio = repositorio;
        this.readRepository = readRepository;
    }

    @Override
    public SolicitudesDto crearSolicitud(Solicitudes solicitud) {
        if(solicitud == null) {
            throw new IllegalArgumentException("Solicitud no puede ser nulo.");
        }

        repositorio.crearSolicitud(solicitud);

        return new SolicitudesDto(
                solicitud.getId(),
                solicitud.getNumeroSolicitud(),
                solicitud.getCliente(),
                solicitud.getServicio(),
                solicitud.getServicioPersonalizado(),
                solicitud.getDescripcion(),
                solicitud.getPresupuestoEstimado(),
                solicitud.getPrioridad(),
                solicitud.getFechaSolicitud(),
                solicitud.getFechaEstimacion(),
                solicitud.getFechaInicio(),
                solicitud.getFechaCierre(),
                solicitud.getEstado(),
                solicitud.getUsuarioAsignado(),
                solicitud.getOrigen(),
                solicitud.getNotasInternas(),
                solicitud.getNotasCliente(),
                solicitud.getCreatedAt(),
                solicitud.getUpdatedAt(),
                solicitud.getCreadoPor(),
                solicitud.getActualizadoPor()
        );
    }

    @Override
    public SolicitudesDto actualizarSolicitud(Solicitudes solicitud) {
        SolicitudesDto dto = readRepository.obtenerSolicitud(solicitud.getId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con el ID: " + solicitud.getId()));
        Solicitudes solicitudActualizada = new Solicitudes();

        solicitudActualizada.setId(dto.getId());
        solicitudActualizada.setNumeroSolicitud(solicitud.getNumeroSolicitud() != null ? solicitud.getNumeroSolicitud() : dto.getNumeroSolicitud());
        solicitudActualizada.setCliente(solicitud.getCliente() != null ? solicitud.getCliente() : dto.getCliente());
        solicitudActualizada.setServicio(solicitud.getServicio() != null ? solicitud.getServicio() : dto.getServicio());
        solicitudActualizada.setServicioPersonalizado(solicitud.getServicioPersonalizado() != null ? solicitud.getServicioPersonalizado() : dto.getServicioPersonalizado());
        solicitudActualizada.setDescripcion(solicitud.getDescripcion() != null ? solicitud.getDescripcion() : dto.getDescripcion());
        solicitudActualizada.setPresupuestoEstimado(solicitud.getPresupuestoEstimado() != null ? solicitud.getPresupuestoEstimado() : dto.getPresupuestoEstimado());
        solicitudActualizada.setPrioridad(solicitud.getPrioridad() != null ? solicitud.getPrioridad() : dto.getPrioridad());
        solicitudActualizada.setFechaSolicitud(solicitud.getFechaSolicitud() != null ? solicitud.getFechaSolicitud() : dto.getFechaSolicitud());
        solicitudActualizada.setFechaEstimacion(solicitud.getFechaEstimacion() != null ? solicitud.getFechaEstimacion() : dto.getFechaEstimacion());
        solicitudActualizada.setFechaInicio(solicitud.getFechaInicio() != null ? solicitud.getFechaInicio() : dto.getFechaInicio());
        solicitudActualizada.setEstado(solicitud.getEstado() != null ? solicitud.getEstado() : dto.getEstado());
        solicitudActualizada.setUsuarioAsignado(solicitud.getUsuarioAsignado() != null ? solicitud.getUsuarioAsignado() : dto.getUsuarioAsignado());
        solicitudActualizada.setOrigen(solicitud.getOrigen() != null ? solicitud.getOrigen() : dto.getOrigen());
        solicitudActualizada.setNotasInternas(solicitud.getNotasInternas() != null ? solicitud.getNotasInternas() : dto.getNotasInternas());
        solicitudActualizada.setNotasCliente(solicitud.getNotasCliente() != null ? solicitud.getNotasCliente() : dto.getNotasCliente());
        solicitudActualizada.setCreatedAt(dto.getCreatedAt());
        solicitudActualizada.setUpdatedAt(dto.getUpdatedAt());
        solicitudActualizada.setCreadoPor(dto.getCreadoPor());
        solicitudActualizada.setActualizadoPor(dto.getActualizadoPor());

        return repositorio.actualizarSolicitud(solicitudActualizada);
    }

    @Override
    public void eliminarSolicitud(UUID id) {
        SolicitudesDto dto = readRepository.obtenerSolicitud(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con el ID: " + id));

        if(dto == null) {
            throw new IllegalArgumentException("El campo de ID no puede estar vacio.");
        }

        repositorio.eliminarSolicitud(dto.getId());
    }
}
