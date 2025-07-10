package aurora.servicios.servicios_backend.services.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiciosReadModelService {
    List<ServiciosDto> obtenerServicios();
    Optional<ServiciosDto> obtenerServicio(UUID id);
}
