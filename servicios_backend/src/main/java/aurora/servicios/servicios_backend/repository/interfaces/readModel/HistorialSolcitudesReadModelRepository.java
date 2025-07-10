package aurora.servicios.servicios_backend.repository.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.HistorialSolicitudesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HistorialSolcitudesReadModelRepository {
    List<HistorialSolicitudesDto> obtenerHistorialSolcitudes();
    Optional<HistorialSolicitudesDto> ObtenerHistorialSolicitudesPorId(UUID id);
}
