package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.models.Clientes;
import aurora.servicios.servicios_backend.repository.interfaces.command.ClientesCommandRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaClientesRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClientesCommandRepositoryImpl implements ClientesCommandRepository {

    private final JpaClientesRepository jpaRepository;

    public ClientesCommandRepositoryImpl(JpaClientesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ClientesDto crearClientes(Clientes clientes) {
        jpaRepository.save(clientes);
        return new ClientesDto(clientes.getId(), clientes.getNombre(), clientes.getEmail(), clientes.getNotas(), clientes.getActivo(),
                clientes.getCreatedAt(), clientes.getUpdatedAt());
    }

    @Override
    public ClientesDto actualizarClientes(Clientes clientes) {
        jpaRepository.save(clientes);
        return new ClientesDto(clientes.getId(), clientes.getNombre(), clientes.getEmail(), clientes.getNotas(), clientes.getActivo(),
                clientes.getCreatedAt(), clientes.getUpdatedAt());
    }

    @Override
    public void eliminarClientes(UUID id) {
        jpaRepository.deleteById(id);
    }
}
