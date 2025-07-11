package aurora.servicios.servicios_backend.models;

import aurora.servicios.servicios_backend.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Usuarios {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String usuario;

    @Column(nullable = false, length = 255)
    private String password_hash;

    private Boolean activo = true;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.ADMIN;

    private LocalDateTime ultimoAcceso;

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

    public Usuarios() {

    }

    public Usuarios(String nombre, String apellido, String usuario, String password_hash, Boolean activo, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password_hash = password_hash;
        this.activo = activo;
        this.rol = rol;
    }

    public Usuarios(UUID id, String nombre, String apellido, String usuario, String password_hash, Boolean activo, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password_hash = password_hash;
        this.activo = activo;
        this.rol = rol;
    }
}
