package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.SolicitudesReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaSolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SolicitudesReadModelRepositoryImpl implements SolicitudesReadModelRepository {
    private final JpaSolicitudesRepository jpaRepository;

    @Autowired
    public SolicitudesReadModelRepositoryImpl(JpaSolicitudesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<SolicitudesDto> obtenerSolicitudes() {
        return jpaRepository.findAll().stream()
                .map(SolicitudesDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<SolicitudesDto> obtenerSolicitudPorId(UUID id) {
        return jpaRepository.findById(id).map(SolicitudesDto::fromEntity);
    }
}
