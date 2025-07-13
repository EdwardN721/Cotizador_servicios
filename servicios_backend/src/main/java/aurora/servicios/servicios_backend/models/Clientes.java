package aurora.servicios.servicios_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
@NoArgsConstructor
public class Clientes {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String notas;

    private Boolean activo = true;

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

    public Clientes(String nombre, String email, String notas, Boolean activo) {
        this.nombre = nombre;
        this.email = email;
        this.notas = notas;
        this.activo = activo;
    }

    public Clientes(UUID id, String nombre, String email, String notas, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.notas = notas;
        this.activo = activo;
    }
}
