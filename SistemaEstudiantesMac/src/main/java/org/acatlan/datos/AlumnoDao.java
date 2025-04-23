package org.acatlan.datos;

import org.acatlan.dominio.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.acatlan.conexion.Conexion.getConexion;

public class AlumnoDao {
    public List<Alumno> listar(){
        List<Alumno> alumnos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "select * from alumno order by id_alumno";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNumCuenta(rs.getString("num_cuenta"));
                alumno.setCorreo(rs.getString("correo"));

                alumnos.add(alumno);


            }
        } catch (Exception e){
            System.out.println("Error al listar datos: " + e.getMessage());

        }
        // cerrar conexion
        finally {
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar la conexion");
            }
        }
        return alumnos;
    }

    // buscarPorId
    public boolean buscarAlumnoId(Alumno alumno){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "select * from alumno where id_alumno = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getId_alumno());
            rs = ps.executeQuery();
            if(rs.next()){
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNumCuenta(rs.getString("num_cuenta"));
                alumno.setCorreo(rs.getString("correo"));
                return true;
            }
        } catch(Exception e){
            System.out.println("Error al buscar alumno: "+ e.getMessage());
        }
        // cerrar conexion
        finally {
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar la conexion");
            }
        }
        return false;
    }

    public boolean addAlumno(Alumno alumno){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "insert into alumno(nombre, apellido, num_cuenta, correo)" + "values(?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNumCuenta());
            ps.setString(4, alumno.getCorreo());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al agregar alumno: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar la conexion");
            }
        }
        return false;
    }

    public boolean actualizarAlumno(Alumno alumno){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "update alumno set nombre=?, apellido=?, num_cuenta=?, correo=? where id_alumno = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNumCuenta());
            ps.setString(4,alumno.getCorreo());
            ps.setInt(5, alumno.getId_alumno());
            ps.execute();
            return true;
        } catch ( Exception e){
            System.out.println("Error al actualizar alumno: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar la conexion");
            }
        }
        return false;
    }

    public boolean eliminarAlumno(Alumno alumno){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "Delete from alumno where id_alumno = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,alumno.getId_alumno());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al eliminar alumno: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar la conexion");
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var alumnoDao = new AlumnoDao();
        // prueba busquedaId
      /*  var alumno2 = new Alumno(3);
        var find = alumnoDao.buscarAlumnoId(alumno2);
        if(find){
            System.out.println("Alumno: " + alumno2);
        }else{
            System.out.println("alumno No encontrado");
        }*/

        // agregar alumno

        /*var nuevoAlumno = new Alumno("Ricardo", "Pascual", "98765","98765@unam.mx");
        var agregado = alumnoDao.addAlumno(nuevoAlumno);
        if(agregado){
            System.out.println("Alumno agregado: " + nuevoAlumno);
        } else {
            System.out.println("No se agrego el alumno: " + nuevoAlumno);
        }*/
        // actualizar o modificar alumno
        /*var alumnoActualizar = new Alumno(5, "Dana","Gopar","586974","586974@unam.mx");
        var actualizado = alumnoDao.actualizarAlumno(alumnoActualizar);
        if(actualizado)
            System.out.println("Alumno Modificado: " + alumnoActualizar);
        else
            System.out.println("Ocurrio un error al modificar/actualizar");*/

        // eliminar alumno
      /* var alumnoEliminar = new Alumno(4);
        System.out.println("Alumno eliminado: " + alumnoEliminar);
        var eliminado = alumnoDao.eliminarAlumno(alumnoEliminar);
        if(eliminado)
            System.out.println("Alumna eliminada");
        else
            System.out.println("Error al eliminar al alumno");*/

        // prueba de listado
       System.out.println("Lista de Alumnos: ");
        List<Alumno> alumnos = alumnoDao.listar();
        alumnos.forEach(System.out::println);

    }
}
