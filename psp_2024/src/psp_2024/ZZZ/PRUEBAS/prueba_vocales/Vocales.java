package psp_2024.ZZZ.PRUEBAS.prueba_vocales;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Esta clase admite como argumentos para el main una cadena y el nombre
 * de un archivo de texto (incluyendo la ruta si se quiere) en el cual se
 * contarán las ocurrencias de la cadena pasada como primer argumento.
 */


public class Vocales {

	//función auxiliar que hace el trabajo de contar el número de apariciones
	//de un determinado carácter en un determinado fichero que ya existe
	//y devolver ese número (no se hace el control de comprobación de si se 
	//trata o no de una vocal).
	public static int contarVocales(char vocal, File fichero) {
		int numVocales = 0;
		try {
			
			//Se usa para ello la opción más simple: el read
			//de FileReader permite no tener que usar cadenas.
			FileReader fr = new FileReader(fichero);
			int letra = 0;
			//bucle de lectura de caracteres
			while ((letra = fr.read()) != -1) {
				if ((char) letra == vocal) {
					numVocales++;
				}
			}
			
			//cierre del canal y devolución del valor obtenido
			fr.close();
			return numVocales;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numVocales;
	}

	
	//método principal para ejecutar el recuento
	public static void main(String[] args) {
		//Sólo se admiten exactamente dos argumentos; en otro caso,
		//no se hace nada
		if (args.length == 2) {
			//
			String voc = args[0];
			char vocal = voc.charAt(0);
			
			File fichero = new File(args[1]);
			int numVocales = contarVocales(vocal, fichero);
			System.out.println("vocal " + vocal + " -> " + numVocales);
			
		} else {
			System.out.println("Argumentos incorrectos");
		}
	}
	
	

}
