package Acatlan.SistemaEstudiantesSpring.servicio;

import Acatlan.SistemaEstudiantesSpring.model.Alumno;

import java.util.List;

public interface IAlumnoServicio {
    public List<Alumno> listarAlumnos();

    public Alumno buscarAlumnoPorId(Integer idAlumno);

    public Alumno guardarAlumno(Alumno alumno);

    public void eliminarAlumnoPorId(Integer idAlumno);

}
