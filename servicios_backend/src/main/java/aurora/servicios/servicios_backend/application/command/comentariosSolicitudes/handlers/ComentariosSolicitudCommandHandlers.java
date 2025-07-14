package aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.handlers;

import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.ActualizarComentarioCommand;
import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.CrearComentarioCommand;
import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.EliminarComentarioCommand;
import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;
import aurora.servicios.servicios_backend.services.interfaces.command.ComentariosSolcitudesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ComentariosSolicitudCommandHandlers {
    private final ComentariosSolcitudesCommandService service;

    @Autowired
    public ComentariosSolicitudCommandHandlers (ComentariosSolcitudesCommandService service) {
    this.service = service;
    }

    public ComentariosSolicitudesDto crearComentario(CrearComentarioCommand command) {
        ComentariosSolicitudes comentario = new ComentariosSolicitudes(command.solicitud(), command.usuario(), command.comentario(), command.esInterno());
        return service.crearComentario(comentario);
    }

    public ComentariosSolicitudesDto actualizarComentario(ActualizarComentarioCommand command) {
        ComentariosSolicitudes comentario = new ComentariosSolicitudes(command.id(), command.solicitud(), command.usuario(), command.comentario(), command.esInterno());
        return service.actualizarComentario(comentario);
    }

    public void eliminarComentario(EliminarComentarioCommand command) {
        service.eliminarComentario(command.id());
    }
}
