package aurora.servicios.servicios_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Servicios {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 200)
    private String nombre;

    private String descripcion;

    @Column(length = 100)
    private String categoria;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio_estimado;

    private int tiempo_estimado_dias;

    private boolean activo = true;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}