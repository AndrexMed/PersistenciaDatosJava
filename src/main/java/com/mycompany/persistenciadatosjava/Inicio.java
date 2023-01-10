package com.mycompany.persistenciadatosjava;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author giova
 */
public class Inicio {
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        int opcion = 0;
        
        do {            
            System.out.println("------------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");
            //Leemos la opcion del usuario
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                    case 2:
                    MensajesService.listarMensajes();
                    break;
                    case 3:
                    MensajesService.borrarMensaje();
                    break;
                    case 4:
                    MensajesService.editarMensaje();
                    break;
                    
                default:
                    System.out.println("***** Salida Exitosa ****");
            }
        } while (opcion != 5);
        
        
    }
}
