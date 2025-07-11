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

        repositorio.crearComentario(comentario);
        return new ComentariosSolicitudesDto(
                comentario.getId(),
                comentario.getSolicitud(),
                comentario.getUsuario(),
                comentario.getComentario(),
                comentario.getEsInterno(),
                comentario.getCreatedAt()
        );
    }

    @Override
    public ComentariosSolicitudesDto actualizarComentario(ComentariosSolicitudes comentario) {
        ComentariosSolicitudesDto dto = readRepository.obtenerComentariosPorId(comentario.getId())
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con el ID: " + comentario.getId()));
        ComentariosSolicitudes comentariosActualizado = new ComentariosSolicitudes();

        comentariosActualizado.setId(dto.getId());
        comentariosActualizado.setSolicitud(comentario.getSolicitud() != null ? comentario.getSolicitud() : dto.getSolicitud());
        comentariosActualizado.setUsuario(comentario.getUsuario() != null ? comentario.getUsuario() : dto.getUsuario());
        comentariosActualizado.setComentario(comentario.getComentario()  != null ? comentario.getComentario() : dto.getComentario());
        comentariosActualizado.setEsInterno(comentario.getEsInterno() != null ? comentario.getEsInterno() : dto.getEsInterno());
        comentariosActualizado.setCreatedAt(dto.getCreatedAt());

        repositorio.actualizarComentario(comentariosActualizado);
        return new ComentariosSolicitudesDto(
                comentario.getId(),
                comentario.getSolicitud(),
                comentario.getUsuario(),
                comentario.getComentario(),
                comentario.getEsInterno(),
                comentario.getCreatedAt()
        );
    }

    @Override
    public void eliminarComentario(UUID id) {
        ComentariosSolicitudesDto dto = readRepository.obtenerComentariosPorId(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con el ID: " + id));
        repositorio.eliminarComentario(dto.getId());
    }
}
