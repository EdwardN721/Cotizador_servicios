package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;
import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.models.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

public record ComentariosSolicitudesDto (
        UUID id,
        Solicitudes solicitud,
        Usuarios usuario,
        String comentario,
        Boolean esInterno,
        LocalDateTime createdAt
){
    public static ComentariosSolicitudesDto fromEntity(ComentariosSolicitudes comentario){
        return new ComentariosSolicitudesDto(
                comentario.getId(),
                comentario.getSolicitud(),
                comentario.getUsuario(),
                comentario.getComentario(),
                comentario.getEsInterno(),
                comentario.getCreatedAt()
        );
    }
}
