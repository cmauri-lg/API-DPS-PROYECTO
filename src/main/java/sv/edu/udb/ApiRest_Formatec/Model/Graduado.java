package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Graduados")
public class Graduado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGraduado;

    @ManyToOne
    @JoinColumn(name = "idHistorial", nullable = false)
    private HistorialInscripcion historial;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    private LocalDate fechaGraduacion;

    // Getters y Setters
    public Integer getIdGraduado() {
        return idGraduado;
    }

    public void setIdGraduado(Integer idGraduado) {
        this.idGraduado = idGraduado;
    }

    public HistorialInscripcion getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialInscripcion historial) {
        this.historial = historial;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }
}
