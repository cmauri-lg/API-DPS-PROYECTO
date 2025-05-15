package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.RightJoin;
import sv.edu.udb.ApiRest_Formatec.Service.RightJoinService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rightjoin")
@CrossOrigin(origins = "*")
public class RightJoinController {

    @Autowired
    private RightJoinService service;

    @GetMapping
    public List<RightJoin> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RightJoin> obtener(@PathVariable Integer id) {
        Optional<RightJoin> nota = service.obtenerPorId(id);
        return nota.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RightJoin> guardar(@RequestBody RightJoin nuevo) {
        return ResponseEntity.ok(service.guardar(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RightJoin> actualizar(@PathVariable Integer id, @RequestBody RightJoin nuevo) {
        Optional<RightJoin> actualizado = service.actualizar(id, nuevo);
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

