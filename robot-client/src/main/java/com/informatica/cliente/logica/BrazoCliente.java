package com.informatica.cliente.logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import lombok.Setter;

/**
 *
 * @author Vamaya
 */
public class BrazoCliente {

    public static final int MAX_BYTES = 200; //Tamaño máximo del mensaje

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
    private DataInputStream datosEntrada;

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
     *
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

    public void run() {
        // Para almacenar lo que llegue del servidor
        byte buffer[];
        while (true) {
            try {
                // leo lo que envía el server
                System.out.println("Esperando mensaje...");
                buffer = new byte[MAX_BYTES];
                datosEntrada.read(buffer); // Se queda acá, hasta que el servidor envíe algo
                System.out.print("El servidor envía: ");
                // decodificar el mensaje
                String mensaje = new String(buffer).trim();
                
                System.out.println(mensaje);
                
            } catch (IOException ex) {
                System.out.println("error en la comunicación");
            }
        }
    }

}
