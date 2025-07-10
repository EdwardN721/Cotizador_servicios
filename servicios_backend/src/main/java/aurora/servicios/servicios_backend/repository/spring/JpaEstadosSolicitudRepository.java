package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEstadosSolicitudRepository extends JpaRepository<EstadosSolicitud, Long> {
}
