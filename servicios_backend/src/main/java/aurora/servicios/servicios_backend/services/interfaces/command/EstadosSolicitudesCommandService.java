package aurora.servicios.servicios_backend.services.interfaces.command;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;

public interface EstadosSolicitudesCommandService {
    EstadosSolicitudDto crearEstadoSolicitud(EstadosSolicitud estadosSolicitud);
    EstadosSolicitudDto actualizarEstadoSolicitud(EstadosSolicitud estadosSolicitud);
    void eliminarEstadoSolicitud(Long id);
}
