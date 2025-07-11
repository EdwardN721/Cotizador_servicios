package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.models.Usuarios;
import aurora.servicios.servicios_backend.repository.interfaces.command.UsuariosCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.UsuariosReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.UsuariosCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuariosCommandServiceImpl implements UsuariosCommandService {
    private final UsuariosCommandRepository repository;
    private final UsuariosReadModelRepository readRepository;

    @Autowired
    public UsuariosCommandServiceImpl(UsuariosCommandRepository repository, UsuariosReadModelRepository readRepository) {
        this.repository = repository;
        this.readRepository = readRepository;
    }

    @Override
    public UsuariosDto crearUsuario(Usuarios usuario) {
        if(usuario == null) {
            throw new IllegalArgumentException("El usuario no puede estar vacio.");
        }
        return repository.crearUsuario(usuario);
    }

    @Override
    public UsuariosDto actualizarUsuario(Usuarios usuario) {
        UsuariosDto dto = readRepository.obtenerUsuario(usuario.getId())
                .orElseThrow(() -> new IllegalArgumentException("El usuario no encontró con el ID: " + usuario.getId()));
        Usuarios usuarioActualizado = new Usuarios();

        usuarioActualizado.setId(dto.getId());
        usuarioActualizado.setNombre(usuario.getNombre() !=   null ? usuario.getNombre() : dto.getNombre());
        usuarioActualizado.setApellido(usuario.getApellido() !=   null ? usuario.getApellido() : dto.getApellido());
        usuarioActualizado.setUsuario(usuario.getUsuario() !=   null ? usuario.getUsuario() : dto.getUsuario());
        usuarioActualizado.setPassword_hash(usuario.getPassword_hash() !=   null ? usuario.getPassword_hash() : dto.getPassword_hash());
        usuarioActualizado.setActivo(usuario.getActivo() !=   null ? usuario.getActivo() : dto.getActivo());
        usuarioActualizado.setRol(usuario.getRol() !=   null ? usuario.getRol() : dto.getRol());
        usuarioActualizado.setUltimoAcceso(dto.getUltimoAcceso());
        usuarioActualizado.setCreatedAt(dto.getCreatedAt());
        usuarioActualizado.setUpdatedAt(dto.getUpdatedAt());

        return repository.actualizarUsuario(usuarioActualizado);
    }

    @Override
    public void eliminarUsuario(UUID id) {
        UsuariosDto dto = readRepository.obtenerUsuario(id)
                .orElseThrow(() -> new IllegalArgumentException("El usuario no se encontro con el ID: " + id));

        if (dto == null) {
            throw new IllegalArgumentException("El usuario no puede estar vacio.");
        }

        repository.eliminarUsuario(dto.getId());
    }
}
