package aurora.servicios.servicios_backend.services.impl.readModel;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ServiciosReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ServiciosReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiciosReadModelServiceImpl implements ServiciosReadModelService {
    private ServiciosReadModelRepository repository;

    @Autowired
    public ServiciosReadModelServiceImpl(ServiciosReadModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiciosDto> obtenerServicios() {
        return repository.obtenerServicios();
    }

    @Override
    public Optional<ServiciosDto> obtenerServicio(UUID id) {
        Optional<ServiciosDto> dto = repository.obtenerServicioPorId(id);
        if (dto.isPresent()) {
            return dto;
        }
        return Optional.empty();
    }
}
