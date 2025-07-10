package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaClientesRepository extends JpaRepository<Clientes, UUID> {
}
