package aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.handlers;

import aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.ObtenerComentariosPorIdQuery;
import aurora.servicios.servicios_backend.application.query.comentariosSolicitudes.ObtenerComentariosQuery;
import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ComentariosSolicitudesReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ComentariosSolicitudQueryHandler {
    private final ComentariosSolicitudesReadModelService service;

    @Autowired
    public ComentariosSolicitudQueryHandler(ComentariosSolicitudesReadModelService service) {
        this.service = service;
    }

    public List<ComentariosSolicitudesDto> obtenerComentarios(ObtenerComentariosQuery query){
        return service.obtenerComentarios();
    }

    public Optional<ComentariosSolicitudesDto>  obtenerComentariosPorId(ObtenerComentariosPorIdQuery query){
        return service.obtenerComentariosPorId(query.id());
    }
}
