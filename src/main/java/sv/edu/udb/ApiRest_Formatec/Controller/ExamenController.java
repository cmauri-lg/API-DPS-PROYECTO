package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.Examen;
import sv.edu.udb.ApiRest_Formatec.Service.ExamenService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/examenes")
@CrossOrigin(origins = "*")
public class ExamenController {

    @Autowired
    private ExamenService service;

    @GetMapping
    public List<Examen> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> obtener(@PathVariable Integer id) {
        Optional<Examen> examen = service.obtenerPorId(id);
        return examen.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Examen> guardar(@RequestBody Examen nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> actualizar(@PathVariable Integer id, @RequestBody Examen nuevo) {
        Optional<Examen> actualizado = service.actualizar(id, nuevo);
        return actualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!service.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
