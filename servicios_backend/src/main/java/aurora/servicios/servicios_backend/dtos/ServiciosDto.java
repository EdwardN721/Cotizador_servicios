package aurora.servicios.servicios_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ServiciosDto {
    private UUID id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private BigDecimal precio_estimado;
    private Integer tiempo_estimado_dias;
    private Boolean activo = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
