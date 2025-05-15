package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.ResultadoExamen;
import sv.edu.udb.ApiRest_Formatec.Repository.ResultadoExamenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoExamenService {

    @Autowired
    private ResultadoExamenRepository repository;

    public List<ResultadoExamen> listar() {
        return repository.findAll();
    }

    public Optional<ResultadoExamen> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public ResultadoExamen guardar(ResultadoExamen resultado) {
        return repository.save(resultado);
    }

    public Optional<ResultadoExamen> actualizar(Integer id, ResultadoExamen nuevo) {
        return repository.findById(id).map(resultado -> {
            resultado.setInscripcion(nuevo.getInscripcion());
            resultado.setExamen(nuevo.getExamen());
            resultado.setNota(nuevo.getNota());
            return repository.save(resultado);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}

