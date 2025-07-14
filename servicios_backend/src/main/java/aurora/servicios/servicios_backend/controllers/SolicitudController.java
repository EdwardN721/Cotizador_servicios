package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.application.command.solicitudes.ActualizarSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.solicitudes.CrearSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.solicitudes.EliminarSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.solicitudes.handlers.SolicitudesCommandHandler;
import aurora.servicios.servicios_backend.application.query.solicitudes.ObtenerSolicitudPorIdQuery;
import aurora.servicios.servicios_backend.application.query.solicitudes.ObtenerSolicitudesQuery;
import aurora.servicios.servicios_backend.application.query.solicitudes.handlers.SolicitudesQueryHandler;
import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/solicitudes")
public class SolicitudController {
    private final SolicitudesCommandHandler commandHandler;
    private final SolicitudesQueryHandler queryHandler;

    @Autowired
    public SolicitudController(SolicitudesCommandHandler commandHandler, SolicitudesQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudesDto>> obtenerSolicitudes(){
        ObtenerSolicitudesQuery query = new ObtenerSolicitudesQuery();
        List<SolicitudesDto> response = queryHandler.obtenerSolicitudes(query);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudesDto> obtenerSolicitudPorId(@PathVariable UUID id){
        ObtenerSolicitudPorIdQuery query = new ObtenerSolicitudPorIdQuery(id);
        return queryHandler.obtenerSolicitudPorId(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SolicitudesDto> crearSolicitud(@Valid @RequestBody CrearSolicitudCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandHandler.crearSolicitud(command));
    }

    @PutMapping
    public ResponseEntity<SolicitudesDto>  actualizarSolicitud(@Valid @RequestBody ActualizarSolicitudCommand command){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandHandler.actualizarSolicitud(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable UUID id){
        EliminarSolicitudCommand command = new EliminarSolicitudCommand(id);
        commandHandler.eliminarSolicitud(command);
        return ResponseEntity.noContent().build();
    }
}
