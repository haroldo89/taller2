package com.informatica.proyecto1.presentacion;

// import logica;
import com.informatica.proyecto1.logica.BrazoRobot;
import com.informatica.proyecto1.utils.Constantes;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author harol
 */
public class Modelo implements Runnable {
    
    //VARIABLES
    private Vista ventanaApp;
    private BrazoRobot brazoCompleto;
    Boolean inicio = true;
    
    //CONSTRUCTOR
    public Modelo() {
        ventanaApp = new Vista(this);
        brazoCompleto = new BrazoRobot();
    }

    
    //GETTERS
    public Vista getVentanaApp() {
        if(ventanaApp == null){
            ventanaApp = new Vista(this);
        }
        return ventanaApp;
    }

    public BrazoRobot getBrazoCompleto() {
        if(brazoCompleto == null){
            brazoCompleto = new BrazoRobot();
        }
        return brazoCompleto;
    }
    
    
    
    
    
    /**
     * Metodo para iniciar la ventana principal de la aplicación
     */
    public void iniciar() {
        getVentanaApp().setSize(Constantes.ANCHO_MAXIMO_FRAME, Constantes.ALTO_MAXIMO_FRAME);
        getVentanaApp().setVisible(true); 
        run();
    }

    
    //METODOS
    public void girarFalDigIzq(){
        int alphaGrados = getVentanaApp().getSldrFalangeDigIzq().getValue();
        System.out.println("Grados: " + alphaGrados);
        //getBrazo().girarFalDidIzq(alphaGrados);
        getBrazoCompleto().getDedoIzq().getHuesoUnido().girarHueso(alphaGrados);
                //.getFalangeDigitalIzquierda().girarHueso(alphaGrados);
        dibujar();
    }
    
    
    public void girarFalDigDer(){
        int alphaGrados = getVentanaApp().getSldFalangeDigDer().getValue();
        System.out.println("Grados: " + alphaGrados);
        getBrazoCompleto().getDedoDer().getHuesoUnido().girarHueso(alphaGrados);
                //.getFalangeDigitalDerecha().girarHueso(alphaGrados);
                //girarFalDidDer(alphaGrados);
        dibujar();
    }
    
    
    
    public void girarFalProxIzq(){
        int alphaGrados = getVentanaApp().getSldFalangeProxIzq().getValue();
        System.out.println("Grados: " + alphaGrados);
        getBrazoCompleto().getDedoIzq().girarHueso(alphaGrados);
                //girarFalProxIzq(alphaGrados);
        dibujar();
    }
    
    
    public void girarFalProxDer(){
        int alphaGrados = getVentanaApp().getSldFalangeProxDer().getValue();
        System.out.println("Grados: " + alphaGrados);
        getBrazoCompleto().getDedoDer().girarHueso(alphaGrados);
                //girarFalProxDer(alphaGrados);
        dibujar();
    }
    
    
    public void girarMano(){
        int alphaGrados = getVentanaApp().getSldMano().getValue();
        System.out.println("Grados: " + alphaGrados);
        getBrazoCompleto().getMano().girarHueso(alphaGrados);
                //girarMano(alphaGrados);
        dibujar();
    }
    
    
    public void girarAnteBrazo(){
        int alphaGrados = getVentanaApp().getSldAnteBrazo().getValue();
        System.out.println("Grados: " + alphaGrados);
        getBrazoCompleto().getAnteBrazo().girarHueso(alphaGrados);
                //girarAnteBrazo(alphaGrados);
        dibujar();
    }
    
    
    public void girarBrazo(){
        int alphaGrados = getVentanaApp().getSldBrazo().getValue();
        System.out.println("Grados: " + alphaGrados);
        getBrazoCompleto().getBrazo().girarHueso(alphaGrados);
                //girarBrazo(alphaGrados);
        dibujar();
    }
    
    
    
    private void dibujar(){
        
        
        System.out.println("Diujando...");
        Canvas lienzo = getVentanaApp().getLienzo();
        
        BufferedImage dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
                
        Graphics lapiz = dobleBuffer.getGraphics();
        
        lapiz.clearRect(0, 0, Constantes.ANCHO_MAXIMO_CANVAS, Constantes.ALTO_MAXIMO_CANVAS);
        
        getBrazoCompleto().dibujarBrazo(lapiz);
        
        Graphics pincel = lienzo.getGraphics();
        
        pincel.drawImage(dobleBuffer, 0, 0, lienzo);
                
    }
    
    
    @Override
    public void run() {
        if(inicio){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Error");
            }
            inicio = false;
        }
        dibujar();
    }
    
}
