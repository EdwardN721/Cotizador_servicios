package aurora.servicios.servicios_backend.services.interfaces.command;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;

import java.util.UUID;

public interface ComentariosSolcitudesCommandService {
    ComentariosSolicitudesDto crearComentario(ComentariosSolicitudes comentario);
    ComentariosSolicitudesDto actualizarComentario(ComentariosSolicitudes comentario);
    void eliminarComentario(UUID id);
}
