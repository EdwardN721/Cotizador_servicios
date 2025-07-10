package aurora.servicios.servicios_backend.repository.interfaces.command;

import aurora.servicios.servicios_backend.dtos.HistorialSolicitudesDto;
import aurora.servicios.servicios_backend.models.HistorialSolicitudes;

import java.util.UUID;

public interface HistorialSolicitudesCommandRepository {
    HistorialSolicitudesDto crearHistorial(HistorialSolicitudes historial);
    HistorialSolicitudesDto actualizarHistorial(HistorialSolicitudes historial);
    void eliminarHistorial(UUID id);
}
