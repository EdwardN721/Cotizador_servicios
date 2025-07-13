package aurora.servicios.servicios_backend.repository.impl.command;

import aurora.servicios.servicios_backend.dtos.ServiciosDto;
import aurora.servicios.servicios_backend.models.Servicios;
import aurora.servicios.servicios_backend.repository.interfaces.command.ServiciosCommandRepository;
import aurora.servicios.servicios_backend.repository.interfaces.readModel.ServiciosReadModelRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ServiciosCommandRepositoryImpl implements ServiciosCommandRepository {

    private final JpaServiciosRepository jpaServiciosRepository;

    @Autowired
    public ServiciosCommandRepositoryImpl(JpaServiciosRepository jpaServiciosRepository) {
        this.jpaServiciosRepository = jpaServiciosRepository;
    }

    @Override
    public ServiciosDto crearServicio(Servicios servicio) {
        jpaServiciosRepository.save(servicio);
        return new ServiciosDto(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getCategoria(),
                servicio.getPrecio_estimado(),
                servicio.getTiempo_estimado_dias(),
                servicio.getActivo(),
                servicio.getCreatedAt(),
                servicio.getUpdatedAt()
        );
    }

    @Override
    public ServiciosDto actualizarServicio(Servicios servicio) {
        jpaServiciosRepository.save(servicio);
        return new ServiciosDto(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getCategoria(),
                servicio.getPrecio_estimado(),
                servicio.getTiempo_estimado_dias(),
                servicio.getActivo(),
                servicio.getCreatedAt(),
                servicio.getUpdatedAt()
        );
    }

    @Override
    public void eliminarServicio(UUID id) {
        jpaServiciosRepository.deleteById(id);
    }
}
