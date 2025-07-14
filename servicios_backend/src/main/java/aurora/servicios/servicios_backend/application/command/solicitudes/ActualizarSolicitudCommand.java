package aurora.servicios.servicios_backend.application.command.solicitudes;

import aurora.servicios.servicios_backend.enums.Origen;
import aurora.servicios.servicios_backend.enums.Prioridad;
import aurora.servicios.servicios_backend.models.Clientes;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import aurora.servicios.servicios_backend.models.Servicios;
import aurora.servicios.servicios_backend.models.Usuarios;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ActualizarSolicitudCommand (
        @NotNull UUID id,
        @NotNull @Size(max = 20) String numeroSolicitud,
        @NotNull UUID cliente,
        @NotNull UUID servicio,
        @Size(max = 200) String servicioPersonalizado,
        @NotNull String descripcion,
        @Digits(integer = 10, fraction = 0, message = "El presupuesto máximo es de 10 digitos con 2 decimales")
        @DecimalMin(value = "0.01", message = "El presupuesto no puede ser 0.")
        BigDecimal presupuestoEstimado,
        @Enumerated(EnumType.STRING) @NotNull Prioridad prioridad,
        LocalDateTime fechaSolicitud,
        LocalDateTime fechaEstimacion,
        LocalDateTime fechaInicio,
        LocalDateTime fechaCierre,
        @NotNull UUID usuarioAsignado,
        @NotNull Long estado,
        @Enumerated(EnumType.STRING) @NotNull Origen origen,
        String notasInternas,
        String notasClientes){}
