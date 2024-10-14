package psp_2024.ZZZ.PRUEBAS.prueba_vocales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/*
 * Con esta clase se crean los procesos basados en la clase Vocales en este
 * mismo paquete. 
 */

public class CrearProcesoVocales {
	
	
	//Variable de clase para el carácter, el fichero y el proceso
	private char vocal;
	private File fichero;
	private Process p;

	//Prácticamente todo lo que se hace en la clase está en esta ocasión en el 
	//constructor: se recogen los argumentos de vocal y nombre de fichero, se preparan
	//los elementos necesarios para el constructor de procesos, se lanza el proceso
	//y también, en este caso, se recoge la salida de la ejecución del (sub)proceso
	public CrearProcesoVocales(char vocal, File fichero) {

		//asignaciones de los argumentos a las variables de clase para el carácter
		//y el fichero
		this.vocal = vocal;
		this.fichero = fichero;
		
		//Variables String para la clase, el carácter y el fichero que se utilizan
		//en el constructor de ProcessBuilder
		String clase = "psp_2024.ZZZ.PRUEBAS.prueba_vocales";
		String letra = String.valueOf(this.vocal);
		String archivo = String.valueOf(this.fichero);
		
		//Construcción del proceso (se usa el método directory pero se puede usar la
		//classpath.
		ProcessBuilder pb = new ProcessBuilder("java",/* "-cp", ".\\bin",*/ clase, letra, archivo);
		
		pb.directory(new File(".\\bin"));
		

		
		try {
			
			//Lanzamiento del proceso
			p = pb.start();
	
			// Recolección del resultado del (sub)proceso --> java -cp clase letra archivo
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String linea = null;
			System.out.println(br.readLine());

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	
	//El único método adicional incluido es el que permite referirse y usar
	//el proceso creado fuera de la clase.
	public Process getP() {
		CrearProcesoVocales crearProcesoVocales;
		return p;
	}
	
}
