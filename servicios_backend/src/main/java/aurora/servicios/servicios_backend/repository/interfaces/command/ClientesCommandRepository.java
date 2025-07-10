package aurora.servicios.servicios_backend.repository.interfaces.command;

import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.models.Clientes;

import java.util.UUID;

public interface ClientesCommandRepository {
    ClientesDto crearClientes(Clientes clientes);
    ClientesDto actualizarClientes(Clientes clientes);
    void eliminarClientes(UUID id);
}
