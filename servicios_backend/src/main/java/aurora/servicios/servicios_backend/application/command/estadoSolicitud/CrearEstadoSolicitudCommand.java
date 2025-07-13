package aurora.servicios.servicios_backend.application.command.estadoSolicitud;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CrearEstadoSolicitudCommand(
    @NotNull @Size(max = 50) String nombre,
    @Nullable String descripcion,
    @Nullable String color,
    @Digits(integer = 3, fraction = 0, message = "No puede exceder de 3 digitos y no hay punto decimal.")
    @DecimalMin(value = "0.01", message = "No puede ser menor a 0.")
    @Nullable Integer orden,
    @Nullable Boolean activo
) {}
