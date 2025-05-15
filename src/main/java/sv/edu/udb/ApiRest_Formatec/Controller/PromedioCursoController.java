package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.PromedioCurso;
import sv.edu.udb.ApiRest_Formatec.Service.PromedioCursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promedios")
@CrossOrigin(origins = "*")
public class PromedioCursoController {

    @Autowired
    private PromedioCursoService service;

    @GetMapping
    public List<PromedioCurso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromedioCurso> obtener(@PathVariable Integer id) {
        Optional<PromedioCurso> promedio = service.obtenerPorId(id);
        return promedio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PromedioCurso> guardar(@RequestBody PromedioCurso nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromedioCurso> actualizar(@PathVariable Integer id, @RequestBody PromedioCurso nuevo) {
        Optional<PromedioCurso> actualizado = service.actualizar(id, nuevo);
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
