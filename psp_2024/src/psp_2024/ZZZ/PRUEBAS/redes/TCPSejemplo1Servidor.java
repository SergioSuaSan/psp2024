package psp_2024.ZZZ.PRUEBAS.redes;

import java.io.IOException;
import java.net.ServerSocket;

public class TCPSejemplo1Servidor {
	
	public static void main(String[] args) {
		
		int puerto = 7000;
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
