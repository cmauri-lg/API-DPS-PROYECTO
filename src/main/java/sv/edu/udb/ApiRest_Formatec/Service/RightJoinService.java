package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.RightJoin;
import sv.edu.udb.ApiRest_Formatec.Repository.RightJoinRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RightJoinService {

    @Autowired
    private RightJoinRepository repository;

    public List<RightJoin> listar() {
        return repository.findAll();
    }

    public Optional<RightJoin> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public RightJoin guardar(RightJoin nota) {
        return repository.save(nota);
    }

    public Optional<RightJoin> actualizar(Integer id, RightJoin nuevo) {
        return repository.findById(id).map(nota -> {
            nota.setInscripcion(nuevo.getInscripcion());
            nota.setResultado(nuevo.getResultado());
            return repository.save(nota);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}
