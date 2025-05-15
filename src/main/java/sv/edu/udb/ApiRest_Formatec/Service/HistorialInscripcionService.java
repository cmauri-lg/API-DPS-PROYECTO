package sv.edu.udb.ApiRest_Formatec.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.HistorialInscripcion;
import sv.edu.udb.ApiRest_Formatec.Repository.HistorialInscripcionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialInscripcionService {

    @Autowired
    private HistorialInscripcionRepository repository;

    public List<HistorialInscripcion> listar() {
        return repository.findAll();
    }

    public Optional<HistorialInscripcion> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public HistorialInscripcion guardar(HistorialInscripcion historial) {
        return repository.save(historial);
    }

    public Optional<HistorialInscripcion> actualizar(Integer id, HistorialInscripcion nuevo) {
        return repository.findById(id).map(historial -> {
            historial.setAlumno(nuevo.getAlumno());
            historial.setInscripcion(nuevo.getInscripcion());
            historial.setFechaInscripcion(nuevo.getFechaInscripcion());
            historial.setEstado(nuevo.getEstado());
            return repository.save(historial);
        });
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return repository.existsById(id);
    }
}
