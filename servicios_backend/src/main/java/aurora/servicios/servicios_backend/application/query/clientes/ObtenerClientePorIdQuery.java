package aurora.servicios.servicios_backend.application.query.clientes;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ObtenerClientePorIdQuery(@NotNull UUID id) {}
