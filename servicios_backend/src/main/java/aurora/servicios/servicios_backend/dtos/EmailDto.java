package aurora.servicios.servicios_backend.dtos;

import java.util.List;

public record EmailDto(
        String destinatario,
        String nombre,
        String asunto,
        String correo,
        List<String> servicios,
        String mensaje
) {
    @Override
    public String destinatario() {
        return "cotizacion.servicios.01@gmail.com";
    }
}
