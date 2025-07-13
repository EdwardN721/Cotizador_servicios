package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.EstadosSolicitudDto;
import aurora.servicios.servicios_backend.repository.impl.command.EstadoSolicitudCommandRepositoryImpl;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.EstadosSolicitudReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaEstadosSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EstadoSolicitudReadModelRepositoryImpl implements EstadosSolicitudReadModelRepository {
    private final JpaEstadosSolicitudRepository jpaRepository;

    @Autowired
    public EstadoSolicitudReadModelRepositoryImpl(JpaEstadosSolicitudRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<EstadosSolicitudDto> obtenerEstadosSolicitud() {
        return jpaRepository.findAll().stream()
                .map(EstadosSolicitudDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<EstadosSolicitudDto> obtenerEstadoSolicitudPorId(Long id) {
        return jpaRepository.findById(id).map(EstadosSolicitudDto::fromEntity);
    }
}
