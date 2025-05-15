package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PromedioCurso")
public class PromedioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromedio;

    @ManyToOne
    @JoinColumn(name = "idInscripcion", nullable = false)
    private InscripcionActiva inscripcion;

    private Double valorPromedio;

    private LocalDate fechaUltimaModificacion;

    // Getters y Setters
    public Integer getIdPromedio() {
        return idPromedio;
    }

    public void setIdPromedio(Integer idPromedio) {
        this.idPromedio = idPromedio;
    }

    public InscripcionActiva getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionActiva inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Double getValorPromedio() {
        return valorPromedio;
    }

    public void setValorPromedio(Double valorPromedio) {
        this.valorPromedio = valorPromedio;
    }

    public LocalDate getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDate fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }
}
