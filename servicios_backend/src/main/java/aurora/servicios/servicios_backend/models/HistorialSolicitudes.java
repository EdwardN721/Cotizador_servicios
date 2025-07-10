package aurora.servicios.servicios_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
public class HistorialSolicitudes {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitudes solicitud;

    @Column(name = "campo_modificado", nullable = false, length = 100)
    private String campoModificado;

    @Column(name = "valor_anterior", columnDefinition = "TEXT")
    private String valorAnterior;

    @Column(name = "valor_nuevo", columnDefinition = "TEXT")
    private String valorNuevo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @Column(name = "fecha_cambio", updatable = false)
    private LocalDateTime fechaCambio;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @PrePersist
    protected void onCreate() {
        fechaCambio = LocalDateTime.now();
    }
}
