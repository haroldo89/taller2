package com.informatica.cliente.presentacion;

// import logica;
import com.informatica.cliente.logica.BrazoCliente;
import java.io.IOException;


/**
 *
 * @author harol
 */
//public class Modelo implements Runnable {
public class Modelo{    
    //VARIABLES
    private Vista ventanaApp;
    private BrazoCliente brazoCliente;
    Boolean inicio = true;
    
    //CONSTRUCTOR
    public Modelo() {
        ventanaApp = new Vista(this);
        brazoCliente = new BrazoCliente();
    }

    
    //GETTERS
    public Vista getVentanaApp() {
        if(ventanaApp == null){
            ventanaApp = new Vista(this);
        }
        return ventanaApp;
    }

    public BrazoCliente getBrazoCliente() {
        if(brazoCliente == null){
            brazoCliente = new BrazoCliente();
        }
        return brazoCliente;
    }
    
    
    
     //METODOS
    
    /**
     * Metodo para iniciar la ventana principal de la aplicación
     */
    public void iniciar() {
        getVentanaApp().setSize(650, 450);
        getVentanaApp().setVisible(true); 
        
    }
    
    
   
    
    public void conectar(){
        try {
            getBrazoCliente().conectar();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    
    public void enviar(String nombreSilder, int valorSlider){
        getBrazoCliente().setNombreSlider(nombreSilder);
        getBrazoCliente().setValorSlider(valorSlider);
        System.out.println("Se va a enviar: Nombre ["+nombreSilder+"] valor ["+valorSlider+"]");
        
        conectar();
        
        
    }
    
   
    
}
