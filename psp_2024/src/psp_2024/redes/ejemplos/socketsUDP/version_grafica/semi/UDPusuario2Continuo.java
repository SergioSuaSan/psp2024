package psp_2024.redes.ejemplos.socketsUDP.version_grafica.semi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPusuario2Continuo extends JFrame implements ActionListener {
    
    // Declaración del socket y el puerto que usaremos para la comunicación UDP
    static DatagramSocket socketUsuario2;
    static int puerto = 12345;
    
    // Componentes de la interfaz gráfica
    static JTextField mensaje = new JTextField(); // Campo de texto donde el usuario escribe el mensaje
    private JScrollPane scrollpane1; // Contenedor que permite hacer scroll en el área de texto
    static JTextArea textarea1; // Área de texto donde se muestran los mensajes enviados y recibidos
    JButton boton = new JButton("Enviar"); // Botón para enviar el mensaje
    JButton desconectar = new JButton("Salir"); // Botón para cerrar la conexión
    boolean repetir = true; // Variable que controla si el ciclo de recepción de mensajes sigue o no

    public UDPusuario2Continuo() {
        super("USUARIO2 UDP"); // Título de la ventana
        setLayout(null); // Usamos un layout nulo, para posicionar los componentes manualmente
        
        // Configuración y adición del campo de texto para el mensaje
        mensaje.setBounds(10, 10, 400, 30); // Posición y tamaño del campo de texto
        add(mensaje); // Añadir el campo de texto a la ventana
        
        // Configuración y adición del área de texto con scroll
        textarea1 = new JTextArea(); // Crear el área de texto
        scrollpane1 = new JScrollPane(textarea1); // Añadir un JScrollPane para que sea desplazable
        scrollpane1.setBounds(10, 50, 400, 300); // Posición y tamaño del área con scroll
        add(scrollpane1); // Añadir el área con scroll a la ventana
        
        // Configuración y adición del botón "Enviar"
        boton.setBounds(420, 10, 100, 30); // Posición y tamaño del botón
        add(boton); // Añadir el botón a la ventana
        
        // Configuración y adición del botón "Salir"
        desconectar.setBounds(420, 50, 100, 30); // Posición y tamaño del botón
        add(desconectar); // Añadir el botón a la ventana
        
        // Hacemos que el área de texto no sea editable
        textarea1.setEditable(false);
        
        // Registramos los eventos de los botones para que ejecuten el código correspondiente
        boton.addActionListener(this); 
        desconectar.addActionListener(this);
        
        // Configuración para cerrar la ventana correctamente
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Método que maneja los eventos de los botones (cuando se presionan)
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) { // Si se presiona el botón "Enviar"
            String texto = " Usuario2 >> " + mensaje.getText(); // Obtener el texto que se ha escrito
            try {
                // Obtenemos la dirección IP local del destino (en este caso, nosotros mismos)
                InetAddress IPDestino = InetAddress.getLocalHost();
                
                // Creamos un paquete UDP con el texto y lo enviamos al destino (puerto 12345)
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), IPDestino, puerto);
                socketUsuario2.send(paquete); // Enviar el paquete UDP
                
                // Mostramos el mensaje enviado en el área de texto
                textarea1.append(texto + "\n");
                
                // Limpiamos el campo de texto para el próximo mensaje
                mensaje.setText("");
            } catch (IOException e1) {
                e1.printStackTrace(); // Si ocurre un error, lo mostramos
            }
        }
        
        // Si se presiona el botón "Salir"
        if (e.getSource() == desconectar) {
            String texto = "*** Abandona el chat: Usuario2 ***"; // Mensaje indicando que el usuario se desconecta
            try {
                // Obtenemos la dirección IP local del destino
                InetAddress IPDestino = InetAddress.getLocalHost();
                
                // Creamos un paquete UDP con el mensaje de desconexión y lo enviamos
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), IPDestino, puerto);
                socketUsuario2.send(paquete); // Enviar el mensaje de desconexión
                
                // Cerramos el socket, terminando la conexión
                socketUsuario2.close();
                
                // Indicamos que ya no se debe seguir repitiendo la recepción de mensajes
                repetir = false;
            } catch (IOException e1) {
                System.exit(0); // Si ocurre un error, cerramos el programa
            }
        }
    }
    
    // Método principal donde se inicia la aplicación
    public static void main(String[] args) throws IOException {
        // Creamos un socket UDP en el puerto 12345
        socketUsuario2 = new DatagramSocket(puerto);
        
        // Creamos la interfaz gráfica
        UDPusuario2Continuo usuario2 = new UDPusuario2Continuo();
        usuario2.setBounds(700, 150, 560, 400); // Posición y tamaño de la ventana
        usuario2.setVisible(true); // Hacemos visible la ventana
        usuario2.setAlwaysOnTop(true); // Aseguramos que la ventana esté siempre encima
        
        byte[] recibidos; // Buffer para almacenar los datos recibidos
        String mensaje; // Variable para almacenar el mensaje recibido
        
        // Bucle para recibir mensajes continuamente hasta que el usuario decida desconectar
        do {
            recibidos = new byte[1024]; // Creamos un buffer de 1024 bytes para los datos recibidos
            DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length); // Creamos el paquete de recepción
            socketUsuario2.receive(recibo); // Recibimos el paquete
            mensaje = new String(recibo.getData()).trim(); // Convertimos los datos recibidos en un string y eliminamos los espacios en blanco
            
            // Mostramos el mensaje recibido en el área de texto
            textarea1.append(mensaje + "\n");
        } while (true); // El bucle sigue de manera indefinida, ya que siempre recibimos mensajes hasta que el programa se cierre
    }
}


/*
// CÓDIGO ORIGINAL EN MODO CONSOLA
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPusuario2Continuo {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        DatagramSocket socketUsuario2 = new DatagramSocket(12345);
        DatagramPacket recibo;
        byte[] bufer;
        String mensaje;
        InetAddress IPOrigen;
        int puerto;
        byte[] enviados;
        String cadena;
        
        do {
            System.out.println("Usuario 2 Esperando Datagrama ... ");
            bufer = new byte[1024];
            recibo = new DatagramPacket(bufer, bufer.length);
            socketUsuario2.receive(recibo);
            mensaje = new String(recibo.getData()).trim();
            System.out.println("Usuario 2 recibe:" + mensaje);
            
            IPOrigen = recibo.getAddress();
            puerto = recibo.getPort();
            System.out.print("Usuario 2 Introduce mensaje: ");
            cadena = sc.nextLine();
            enviados = cadena.getBytes();
            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
            socketUsuario2.send(envio);
        } while (!mensaje.equals("*"));
        
        System.out.println("Corto y cierro.");
        socketUsuario2.close();
    }
}
*/
