package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.UsuariosReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UsuariosReadModelRepositoryImpl implements UsuariosReadModelRepository {
    private JpaUsuariosRepository jpaRepository;

    @Autowired
    public UsuariosReadModelRepositoryImpl(JpaUsuariosRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<UsuariosDto> obtenerUsuarios() {
        return jpaRepository.findAll().stream()
                .map(usuarios -> new UsuariosDto(
                   usuarios.getId(),
                   usuarios.getNombre(),
                   usuarios.getApellido(),
                   usuarios.getUsuario(),
                   usuarios.getPassword_hash(),
                   usuarios.isActivo(),
                   usuarios.getRol(),
                   usuarios.getUltimoAcceso(),
                   usuarios.getCreatedAt(),
                   usuarios.getUpdatedAt()
                )).collect(Collectors.toList());
    }

    @Override
    public Optional<UsuariosDto> obtenerUsuario(UUID id) {
        return Optional.empty();
    }
}
