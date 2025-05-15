package sv.edu.udb.ApiRest_Formatec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.ApiRest_Formatec.Model.Alumno;
import sv.edu.udb.ApiRest_Formatec.Repository.AlumnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    // Obtener un alumno por ID
    public Optional<Alumno> obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id);
    }
    public List<Alumno> obtenerTodos(){
        return alumnoRepository.findAll();
    }

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno actualizarAlumno(Long id, Alumno alumno){
        Alumno existente = alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        existente.setNombre(alumno.getNombre());
        existente.setApellido(alumno.getApellido());
        existente.setEdad(alumno.getEdad());
        existente.setFechaNacimiento(alumno.getFechaNacimiento());
        existente.setDui(alumno.getDui());
        existente.setDuiEncargado(alumno.getDuiEncargado());
        existente.setSexo(alumno.getSexo());
        existente.setTelefono(alumno.getTelefono());
        existente.setEmail(alumno.getEmail());
        existente.setMunicipio(alumno.getMunicipio());
        existente.setDistrito(alumno.getDistrito());
        existente.setComunidad(alumno.getComunidad());
        existente.setDireccionResidencia(alumno.getDireccionResidencia());
        existente.setEstado(alumno.getEstado());
        return alumnoRepository.save(existente);
    }

    public void eliminar(Long id){
        alumnoRepository.deleteById(id);
    }
}
