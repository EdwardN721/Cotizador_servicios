package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.HistorialSolicitudesDto;
import aurora.servicios.servicios_backend.models.HistorialSolicitudes;
import aurora.servicios.servicios_backend.repository.interfaces.command.HistorialSolicitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.HistorialSolcitudesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.HistorialSolicitudesCommandService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HistorialSolicitudesCommandServiceImpl implements HistorialSolicitudesCommandService {
    private final HistorialSolicitudesCommandRepository repositorio;
    private final HistorialSolcitudesReadModelRepository readRepository;

    public HistorialSolicitudesCommandServiceImpl(HistorialSolicitudesCommandRepository repositorio, HistorialSolcitudesReadModelRepository readRepository) {
        this.repositorio = repositorio;
        this.readRepository = readRepository;
    }

    @Override
    public HistorialSolicitudesDto crearHistorial(HistorialSolicitudes historial) {
        return null;
    }

    @Override
    public HistorialSolicitudesDto actualizarHistorial(HistorialSolicitudes historial) {
        return null;
    }

    @Override
    public void eliminarHistorial(UUID id) {

    }
}
