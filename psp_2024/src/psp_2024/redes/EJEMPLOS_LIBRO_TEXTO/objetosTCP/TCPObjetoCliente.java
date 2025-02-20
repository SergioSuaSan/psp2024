package psp_2024.redes.EJEMPLOS_LIBRO_TEXTO.objetosTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host = "localhost";
		int puerto = 6000; //Puerto remoto
		
		System.out.println("Programa cliente Iniciado");
		Socket cliente = new Socket(host, puerto);
	
		//Flujo de entrada para objetos
		ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
		
		//Se recibe un objeto
		Persona dato = (Persona) perEnt.readObject(); //Recibo el objeto
		
		System.out.println("Recibo" + dato.getNombre() + ", " + dato.getEdad());
	
		
		//Modifico el objeto
		dato.setNombre("Juan Ramos");
		dato.setEdad(22+4);
		
		//Flujo de salida para objeto
		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		
		//Se envía el objeto
		perSal.writeObject(dato);
		System.out.println("Envío: "+ dato.getNombre() + ", " + dato.getEdad());
	
		//Cerramos objetos
		perEnt.close();
		perSal.close();
		cliente.close();
		
	}

}
