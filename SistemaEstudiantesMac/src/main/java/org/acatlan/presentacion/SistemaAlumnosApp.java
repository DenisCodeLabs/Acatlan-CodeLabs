package org.acatlan.presentacion;

import org.acatlan.datos.AlumnoDao;
import org.acatlan.dominio.Alumno;

import java.util.Scanner;

public class SistemaAlumnosApp {
    public static void main(String[] args) {

        var salir = false;
        var consola = new Scanner(System.in);

        // instancia a la clase de servicio
        var alumnoDao = new AlumnoDao();
        while(!salir){
            try{
                showMenu();
                salir = ejecutarOpciones(consola, alumnoDao);
            } catch(Exception e){
                System.out.println("Ocurrio un error al ejecutar: " + e.getMessage());

            }
            System.out.println();
        }
    }

    private static void showMenu(){
        System.out.println("""
                *** Sistema de Alumnos *** 
                1. Listar Alumnos
                2. Buscar Alumno
                3. Agregar Alumno
                4. Modificar Alumno 
                5. Eliminar Alumno
                6. Salir
                Elige una opcion:                               
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, AlumnoDao alumnoDao){

        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        if(opcion == 1) {
            System.out.println("Listado de Alumnos: ");
            var alumnos = alumnoDao.listar();
            alumnos.forEach(System.out::println);

        } else if (opcion == 2){
            System.out.println("Ingresa el Id a buscar: ");
            var idAlumno = Integer.parseInt(consola.nextLine());
            var alumno = new Alumno(idAlumno);
            var encontrado = alumnoDao.buscarAlumnoId(alumno);
            System.out.println((encontrado ? "Alumno Encontrado: " : "Alumno NO Encontrado: ") + alumno);

        } else if (opcion == 3){
            System.out.println("Agregar Alumno: ");
            System.out.println("Nombre: ");
            var nombre = consola.nextLine();
            System.out.println("Apellido: ");
            var apellido = consola.nextLine();
            System.out.println("Numero de cuenta: ");
            var numCuenta = consola.nextLine();
            System.out.println("Correo: ");
            var correo = consola.nextLine();
            var alumno = new Alumno(nombre, apellido, numCuenta, correo);
            var agregado = alumnoDao.addAlumno(alumno);
            System.out.println((agregado ? "Alumno Agregado: " : "Alumno NO Agregado: ") + alumno);

        } else if (opcion == 4){
            System.out.println("Actualizar Alumno: ");
            System.out.println("Ingresa el Id: ");
            var idAlumno = Integer.parseInt(consola.nextLine());
            System.out.println("Nombre: ");
            var nombre = consola.nextLine();
            System.out.println("Apellido: ");
            var apellido = consola.nextLine();
            System.out.println("Numero de cuenta: ");
            var numCuenta = consola.nextLine();
            System.out.println("Correo: ");
            var correo = consola.nextLine();
            var alumno = new Alumno(idAlumno, nombre, apellido, numCuenta, correo);
            var actualizado = alumnoDao.actualizarAlumno(alumno);
            System.out.println((actualizado ? "Alumno Actualizado: " : "Alumno NO Actualizado: ") + alumno);

        } else if (opcion == 5){
            System.out.println("Eliminar Alumno: ");
            System.out.println("Ingresa el Id: ");
            var idAlumno = Integer.parseInt(consola.nextLine());
            var alumno = new Alumno(idAlumno);
            var eliminado = alumnoDao.eliminarAlumno(alumno);
            System.out.println((eliminado ? "Alumno Eliminado: " : "Alumno NO Eliminado: ") + alumno);

        } else if (opcion == 6){
            System.out.println("Hasta Pronto!");
            salir = true;
        }
        else
            System.out.println("Opcion No Reconocida");

        return salir;
    }

}