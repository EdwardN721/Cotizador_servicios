package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.enums.Origen;
import aurora.servicios.servicios_backend.enums.Prioridad;
import aurora.servicios.servicios_backend.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record SolicitudesDto (
        UUID id,
        String numeroSolicitud,
        Clientes cliente,
        Servicios servicio,
        String servicioPersonalizado,
        String descripcion,
        BigDecimal presupuestoEstimado,
        Prioridad prioridad,
        LocalDateTime fechaSolicitud,
        LocalDateTime fechaEstimacion,
        LocalDateTime fechaInicio,
        LocalDateTime fechaCierre,
        EstadosSolicitud estado,
        Usuarios usuarioAsignado,
        Origen origen,
        String notasInternas,
        String notasCliente,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Usuarios creadoPor,
        Usuarios actualizadoPor
){
  public static SolicitudesDto fromEntity(Solicitudes solicitudes){
      return new SolicitudesDto(
              solicitudes.getId(),
              solicitudes.getNumeroSolicitud(),
              solicitudes.getCliente(),
              solicitudes.getServicio(),
              solicitudes.getServicioPersonalizado(),
              solicitudes.getDescripcion(),
              solicitudes.getPresupuestoEstimado(),
              solicitudes.getPrioridad(),
              solicitudes.getFechaSolicitud(),
              solicitudes.getFechaEstimacion(),
              solicitudes.getFechaInicio(),
              solicitudes.getFechaCierre(),
              solicitudes.getEstado(),
              solicitudes.getUsuarioAsignado(),
              solicitudes.getOrigen(),
              solicitudes.getNotasInternas(),
              solicitudes.getNotasCliente(),
              solicitudes.getCreatedAt(),
              solicitudes.getUpdatedAt(),
              solicitudes.getCreadoPor(),
              solicitudes.getActualizadoPor()
      );
  }
}
