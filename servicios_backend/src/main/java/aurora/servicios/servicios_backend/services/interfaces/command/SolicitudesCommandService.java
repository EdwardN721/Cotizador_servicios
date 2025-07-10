package aurora.servicios.servicios_backend.services.interfaces.command;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.models.Solicitudes;

import java.util.UUID;

public interface SolicitudesCommandService {
    SolicitudesDto crearSolicitud(Solicitudes solicitud);
    SolicitudesDto actualizarSolicitud(Solicitudes solicitud);
    void eliminarSolicitud(UUID id);
}
