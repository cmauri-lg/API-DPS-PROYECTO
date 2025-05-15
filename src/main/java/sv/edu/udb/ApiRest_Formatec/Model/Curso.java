package sv.edu.udb.ApiRest_Formatec.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String duracion;
    private String nivel;
    private String estado;

    // Relaciones
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<InscripcionActiva> inscripciones;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Examen> examenes;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Graduado> graduados;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Desertado> desertados;

    // Getters y Setters

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<InscripcionActiva> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionActiva> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    public List<Graduado> getGraduados() {
        return graduados;
    }

    public void setGraduados(List<Graduado> graduados) {
        this.graduados = graduados;
    }

    public List<Desertado> getDesertados() {
        return desertados;
    }

    public void setDesertados(List<Desertado> desertados) {
        this.desertados = desertados;
    }
}

