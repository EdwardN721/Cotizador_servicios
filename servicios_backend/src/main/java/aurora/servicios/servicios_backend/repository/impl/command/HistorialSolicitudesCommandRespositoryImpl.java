package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.HistorialSolicitudesDto;
import aurora.servicios.servicios_backend.models.HistorialSolicitudes;
import aurora.servicios.servicios_backend.repository.interfaces.command.HistorialSolicitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaHistorialSolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class HistorialSolicitudesCommandRespositoryImpl implements HistorialSolicitudesCommandRepository{
    private final JpaHistorialSolicitudesRepository jpaRepository;

    @Autowired
    public HistorialSolicitudesCommandRespositoryImpl(JpaHistorialSolicitudesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public HistorialSolicitudesDto crearHistorial(HistorialSolicitudes historial) {
        jpaRepository.save(historial);
        return new HistorialSolicitudesDto(
                historial.getId(),
                historial.getSolicitud(),
                historial.getCampoModificado(),
                historial.getValorAnterior(),
                historial.getValorNuevo(),
                historial.getUsuario(),
                historial.getFechaCambio(),
                historial.getComentario()
        );
    }

    @Override
    public HistorialSolicitudesDto actualizarHistorial(HistorialSolicitudes historial) {
        jpaRepository.save(historial);
        return new HistorialSolicitudesDto(
                historial.getId(),
                historial.getSolicitud(),
                historial.getCampoModificado(),
                historial.getValorAnterior(),
                historial.getValorNuevo(),
                historial.getUsuario(),
                historial.getFechaCambio(),
                historial.getComentario()
        );
    }

    @Override
    public void eliminarHistorial(UUID id) {
        jpaRepository.deleteById(id);
    }
}
