/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica.cliente.logica;

import com.informatica.cliente.presentacion.Modelo;
import com.informatica.cliente.utils.NombreSlider;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class HiloEscuchaBrazoServidor extends Thread {

    private final String raizLog;
    //private Modelo modelo;
    private Socket servidor;
    private Modelo modelo;
    
    private String nombreSlider;
    private Integer valorSlider;
    
    private final boolean lecturaActiva;
    
    
    /**
     * Variables para recibir datos del servidor
     */
    private DataInputStream datosEntrada;
    
    public static final int MAX_BYTES = 200; //Tamaño máximo del mensaje

    public HiloEscuchaBrazoServidor(Socket servidor, Modelo modelo) {
        //this.modelo = modelo;
        this.servidor = servidor;
        this.modelo = modelo;
        this.lecturaActiva = true;
        this.raizLog = "["+this.getName() + "] - ";
    }
    
    //Metodo que retorna la continuación de la comunicación
    public boolean isLecturaActiva() {
        return lecturaActiva;
    }

    @Override
    public void run() {
//        try {
//            
//
//        } catch (IOException e) {
//            System.out.println(raizLog +"IO error in server thread");
//        }

        try {
            while(true){
                
            System.out.println(raizLog + "Leyendo datos de entrada...");
            //capturar los flujos
            datosEntrada = new DataInputStream(servidor.getInputStream());
            //inputBufferReader = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
            //os=new PrintWriter(s.getOutputStream());
            
            //Se leen los datos de entrada del servidor
            String mensajeServidor = "";
                    
            mensajeServidor = leerDataServidor();
            //Se maneja el mensaje
            String[] vectorMensaje = mensajeServidor.split(","); //Se concierte en un vector segun las comas encontradas en el mensaje
            
            //Nombre            
            nombreSlider = vectorMensaje[0];
            System.out.println(raizLog +"El Slider enviado fue : ["+nombreSlider+"]");
            //Valor
            valorSlider = Integer.parseInt(vectorMensaje[1]);
            System.out.println(raizLog +"El Valor del Slider enviado fue : ["+valorSlider+"]");
            // Para almacenar lo que llegue del servidor
            
            moverBrazo(nombreSlider, valorSlider);
            
            
            }

        } catch (IOException e) {

            //readLine=; //reused String readLine for getting thread name
            System.out.println(raizLog +"IO Error/ erver " + this.getName() + " terminated abruptly");
        } catch (NullPointerException e) {
            //readLine=this.getName(); //reused String readLine for getting thread name
            System.out.println(raizLog +"Server " + this.getName() + " Closed");
        } catch (Exception ex) {
            System.out.println(raizLog +"Algun otro error");
        } finally {
            try {
                System.out.println(raizLog +"Connection Closing..");
                if (datosEntrada != null) {
                    datosEntrada.close();
                    System.out.println(raizLog +" Socket Input Stream Closed");
                }

//        if(os!=null){
//            os.close();
//            System.out.println("Socket Out Closed");
//        }
                if (servidor != null) {
                    servidor.close();
                    System.out.println(raizLog +"Socket Closed");
                }

            } catch (IOException ie) {
                System.out.println(raizLog +"Socket Close Error");
            }
        }//end finally
    }



    public String leerDataServidor() throws Exception{

        byte buffer[];
        String mensaje = "";

            // leo lo que envía el server
            System.out.println(raizLog +"Esperando mensaje...");
            
            //Thread.sleep(100);
            
            buffer = new byte[MAX_BYTES];
            datosEntrada.read(buffer); // Se queda acá, hasta que el cliente envíe algo
            //inputBufferReader.read();
            System.out.println(raizLog +"Capturando mensaje del servidor...");

            // decodificar el mensaje
            mensaje = new String(buffer).trim();

            System.out.println(raizLog +"El mensaje enviado por el servidor fue : [" + mensaje + "]");

//            if (mensaje.equals("ADIOS")) {
//                this.lecturaActiva = false;
//            }

        return mensaje;
    }
    
    
    
    
    public void moverBrazo(String nombreSlider, Integer valorSlider) {

        //Falange dig izq
        System.out.println("Entro a cambio de estado..");
        if (nombreSlider.equals(NombreSlider.FALANGE_DIG_IZQ.toString())) {
            System.out.println("Falange dig izq");
            //Mover la falange dig izq
            modelo.girarFalDigIzq(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.FALANGE_DIG_DER.toString())) {
            System.out.println("Falange dig der");
            //Mover la falange dig der
            modelo.girarFalDigDer(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.FALANGE_PROX_IZQ.toString())) {
            System.out.println("Falange prox izq");
            //Mover la falange prox izq
            modelo.girarFalProxIzq(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.FALANGE_PROX_DER.toString())) {
            System.out.println("Falange prox der");
            //Mover la falange prox der
            modelo.girarFalProxDer(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.MANO.toString())) {
            System.out.println("Mano");
            //Mover la mano
            modelo.girarMano(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.ANTEBRAZO.toString())) {
            System.out.println("Antebrazo");
            //Mover el antebrazo
            modelo.girarAnteBrazo(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.BRAZO.toString())) {
            System.out.println("Brazo");
            //Mover el antebrazo
            modelo.girarBrazo(valorSlider);

        }

    }
    
    
}
