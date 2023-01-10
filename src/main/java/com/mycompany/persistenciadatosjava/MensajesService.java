package com.mycompany.persistenciadatosjava;

import java.util.Scanner;

/**
 *
 * @author giova
 */
public class MensajesService {
    
    public static void crearMensaje(){
        Scanner leer = new Scanner(System.in);
        System.out.println("***** Escribe tu mensaje *****");
        String mensaje = leer.nextLine();
        
        System.out.println("***** Author *****");
        String nombre = leer.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner leer = new Scanner(System.in);
        System.out.println("***** Indica el -ID- del mensaje a borrar *****");
                int id_mensaje = leer.nextInt();
                
                MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    
    public static void editarMensaje(){
        
    }
}
