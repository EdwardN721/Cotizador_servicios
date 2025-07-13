package aurora.servicios.servicios_backend.application.command.estadoSolicitud;

import jakarta.validation.constraints.NotNull;

public record EliminarEstadoSolicitudCommand(@NotNull Long id) {}