package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.models.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class HistorialSolicitudesDto {
    private UUID id;
    private Solicitudes solicitud;
    private String campoModificado;
    private String valorAnterior;
    private String valorNuevo;
    private Usuarios usuario;
    private LocalDateTime fechaCambio;
    private String comentario;
}
