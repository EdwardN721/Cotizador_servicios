package aurora.servicios.servicios_backend.application.command.comentariosSolicitudes;

import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.models.Usuarios;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ActualizarComentarioCommand (
        @NotNull UUID id,
        @NotNull Solicitudes solicitud,
        @NotNull Usuarios usuario,
        @NotNull String comentario,
        Boolean esInterno
){}
