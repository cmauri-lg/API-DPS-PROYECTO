package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.ResultadoExamen;
import sv.edu.udb.ApiRest_Formatec.Service.ResultadoExamenService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados")
@CrossOrigin(origins = "*")
public class ResultadoExamenController {

    @Autowired
    private ResultadoExamenService service;

    @GetMapping
    public List<ResultadoExamen> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoExamen> obtener(@PathVariable Integer id) {
        Optional<ResultadoExamen> resultado = service.obtenerPorId(id);
        return resultado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResultadoExamen> guardar(@RequestBody ResultadoExamen nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoExamen> actualizar(@PathVariable Integer id, @RequestBody ResultadoExamen nuevo) {
        Optional<ResultadoExamen> actualizado = service.actualizar(id, nuevo);
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
