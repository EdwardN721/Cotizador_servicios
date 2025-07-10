package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.ComentariosSolicitudesDto;
import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;
import aurora.servicios.servicios_backend.repository.interfaces.command.ComentariosSolcitudesCommandRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaComentariosSolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ComentatiosSolicitudesCommandRepositoryImpl implements ComentariosSolcitudesCommandRepository {
    private final JpaComentariosSolicitudesRepository jpaRepository;

    @Autowired
    public ComentatiosSolicitudesCommandRepositoryImpl(JpaComentariosSolicitudesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ComentariosSolicitudesDto crearComentario(ComentariosSolicitudes comentario) {
        jpaRepository.save(comentario);
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
        jpaRepository.save(comentario);
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
        jpaRepository.deleteById(id);
    }
}
