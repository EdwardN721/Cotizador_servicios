package aurora.servicios.servicios_backend.services.impl.readModel;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.SolicitudesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.readModel.SolicitudesReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SolicitudesReadModelServicesImpl implements SolicitudesReadModelService {
    private final SolicitudesReadModelRepository repository;

    @Autowired
    public SolicitudesReadModelServicesImpl(SolicitudesReadModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SolicitudesDto> obtenerSolicitudes() {
        return repository.obtenerSolicitudes();
    }

    @Override
    public Optional<SolicitudesDto> obtenerSolicitud(UUID id) {
        Optional<SolicitudesDto> dto = repository.obtenerSolicitud(id);
        if (dto.isPresent()) {
            return dto;
        }

        return Optional.empty();
    }
}
