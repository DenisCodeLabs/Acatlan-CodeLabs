package org.acatlan.dominio;

public class Alumno {
    private int id_alumno;
    private String nombre;
    private String apellido;
    private String numCuenta;
    private String correo;


    public Alumno(){}

    public Alumno(int idAlumno) {
        this.id_alumno = idAlumno;
    }

    public Alumno(String nombre, String apellido, String numCuenta, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCuenta = numCuenta;
        this.correo = correo;
    }

    public Alumno(int id_alumno, String nombre, String apellido, String numCuenta, String correo) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCuenta = numCuenta;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id_alumno=" + id_alumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
