package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ServiciosReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ServiciosReadModelRepositoryImpl implements ServiciosReadModelRepository {

    private final JpaServiciosRepository jpaRepository;

    @Autowired
    public ServiciosReadModelRepositoryImpl(JpaServiciosRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public List<ServiciosDto> obtenerServicios() {
        return jpaRepository.findAll().stream()
                .map(ServiciosDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<ServiciosDto> obtenerServicioPorId(UUID id) {
        return jpaRepository.findById(id).map(ServiciosDto::fromEntity);
    }
}
