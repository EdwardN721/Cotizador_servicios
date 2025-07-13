package aurora.servicios.servicios_backend.application.command.servicios.handlers;

import aurora.servicios.servicios_backend.application.command.servicios.ActualizarServicioCommand;
import aurora.servicios.servicios_backend.application.command.servicios.CrearServicioCommand;
import aurora.servicios.servicios_backend.application.command.servicios.EliminarServicioCommand;
import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.models.Servicios;
import aurora.servicios.servicios_backend.services.interfaces.command.ServiciosCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiciosCommandHandler {
    private final ServiciosCommandService service;

    @Autowired
    public ServiciosCommandHandler(ServiciosCommandService service) {
        this.service = service;
    }

    public ServiciosDto crearServicio(CrearServicioCommand command) {
        Servicios servicio = new Servicios(command.nombre(), command.descripcion(), command.categoria(), command.precioEstimado(), command.diasEstimado(), command.activo());
        return service.crearServicio(servicio);
    }

    public ServiciosDto actualizarServicio(ActualizarServicioCommand command) {
        Servicios servicios = new Servicios(command.id() ,command.nombre(), command.categoria(), command.descripcion(), command.precioEstimado(), command.diasEstimado(), command.activo());
        return service.actualizarServicio(servicios);
    }

    public void eliminarServicio(EliminarServicioCommand command) {
        service.eliminarServicio(command.id());
    }
}
