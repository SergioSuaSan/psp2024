package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class AuxiliarSinParametro {

	public static void salida_comando() {
		// TODO Auto-generated method stub
		//Variables que podemos utilizar
		String comando;
		
		//Scanner para utilizar el teclado
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe el comando que quieres introducir");
		comando = teclado.nextLine();
		teclado.close();
		
		
		//Ejecutar proceso que abra el cmd con el comando "dir"
		ProcessBuilder pb = new ProcessBuilder("cmd", "/C", comando);
		try {
			Process p = pb.start();
			
			//Para leer el comando utilizaremos un inputstream
			InputStream is = p.getInputStream();
			
			//Mostrar carácter a carácter la salida del input stream 
			int c;
			while ((c = is.read()) != -1) System.out.print((char) c);
			
			//Cerramos el stream
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		


	}
	public static void salida_comando_error() {
		// TODO Auto-generated method stub
		//Variables que podemos utilizar
		String comando;
		
		//Scanner para utilizar el teclado
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe el comando que quieres introducir");
		comando = teclado.nextLine();
		teclado.close();
		
		
		//Ejecutar proceso que abra el cmd con el comando "dir"
		ProcessBuilder pb = new ProcessBuilder("cmd", "/C", comando);
		try {
			Process p = pb.start();
			
			
			// El funcionamiento para el Error es el mismo
			int c;
	        InputStream is = p.getErrorStream();			
			while ((c = is.read()) != -1) System.out.print((char) c);
			
			
			//Cerramos el stream
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		


	}

}
