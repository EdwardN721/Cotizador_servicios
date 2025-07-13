package aurora.servicios.servicios_backend.application.command.clientes;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ActualizarClienteCommand(
        @NotNull UUID id,
        @NotNull @Size(max = 150) String nombre,
        @NotNull @Size(max = 255) String email,
        @Nullable String notas,
        Boolean activo
) {
}
