package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.HistorialSolicitudes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaHistorialSolicitudesRepository extends JpaRepository<HistorialSolicitudes, UUID> {
}
