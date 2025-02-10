package udpSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServidorEjemplo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		DatagramSocket socket = new DatagramSocket(12345);
		
		DatagramPacket recibo;
		byte[] buffer = new byte[1024];
		
		recibo = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(recibo);
		
		String mensaje = new String(recibo.getData().toString());
		
		System.out.println("el servidor recibe " + mensaje);
		
		InetAddress ipOrigen = recibo.getAddress();
		int puerto = recibo.getPort();
		System.out.println("puerto del cliente " + puerto);
		
		int contador = 30;
		System.out.println("enviando número de apariciones de la letra A");
		byte b = (byte) contador;
		byte[] enviados = new byte[2];
		enviados[0] = b;
		
		DatagramPacket envio = new DatagramPacket(buffer, enviados.length, ipOrigen, puerto);
		socket.send(envio);
		
	}
	

}
