package sv.edu.udb.ApiRest_Formatec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.ApiRest_Formatec.Model.Alumno;
import sv.edu.udb.ApiRest_Formatec.Service.AlumnoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    //Obtener todos los alumnos
    @GetMapping
    public List<Alumno> obtenerAlumnos(){
        return alumnoService.obtenerTodos();
    }

    // Obtener un alumno por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.obtenerAlumnoPorId(id);
        return alumno.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Crear un nuevo alumno
    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.crearAlumno(alumno));
    }

    // Modificar un alumno existente
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.actualizarAlumno(id, alumno));
    }

    //Eliminar Alumno existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id){
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
