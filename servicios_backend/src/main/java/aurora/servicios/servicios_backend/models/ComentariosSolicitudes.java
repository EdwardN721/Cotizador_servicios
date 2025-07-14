package aurora.servicios.servicios_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ComentariosSolicitudes {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitudes solicitud;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @Column(name = "comentario", columnDefinition = "TEXT", nullable = false)
    private String comentario;

    @Column(name = "es_interno")
    private Boolean esInterno = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public ComentariosSolicitudes(UUID id, Solicitudes solicitud, Usuarios usuario, String comentario, Boolean esInterno) {
        this.id = id;
        this.solicitud = solicitud;
        this.usuario = usuario;
        this.comentario = comentario;
        this.esInterno = esInterno;
    }

    public ComentariosSolicitudes(Solicitudes solicitud, Usuarios usuario, String comentario, Boolean esInterno) {
        this.solicitud = solicitud;
        this.usuario = usuario;
        this.comentario = comentario;
        this.esInterno = esInterno;
    }
}
