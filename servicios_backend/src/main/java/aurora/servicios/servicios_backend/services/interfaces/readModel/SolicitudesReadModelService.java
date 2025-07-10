package aurora.servicios.servicios_backend.services.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SolicitudesReadModelService {
    List<SolicitudesDto> obtenerSolicitudes();
    Optional<SolicitudesDto> obtenerSolicitud(UUID id);
}
