package com.informatica.servidor.logica;

import com.informatica.servidor.presentacion.Modelo;
import com.informatica.servidor.utils.NombreSlider;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Vamaya
 */
public class BrazoServidor {
    //VARIABLES
    
    private Modelo modelo;
    
    
    /**
     * Variables de la conexión del servidor
     */
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private final int serverPort;    
    
    /**
     * Variables para recibir datos del cliente
     */
    private DataInputStream datosEntrada;
    public static final int MAX_BYTES = 200; //Tamaño máximo del mensaje
    
    /**
     * Variable booleana para esperar indefinidamente respuestas del cliente
     */
    private final boolean conectarActivo;
    
    
    //CONSTRUCTOR
    
    public BrazoServidor(Modelo modelo) {
        serverPort = 5000;
        conectarActivo = true;
        this.modelo = modelo;
    }       
    
    //MÉTODOS
    
    
    public void conectar() throws IOException {
                       
        // Crear el servidor
        serverSocket = new ServerSocket(serverPort);
        
        while (conectarActivo) {
            //Se queda esperando que se conecte un cliente
            clientSocket = serverSocket.accept();
            //Define donde se leeran los datos de ntrada
            datosEntrada = new DataInputStream(clientSocket.getInputStream());
            //Se leen los datos de entrada del cleinte
            String mensajeCliente = leerDataCliente();
            //Se maneja el mensaje
            String[] vectorMensaje = mensajeCliente.split(","); //Se concierte en un vector segun las comas encontradas en el mensaje

            //Nombre            
            String nombreSlider = vectorMensaje[0];
            System.out.println("El Slider enviado fue : ["+nombreSlider+"]");
            //Valor
            Integer valorSlider = Integer.parseInt(vectorMensaje[1]);
            System.out.println("El Valor del Slider enviado fue : ["+valorSlider+"]");
            
            moverBrazo(nombreSlider, valorSlider);
            
        }
        
    }
    
    
    public String leerDataCliente() {

        byte buffer[];
        String mensaje = "";
        
        try {
            // leo lo que envía el server
            System.out.println("Esperando mensaje...");
            buffer = new byte[MAX_BYTES];
            datosEntrada.read(buffer); // Se queda acá, hasta que el cliente envíe algo
            System.out.print("Capturando mensaje del cliente...");

            // decodificar el mensaje
            mensaje = new String(buffer).trim();

            System.out.println("El mensaje enviado fue : ["+mensaje+"]");
            
           
//            if (mensaje.equals("ADIOS")) {
//                this.lecturaActiva = false;
//            }

        } catch (IOException ex) {
            System.out.println("error en la comunicación");
        }
        
        return mensaje;
    }
    
    
    
    public void moverBrazo(String nombreSlider, Integer valorSlider){
        
        //Falange dig izq
        System.out.println("Entro a cambio de estado..");
        if (nombreSlider.equals(NombreSlider.FALANGE_DIG_IZQ.toString())) {
            System.out.println("Falange dig izq");
            //Mover la falange dig izq
            modelo.girarFalDigIzq();

        } else if (nombreSlider.equals(NombreSlider.FALANGE_DIG_DER.toString())) {
            System.out.println("Falange dig der");
            //Mover la falange dig der
            modelo.girarFalDigDer();

        } else if (nombreSlider.equals(NombreSlider.FALANGE_PROX_IZQ.toString())) {
            System.out.println("Falange prox izq");
            //Mover la falange prox izq
            modelo.girarFalProxIzq();

        } else if (nombreSlider.equals(NombreSlider.FALANGE_PROX_DER.toString())) {
            System.out.println("Falange prox der");
            //Mover la falange prox der
            modelo.girarFalProxDer();

        } else if (nombreSlider.equals(NombreSlider.MANO.toString())) {
            System.out.println("Mano");
            //Mover la mano
            modelo.girarMano();

        } else if (nombreSlider.equals(NombreSlider.ANTEBRAZO.toString())) {
            System.out.println("Antebrazo");
            //Mover el antebrazo
            modelo.girarAnteBrazo();

        } else if (nombreSlider.equals(NombreSlider.BRAZO.toString())) {
            System.out.println("Brazo");
            //Mover el antebrazo
            modelo.girarBrazo();

        }
        
    }
    
}
