package psp_2024.ZZZ.PRUEBAS;

import java.io.File;
import java.io.IOException;

import psp_2024.ZZZ.PRUEBAS.practica_cmd.Auxiliar;

public class EscrituraEnProcesoJava {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "psp_2024.procesos.EJEMPLOS_LIBRO_TEXTO.Ejemplo1");
		/*
		 * ProcessBuilder pb = new ProcessBuilder("java", 
		 * "-cp",
		 * ".\\bin",
		 * "psp_2024.procesos.EJEMPLOS_LIBRO_TEXTO.Ejemplo1");

		 */
		
		
		pb.directory(directorio);
		
		//Se ejecuta el proceso
		Process p = pb.start();
		Auxiliar.salida_comando(p);
		Auxiliar.salida_comando_error(p);
		
		

	}

}
