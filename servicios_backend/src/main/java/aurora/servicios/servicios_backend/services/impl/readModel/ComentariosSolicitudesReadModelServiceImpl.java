package aurora.servicios.servicios_backend.services.impl.readModel;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ComentariosSolicitudesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ComentariosSolicitudesReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComentariosSolicitudesReadModelServiceImpl implements ComentariosSolicitudesReadModelService {
    private final ComentariosSolicitudesReadModelRepository repository;

    @Autowired
    public ComentariosSolicitudesReadModelServiceImpl(ComentariosSolicitudesReadModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ComentariosSolicitudesDto> obtenerComentarios() {
        return repository.obtenerComentarios();
    }

    @Override
    public Optional<ComentariosSolicitudesDto> obtenerComentariosPorId(UUID id) {
        Optional<ComentariosSolicitudesDto> dto = repository.obtenerComentariosPorId(id);
        if (dto.isPresent()) {
            return dto;
        }

        return Optional.empty();
    }
}
