package Acatlan.SistemaEstudiantesSpring.servicio;

import Acatlan.SistemaEstudiantesSpring.model.Alumno;
import Acatlan.SistemaEstudiantesSpring.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicio implements IAlumnoServicio{

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    @Override
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = alumnoRepositorio.findAll();
        return alumnos;
    }

    @Override
    public Alumno buscarAlumnoPorId(Integer idAlumno) {
        Alumno alumno = alumnoRepositorio.findById(idAlumno).orElse(null);
        return alumno;
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    @Override
    public void eliminarAlumnoPorId(Integer idAlumno) {
        this.alumnoRepositorio.deleteById(idAlumno);

    }
}
