package psp_2024.ZZZ.PRUEBAS.url;

import java.io.*;
import java.net.*;

public class TCPejemplo1Servidor {

	public static void main(String[] args) throws IOException {

		
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteConectado = null;
		System.out.println("Se está esperando al cliente");
		clienteConectado = servidor.accept();

		//CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		//EL CLIENTE ME ENVÍA UN MENSAJE
		System.out.println("Recibiendo mensaje del cliente \n\t " + flujoEntrada.readUTF());
		
		
		//CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		//ENVÍO MENSAJE AL CLIENTE
		flujoSalida.writeUTF("Saludo al cliente desde el servidor");
		
		
		//CERRAR STREAM Y DESPUES SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		
		clienteConectado.close();
		
		
		
	}

}
