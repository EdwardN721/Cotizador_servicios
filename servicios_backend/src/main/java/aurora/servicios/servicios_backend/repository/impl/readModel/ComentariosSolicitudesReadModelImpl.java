package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ComentariosSolicitudesReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaComentariosSolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ComentariosSolicitudesReadModelImpl implements ComentariosSolicitudesReadModelRepository {
    private final JpaComentariosSolicitudesRepository jpaRepository;

    @Autowired
    public ComentariosSolicitudesReadModelImpl(JpaComentariosSolicitudesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<ComentariosSolicitudesDto> obtenerComentarios() {
        return jpaRepository.findAll().stream()
                .map(comentario -> new ComentariosSolicitudesDto(
                        comentario.getId(),
                        comentario.getSolicitud(),
                        comentario.getUsuario(),
                        comentario.getComentario(),
                        comentario.getEsInterno(),
                        comentario.getCreatedAt()
                ))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<ComentariosSolicitudesDto> obtenerComentariosPorId(UUID id) {
        return jpaRepository.findById(id).map(comentario -> new ComentariosSolicitudesDto(
                comentario.getId(),
                comentario.getSolicitud(),
                comentario.getUsuario(),
                comentario.getComentario(),
                comentario.getEsInterno(),
                comentario.getCreatedAt()
        ));
    }
}
