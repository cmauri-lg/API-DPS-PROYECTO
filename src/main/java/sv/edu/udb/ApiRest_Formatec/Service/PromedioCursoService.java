package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.PromedioCurso;
import sv.edu.udb.ApiRest_Formatec.Repository.PromedioCursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PromedioCursoService {

    @Autowired
    private PromedioCursoRepository repository;

    public List<PromedioCurso> listar() {
        return repository.findAll();
    }

    public Optional<PromedioCurso> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public PromedioCurso guardar(PromedioCurso promedio) {
        return repository.save(promedio);
    }

    public Optional<PromedioCurso> actualizar(Integer id, PromedioCurso nuevo) {
        return repository.findById(id).map(promedio -> {
            promedio.setInscripcion(nuevo.getInscripcion());
            promedio.setValorPromedio(nuevo.getValorPromedio());
            promedio.setFechaUltimaModificacion(nuevo.getFechaUltimaModificacion());
            return repository.save(promedio);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}

