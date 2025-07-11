package aurora.servicios.servicios_backend.application.command.usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
@AllArgsConstructor
public class EliminarUsuarioCommand {
    private UUID id;
}
