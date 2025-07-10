package aurora.servicios.servicios_backend.repository.interfaces.command;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.models.Servicios;

import java.util.UUID;

public interface ServiciosCommandRepository {
    ServiciosDto crearServicio(Servicios servicio);
    ServiciosDto actualizarServicio(Servicios servicio);
    void eliminarServicio(UUID id);
}
