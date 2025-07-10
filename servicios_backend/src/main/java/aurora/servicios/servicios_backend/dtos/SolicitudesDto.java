package aurora.servicios.servicios_backend.dtos;

import aurora.servicios.servicios_backend.enums.Origen;
import aurora.servicios.servicios_backend.enums.Prioridad;
import aurora.servicios.servicios_backend.models.Clientes;
import aurora.servicios.servicios_backend.models.EstadosSolicitud;
import aurora.servicios.servicios_backend.models.Servicios;
import aurora.servicios.servicios_backend.models.Usuarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class SolicitudesDto {
    private UUID id;
    private String numeroSolicitud;
    private Clientes cliente;
    private Servicios servicio;
    private String servicioPersonalizado;
    private String descripcion;
    private BigDecimal presupuestoEstimado;
    private Prioridad prioridad = Prioridad.MEDIA;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaEstimacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;
    private EstadosSolicitud estado;
    private Usuarios usuarioAsignado;
    private Origen origen = Origen.WEB;
    private String notasInternas;
    private String notasCliente;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Usuarios creadoPor;
    private Usuarios actualizadoPor;
}
