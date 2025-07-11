package aurora.servicios.servicios_backend.services.impl.readModel;

import aurora.servicios.servicios_backend.dtos.UsuariosDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.UsuariosReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.readModel.UsuariosReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuariosReadModelServiceImpl implements UsuariosReadModelService {
    private final UsuariosReadModelRepository repository;

    @Autowired
    public UsuariosReadModelServiceImpl(UsuariosReadModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuariosDto> obtenerUsuarios() {
        return repository.obtenerUsuarios();
    }

    @Override
    public Optional<UsuariosDto> obtenerUsuario(UUID id) {
        Optional<UsuariosDto> dto = repository.obtenerUsuario(id);
        if (dto.isPresent()) {
            return dto;
        }

        return Optional.empty();
    }
}
