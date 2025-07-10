package aurora.servicios.servicios_backend.services.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComentariosSolicitudesReadModelService {
    List<ComentariosSolicitudesDto> obtenerComentarios();
    Optional<ComentariosSolicitudesDto> obtenerComentariosPorId(UUID id);
}
