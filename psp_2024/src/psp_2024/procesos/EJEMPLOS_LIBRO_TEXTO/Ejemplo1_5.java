package psp_2024.procesos.EJEMPLOS_LIBRO_TEXTO;

import java.io.File;
import java.io.IOException;

// Ejemplo básico de creación y manejo de procesos en Java: 1) instanciación de un "constructor
// de procesos" (ProcessBuilder), al que se le pasará como argumento un comando; 2) con ese objeto
// ProcessBuilder se podrá iniciar mediante el método start() un proceso propiamente dicho (Process);
// 3) además, se añade una instrucción de proceso.waitFor(); inmediatamente a continuación del 
// comienzo del proceso para asegurarse de el proceso lanzado se termina antes de continuar con
// el programa principal, para evitar anomalías e interferencias con otros procesos que puedan
// ejecutarse.

public class Ejemplo1_5 {

	private static void lanzarPrograma(String comando) {
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			
			
			Process p = pb.start();
			// esperar a que termine el proceso para poder continuar el programa principal
			p.waitFor(); 
			

		} catch (IOException | InterruptedException e) {
			System.out.println("error al lanzar el proceso");
			// e.printStackTrace();
		}
	}

	public static void main(String[] args) {


//		lanzarPrograma("C:\\Program Files\\Microsoft Office\\Office16\\winword.exe");
		
		lanzarPrograma("mspaint.exe");
		
		lanzarPrograma("mspaint.exe");
		

		
	/*	
*/
	}


}
