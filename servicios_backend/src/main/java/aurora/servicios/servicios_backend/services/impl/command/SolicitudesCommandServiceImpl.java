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

        System.out.println(solicitud);
        return repositorio.crearSolicitud(solicitud);
    }

    @Override
    public SolicitudesDto actualizarSolicitud(Solicitudes solicitud) {
        SolicitudesDto dto = readRepository.obtenerSolicitudPorId(solicitud.getId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con el ID: " + solicitud.getId()));
        Solicitudes solicitudActualizada = new Solicitudes();

        solicitudActualizada.setId(dto.id());
        solicitudActualizada.setNumeroSolicitud(solicitud.getNumeroSolicitud() != null ? solicitud.getNumeroSolicitud() : dto.numeroSolicitud());
        solicitudActualizada.setCliente(solicitud.getCliente() != null ? solicitud.getCliente() : dto.cliente());
        solicitudActualizada.setServicio(solicitud.getServicio() != null ? solicitud.getServicio() : dto.servicio());
        solicitudActualizada.setServicioPersonalizado(solicitud.getServicioPersonalizado() != null ? solicitud.getServicioPersonalizado() : dto.servicioPersonalizado());
        solicitudActualizada.setDescripcion(solicitud.getDescripcion() != null ? solicitud.getDescripcion() : dto.descripcion());
        solicitudActualizada.setPresupuestoEstimado(solicitud.getPresupuestoEstimado() != null ? solicitud.getPresupuestoEstimado() : dto.presupuestoEstimado());
        solicitudActualizada.setPrioridad(solicitud.getPrioridad() != null ? solicitud.getPrioridad() : dto.prioridad());
        solicitudActualizada.setFechaSolicitud(solicitud.getFechaSolicitud() != null ? solicitud.getFechaSolicitud() : dto.fechaSolicitud());
        solicitudActualizada.setFechaEstimacion(solicitud.getFechaEstimacion() != null ? solicitud.getFechaEstimacion() : dto.fechaEstimacion());
        solicitudActualizada.setFechaInicio(solicitud.getFechaInicio() != null ? solicitud.getFechaInicio() : dto.fechaInicio());
        solicitudActualizada.setEstado(solicitud.getEstado() != null ? solicitud.getEstado() : dto.estado());
        solicitudActualizada.setUsuarioAsignado(solicitud.getUsuarioAsignado() != null ? solicitud.getUsuarioAsignado() : dto.usuarioAsignado());
        solicitudActualizada.setOrigen(solicitud.getOrigen() != null ? solicitud.getOrigen() : dto.origen());
        solicitudActualizada.setNotasInternas(solicitud.getNotasInternas() != null ? solicitud.getNotasInternas() : dto.notasInternas());
        solicitudActualizada.setNotasCliente(solicitud.getNotasCliente() != null ? solicitud.getNotasCliente() : dto.notasCliente());
        solicitudActualizada.setCreatedAt(dto.createdAt());
        solicitudActualizada.setUpdatedAt(dto.updatedAt());
        solicitudActualizada.setCreadoPor(dto.creadoPor());
        solicitudActualizada.setActualizadoPor(dto.actualizadoPor());

        return repositorio.actualizarSolicitud(solicitudActualizada);
    }

    @Override
    public void eliminarSolicitud(UUID id) {
        SolicitudesDto dto = readRepository.obtenerSolicitudPorId(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con el ID: " + id));

        if(dto == null) {
            throw new IllegalArgumentException("El campo de ID no puede estar vacio.");
        }

        repositorio.eliminarSolicitud(dto.id());
    }
}
