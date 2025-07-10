package aurora.servicios.servicios_backend.services.impl.readModel;

import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ClientesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ClientesReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientesReadModelServiceImpl implements ClientesReadModelService {
    private final ClientesReadModelRepository repository;

    @Autowired
    public  ClientesReadModelServiceImpl(ClientesReadModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientesDto> ObtenerClientes() {
        return repository.ObtenerClientes();
    }

    @Override
    public Optional<ClientesDto> ObtenerCliente(UUID id) {
        Optional<ClientesDto> cliente = repository.ObtenerClientePorId(id);

        if (cliente.isPresent()) {
            return cliente;
        }
        return Optional.empty();
    }
}
