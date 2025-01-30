package psp_2024.redes.EJEMPLOS_LIBRO_TEXTO.sockets.tcp;



import java.io.IOException;
import java.net.*;

public class TCPServidorBasico {

	public static void main(String[] args) throws IOException {
		
		int Puerto = 6000;// Puerto 
		ServerSocket Servidor = new ServerSocket(Puerto);
		
		System.out.println("Escuchando en " + Servidor.getLocalPort());	
		Socket cliente1= Servidor.accept();//esperando a un cliente 
		//realizar acciones con cliente1
		
		Socket cliente2 = Servidor.accept();//esperando a otro cliente
		//realizar acciones con cliente2
		
		Socket cliente3 = Servidor.accept();//esperando a otro cliente
		//realizar acciones con cliente2
		
		Servidor.close();	//cierro socket servidor
		
		//Puesto que hay tres esperas de clientes la clase ClienteBasico debe
		//ejecutarse tres veces para que el programa servidor termine correctamente
	}

}
