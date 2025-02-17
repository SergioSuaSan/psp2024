package psp_2024.ZZZ.PRUEBAS.redes.multicast;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

// Clase principal que extiende JFrame e implementa ActionListener y Runnable
public class UDPMultiChat extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	
	  // Variables de red y configuración multicast
    static MulticastSocket ms = null; // Socket multicast para enviar y recibir mensajes
    static byte[] buf = new byte[1000]; // Buffer para recibir mensajes
    static InetAddress grupo = null; // Dirección del grupo multicast
    static int Puerto = 12345; // Puerto multicast
    
    // Elementos de la interfaz gráfica
    static JTextField mensaje = new JTextField();
    private JScrollPane scrollpane1;
    static JTextArea textarea1;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true; // Controla la ejecución del hilo
    String nombre; // Nombre del usuario en el chat

    // Constructor que inicializa la ventana del chat
    public UDPMultiChat(String nom) {
        super("VENTANA DE CHAT UDP - Nick: " + nom);
        setLayout(null);
        this.nombre = nom;
        
        // Configuración de los componentes de la interfaz
        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);
        
        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 50, 400, 300);
        add(scrollpane1);
        
        boton.setBounds(420, 10, 100, 30);    
        add(boton);
        
        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);
        
        textarea1.setEditable(false); // Evita la edición del área de mensajes
        boton.addActionListener(this); // Agrega eventos a los botones
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evita el cierre accidental
    }

    // Método que maneja los eventos de los botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) { // Si se pulsa el botón enviar
            String texto = nombre + ">> " + mensaje.getText();
            try {
                // Crea un paquete con el mensaje y lo envía al grupo multicast
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, Puerto);
                ms.send(paquete);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == desconectar) { // Si se pulsa el botón salir
            String texto = "*** Abandona el chat: " + nombre + " ***";            
            try {
                // Envía un mensaje de salida al grupo
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, Puerto);
                ms.send(paquete);
                ms.close(); // Cierra el socket
                repetir = false; // Detiene la ejecución del hilo
                System.out.println("Abandona el chat: " + nombre);
                System.exit(0); // Sale del programa
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // Método que recibe y muestra los mensajes del grupo multicast
    public void run() {    
        while (repetir) { // Mientras el usuario no haya salido
            try {
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p); // Espera a recibir un mensaje
                String texto = new String(p.getData(), 0, p.getLength());
                textarea1.append(texto + "\n"); // Muestra el mensaje en la interfaz
            } catch (SocketException s) {
                System.out.println(s.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    
    }

    // Método principal que inicia el chat
    public static void main(String args[]) throws IOException {
        // Solicita al usuario que introduzca un nombre
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
        
        // Crea el socket multicast y se une al grupo
        ms = new MulticastSocket(Puerto);
        grupo = InetAddress.getByName("224.0.0.1"); // Dirección del grupo multicast
        
        // Configura la interfaz de red 
        ms.setNetworkInterface(NetworkInterface.getByInetAddress(InetAddress.getByName("172.19.185.1")));
        
        // Se une al grupo multicast
        SocketAddress sa = new InetSocketAddress(grupo, Puerto);
        ms.joinGroup(sa, null);

        if (!nombre.trim().equals("")) { // Si el nombre no está vacío
            UDPMultiChat server = new UDPMultiChat(nombre);
            server.setBounds(0, 0, 540, 400);
            server.setVisible(true);
            new Thread(server).start(); // Inicia el hilo que recibe mensajes
        } else {
            System.out.println("El nombre está vacío....");
        }
    }
}
