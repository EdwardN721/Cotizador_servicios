package aurora.servicios.servicios_backend.application.query.usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ObtenerUsuarioPorIdQuery {
    private UUID id;
}
