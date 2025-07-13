package aurora.servicios.servicios_backend.application.command.clientes.handlers;

import aurora.servicios.servicios_backend.application.command.clientes.ActualizarClienteCommand;
import aurora.servicios.servicios_backend.application.command.clientes.CrearClienteCommand;
import aurora.servicios.servicios_backend.application.command.clientes.EliminarClienteCommand;
import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.models.Clientes;
import aurora.servicios.servicios_backend.services.interfaces.command.ClientesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientesCommandHandler {
    private final ClientesCommandService service;

    @Autowired
    public ClientesCommandHandler(ClientesCommandService service) {
        this.service = service;
    }

    public ClientesDto crearCliente(CrearClienteCommand command) {
        Clientes cliente = new Clientes(command.nombre(), command.email(), command.notas(), command.activo());
        return service.crearClientes(cliente);
    }

    public ClientesDto actualizarCliente(ActualizarClienteCommand command) {
        Clientes clientes = new Clientes(command.id(), command.nombre(), command.email(), command.notas(), command.activo());
        return service.actualizarClientes(clientes);
    }

    public void eliminarCliente(EliminarClienteCommand command) {
        service.eliminarClientes(command.id());
    }
}
