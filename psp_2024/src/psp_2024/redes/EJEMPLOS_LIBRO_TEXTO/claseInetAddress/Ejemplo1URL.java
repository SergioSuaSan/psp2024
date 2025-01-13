package psp_2024.redes.EJEMPLOS_LIBRO_TEXTO.claseInetAddress;

import java.net.*;

public class Ejemplo1URL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		URL url;
		
		try {
			System.out.println("Constructor sumple de url");
			url = new URL("http://armando@docs.oracle.com");
			visualizar(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	

	}

	private static void visualizar(URL url) {
		// TODO Auto-generated method stub
		
	}

}
