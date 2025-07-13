package aurora.servicios.servicios_backend.application.command.clientes;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CrearClienteCommand (
        @NotNull @Size(max = 150) String nombre,
        @NotNull @Size(max = 255) String email,
        @Nullable String notas,
        Boolean activo
){
}

