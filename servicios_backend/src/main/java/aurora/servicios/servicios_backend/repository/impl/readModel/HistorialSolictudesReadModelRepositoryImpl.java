package aurora.servicios.servicios_backend.repository.impl.readModel;

import aurora.servicios.servicios_backend.dtos.HistorialSolicitudesDto;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.HistorialSolcitudesReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaHistorialSolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class HistorialSolictudesReadModelRepositoryImpl implements HistorialSolcitudesReadModelRepository {
    private final JpaHistorialSolicitudesRepository jpaRepository;

    @Autowired
    public HistorialSolictudesReadModelRepositoryImpl(JpaHistorialSolicitudesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<HistorialSolicitudesDto> obtenerHistorialSolcitudes() {
        return jpaRepository.findAll().stream()
                .map(historial -> new HistorialSolicitudesDto(
                        historial.getId(),
                        historial.getSolicitud(),
                        historial.getCampoModificado(),
                        historial.getValorAnterior(),
                        historial.getValorNuevo(),
                        historial.getUsuario(),
                        historial.getFechaCambio(),
                        historial.getComentario()
                )).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<HistorialSolicitudesDto> ObtenerHistorialSolicitudesPorId(UUID id) {
        return jpaRepository.findById(id).map(historial -> new HistorialSolicitudesDto(
                historial.getId(),
                historial.getSolicitud(),
                historial.getCampoModificado(),
                historial.getValorAnterior(),
                historial.getValorNuevo(),
                historial.getUsuario(),
                historial.getFechaCambio(),
                historial.getComentario()
        ));
    }
}
