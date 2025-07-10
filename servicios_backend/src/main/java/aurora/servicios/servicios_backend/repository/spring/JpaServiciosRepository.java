package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaServiciosRepository extends JpaRepository<Servicios, UUID> {
}
