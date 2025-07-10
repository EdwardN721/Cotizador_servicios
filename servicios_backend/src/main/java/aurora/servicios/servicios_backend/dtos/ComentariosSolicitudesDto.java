package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.models.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ComentariosSolicitudesDto {
    private UUID id;
    private Solicitudes solicitud;
    private Usuarios usuario;
    private String comentario;
    private Boolean esInterno = true;
    private LocalDateTime createdAt;
}
