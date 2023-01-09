/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistenciadatosjava;

import java.util.Scanner;

/**
 *
 * @author giova
 */
public class MensajesService {
    
    public static void crearMensaje(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = leer.nextLine();
        
        System.out.println("Author");
        String nombre = leer.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        
    }
    
    public static void borrarMensaje(){
        
    }
    
    public static void editarMensaje(){
        
    }
}
