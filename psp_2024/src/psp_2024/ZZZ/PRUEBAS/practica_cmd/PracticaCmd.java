package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PracticaCmd {
	
	/*
	 * Esta clase muestra la ejecución de un comando -p. e. dir- del CMD de Windows,
	 * Su ledtura por parte del proceso `padre, y su salida por pantalla. Esta veersión 
	 * incluirá todo dentro de un solo método main
	 */

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe CMD");
		String entorno = scanner.nextLine();
		System.out.println("Escribe el comando a utilizar");
		String comando = scanner.nextLine(); 
		leer_cmd(entorno, comando);
		scanner.close();
	

	}
	
	static void leer_cmd (String entorno, String comando) {
		try {
			//Crear el proceso de inicio del comando
			ProcessBuilder pb = new ProcessBuilder(entorno, "/C", comando, "c:\\");
			Process p = pb.start();
			
			//Lectura de la salida del proceso hijo desde el padre
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String  linea = null;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			//Lectura de la salida del proceso hijo desde el padre
			InputStream is2 = p.getErrorStream();
			InputStreamReader isr2 = new InputStreamReader(is2);
			BufferedReader br2 = new BufferedReader(isr2);
			
			String  linea2 = null;
			while ((linea2 = br2.readLine()) != null) {
				System.out.println(linea2);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
//		int c;
//		while ((c = is.read()) != -1) {
//			System.out.print((char) c);
//		}
	}

}
