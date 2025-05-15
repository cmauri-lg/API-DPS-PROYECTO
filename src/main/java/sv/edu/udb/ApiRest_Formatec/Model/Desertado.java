package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Desertados")
public class Desertado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesertado;

    @ManyToOne
    @JoinColumn(name = "idHistorial", nullable = false)
    private HistorialInscripcion historial;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    @Column(columnDefinition = "TEXT")
    private String motivo;

    private LocalDate fechaRetiro;

    // Getters y Setters
    public Integer getIdDesertado() {
        return idDesertado;
    }

    public void setIdDesertado(Integer idDesertado) {
        this.idDesertado = idDesertado;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }
}
