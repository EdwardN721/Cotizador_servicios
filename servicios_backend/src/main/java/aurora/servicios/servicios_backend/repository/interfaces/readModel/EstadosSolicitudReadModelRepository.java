package aurora.servicios.servicios_backend.repository.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;

import java.util.List;
import java.util.Optional;

public interface EstadosSolicitudReadModelRepository {
    List<EstadosSolicitudDto> obtenerEstadosSolicitud();
    Optional<EstadosSolicitudDto> obtenerEstadoSolicitudPorId(Long id);
}
