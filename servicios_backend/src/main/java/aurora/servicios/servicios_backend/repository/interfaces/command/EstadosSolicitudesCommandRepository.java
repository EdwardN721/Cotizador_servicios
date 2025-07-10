package aurora.servicios.servicios_backend.repository.interfaces.command;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;

public interface EstadosSolicitudesCommandRepository {
    EstadosSolicitudDto crearEstadoSolicitud(EstadosSolicitud estadosSolicitud);
    EstadosSolicitudDto actualizarEstadoSolicitud(EstadosSolicitud estadosSolicitud);
    void eliminarEstadoSolicitud(Long id);
}
