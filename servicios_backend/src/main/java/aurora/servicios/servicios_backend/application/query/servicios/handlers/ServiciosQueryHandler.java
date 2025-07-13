package aurora.servicios.servicios_backend.application.query.servicios.handlers;

import aurora.servicios.servicios_backend.application.query.servicios.ObtenerServicioPorIdQuery;
import aurora.servicios.servicios_backend.application.query.servicios.ObtenerServiciosQuery;
import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ServiciosReadModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiciosQueryHandler {
    private final ServiciosReadModelService service;

    @Autowired
    public ServiciosQueryHandler(ServiciosReadModelService servicios) {
        this.service = servicios;
    }

    public List<ServiciosDto>  obtenerServicios(ObtenerServiciosQuery query){
        return service.obtenerServicios();
    }

    public Optional<ServiciosDto> obtenerServicioPorId(ObtenerServicioPorIdQuery query){
        return service.obtenerServicio(query.id());
    }

}
