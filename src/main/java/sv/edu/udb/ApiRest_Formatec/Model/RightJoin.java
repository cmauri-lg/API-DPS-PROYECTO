package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "RightJoin")
public class RightJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    @ManyToOne
    @JoinColumn(name = "idInscripcion", nullable = false)
    private InscripcionActiva inscripcion;

    @ManyToOne
    @JoinColumn(name = "idResultado", nullable = false)
    private ResultadoExamen resultado;

    // Getters y Setters
    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public InscripcionActiva getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionActiva inscripcion) {
        this.inscripcion = inscripcion;
    }

    public ResultadoExamen getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoExamen resultado) {
        this.resultado = resultado;
    }
}
