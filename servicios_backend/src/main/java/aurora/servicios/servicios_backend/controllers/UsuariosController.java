package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.application.command.usuarios.ActualizarUsuarioCommand;
import aurora.servicios.servicios_backend.application.command.usuarios.CrearUsuarioCommand;
import aurora.servicios.servicios_backend.application.command.usuarios.EliminarUsuarioCommand;
import aurora.servicios.servicios_backend.application.command.usuarios.handlers.UsuariosCommandHandler;
import aurora.servicios.servicios_backend.application.query.usuarios.ObtenerUsuarioPorIdQuery;

import aurora.servicios.servicios_backend.application.query.usuarios.handlres.UsuariosQueryHandler;
import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {
    private final UsuariosCommandHandler commandHandler;
    private final UsuariosQueryHandler queryHandler;

    @Autowired
    public UsuariosController(UsuariosCommandHandler commandHandler, UsuariosQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDto>> obtenerUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(queryHandler.ObtenerUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDto> obtenerUsuarioPorId(@PathVariable UUID id) {
        ObtenerUsuarioPorIdQuery query = new ObtenerUsuarioPorIdQuery(id);
        return  queryHandler.ObtenerUsuarioPorId(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuariosDto> crearUsuario(@RequestBody CrearUsuarioCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandHandler.crearUsuario(command));
    }

    @PutMapping()
    public ResponseEntity<UsuariosDto> actualizarUsuario(@RequestBody ActualizarUsuarioCommand command) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandHandler.ActualizarUsuario(command));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable UUID id) {
        EliminarUsuarioCommand command = new EliminarUsuarioCommand(id);
        commandHandler.eliminarUsuario(command);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


