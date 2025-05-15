package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ResultadosExamenes")
public class ResultadoExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResultado;

    @ManyToOne
    @JoinColumn(name = "idInscripcion", nullable = false)
    private InscripcionActiva inscripcion;

    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = false)
    private Examen examen;

    private Double nota;

    // Getters y Setters
    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public InscripcionActiva getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionActiva inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}

