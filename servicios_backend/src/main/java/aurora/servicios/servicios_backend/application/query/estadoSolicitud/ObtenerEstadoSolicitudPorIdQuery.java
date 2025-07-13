package aurora.servicios.servicios_backend.application.query.estadoSolicitud;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ObtenerEstadoSolicitudPorIdQuery(@NotNull Long id) {
}
