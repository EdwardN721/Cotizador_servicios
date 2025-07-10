package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.ComentariosSolicitudes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaComentariosSolicitudesRepository extends JpaRepository<ComentariosSolicitudes, UUID> {
}
