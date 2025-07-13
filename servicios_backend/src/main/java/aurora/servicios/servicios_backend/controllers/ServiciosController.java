package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.application.command.servicios.ActualizarServicioCommand;
import aurora.servicios.servicios_backend.application.command.servicios.CrearServicioCommand;
import aurora.servicios.servicios_backend.application.command.servicios.EliminarServicioCommand;
import aurora.servicios.servicios_backend.application.command.servicios.handlers.ServiciosCommandHandler;
import aurora.servicios.servicios_backend.application.query.clientes.ObtenerClientePorIdQuery;
import aurora.servicios.servicios_backend.application.query.servicios.ObtenerServicioPorIdQuery;
import aurora.servicios.servicios_backend.application.query.servicios.ObtenerServiciosQuery;
import aurora.servicios.servicios_backend.application.query.servicios.handlers.ServiciosQueryHandler;
import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/servicios")
public class ServiciosController {
    private final ServiciosCommandHandler commandHandler;
    private final ServiciosQueryHandler queryHandler;

    @Autowired
    public ServiciosController(ServiciosCommandHandler commandHandler, ServiciosQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public ResponseEntity<List<ServiciosDto>> obtenerServicios(){
        ObtenerServiciosQuery query = new ObtenerServiciosQuery();
        List<ServiciosDto> respuesta = queryHandler.obtenerServicios(query);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosDto> obtenerServicio(@PathVariable UUID id){
        ObtenerServicioPorIdQuery query = new ObtenerServicioPorIdQuery(id);
        return queryHandler.obtenerServicioPorId(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServiciosDto> crearServicio(@Valid @RequestBody CrearServicioCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandHandler.crearServicio(command));
    }

    @PutMapping
    public ResponseEntity<ServiciosDto> actualizarServicio(@Valid @RequestBody ActualizarServicioCommand command){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandHandler.actualizarServicio(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable UUID id){
        EliminarServicioCommand command = new EliminarServicioCommand(id);
        commandHandler.eliminarServicio(command);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
