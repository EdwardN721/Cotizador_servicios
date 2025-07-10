package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSolicitudesRepository extends JpaRepository<Solicitudes, UUID> {
}
