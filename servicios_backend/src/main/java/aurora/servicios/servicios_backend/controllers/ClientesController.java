package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.application.command.clientes.ActualizarClienteCommand;
import aurora.servicios.servicios_backend.application.command.clientes.CrearClienteCommand;
import aurora.servicios.servicios_backend.application.command.clientes.EliminarClienteCommand;
import aurora.servicios.servicios_backend.application.command.clientes.handlers.ClientesCommandHandler;
import aurora.servicios.servicios_backend.application.query.clientes.ObtenerClientePorIdQuery;
import aurora.servicios.servicios_backend.application.query.clientes.ObtenerClientesQuery;
import aurora.servicios.servicios_backend.application.query.clientes.handlers.ClientesQueryHandler;
import aurora.servicios.servicios_backend.dtos.ClientesDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/clientes")
public class ClientesController {
    private final ClientesCommandHandler commandHandler;
    private final ClientesQueryHandler queryHandler;

    @Autowired
    public ClientesController(ClientesCommandHandler commandHandler, ClientesQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public ResponseEntity<List<ClientesDto>> obtenerClientes(){
        ObtenerClientesQuery query = new ObtenerClientesQuery();
        List<ClientesDto> respuesta = queryHandler.obtenerClientes(query);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesDto> obtenerClientePorId(@PathVariable UUID id){
        ObtenerClientePorIdQuery query = new ObtenerClientePorIdQuery(id);
        return queryHandler.obtenerClientesPorId(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientesDto> crearCliente(@Valid @RequestBody CrearClienteCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandHandler.crearCliente(command));
    }

    @PutMapping
    public ResponseEntity<ClientesDto> actualizarCliente(@Valid @RequestBody ActualizarClienteCommand command){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandHandler.actualizarCliente(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable UUID id){
        EliminarClienteCommand command = new EliminarClienteCommand(id);
        commandHandler.eliminarCliente(command);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
