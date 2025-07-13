package aurora.servicios.servicios_backend.application.command.estadoSolicitud.handler;

import aurora.servicios.servicios_backend.application.command.estadoSolicitud.ActualizarEstadoSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.estadoSolicitud.CrearEstadoSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.estadoSolicitud.EliminarEstadoSolicitudCommand;
import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import aurora.servicios.servicios_backend.services.interfaces.command.EstadosSolicitudesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoSolicitudCommandHandler {
    private final EstadosSolicitudesCommandService service;

    @Autowired
    public EstadoSolicitudCommandHandler(EstadosSolicitudesCommandService service) {
        this.service = service;
    }

    public EstadosSolicitudDto crearEstadoSolicitud(CrearEstadoSolicitudCommand command) {
        EstadosSolicitud estadoSolicitud = new EstadosSolicitud(command.nombre(), command.descripcion(), command.color(), command.orden(), command.activo());
        return service.crearEstadoSolicitud(estadoSolicitud);
    }

    public EstadosSolicitudDto actualizarEstadoSolicitud(ActualizarEstadoSolicitudCommand command) {
        EstadosSolicitud estadosSolicitud = new EstadosSolicitud(command.id(), command.nombre(), command.descripcion(), command.color(), command.orden(), command.activo());
        return service.actualizarEstadoSolicitud(estadosSolicitud);
    }

    public void eliminarEstadoSolicitud(EliminarEstadoSolicitudCommand command) {
        service.eliminarEstadoSolicitud(command.id());
    }

}
