package aurora.servicios.servicios_backend.application.query.clientes.handlers;

import aurora.servicios.servicios_backend.application.query.clientes.ObtenerClientePorIdQuery;
import aurora.servicios.servicios_backend.application.query.clientes.ObtenerClientesQuery;
import aurora.servicios.servicios_backend.dtos.ClientesDto;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ClientesReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientesQueryHandler {
    private final ClientesReadModelService service;

    @Autowired
    public ClientesQueryHandler(ClientesReadModelService service) {
        this.service = service;
    }

    public List<ClientesDto> obtenerClientes(ObtenerClientesQuery query) {
        return service.ObtenerClientes();
    }

    public Optional<ClientesDto> obtenerClientesPorId(ObtenerClientePorIdQuery query) {
        return service.ObtenerCliente(query.id());
    }
}
