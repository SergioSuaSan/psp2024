package psp_2024.redes.EJEMPLOS_LIBRO_TEXTO.objetosTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		int numeroPuerto = 6000;//puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteconectado = null;
		System.out.println("Esperando al cliente...");
		clienteconectado = servidor.accept();
		
		//Se prepara un flujo de salida para objetos
		ObjectOutputStream outObjeto = new ObjectOutputStream(clienteconectado.getOutputStream());
		
		//Se prepara un objeto y se envía
		Persona per = new Persona ("Juan", 20);
		outObjeto.writeObject(per); //Enviamos el objeto
		System.out.println("envío:" +  per.getNombre() + ", " + per.getEdad());
		
		
		
		ObjectInputStream inObjeto = new ObjectInputStream(clienteconectado.getInputStream());
		Persona dato = (Persona) inObjeto.readObject();
		System.out.println("Recibo: " + dato.getNombre() + ", " + dato.getEdad());
		
		//Cerrar Servidor y Objeto
		outObjeto.close();
		inObjeto.close();
		clienteconectado.close();
		servidor.close();
		

	}

}
