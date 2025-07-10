package aurora.servicios.servicios_backend.repository.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiciosReadModelRepository {
    List<ServiciosDto> obtenerServicios();
    Optional<ServiciosDto> obtenerServicio(UUID id);
}
