/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica.cliente.presentacion;

import com.informatica.cliente.utils.NombreSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author harol otro comentario
 */
public class Controlador implements ChangeListener{
    
    //VARIABLES
    private Vista ventana;
    private Modelo modelo;
    
    //CONSTRUCTOR
    public Controlador(Vista v) {
        this.ventana = v;
        modelo = ventana.getModelo();
    }

    //CHANGELISTENER METHOD
    @Override
    public void stateChanged(ChangeEvent e) {
        //Falange dig izq
        System.out.println("Entro a cambio de estado...");
        if(e.getSource().equals(ventana.getSldrFalangeDigIzq())){
            System.out.println("Falange dig izq");
            //Mover la falange dig izq
            modelo.enviar(NombreSlider.FALANGE_DIG_IZQ.toString(), ventana.getSldrFalangeDigIzq().getValue());
            
        }
        else if(e.getSource().equals(ventana.getSldFalangeDigDer())){
            System.out.println("Falange dig der");
            //Mover la falange dig der
            modelo.enviar(NombreSlider.FALANGE_DIG_DER.toString(), ventana.getSldFalangeDigDer().getValue());
            
        }
        else if(e.getSource().equals(ventana.getSldFalangeProxIzq())){
            System.out.println("Falange prox izq");
            //Mover la falange prox izq
            modelo.enviar(NombreSlider.FALANGE_PROX_IZQ.toString(), ventana.getSldFalangeProxIzq().getValue());
            
        }
        else if(e.getSource().equals(ventana.getSldFalangeProxDer())){
            System.out.println("Falange prox der");
            //Mover la falange prox der
            modelo.enviar(NombreSlider.FALANGE_PROX_DER.toString(), ventana.getSldFalangeProxDer().getValue());
            
        }
        else if(e.getSource().equals(ventana.getSldMano())){
            System.out.println("Mano");
            //Mover la mano
            modelo.enviar(NombreSlider.MANO.toString(), ventana.getSldMano().getValue());
            
        }
        else if(e.getSource().equals(ventana.getSldAnteBrazo())){
            System.out.println("Antebrazo");
            //Mover el antebrazo
            modelo.enviar(NombreSlider.ANTEBRAZO.toString(), ventana.getSldAnteBrazo().getValue());
            
        }
        else if(e.getSource().equals(ventana.getSldBrazo())){
            System.out.println("Brazo");
            //Mover el antebrazo
            modelo.enviar(NombreSlider.BRAZO.toString(), ventana.getSldBrazo().getValue());
            
        }
        
        
    }
    
}
