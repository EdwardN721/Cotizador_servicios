package aurora.servicios.servicios_backend.services.impl.command;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;
import aurora.servicios.servicios_backend.repository.interfaces.command.ComentariosSolcitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ComentariosSolicitudesReadModelRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.ComentariosSolcitudesCommandService;
import aurora.servicios.servicios_backend.services.interfaces.readModel.ComentariosSolicitudesReadModelService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ComentariosSolicitudesCommandServceImpl implements ComentariosSolcitudesCommandService {
    private final ComentariosSolcitudesCommandRepository repositorio;
    private final ComentariosSolicitudesReadModelRepository readRepository;

    @Autowired
    public ComentariosSolicitudesCommandServceImpl(ComentariosSolcitudesCommandRepository repositorio, ComentariosSolicitudesReadModelRepository readRepository, ComentariosSolcitudesCommandRepository repository) {
        this.repositorio = repositorio;
        this.readRepository = readRepository;
    }

    @Override
    public ComentariosSolicitudesDto crearComentario(ComentariosSolicitudes comentario) {
        if(comentario == null){
            return null;
        }

        return repositorio.crearComentario(comentario);
    }

    @Override
    public ComentariosSolicitudesDto actualizarComentario(ComentariosSolicitudes comentario) {
        ComentariosSolicitudesDto dto = readRepository.obtenerComentariosPorId(comentario.getId())
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con el ID: " + comentario.getId()));
        ComentariosSolicitudes comentariosActualizado = new ComentariosSolicitudes();

        comentariosActualizado.setId(dto.id());
        comentariosActualizado.setSolicitud(comentario.getSolicitud() != null ? comentario.getSolicitud() : dto.solicitud());
        comentariosActualizado.setUsuario(comentario.getUsuario() != null ? comentario.getUsuario() : dto.usuario());
        comentariosActualizado.setComentario(comentario.getComentario()  != null ? comentario.getComentario() : dto.comentario());
        comentariosActualizado.setEsInterno(comentario.getEsInterno() != null ? comentario.getEsInterno() : dto.esInterno());
        comentariosActualizado.setCreatedAt(dto.createdAt());

        return repositorio.actualizarComentario(comentariosActualizado);
    }

    @Override
    public void eliminarComentario(UUID id) {
        ComentariosSolicitudesDto dto = readRepository.obtenerComentariosPorId(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con el ID: " + id));
        repositorio.eliminarComentario(dto.id());
    }
}
