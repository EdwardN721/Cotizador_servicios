package aurora.servicios.servicios_backend.repository.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SolicitudesReadModelRepository {
    List<SolicitudesDto> obtenerSolicitudes();
    Optional<SolicitudesDto> obtenerSolicitudPorId(UUID id);
}
