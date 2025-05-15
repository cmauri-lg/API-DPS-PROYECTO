package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.InscripcionActiva;
import sv.edu.udb.ApiRest_Formatec.Service.InscripcionActivaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionActivaController {

    @Autowired
    private InscripcionActivaService service;

    @GetMapping
    public List<InscripcionActiva> listar() {
        return service.listarInscripciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionActiva> obtener(@PathVariable Integer id) {
        Optional<InscripcionActiva> resultado = service.obtenerPorId(id);
        return resultado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InscripcionActiva> guardar(@RequestBody InscripcionActiva inscripcion) {
        return ResponseEntity.ok(service.guardar(inscripcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionActiva> actualizar(@PathVariable Integer id, @RequestBody InscripcionActiva nueva) {
        Optional<InscripcionActiva> resultado = service.actualizar(id, nueva);
        return resultado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
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

