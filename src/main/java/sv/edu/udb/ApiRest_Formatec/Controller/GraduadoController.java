package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.Graduado;
import sv.edu.udb.ApiRest_Formatec.Service.GraduadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/graduados")
@CrossOrigin(origins = "*")
public class GraduadoController {

    @Autowired
    private GraduadoService service;

    @GetMapping
    public List<Graduado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Graduado> obtener(@PathVariable Integer id) {
        Optional<Graduado> graduado = service.obtenerPorId(id);
        return graduado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Graduado> guardar(@RequestBody Graduado nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Graduado> actualizar(@PathVariable Integer id, @RequestBody Graduado nuevo) {
        Optional<Graduado> actualizado = service.actualizar(id, nuevo);
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