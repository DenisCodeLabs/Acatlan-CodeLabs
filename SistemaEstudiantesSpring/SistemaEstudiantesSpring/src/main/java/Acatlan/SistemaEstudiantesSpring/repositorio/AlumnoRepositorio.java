package Acatlan.SistemaEstudiantesSpring.repositorio;

import Acatlan.SistemaEstudiantesSpring.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {
}
