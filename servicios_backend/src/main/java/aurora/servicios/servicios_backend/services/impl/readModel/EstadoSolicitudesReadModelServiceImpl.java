package aurora.servicios.servicios_backend.services.impl.readModel;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.EstadosSolicitudReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.readModel.EstadosSolicitudReadModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoSolicitudesReadModelServiceImpl implements EstadosSolicitudReadModelService {
    private final EstadosSolicitudReadModelRepository repositorio;

    public EstadoSolicitudesReadModelServiceImpl (EstadosSolicitudReadModelRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<EstadosSolicitudDto> obtenerEstadosSolicitud(Long id) {
        return repositorio.obtenerEstadosSolicitud();
    }

    @Override
    public Optional<EstadosSolicitudDto> obtenerEstadoSolicitudPorId(Long id) {
        Optional<EstadosSolicitudDto> dto = repositorio.obtenerEstadoSolicitudPorId(id);
        if (dto.isPresent()) {
            return dto;
        }

        return Optional.empty();
    }
}
