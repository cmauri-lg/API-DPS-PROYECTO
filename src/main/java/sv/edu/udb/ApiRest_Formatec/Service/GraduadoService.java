package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.Graduado;
import sv.edu.udb.ApiRest_Formatec.Repository.GraduadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GraduadoService {

    @Autowired
    private GraduadoRepository repository;

    public List<Graduado> listar() {
        return repository.findAll();
    }

    public Optional<Graduado> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Graduado guardar(Graduado graduado) {
        return repository.save(graduado);
    }

    public Optional<Graduado> actualizar(Integer id, Graduado nuevo) {
        return repository.findById(id).map(graduado -> {
            graduado.setHistorial(nuevo.getHistorial());
            graduado.setCurso(nuevo.getCurso());
            graduado.setFechaGraduacion(nuevo.getFechaGraduacion());
            return repository.save(graduado);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}
