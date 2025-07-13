package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.Servicios;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ServiciosDto(
    UUID id,
    String nombre,
    String descripcion,
    String categoria,
    BigDecimal precio_estimado,
    Integer tiempo_estimado_dias,
    Boolean activo,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
    ){
    public static ServiciosDto fromEntity(Servicios servicio){
        return new ServiciosDto(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getCategoria(),
                servicio.getPrecio_estimado(),
                servicio.getTiempo_estimado_dias(),
                servicio.getActivo(),
                servicio.getCreatedAt(),
                servicio.getUpdatedAt()
        );
    }
}
