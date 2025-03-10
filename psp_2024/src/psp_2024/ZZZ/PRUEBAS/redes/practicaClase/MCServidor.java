package psp_2024.ZZZ.PRUEBAS.redes.practicaClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MCServidor {

	public static void main(String[] args) throws IOException {
		
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 
		 //Crear socket multicast
		 MulticastSocket ms = new MulticastSocket();
		 
		 int puerto = 12345;
		 ms.setNetworkInterface(NetworkInterface.getByInetAddress(InetAddress.getByName("172.19.185.1")));
		    
		   // InetAddress grupo = InetAddress.getByName("225.0.0.1");//Grupo
		    InetAddress grupo = InetAddress.getByName("224.0.0.1");
		    
		 
		 String cadena = "";
		 while (!cadena.trim().equals("*")) {
			 System.out.println("Datos a enviar al grupo: ");
			 cadena = in.readLine();
			 DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto );
			 ms.send(paquete);
			 
		 }
		 
		 System.out.println("Socket cerrado.");
		 

	}

}
