package aurora.servicios.servicios_backend.application.command.usuarios.handlers;

import aurora.servicios.servicios_backend.application.command.usuarios.ActualizarUsuarioCommand;
import aurora.servicios.servicios_backend.application.command.usuarios.CrearUsuarioCommand;
import aurora.servicios.servicios_backend.application.command.usuarios.EliminarUsuarioCommand;
import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.models.Usuarios;
import aurora.servicios.servicios_backend.services.interfaces.command.UsuariosCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuariosCommandHandler {
    private final UsuariosCommandService service;

    @Autowired
    public UsuariosCommandHandler(UsuariosCommandService service) {
        this.service = service;
    }

    public UsuariosDto crearUsuario(CrearUsuarioCommand command) {
        Usuarios usuario = new Usuarios(command.getNombre(), command.getApellido(), command.getUsuario(), command.getPassword_hash(),
                command.getActivo(), command.getRol());
        return service.crearUsuario(usuario);
    }

    public  void eliminarUsuario(EliminarUsuarioCommand command) {
        service.eliminarUsuario(command.getId());
    }

    public UsuariosDto ActualizarUsuario(ActualizarUsuarioCommand command) {
        Usuarios usuario = new Usuarios(command.getId(),command.getNombre(), command.getApellido(), command.getUsuario(), command.getPassword_hash(),
                command.getActivo(), command.getRol());
        return service.actualizarUsuario(usuario);
    }
}
