package aurora.servicios.servicios_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
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

    private Integer tiempo_estimado_dias;

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

    public Servicios(UUID id, String nombre, String descripcion, String categoria, BigDecimal precio_estimado, Integer tiempo_estimado_dias, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio_estimado = precio_estimado;
        this.tiempo_estimado_dias = tiempo_estimado_dias;
        this.activo = activo;
    }

    public Servicios(String nombre, String descripcion, String categoria, BigDecimal precio_estimado, Integer tiempo_estimado_dias, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio_estimado = precio_estimado;
        this.tiempo_estimado_dias = tiempo_estimado_dias;
        this.activo = activo;
    }
}