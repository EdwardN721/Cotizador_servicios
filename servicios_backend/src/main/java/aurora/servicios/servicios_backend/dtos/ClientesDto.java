package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.models.Clientes;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientesDto (
    UUID id,
    String nombre,
    String email,
    String notas,
    Boolean activo,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
){
    public static ClientesDto fromEntity(Clientes cliente){
        return new ClientesDto(
                cliente.getId(),
        cliente.getNombre(),
        cliente.getEmail(),
        cliente.getNotas(),
        cliente.getActivo(),
        cliente.getCreatedAt(),
        cliente.getUpdatedAt()
        );
    }
}