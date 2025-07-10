package aurora.servicios.servicios_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ClientesDto {
    private UUID id;
    private String nombre;
    private String email;
    private String notas;
    private Boolean activo = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
