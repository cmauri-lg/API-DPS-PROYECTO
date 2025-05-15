package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HistorialInscripciones")
public class HistorialInscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorial;

    @ManyToOne
    @JoinColumn(name = "idAlumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idInscripcion", nullable = false)
    private InscripcionActiva inscripcion;

    private LocalDate fechaInscripcion;

    private String estado;

    // Getters y Setters
    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public InscripcionActiva getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionActiva inscripcion) {
        this.inscripcion = inscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
