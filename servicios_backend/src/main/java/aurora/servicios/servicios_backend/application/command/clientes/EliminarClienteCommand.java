package aurora.servicios.servicios_backend.application.command.clientes;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EliminarClienteCommand(@NotNull UUID id) {}
