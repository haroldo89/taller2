/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica.servidor.logica;

import com.informatica.servidor.presentacion.Modelo;
import com.informatica.servidor.utils.NombreSlider;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class HiloEscucharBrazoCliente extends Thread {

    private Modelo modelo;
   private final String raizLog;
    
    private DataOutputStream datosSalida;
    private DataInputStream datosEntrada;
    
    private String nombreSlider;
    private Integer valorSlider;

    public String getNombreSlider() {
        return nombreSlider;
    }

    public Integer getValorSlider() {
        return valorSlider;
    }
    
    

    //Variables para la comunicación (Envío y recepción de datos)
    public static final int MAX_BYTES = 200; //Tamaño máximo del mensaje

    //Variables para el hilo de trabajo
    private final boolean lecturaActiva;

//    String readLine=null;
//    BufferedReader  inputBufferReader = null;
    //PrintWriter os=null;
    private final Socket cliente;

    public Socket getCliente() {
        return cliente;
    }
    
    
    
    private final BrazoServidor servidor;

    public HiloEscucharBrazoCliente(Socket cliente, Modelo modelo, BrazoServidor servidor) {
        this.cliente = cliente;
        this.modelo = modelo;
        this.servidor = servidor;
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
//            //capturar los flujos
//            
//            //os=new PrintWriter(s.getOutputStream());
//
//        } catch (IOException e) {
//            System.out.println(raizLog +"IO error in server thread");
//        }

        try {
            while(true){
            System.out.println(raizLog + "Leyendo datos de entrada...");
            datosEntrada = new DataInputStream(cliente.getInputStream());
            
            //Se leen los datos de entrada del cleinte
            String mensajeCliente = "";
                    
            mensajeCliente = leerDataCliente();
            //Se maneja el mensaje
            String[] vectorMensaje = mensajeCliente.split(","); //Se concierte en un vector segun las comas encontradas en el mensaje

            Boolean error;
            int i = 0;
            do{
                try {
                    error = false;
                    //Valor
                    valorSlider = Integer.parseInt(vectorMensaje[i + 1]);
                    System.out.println(raizLog + "El Valor del Slider enviado fue : [" + valorSlider + "]");
                    //Nombre            
                    nombreSlider = vectorMensaje[i];
                    System.out.println(raizLog + "El Slider enviado fue : [" + nombreSlider + "]");
                } catch (Exception e) {
                    error = true;
                    i++;
                }
            }while(error);
            
            moverBrazo(nombreSlider, valorSlider);
            
            
            actualizarMensajeClientes();
            
            }

        } catch (IOException e) {

            //readLine=; //reused String readLine for getting thread name
            System.out.println(raizLog +"IO Error/ Client " + this.getName() + " terminated abruptly");
        } catch (NullPointerException e) {
            //readLine=this.getName(); //reused String readLine for getting thread name
            System.out.println(raizLog +"Client " + this.getName() + " Closed");
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
                if (cliente != null) {
                    cliente.close();
                    System.out.println(raizLog +"Socket Closed");
                }
                

            } catch (IOException ie) {
                System.out.println(raizLog +"Socket Close Error");
            }
        }//end finally
    }



    public String leerDataCliente() throws Exception{

        byte buffer[];
        String mensaje = "";

            // leo lo que envía el server
            System.out.println(raizLog +"Esperando mensaje...");
            
            //Thread.sleep(100);
            
            buffer = new byte[MAX_BYTES];
            datosEntrada.read(buffer); // Se queda acá, hasta que el cliente envíe algo
            System.out.println(raizLog +"Capturando mensaje del cliente...");

            // decodificar el mensaje
            mensaje = new String(buffer).trim();

            System.out.println(raizLog +"El mensaje enviado por el cliente fue : [" + mensaje + "]");

//            if (mensaje.equals("ADIOS")) {
//                this.lecturaActiva = false;
//            }

        return mensaje;
    }
    
    
    public void actualizarMensajeClientes() throws IOException{
        List<HiloEscucharBrazoCliente> listaHilos = servidor.getListaHilosClientes();
        
        for (HiloEscucharBrazoCliente unHilo : listaHilos) {
            if(!unHilo.getName().equals(this.getName()) && unHilo.isAlive()){
                //Enviar mensaje a los demás
                unHilo.enviarMensaje(this.nombreSlider, this.valorSlider);
            }
            
        }
    }
    
    
    
    
    public void enviarMensaje(String nombreSliderEnviado, Integer ValorSliderEnviado) throws IOException{
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloEscucharBrazoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Establecer el protocolo de mensaje a enviar
        String mensaje = nombreSliderEnviado + "," + ValorSliderEnviado+",";

        //Capturo el flujo de salida y lo asocio al dato de salida
        datosSalida = new DataOutputStream(this.cliente.getOutputStream());

        //Opero con los mensajes
        System.out.println(raizLog + "Enviando el mensaje: [" + mensaje + "]");
        datosSalida.write(mensaje.getBytes()); // ESTE ES EL PROTOCOLO
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            System.out.println("Error");
//        }
        
    }
    

    public void moverBrazo(String nombreSlider, Integer valorSlider) {

        //Falange dig izq
        System.out.println(raizLog + "Entro a cambio de estado..");
        if (nombreSlider.equals(NombreSlider.FALANGE_DIG_IZQ.toString())) {
            System.out.println(raizLog + "Falange dig izq");
            //Mover la falange dig izq
            modelo.girarFalDigIzq(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.FALANGE_DIG_DER.toString())) {
            System.out.println(raizLog + "Falange dig der");
            //Mover la falange dig der
            modelo.girarFalDigDer(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.FALANGE_PROX_IZQ.toString())) {
            System.out.println(raizLog + "Falange prox izq");
            //Mover la falange prox izq
            modelo.girarFalProxIzq(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.FALANGE_PROX_DER.toString())) {
            System.out.println(raizLog + "Falange prox der");
            //Mover la falange prox der
            modelo.girarFalProxDer(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.MANO.toString())) {
            System.out.println(raizLog + "Mano");
            //Mover la mano
            modelo.girarMano(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.ANTEBRAZO.toString())) {
            System.out.println(raizLog + "Antebrazo");
            //Mover el antebrazo
            modelo.girarAnteBrazo(valorSlider);

        } else if (nombreSlider.equals(NombreSlider.BRAZO.toString())) {
            System.out.println(raizLog + "Brazo");
            //Mover el antebrazo
            modelo.girarBrazo(valorSlider);

        }

    }

}
