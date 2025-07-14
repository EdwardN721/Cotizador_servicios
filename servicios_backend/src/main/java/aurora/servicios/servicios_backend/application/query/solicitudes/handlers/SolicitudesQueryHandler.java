package aurora.servicios.servicios_backend.application.query.solicitudes.handlers;

import aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.ObtenerComentariosQuery;
import aurora.servicios.servicios_backend.application.query.solicitudes.ObtenerSolicitudPorIdQuery;
import aurora.servicios.servicios_backend.application.query.solicitudes.ObtenerSolicitudesQuery;
import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.services.interfaces.readModel.SolicitudesReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SolicitudesQueryHandler {
    private final SolicitudesReadModelService service;

    @Autowired
    public SolicitudesQueryHandler(SolicitudesReadModelService service){
        this.service = service;
    }

    public List<SolicitudesDto> obtenerSolicitudes(ObtenerSolicitudesQuery query){
        return service.obtenerSolicitudes();
    }

    public Optional<SolicitudesDto> obtenerSolicitudPorId(ObtenerSolicitudPorIdQuery query){
        return service.obtenerSolicitudPorId(query.id());
    }
}
