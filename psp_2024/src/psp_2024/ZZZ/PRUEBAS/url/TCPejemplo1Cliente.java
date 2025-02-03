package psp_2024.ZZZ.PRUEBAS.url;

import java.io.*;
import java.net.*;


public class TCPejemplo1Cliente {

	public static void main(String[] args) throws IOException {

		
		String host = "localhost";
		int puerto = 6000;
		
		System.out.println("Programa cliente iniciado");
		Socket cliente = new Socket(host, puerto);
		
		//CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		//ENVÍO DE MENSAJE AL SERVIDOR
		flujoSalida.writeUTF("Saludos al servidor desde el cliente");
		
		//CREO FLUJO DE ENTRADA DESDE EL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		
		//EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del servidor: \n\t" + flujoEntrada.readUTF());
		
		
		//CERRAR 
		flujoEntrada.close();
		flujoSalida.close();
		
		cliente.close();
		


	}

}
