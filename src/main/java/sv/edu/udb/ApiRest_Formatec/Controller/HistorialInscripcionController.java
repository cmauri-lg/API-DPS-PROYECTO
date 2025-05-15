package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.HistorialInscripcion;
import sv.edu.udb.ApiRest_Formatec.Service.HistorialInscripcionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*")
public class HistorialInscripcionController {

    @Autowired
    private HistorialInscripcionService service;

    @GetMapping
    public List<HistorialInscripcion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialInscripcion> obtener(@PathVariable Integer id) {
        Optional<HistorialInscripcion> historial = service.obtenerPorId(id);
        return historial.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialInscripcion> guardar(@RequestBody HistorialInscripcion nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialInscripcion> actualizar(@PathVariable Integer id, @RequestBody HistorialInscripcion nuevo) {
        Optional<HistorialInscripcion> actualizado = service.actualizar(id, nuevo);
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

