package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.HistorialSolicitudes;
import aurora.servicios.servicios_backend.models.Solicitudes;
import aurora.servicios.servicios_backend.models.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

public record HistorialSolicitudesDto(
        UUID id,
        Solicitudes solicitud,
        String campoModificado,
        String valorAnterior,
        String valorNuevo,
        Usuarios usuario,
        LocalDateTime fechaCambio,
        String comentario
){
    public static HistorialSolicitudesDto fromEntity(HistorialSolicitudes historial){
        return new HistorialSolicitudesDto(
                historial.getId(),
                historial.getSolicitud(),
                historial.getCampoModificado(),
                historial.getValorAnterior(),
                historial.getValorNuevo(),
                historial.getUsuario(),
                historial.getFechaCambio(),
                historial.getComentario()        );
    }
}
