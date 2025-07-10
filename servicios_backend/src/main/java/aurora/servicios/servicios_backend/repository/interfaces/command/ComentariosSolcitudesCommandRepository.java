package aurora.servicios.servicios_backend.repository.interfaces.command;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;

import java.util.UUID;

public interface ComentariosSolcitudesCommandRepository {
    ComentariosSolicitudesDto crearComentario(ComentariosSolicitudes comentario);
    ComentariosSolicitudesDto actualizarComentario(ComentariosSolicitudes comentario);
    void eliminarComentario(UUID id);
}
