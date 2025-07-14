package aurora.servicios.servicios_backend.models;

import aurora.servicios.servicios_backend.enums.Origen;
import aurora.servicios.servicios_backend.enums.Prioridad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
@NoArgsConstructor
public class Solicitudes {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true, length = 20)
    private String numeroSolicitud;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicios servicio;


    @Column(name = "servicio_personalizado", length = 200)
    private String servicioPersonalizado;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(name = "presupuesto_estimado", precision = 10, scale = 2)
    private BigDecimal presupuestoEstimado;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridad", length = 20)
    private Prioridad prioridad = Prioridad.MEDIA;

    @Column(name = "fecha_solicitud", updatable = false)
    private LocalDateTime fechaSolicitud;

    private LocalDateTime fechaEstimacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadosSolicitud estado;

    @ManyToOne
    @JoinColumn(name = "usuario_asignado_id")
    private Usuarios usuarioAsignado;

    @Enumerated(EnumType.STRING)
    @Column(name = "origen", length = 50)
    private Origen origen = Origen.WEB;

    @Column(name = "notas_internas", columnDefinition = "TEXT")
    private String notasInternas;

    @Column(name = "notas_cliente", columnDefinition = "TEXT")
    private String notasCliente;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Usuarios creadoPor;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Usuarios actualizadoPor;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        fechaSolicitud = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Solicitudes(UUID id, String numeroSolicitud, Clientes cliente, Servicios servicio, String servicioPersonalizado, String descripcion, BigDecimal presupuestoEstimado, Prioridad prioridad, LocalDateTime fechaSolicitud, LocalDateTime fechaEstimacion, LocalDateTime fechaInicio, LocalDateTime fechaCierre, EstadosSolicitud estado, Usuarios usuarioAsignado, Origen origen, String notasInternas, String notasCliente) {
        this.id = id;
        this.numeroSolicitud = numeroSolicitud;
        this.cliente = cliente;
        this.servicio = servicio;
        this.servicioPersonalizado = servicioPersonalizado;
        this.descripcion = descripcion;
        this.presupuestoEstimado = presupuestoEstimado;
        this.prioridad = prioridad;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEstimacion = fechaEstimacion;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.usuarioAsignado = usuarioAsignado;
        this.origen = origen;
        this.notasInternas = notasInternas;
        this.notasCliente = notasCliente;
    }

    public Solicitudes(String numeroSolicitud, Clientes cliente, Servicios servicio, String servicioPersonalizado, String descripcion, BigDecimal presupuestoEstimado, Prioridad prioridad, LocalDateTime fechaSolicitud, LocalDateTime fechaEstimacion, LocalDateTime fechaInicio, LocalDateTime fechaCierre, EstadosSolicitud estado, Usuarios usuarioAsignado, Origen origen, String notasInternas, String notasCliente) {
        this.numeroSolicitud = numeroSolicitud;
        this.cliente = cliente;
        this.servicio = servicio;
        this.servicioPersonalizado = servicioPersonalizado;
        this.descripcion = descripcion;
        this.presupuestoEstimado = presupuestoEstimado;
        this.prioridad = prioridad;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEstimacion = fechaEstimacion;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.usuarioAsignado = usuarioAsignado;
        this.origen = origen;
        this.notasInternas = notasInternas;
        this.notasCliente = notasCliente;
    }
}
