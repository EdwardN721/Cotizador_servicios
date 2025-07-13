package aurora.servicios.servicios_backend.application.query.estadoSolicitud.handler;

import aurora.servicios.servicios_backend.application.query.clientes.ObtenerClientesQuery;
import aurora.servicios.servicios_backend.application.query.estadoSolicitud.ObtenerEstadoSolicitudPorIdQuery;
import aurora.servicios.servicios_backend.application.query.estadoSolicitud.ObtenerEstadosSolicitudQuery;
import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.services.interfaces.readModel.EstadosSolicitudReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoSolicitudQueryHandler {
    private final EstadosSolicitudReadModelService service;

    @Autowired
    public EstadoSolicitudQueryHandler(EstadosSolicitudReadModelService service) {
        this.service = service;
    }

    public List<EstadosSolicitudDto> obtenerEstadosSolicitud(ObtenerEstadosSolicitudQuery query) {
        return service.obtenerEstadosSolicitud();
    }

    public Optional<EstadosSolicitudDto> obtenerEstadoSolicitudPorId(ObtenerEstadoSolicitudPorIdQuery query) {
        return service.obtenerEstadoSolicitudPorId(query.id());
    }
}
