package psp_2024.redes.ejemplos.socketsUDP.version_grafica.semi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPusuario1Continuo extends JFrame implements ActionListener{

	
	InetAddress IPServidor;
	static DatagramSocket socketUsuario1;
	static int puerto = 12345; 
	
	private static Scanner sc = new Scanner(System.in);
	
	
	
	static JTextField mensaje = new JTextField();
	private JScrollPane scrollpane1;
	static JTextArea textarea1;
	JButton boton = new JButton("Enviar");
	JButton desconectar = new JButton("Salir");
	boolean repetir = true;
	String nombre;
	
	
	public UDPusuario1Continuo() {
		super("USUARIO1 UDP");
		setLayout(null);
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

		textarea1.setEditable(false);
		boton.addActionListener(this);
		desconectar.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) { 
			String texto = " Usuario1 >> " + mensaje.getText();			
			try {
				
				InetAddress IPServidor = InetAddress.getLocalHost();
				DatagramPacket paquete = new DatagramPacket(texto.getBytes(),
						texto.length(), IPServidor, puerto);
				socketUsuario1.send(paquete);
				
				textarea1.append(texto + "\n");
				
				
				mensaje.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == desconectar) { // SE PULSA DESCONECTAR
			String texto = "*** Abandona el chat: " + nombre + " ***";			
			try {
				
				InetAddress IPServidor = InetAddress.getLocalHost();// localhost
				DatagramPacket paquete = new DatagramPacket(texto.getBytes(),
						texto.length(), IPServidor, puerto);
				socketUsuario1.send(paquete);
				socketUsuario1.close();
				repetir = false;
				
				

			} catch (IOException e1) {
				System.exit(0);
			}
		}
	}//
	

	public static void main(String[] args) throws IOException {

		socketUsuario1 = new DatagramSocket();// socket cliente

		// DATOS DEL RECEPTOR al que enviar mensaje
		//InetAddress IPServidor = InetAddress.getLocalHost();// localhost
		//int puerto = 12345; // puerto por el que escucha
		
		UDPusuario1Continuo usuario1 = new UDPusuario1Continuo();
		usuario1.setBounds(100, 150, 560, 400);
		usuario1.setVisible(true);
		usuario1.setAlwaysOnTop(true);
		
		//String cadena;
		//byte[] enviados = new byte[1024];
		//DatagramPacket envio;
		byte[] recibidos;
		String mensaje;
		
		do {
			/*
			 * // INTRODUCIR DATOS POR TECLADO
			 * System.out.print("Usuario 1 Introduce mensaje: "); cadena = sc.nextLine();
			 * 
			 * 
			 * enviados = cadena.getBytes();
			 * 
			 * // ENVIANDO DATAGRAMA AL OTRO USUARIO envio = new DatagramPacket(enviados,
			 * enviados.length, IPServidor, puerto); socketUsuario1.send(envio);
			 */

			// RECIBIENDO DATAGRAMA DEL OTRO USUARIO
			recibidos = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
			//System.out.println("Usuario 1 Esperando datagrama...");
			
			

				socketUsuario1.receive(recibo);



			mensaje = new String(recibo.getData()).trim();// obtengo String
			//System.out.println("Usuario 1 recibe: " +mensaje);
			textarea1.append(mensaje + "\n");
			
			
		} while (/*!mensaje.equals("*")*/ true);

		//System.out.println("Corto y cierro.");
		//socketUsuario1.close();// cerrar socket
		//System.exit(0);

	}



}
