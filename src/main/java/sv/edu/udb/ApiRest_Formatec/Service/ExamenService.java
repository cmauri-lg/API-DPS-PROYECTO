package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.Examen;
import sv.edu.udb.ApiRest_Formatec.Repository.ExamenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository repository;

    public List<Examen> listar() {
        return repository.findAll();
    }

    public Optional<Examen> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Examen guardar(Examen examen) {
        return repository.save(examen);
    }

    public Optional<Examen> actualizar(Integer id, Examen nuevo) {
        return repository.findById(id).map(examen -> {
            examen.setCurso(nuevo.getCurso());
            examen.setNombre(nuevo.getNombre());
            examen.setFecha(nuevo.getFecha());
            return repository.save(examen);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}

