package com.mycompany.persistenciadatosjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author giova
 */
public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();
        try ( Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {

                String query = "INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("*****  Mensaje creado con exito *****");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajesDB() {
        Conexion db_connect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try ( Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery(); //Se usa este metodo ya que no estamos insertando datos sino solo recibiendo

            while (rs.next()) {
                System.out.println("*****************");
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("***** No se pudieron recuperar los mensajes *****");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();

        try ( Connection conexion = db_connect.get_connection()) {

            PreparedStatement ps = null;

            try {

                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                //Forma 1 hecha en clase
                //ps = conexion.prepareStatement(query);
               // ps.setInt(1, id_mensaje);
                // ps.executeUpdate();
                //PreparedStatement statement = connection.prepareStatement(query);
                
                //Forma 2 hecha en aportes muestra error sino encuentra el id
               PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, id_mensaje);
                int countRowsUpdated = statement.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.out.println("***** Mensaje eliminado con exito *****");
                } else {
      
                
                    System.out.println(" ***** ID NO ENCONTRADO *****");
                    System.out.println("***** Ingrese un ID de mensaje valido *****");
                }
                

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("***** No se pudo borrar el mensaje *****");
            }

        } catch (SQLException e) {
            
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();
        
        try ( Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            
            try {
                String query = "UPDATE mensajes SET mensaje =  ? WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensajes());
                ps.executeUpdate();
                System.out.println("***** Mensaje actulizado correctamente *****");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("***** No se pudo actualizar el mensaje *****");
            }
            
        }catch (SQLException e) {
                System.out.println(e);
            }
    }
}
