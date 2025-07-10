package aurora.servicios.servicios_backend.repository.spring;

import aurora.servicios.servicios_backend.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUsuariosRepository extends JpaRepository<Usuarios, UUID> {
}
