package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Crea un programa con las clases y métodos que necesites para ejecutar comandos del sistema operativo como procesos 
		 * lanzados desde Java, leyéndolos desde consola mediante Scanner, y capturando y mostrando la salida/error correspondientes 
		 * a través del proceso padre.
		 * 
		 */
		
		
		
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
			
			/*
			Input y Error no son compatibles, por lo que si el comando es correcto, Error será ignorado, 
			y si el comando es incorrecto, será Input el ignorado
			*/
			
			// El funcionamiento para el Error es el mismo
	        is = p.getErrorStream();			
			while ((c = is.read()) != -1) System.out.print((char) c);
			
			
			//Cerramos el stream
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
