package aurora.servicios.servicios_backend.services.interfaces.command;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.models.Servicios;

import java.util.UUID;

public interface ServiciosCommandService {
    ServiciosDto crearServicio(Servicios servicio);
    ServiciosDto actualizarServicio(Servicios servicio);
    void eliminarServicio(UUID id);
}
