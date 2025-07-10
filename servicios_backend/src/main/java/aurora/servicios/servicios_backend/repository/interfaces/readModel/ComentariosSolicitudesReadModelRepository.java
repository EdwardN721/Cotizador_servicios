package aurora.servicios.servicios_backend.repository.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComentariosSolicitudesReadModelRepository {
    List<ComentariosSolicitudesDto> obtenerComentarios();
    Optional<ComentariosSolicitudesDto> obtenerComentariosPorId(UUID id);
}
