package aurora.servicios.servicios_backend.services.interfaces.readModel;

import aurora.servicios.servicios_backend.dtos.ClientesDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientesReadModelService {
    List<ClientesDto> ObtenerClientes();
    Optional<ClientesDto> ObtenerCliente(UUID id);
}
