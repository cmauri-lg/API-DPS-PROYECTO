package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.Desertado;
import sv.edu.udb.ApiRest_Formatec.Repository.DesertadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DesertadoService {

    @Autowired
    private DesertadoRepository repository;

    public List<Desertado> listar() {
        return repository.findAll();
    }

    public Optional<Desertado> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Desertado guardar(Desertado desertado) {
        return repository.save(desertado);
    }

    public Optional<Desertado> actualizar(Integer id, Desertado nuevo) {
        return repository.findById(id).map(desertado -> {
            desertado.setHistorial(nuevo.getHistorial());
            desertado.setCurso(nuevo.getCurso());
            desertado.setMotivo(nuevo.getMotivo());
            desertado.setFechaRetiro(nuevo.getFechaRetiro());
            return repository.save(desertado);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}
