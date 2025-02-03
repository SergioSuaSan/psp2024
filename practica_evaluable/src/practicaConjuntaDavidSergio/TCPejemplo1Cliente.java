package practicaConjuntaDavidSergio;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class TCPejemplo1Cliente {

	public static void main(String[] args) throws IOException {

		
		String host = "172.19.178.1";
		int puerto = 6000;
		
		System.out.println("Programa cliente iniciado");
		Socket cliente = new Socket(host, puerto);
		
		//CREO FLUJO DE ENTRADA DESDE EL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		
		//EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del servidor: \n\t" + flujoEntrada.readUTF());
		
		//CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		//ENVÍO DE MENSAJE AL SERVIDOR
		System.out.println("Escribe el mensaje para el servidor");
		Scanner teclado = new Scanner(System.in);
		String frase = teclado.nextLine();
		
		flujoSalida.writeUTF(frase);
		
		
		//CERRAR 
		flujoEntrada.close();
		flujoSalida.close();
		
		cliente.close();
		


	}

}
