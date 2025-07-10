package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import aurora.servicios.servicios_backend.repository.interfaces.command.EstadosSolicitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaEstadosSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoSolicitudCommandRepositoryImpl implements EstadosSolicitudesCommandRepository {
    private JpaEstadosSolicitudRepository  jpaRepository;

    @Autowired
    public EstadoSolicitudCommandRepositoryImpl(JpaEstadosSolicitudRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public EstadosSolicitudDto crearEstadoSolicitud(EstadosSolicitud estadosSolicitud) {
        jpaRepository.save(estadosSolicitud);
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
        jpaRepository.save(estadosSolicitud);
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
    public void eliminarEstadoSolicitud(Long id) {
        jpaRepository.deleteById(id);
    }
}
