
package com.informatica.cliente.logica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import lombok.Setter;

/**
 *
 * @author Vamaya
 */
public class BrazoCliente{
    //VARIABLES
    /**
     * Variables para la conexión con el servidor
     */
    private final String serverHost = "localhost";
    private final int serverPort = 5000;
    private Socket serverSocket;

    /**
     * Variables para el envío de datos al servidor
     */
    private DataOutputStream datosSalida;
    
    /**
     * Variables para guardfar valores del slider modificado
     */
    @Setter
    private String nombreSlider;
    @Setter
    private int valorSlider;
    
    //CONSTRUCTOR
    /**
     * Default constructor
     */
    public BrazoCliente() {
        
    }

    //MÉTODOS
    
    
    /**
     * Método para conectarse con el servidor y enviar datos
     * @throws java.io.IOException
     */
    public void conectar() throws IOException {

        //Establecer conexion
        serverSocket = new Socket(serverHost, serverPort);

        //Establecer el protocolo de mensaje a enviar
        String mensaje = nombreSlider + "," + valorSlider;

        //Capturo el flujo de salida y lo asocio al dato de salida
        datosSalida = new DataOutputStream(serverSocket.getOutputStream());

        //Opero con los mensajes
        System.out.println("Enviando el mensaje: [" + mensaje + "]");
        datosSalida.write(mensaje.getBytes()); // ESTE ES EL PROTOCOLO

        //Se cierra todo
        datosSalida.close();
        serverSocket.close();

    }

    
    
}
