package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.Curso;
import sv.edu.udb.ApiRest_Formatec.Repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> actualizarCurso(Integer id, Curso cursoActualizado) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(cursoActualizado.getNombre());
            curso.setDescripcion(cursoActualizado.getDescripcion());
            curso.setDuracion(cursoActualizado.getDuracion());
            curso.setNivel(cursoActualizado.getNivel());
            curso.setEstado(cursoActualizado.getEstado());
            return cursoRepository.save(curso);
        });
    }

    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }

    public boolean existeCurso(Integer id) {
        return cursoRepository.existsById(id);
    }
}
