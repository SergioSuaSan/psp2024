package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CrearProcesoCadenas {

	//Variable de clase para las palabras, el fichero y el proceso
	String palabra;
	File fichero;
	Process p;
	
	
	//Creamos el constructor con los parámetros establecidos
	public CrearProcesoCadenas(String palabra, File fichero) {
		//Asignamos los parámetros a las variables de clase
		this.palabra = palabra;
		this.fichero = fichero;
		
		
		//Variables String para la clase, el la palabra y el fichero que se utilizan
		//en el constructor de ProcessBuilder
		String clase = "ejercicio2.Cadenas";
		String palab = String.valueOf(palabra);
		String archivo = fichero.getAbsolutePath();
		
		//Creamos el proceso que use la clase dada, la palabra que se va a buscar y el path del fichero
		//Recordamos que el .class está en bin
		ProcessBuilder pb = new ProcessBuilder("java","-cp", ".\\bin", clase, palab, archivo);
		
		
		try {
			
			//Lanzamiento del proceso
			p = pb.start();
	
			// Recolectamos el resultado
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);

			//Escribimos el resultado
			String resultado = null;
			while((resultado = br.readLine())!= null) {					
					System.out.println(resultado); //
					
			}

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	
	//El único método adicional incluido es el que permite referirse y usar
	//el proceso creado fuera de la clase.
	public Process getP() {
		return p;
	}
		

	

}
