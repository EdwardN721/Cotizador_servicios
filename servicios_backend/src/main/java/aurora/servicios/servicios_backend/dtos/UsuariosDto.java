package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UsuariosDto {
    private UUID id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password_hash;
    private Boolean activo = true;
    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.ADMIN;
    private LocalDateTime ultimoAcceso;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
