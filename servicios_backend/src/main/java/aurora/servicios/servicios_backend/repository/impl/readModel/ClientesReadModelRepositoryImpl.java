package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ClientesReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ClientesReadModelRepositoryImpl implements ClientesReadModelRepository {

    private final JpaClientesRepository jpaRepository;

    @Autowired
    public ClientesReadModelRepositoryImpl(JpaClientesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public List<ClientesDto> ObtenerClientes() {
        return jpaRepository.findAll().stream()
                .map(clientes -> new ClientesDto(
                        clientes.getId(),
                        clientes.getNombre(),
                        clientes.getEmail(),
                        clientes.getNotas(),
                        clientes.getActivo(),
                        clientes.getCreatedAt(),
                        clientes.getUpdatedAt()
                )).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientesDto> ObtenerClientePorId(UUID id) {
        return jpaRepository.findById(id).map(cliente -> new ClientesDto(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getNotas(),
                cliente.getActivo(),
                cliente.getCreatedAt(),
                cliente.getUpdatedAt()
        ));
    }
}
