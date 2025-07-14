package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.ActualizarComentarioCommand;
import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.CrearComentarioCommand;
import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.EliminarComentarioCommand;
import aurora.servicios.servicios_backend.application.command.comentariosSolicitudes.handlers.ComentariosSolicitudCommandHandlers;
import aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.ObtenerComentariosPorIdQuery;
import aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.ObtenerComentariosQuery;
import aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.handlers.ComentariosSolicitudQueryHandler;
import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/comentarios")
public class ComentariosSolicitudController {
    private final ComentariosSolicitudCommandHandlers commandHandlers;
    private final ComentariosSolicitudQueryHandler queryHandler;

    @Autowired
    public ComentariosSolicitudController(ComentariosSolicitudCommandHandlers commandHandlers, ComentariosSolicitudQueryHandler queryHandler) {
        this.commandHandlers = commandHandlers;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public ResponseEntity<List<ComentariosSolicitudesDto>> obtenerComentarios(){
        ObtenerComentariosQuery query = new ObtenerComentariosQuery();
        List<ComentariosSolicitudesDto> resultado = queryHandler.obtenerComentarios(query);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentariosSolicitudesDto> obtenerComentariosPorId(@PathVariable UUID id){
        ObtenerComentariosPorIdQuery query = new ObtenerComentariosPorIdQuery(id);
        return queryHandler.obtenerComentariosPorId(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ComentariosSolicitudesDto> crearComentario(@Valid @RequestBody CrearComentarioCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandHandlers.crearComentario(command));
    }

    @PutMapping
    public ResponseEntity<ComentariosSolicitudesDto>  actualizarComentario(@Valid @RequestBody ActualizarComentarioCommand command){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandHandlers.actualizarComentario(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable UUID id){
        EliminarComentarioCommand command = new EliminarComentarioCommand(id);
        commandHandlers.eliminarComentario(command);
        return ResponseEntity.noContent().build();
    }
}
