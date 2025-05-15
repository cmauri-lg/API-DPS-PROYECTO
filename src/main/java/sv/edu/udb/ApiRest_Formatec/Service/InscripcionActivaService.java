package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.InscripcionActiva;
import sv.edu.udb.ApiRest_Formatec.Repository.InscripcionActivaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionActivaService {

    @Autowired
    private InscripcionActivaRepository repository;

    public List<InscripcionActiva> listarInscripciones() {
        return repository.findAll();
    }

    public Optional<InscripcionActiva> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public InscripcionActiva guardar(InscripcionActiva inscripcion) {
        return repository.save(inscripcion);
    }

    public Optional<InscripcionActiva> actualizar(Integer id, InscripcionActiva nueva) {
        return repository.findById(id).map(inscripcion -> {
            inscripcion.setAlumno(nueva.getAlumno());
            inscripcion.setCurso(nueva.getCurso());
            inscripcion.setFechaInscripcion(nueva.getFechaInscripcion());
            return repository.save(inscripcion);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}