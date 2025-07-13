package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record EstadosSolicitudDto(
        Long id,
        String nombre,
        String descripcion,
        String color,
        Integer orden,
        Boolean activo
) {
    public static EstadosSolicitudDto fromEntity(EstadosSolicitud estadosSolicitud){
        return new EstadosSolicitudDto(
                estadosSolicitud.getId(),
                estadosSolicitud.getNombre(),
                estadosSolicitud.getDescripcion(),
                estadosSolicitud.getColor(),
                estadosSolicitud.getOrden(),
                estadosSolicitud.getActivo()
        );
    }
}
