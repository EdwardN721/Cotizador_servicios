package aurora.servicios.servicios_backend.services.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuariosReadModelService {
    List<UsuariosDto> obtenerUsuarios();
    Optional<UsuariosDto> obtenerUsuario(UUID id);
}
