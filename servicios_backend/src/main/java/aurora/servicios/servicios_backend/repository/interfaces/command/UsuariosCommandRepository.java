package aurora.servicios.servicios_backend.repository.interfaces.command;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.models.Usuarios;

import java.util.UUID;

public interface UsuariosCommandRepository {

    UsuariosDto crearUsuario(Usuarios usuario);
    UsuariosDto actualizarUsuario(Usuarios usuario);
    void eliminarUsuario(UUID id);
}
