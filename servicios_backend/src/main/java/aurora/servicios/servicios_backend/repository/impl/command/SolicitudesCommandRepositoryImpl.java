package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.repository.interfaces.command.SolicitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaSolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SolicitudesCommandRepositoryImpl implements SolicitudesCommandRepository {
    private final JpaSolicitudesRepository jpaRepository;

    @Autowired
    public SolicitudesCommandRepositoryImpl(JpaSolicitudesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public SolicitudesDto crearSolicitud(Solicitudes solicitud) {
        jpaRepository.save(solicitud);
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
        jpaRepository.save(solicitud);
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
    public void eliminarSolicitud(UUID id) {
        jpaRepository.deleteById(id);
    }
}
