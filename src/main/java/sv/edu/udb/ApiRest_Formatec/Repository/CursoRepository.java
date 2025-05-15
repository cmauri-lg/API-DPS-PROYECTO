package sv.edu.udb.ApiRest_Formatec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.ApiRest_Formatec.Model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
