package udpSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClienteEjemplo2 {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DatagramSocket clienteSocket = new DatagramSocket();
		
		InetAddress ipServidor = InetAddress.getLocalHost();
		int puerto = 12345;
		
		//Introducir datos por teclado
		System.out.println("Introduce mensaje: ");
		
		String cadena = sc.nextLine();
		
		byte[]enviados = new byte[1024];
		
		enviados = cadena.getBytes();
		
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, ipServidor, puerto);
		clienteSocket.send(envio);
		
		
		//Recibiendo datagrama del servidor
		byte[] recibido = new byte[2];
	
		
		DatagramPacket recibo = new DatagramPacket(recibido, recibido.length);
		
		

	}

}
