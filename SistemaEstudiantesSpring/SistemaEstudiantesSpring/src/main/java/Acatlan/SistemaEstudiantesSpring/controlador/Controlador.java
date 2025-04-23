package Acatlan.SistemaEstudiantesSpring.controlador;

import Acatlan.SistemaEstudiantesSpring.excepcion.RecursoNoEncontradoExcepcion;
import Acatlan.SistemaEstudiantesSpring.model.Alumno;
import Acatlan.SistemaEstudiantesSpring.servicio.AlumnoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("alumnos-api")
@CrossOrigin(value = "http://localhost:4200")
public class Controlador {

    private static final Logger logger = LoggerFactory.getLogger(Controlador.class);

    @Autowired
    private AlumnoServicio alumnoServicio;

    @GetMapping("/alumnos")
    public List<Alumno> getAlumnos(){
        List<Alumno> alumnos = this.alumnoServicio.listarAlumnos();
        logger.info("Alumnos obtenidos: ");
        alumnos.forEach((alumno -> logger.info(alumno.toString())));
        return alumnos;
    }
    @PostMapping("/alumnos")
    public Alumno agregarAlumno(@RequestBody Alumno alumno){
        logger.info("Alumno a Agregar: " + alumno);
        return this.alumnoServicio.guardarAlumno(alumno);

    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable int id){
        Alumno alumno = this.alumnoServicio.buscarAlumnoPorId(id);
        if(alumno != null){
            return ResponseEntity.ok(alumno);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id " + id);
        }
    }

    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(
            @PathVariable int id,
            @RequestBody Alumno alumnoIngresado){
        Alumno alumno = this.alumnoServicio.buscarAlumnoPorId(id);
        alumno.setNombre(alumnoIngresado.getNombre());
        alumno.setApellido(alumnoIngresado.getApellido());
        alumno.setNum_cuenta(alumnoIngresado.getNum_cuenta());
        alumno.setCorreo(alumnoIngresado.getCorreo());
        this.alumnoServicio.guardarAlumno(alumno);

        return ResponseEntity.ok(alumno);
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Map<String, Boolean>> aliminarAlumno(@PathVariable int id){
        Alumno alumno = alumnoServicio.buscarAlumnoPorId(id);
        if(alumno == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + id);
        this.alumnoServicio.eliminarAlumnoPorId(alumno.getIdAlumno());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado con Exito", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
