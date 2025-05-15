package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.Desertado;
import sv.edu.udb.ApiRest_Formatec.Service.DesertadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/desertados")
@CrossOrigin(origins = "*")
public class DesertadoController {

    @Autowired
    private DesertadoService service;

    @GetMapping
    public List<Desertado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desertado> obtener(@PathVariable Integer id) {
        Optional<Desertado> desertado = service.obtenerPorId(id);
        return desertado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Desertado> guardar(@RequestBody Desertado nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desertado> actualizar(@PathVariable Integer id, @RequestBody Desertado nuevo) {
        Optional<Desertado> actualizado = service.actualizar(id, nuevo);
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

