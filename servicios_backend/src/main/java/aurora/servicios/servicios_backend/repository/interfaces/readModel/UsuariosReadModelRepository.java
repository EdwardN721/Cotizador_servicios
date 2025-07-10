package aurora.servicios.servicios_backend.repository.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuariosReadModelRepository {
    List<UsuariosDto> obtenerUsuarios();
    Optional<UsuariosDto> obtenerUsuario(UUID id);
}
