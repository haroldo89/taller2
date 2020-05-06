package com.informatica.cliente.logica;

import com.informatica.cliente.presentacion.Modelo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import lombok.Setter;

/**
 *
 * @author Vamaya
 */
public class BrazoCliente{
    
    private Modelo modelo;

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
    public BrazoCliente(Modelo modelo) {
        this.modelo = modelo;
    }

    //MÉTODOS
    /**
     * Método para conectarse con el servidor y enviar datos
     *
     * @throws java.io.IOException
     */
    public void conectar() throws IOException {

        //Establecer conexion
        System.out.println("Estableciendo conexion con el servidor...");
        serverSocket = new Socket(serverHost, serverPort);
        
        //Capturo el flujo de salida y lo asocio al dato de salida
        datosSalida = new DataOutputStream(serverSocket.getOutputStream());
        
        System.out.println("Abriendo hilo para recibir de datos del servidor...");
        HiloEscuchaBrazoServidor hiloServidor = new HiloEscuchaBrazoServidor(serverSocket, modelo);
        hiloServidor.start();

    }
    
    public synchronized void enviarMensaje() throws IOException{
        //Establecer el protocolo de mensaje a enviar
        String mensaje = "";
        mensaje = nombreSlider + "," + valorSlider+ ",";
        
        //Opero con los mensajes
        System.out.println("Enviando el mensaje: [" + mensaje + "]");
        
        datosSalida.write(mensaje.getBytes()); // ESTE ES EL PROTOCOLO
        
    }

}
