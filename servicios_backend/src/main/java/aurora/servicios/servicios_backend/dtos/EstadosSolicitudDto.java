package aurora.servicios.servicios_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstadosSolicitudDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String color;
    private Integer orden = 0;
    private Boolean activo = true;
}
