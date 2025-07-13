package aurora.servicios.servicios_backend.application.command.servicios;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CrearServicioCommand(
        @NotNull @Size(max = 200) String nombre,
        @Nullable String descripcion,
        @Nullable String categoria,
        @Digits(integer = 10, fraction = 2, message = "El precio debe tener hasta 10 digitos y 2 decimales")
        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
        BigDecimal precioEstimado,
        @Digits(integer = 3, fraction = 0,message = "No puede exceder de 3 digitos y no debe tener valores con punto decimal.")
        @DecimalMin(value = "0.01", message = "Debe ser mayor a 1 día.")
        Integer diasEstimado,
        Boolean activo
) {}
