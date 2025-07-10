package aurora.servicios.servicios_backend.services.interfaces.command;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.models.Usuarios;

import java.util.UUID;

public interface UsuariosCommandService {

    UsuariosDto crearUsuario(Usuarios usuario);
    UsuariosDto actualizarUsuario(Usuarios usuario);
    void eliminarUsuario(UUID id);
}
