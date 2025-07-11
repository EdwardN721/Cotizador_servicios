package aurora.servicios.servicios_backend.application.command.usuarios;

import aurora.servicios.servicios_backend.enums.Rol;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class CrearUsuarioCommand {
    @Size(max = 100)
    private String nombre;

    @Size(max = 100)
    private String apellido;

    @Size(max = 50)
    private String usuario;

    @Size(max = 255)
    private String password_hash;

    private Boolean activo = true;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.ADMIN;

}
