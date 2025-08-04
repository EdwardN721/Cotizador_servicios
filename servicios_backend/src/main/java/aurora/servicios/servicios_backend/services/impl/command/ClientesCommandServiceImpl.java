package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.models.Clientes;
import aurora.servicios.servicios_backend.repository.interfaces.command.ClientesCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ClientesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.ClientesCommandService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ClientesCommandServiceImpl implements ClientesCommandService {
    private final ClientesCommandRepository repository;
    private final ClientesReadModelRepository  modelRepository;

    @Autowired
    public ClientesCommandServiceImpl(ClientesCommandRepository repository,  ClientesReadModelRepository modelRepository) {
        this.repository = repository;
        this.modelRepository = modelRepository;
    }

    @Override
    public ClientesDto crearClientes(Clientes clientes) {
        if (clientes == null) {
            return null;
        }

        return repository.crearClientes(clientes);
    }

    @Override
    public ClientesDto actualizarClientes(Clientes clientes) {
        ClientesDto dto = modelRepository.ObtenerClientePorId(clientes.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el ID: " + clientes.getId()));
        if (dto == null) {
            return null;
        }
        Clientes clienteActualizado = new  Clientes();

        clienteActualizado.setId(clientes.getId());
        clienteActualizado.setNombre(clientes.getNombre() != null ? clientes.getNombre() : dto.nombre());
        clienteActualizado.setEmail(clientes.getEmail() != null ? clientes.getEmail() : dto.email());
        clienteActualizado.setNotas(clientes.getNotas() != null ? clientes.getNotas() : dto.notas());
        clienteActualizado.setActivo(clientes.getActivo() != null ? clientes.getActivo() : dto.activo());
        clienteActualizado.setCreatedAt(clientes.getCreatedAt());
        clienteActualizado.setUpdatedAt(clientes.getUpdatedAt());

        return repository.actualizarClientes(clienteActualizado);
    }

    @Override
    public void eliminarClientes(UUID id) {
        ClientesDto dto = modelRepository.ObtenerClientePorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el ID: " + id));

        if (dto == null) {
            return;
        }

        repository.eliminarClientes(dto.id());
    }
}
