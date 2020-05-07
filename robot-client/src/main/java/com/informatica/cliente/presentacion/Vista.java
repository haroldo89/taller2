/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica.cliente.presentacion;

import java.awt.Canvas;
import javax.swing.JSlider;

/**
 *
 * @author harol
 */
public class Vista extends javax.swing.JFrame {
    
    //VARIABLES
    private Controlador control;
    private Modelo modelo;

    
    //GETTERS
    public Modelo getModelo() {
        return modelo;
    }
    
    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }
    
    /**
     * Constructor de la vista 
     * @param m 
     */
    public Vista(Modelo m) {
        modelo = m;
        initComponents();
        asignarEventos();
    }

    
    
    private void asignarEventos() {
//        sldFalangeDigIzq.addChangeListener(getControl());
//        sldFalangeDigDer.addChangeListener(getControl());
//        sldFalangeProxIzq.addChangeListener(getControl());
//        sldFalangeProxDer.addChangeListener(getControl());
//        sldMano.addChangeListener(getControl());
//        sldAnteBrazo.addChangeListener(getControl());
//        sldBrazo.addChangeListener(getControl());
        
        sldFalangeDigIzq.addMouseListener(getControl());
        sldFalangeDigDer.addMouseListener(getControl());
        sldFalangeProxIzq.addMouseListener(getControl());
        sldFalangeProxDer.addMouseListener(getControl());
        sldMano.addMouseListener(getControl());
        sldAnteBrazo.addMouseListener(getControl());
        sldBrazo.addMouseListener(getControl());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCanvas = new javax.swing.JPanel();
        lienzo = new java.awt.Canvas();
        PanelControles = new javax.swing.JPanel();
        sldFalangeDigIzq = new javax.swing.JSlider();
        sldFalangeDigDer = new javax.swing.JSlider();
        lblFalangesDig = new javax.swing.JLabel();
        sldFalangeProxDer = new javax.swing.JSlider();
        sldFalangeProxIzq = new javax.swing.JSlider();
        lblFalangesProx = new javax.swing.JLabel();
        sldMano = new javax.swing.JSlider();
        lblMano = new javax.swing.JLabel();
        sldAnteBrazo = new javax.swing.JSlider();
        lblAnteBrazo = new javax.swing.JLabel();
        sldBrazo = new javax.swing.JSlider();
        lblBrazo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 350));

        PanelCanvas.setBackground(new java.awt.Color(255, 255, 255));
        PanelCanvas.setPreferredSize(new java.awt.Dimension(300, 300));

        lienzo.setBackground(new java.awt.Color(204, 204, 204));
        lienzo.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout PanelCanvasLayout = new javax.swing.GroupLayout(PanelCanvas);
        PanelCanvas.setLayout(PanelCanvasLayout);
        PanelCanvasLayout.setHorizontalGroup(
            PanelCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCanvasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PanelCanvasLayout.setVerticalGroup(
            PanelCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCanvasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        lienzo.getAccessibleContext().setAccessibleName("");

        PanelControles.setBackground(new java.awt.Color(255, 255, 255));
        PanelControles.setPreferredSize(new java.awt.Dimension(200, 300));

        sldFalangeDigIzq.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldFalangeDigIzq.setMajorTickSpacing(180);
        sldFalangeDigIzq.setMaximum(360);
        sldFalangeDigIzq.setMinimum(-360);
        sldFalangeDigIzq.setMinorTickSpacing(1);
        sldFalangeDigIzq.setPaintLabels(true);
        sldFalangeDigIzq.setPaintTicks(true);
        sldFalangeDigIzq.setSnapToTicks(true);
        sldFalangeDigIzq.setToolTipText("Falange Dig Izq");
        sldFalangeDigIzq.setValue(0);
        sldFalangeDigIzq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldFalangeDigIzq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldFalangeDigIzq.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldFalangeDigIzq.setName("Falange Dig Izq"); // NOI18N
        sldFalangeDigIzq.setPreferredSize(new java.awt.Dimension(100, 35));

        sldFalangeDigDer.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldFalangeDigDer.setMajorTickSpacing(180);
        sldFalangeDigDer.setMaximum(360);
        sldFalangeDigDer.setMinimum(-360);
        sldFalangeDigDer.setMinorTickSpacing(1);
        sldFalangeDigDer.setPaintLabels(true);
        sldFalangeDigDer.setPaintTicks(true);
        sldFalangeDigDer.setSnapToTicks(true);
        sldFalangeDigDer.setToolTipText("Falange Dig Izq");
        sldFalangeDigDer.setValue(0);
        sldFalangeDigDer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldFalangeDigDer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldFalangeDigDer.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldFalangeDigDer.setName("Falange Dig Izq"); // NOI18N
        sldFalangeDigDer.setPreferredSize(new java.awt.Dimension(100, 35));

        lblFalangesDig.setText("Falanges Digitales:");

        sldFalangeProxDer.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldFalangeProxDer.setMajorTickSpacing(180);
        sldFalangeProxDer.setMaximum(360);
        sldFalangeProxDer.setMinimum(-360);
        sldFalangeProxDer.setMinorTickSpacing(1);
        sldFalangeProxDer.setPaintLabels(true);
        sldFalangeProxDer.setPaintTicks(true);
        sldFalangeProxDer.setSnapToTicks(true);
        sldFalangeProxDer.setToolTipText("");
        sldFalangeProxDer.setValue(0);
        sldFalangeProxDer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldFalangeProxDer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldFalangeProxDer.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldFalangeProxDer.setName(""); // NOI18N
        sldFalangeProxDer.setPreferredSize(new java.awt.Dimension(100, 35));

        sldFalangeProxIzq.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldFalangeProxIzq.setMajorTickSpacing(180);
        sldFalangeProxIzq.setMaximum(360);
        sldFalangeProxIzq.setMinimum(-360);
        sldFalangeProxIzq.setMinorTickSpacing(1);
        sldFalangeProxIzq.setPaintLabels(true);
        sldFalangeProxIzq.setPaintTicks(true);
        sldFalangeProxIzq.setSnapToTicks(true);
        sldFalangeProxIzq.setToolTipText("");
        sldFalangeProxIzq.setValue(0);
        sldFalangeProxIzq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldFalangeProxIzq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldFalangeProxIzq.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldFalangeProxIzq.setName(""); // NOI18N
        sldFalangeProxIzq.setPreferredSize(new java.awt.Dimension(100, 35));

        lblFalangesProx.setText("Falanges Proximales:");

        sldMano.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldMano.setMajorTickSpacing(45);
        sldMano.setMaximum(180);
        sldMano.setMinimum(-180);
        sldMano.setMinorTickSpacing(1);
        sldMano.setPaintLabels(true);
        sldMano.setPaintTicks(true);
        sldMano.setSnapToTicks(true);
        sldMano.setToolTipText("");
        sldMano.setValue(0);
        sldMano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldMano.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldMano.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldMano.setName(""); // NOI18N

        lblMano.setText("Mano:");

        sldAnteBrazo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldAnteBrazo.setMajorTickSpacing(45);
        sldAnteBrazo.setMaximum(180);
        sldAnteBrazo.setMinimum(-180);
        sldAnteBrazo.setMinorTickSpacing(1);
        sldAnteBrazo.setPaintLabels(true);
        sldAnteBrazo.setPaintTicks(true);
        sldAnteBrazo.setSnapToTicks(true);
        sldAnteBrazo.setToolTipText("");
        sldAnteBrazo.setValue(0);
        sldAnteBrazo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldAnteBrazo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldAnteBrazo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldAnteBrazo.setName(""); // NOI18N

        lblAnteBrazo.setText("Antebrazo:");

        sldBrazo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sldBrazo.setMajorTickSpacing(45);
        sldBrazo.setMaximum(90);
        sldBrazo.setMinimum(-90);
        sldBrazo.setMinorTickSpacing(1);
        sldBrazo.setPaintLabels(true);
        sldBrazo.setPaintTicks(true);
        sldBrazo.setSnapToTicks(true);
        sldBrazo.setToolTipText("");
        sldBrazo.setValue(0);
        sldBrazo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldBrazo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldBrazo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        sldBrazo.setName(""); // NOI18N

        lblBrazo.setText("Brazo:");

        javax.swing.GroupLayout PanelControlesLayout = new javax.swing.GroupLayout(PanelControles);
        PanelControles.setLayout(PanelControlesLayout);
        PanelControlesLayout.setHorizontalGroup(
            PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldBrazo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sldMano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sldAnteBrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelControlesLayout.createSequentialGroup()
                        .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFalangesDig)
                            .addComponent(lblBrazo)
                            .addComponent(lblFalangesProx)
                            .addComponent(lblMano)
                            .addComponent(lblAnteBrazo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelControlesLayout.createSequentialGroup()
                        .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sldFalangeDigIzq, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(sldFalangeProxIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sldFalangeProxDer, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(sldFalangeDigDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelControlesLayout.setVerticalGroup(
            PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlesLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblFalangesDig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sldFalangeDigIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sldFalangeDigDer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFalangesProx)
                .addGap(8, 8, 8)
                .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sldFalangeProxDer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sldFalangeProxIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnteBrazo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAnteBrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBrazo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldBrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sldFalangeDigIzq.getAccessibleContext().setAccessibleName("Falange Dig Izq");
        sldFalangeProxIzq.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //GETTERS DE LOS COMPONENTES DEL FRAME
    public Canvas getLienzo() {
        return lienzo;
    }

    public JSlider getSldrFalangeDigIzq() {
        return sldFalangeDigIzq;
    }

    public JSlider getSldFalangeDigDer() {
        return sldFalangeDigDer;
    }

    public JSlider getSldFalangeProxDer() {
        return sldFalangeProxDer;
    }

    public JSlider getSldFalangeProxIzq() {
        return sldFalangeProxIzq;
    }

    public JSlider getSldMano() {
        return sldMano;
    }

    public JSlider getSldAnteBrazo() {
        return sldAnteBrazo;
    }

    public JSlider getSldBrazo() {
        return sldBrazo;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCanvas;
    private javax.swing.JPanel PanelControles;
    private javax.swing.JLabel lblAnteBrazo;
    private javax.swing.JLabel lblBrazo;
    private javax.swing.JLabel lblFalangesDig;
    private javax.swing.JLabel lblFalangesProx;
    private javax.swing.JLabel lblMano;
    private java.awt.Canvas lienzo;
    private javax.swing.JSlider sldAnteBrazo;
    private javax.swing.JSlider sldBrazo;
    private javax.swing.JSlider sldFalangeDigDer;
    private javax.swing.JSlider sldFalangeDigIzq;
    private javax.swing.JSlider sldFalangeProxDer;
    private javax.swing.JSlider sldFalangeProxIzq;
    private javax.swing.JSlider sldMano;
    // End of variables declaration//GEN-END:variables
}
