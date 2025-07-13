package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.application.command.estadoSolicitud.ActualizarEstadoSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.estadoSolicitud.CrearEstadoSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.estadoSolicitud.EliminarEstadoSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.estadoSolicitud.handler.EstadoSolicitudCommandHandler;
import aurora.servicios.servicios_backend.application.query.estadoSolicitud.ObtenerEstadoSolicitudPorIdQuery;
import aurora.servicios.servicios_backend.application.query.estadoSolicitud.ObtenerEstadosSolicitudQuery;
import aurora.servicios.servicios_backend.application.query.estadoSolicitud.handler.EstadoSolicitudQueryHandler;
import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estado")
public class EstadoSolicitudController {
    private final EstadoSolicitudCommandHandler commandHandler;
    private final EstadoSolicitudQueryHandler queryHandler;

    @Autowired
    public EstadoSolicitudController(EstadoSolicitudCommandHandler commandHandler, EstadoSolicitudQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public ResponseEntity<List<EstadosSolicitudDto>> obtenerEstadosSolicitud(){
        ObtenerEstadosSolicitudQuery query = new ObtenerEstadosSolicitudQuery();
        List<EstadosSolicitudDto> respuesta = queryHandler.obtenerEstadosSolicitud(query);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadosSolicitudDto> obtenerEstadosSolicitud(@PathVariable Long id){
        ObtenerEstadoSolicitudPorIdQuery query = new ObtenerEstadoSolicitudPorIdQuery(id);
        return queryHandler.obtenerEstadoSolicitudPorId(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadosSolicitudDto> crearEstadoSolicitud(@Valid @RequestBody CrearEstadoSolicitudCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandHandler.crearEstadoSolicitud(command));
    }

    @PutMapping
    public ResponseEntity<EstadosSolicitudDto> actualizarEstadoSolicitud(@Valid @RequestBody ActualizarEstadoSolicitudCommand command){
        return ResponseEntity.status(HttpStatus.OK).body(commandHandler.actualizarEstadoSolicitud(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstadoSolicitud(@PathVariable Long id){
        EliminarEstadoSolicitudCommand command = new EliminarEstadoSolicitudCommand(id);
        commandHandler.eliminarEstadoSolicitud(command);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
