package aurora.servicios.servicios_backend.dtos;

public record EmailDto(
        String destinatario,
        String nombre,
        String asunto,
        String correo,
        String servicios,
        String mensaje
) {}
