package ejercicio2;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Solo si se le dan 2 parámetros a la Clase, funcionará
		if (args.length == 2) {
			//Asignamos los parámetros a las variables
			String cad = args[0];
			File fichero = new File(args[1]);
			
			//Llamamos a la función
			int numCadenas = contarCadenas(cad, fichero);
			
			//Escribimos el resultado
			System.out.println("Cadena " + cad + " -> " + numCadenas);
			
		} else {
			// no se hace nada
		}
	}
	
	//Función que cuenta la cantidad de veces que sale una palabra en un archivo
	public static int contarCadenas(String cadena, File fichero) {
		//Inicializamos la variable
		int numCadenas = 0;
		try {
			
			//Abrimos el flujo para leer el fichero y trabajar con el
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			//int letra = 0;
			
			String c = null;

			
			//Bucle de lectura de palabras
			while ((c = br.readLine()) != null) {
				
				boolean control = true;

					while(control) {
						if (c.contains(cadena)) {
							numCadenas++;
							c=c.replaceFirst(cadena, "");
						}
						else {
							control=false;
						}
					}
					
			}
			
			//Cerramos los flujos para que no haya errores
			fr.close();
			br.close();
			return numCadenas;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numCadenas;
	}

}
