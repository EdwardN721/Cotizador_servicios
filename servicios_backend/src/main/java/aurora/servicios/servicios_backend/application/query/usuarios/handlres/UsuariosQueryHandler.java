package aurora.servicios.servicios_backend.application.query.usuarios.handlres;

import aurora.servicios.servicios_backend.application.query.usuarios.ObtenerUsuarioPorIdQuery;
import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.models.Usuarios;
import aurora.servicios.servicios_backend.services.interfaces.readModel.UsuariosReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuariosQueryHandler {
    private final UsuariosReadModelService service;

    @Autowired
    public UsuariosQueryHandler(UsuariosReadModelService service) {
        this.service = service;
    }

    public List<UsuariosDto> ObtenerUsuarios() {
        return service.obtenerUsuarios();
    }

    public Optional<UsuariosDto> ObtenerUsuarioPorId(ObtenerUsuarioPorIdQuery query) {
        return service.obtenerUsuario(query.getId())
                .map(usuario -> new UsuariosDto(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getUsuario(),
                        usuario.getPassword_hash(),
                        usuario.getActivo(),
                        usuario.getRol(),
                        usuario.getUltimoAcceso(),
                        usuario.getCreatedAt(),
                        usuario.getUpdatedAt()));
    }
}
