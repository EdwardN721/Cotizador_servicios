package aurora.servicios.servicios_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@NoArgsConstructor
public class EstadosSolicitud {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 7)
    private String color;

    private Integer orden = 0;

    private Boolean activo = true;

    public EstadosSolicitud(Long id, String nombre, String descripcion, String color, Integer orden, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
        this.orden = orden;
        this.activo = activo;
    }

    public EstadosSolicitud(String nombre, String descripcion, String color, Integer orden, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
        this.orden = orden;
        this.activo = activo;
    }
}
