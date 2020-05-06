package com.informatica.servidor.logica;

import com.informatica.servidor.presentacion.Modelo;
import com.informatica.servidor.utils.NombreSlider;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vamaya
 */
public class BrazoServidor {
    //VARIABLES
    
    private Modelo modelo;
    
    //VARIABLES
    private ServerSocket server;
    private Socket cliente;

    private List<HiloEscucharBrazoCliente> listaHilosClientes = new ArrayList<>();

    public List<HiloEscucharBrazoCliente> getListaHilosClientes() {
        return listaHilosClientes;
    }

    private DataInputStream datosEntrada;
    public static final int MAX_BYTES = 200; //Tamaño máximo del mensaje

    private final int puerto;
    private final boolean conectarActivo;

    //CONSTRUCTOR
    public BrazoServidor(Modelo modelo) {
        this.puerto = 5000;
        this.conectarActivo = true;
        this.modelo = modelo;
    }

    //MÉTODOS
    public void conectar() {

        System.out.println("Iniciando Servidor en el puerto [" + puerto + "] ......");
        try {
            server = new ServerSocket(puerto);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error de servidor, no se pudo conectar");

        }

        while (conectarActivo) {
            try {
                cliente = server.accept();
                System.out.println("Conexión establecida con el cliente");

                HiloEscucharBrazoCliente hiloCliente = new HiloEscucharBrazoCliente(cliente, modelo, this);
                System.out.println(hiloCliente.getName());
                listaHilosClientes.add(hiloCliente);
                hiloCliente.start();

                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error de conexión con el cliente");

            }

        }

    }
    
}
