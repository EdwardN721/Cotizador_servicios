package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.models.Usuarios;
import aurora.servicios.servicios_backend.repository.interfaces.command.UsuariosCommandRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UsuariosCommandRepositoryImpl implements UsuariosCommandRepository {
    private final JpaUsuariosRepository jpaRepository;

    @Autowired
    public UsuariosCommandRepositoryImpl(JpaUsuariosRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public UsuariosDto crearUsuario(Usuarios usuario) {
        System.out.println("Rol al guardar: " + usuario.getRol());
        if (usuario.getRol() == null) {
            throw new IllegalStateException("Rol no puede ser null");
        }


        jpaRepository.save(usuario);
        return
                new UsuariosDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getUsuario(),
                usuario.getPassword_hash(),
                usuario.getActivo(),
                usuario.getRol(),
                usuario.getUltimoAcceso(),
                usuario.getCreatedAt(),
                usuario.getUpdatedAt()
        );
    }

    @Override
    public UsuariosDto actualizarUsuario(Usuarios usuario) {
        jpaRepository.save(usuario);
        return new UsuariosDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getUsuario(),
                usuario.getPassword_hash(),
                usuario.getActivo(),
                usuario.getRol(),
                usuario.getUltimoAcceso(),
                usuario.getCreatedAt(),
                usuario.getUpdatedAt()
        );
    }

    @Override
    public void eliminarUsuario(UUID id) {
        jpaRepository.deleteById(id);
    }
}
