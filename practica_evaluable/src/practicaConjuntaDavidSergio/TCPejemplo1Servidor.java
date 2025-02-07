package practicaConjuntaDavidSergio;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Scanner;

public class TCPejemplo1Servidor {

	public static void main(String[] args) throws IOException {

		System.out.println("Indica cuántos clientes quieres:");
		Scanner teclado = new Scanner(System.in);
		int bucle = teclado.nextInt();
	
		
		
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.out.println("Se está esperando al cliente");
		
		for (int i = 0; i < bucle; i++) {
			System.out.println("Cliente "+ (i+1));
			Socket cliente = servidor.accept();
			manejarCliente(cliente);
			
		}
		
		
		
		
		
		

		servidor.close();
		
		
		
	}
	
	public static void manejarCliente(Socket cliente ) throws IOException {
		//CREO FLUJO DE SALIDA AL CLIENTE
				OutputStream salida = cliente.getOutputStream();
				DataOutputStream flujoSalida = new DataOutputStream(salida);
				
				//ENVÍO MENSAJE AL CLIENTE
				System.out.println("Escribe el mensaje para el cliente");
				Scanner teclado = new Scanner(System.in);
				String frase = teclado.nextLine();
				
				flujoSalida.writeUTF(frase);

				//CREO FLUJO DE ENTRADA DEL CLIENTE
				InputStream entrada = cliente.getInputStream();
				DataInputStream flujoEntrada = new DataInputStream(entrada);
				
				//EL CLIENTE ME ENVÍA UN MENSAJE
				System.out.println("Recibiendo mensaje del cliente \n\t " + flujoEntrada.readUTF());
				
				
				System.out.println("Fin de mensaje");
				
				//CERRAR STREAM Y DESPUES SOCKETS
				entrada.close();
				flujoEntrada.close();
				salida.close();
				flujoSalida.close();
				
				cliente.close();
				
	}

}
