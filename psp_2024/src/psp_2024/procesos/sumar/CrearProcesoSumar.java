package psp_2024.procesos.sumar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Esta clase se encarga, por una parte, de crear un proceso con la clase Sumar pasándole
 * como argumentos los extremos del rango a sumar y el nombre del fichero en donde guardar
 * el resultado con el método constructor, y, por otra, también se encarga de cómo recoger 
 * el resultado de dicha suma desde el fichero mediante el método getResultadoSuma. Estos 
 * métodos serán lanzados y controlados desde un main en la clase Ejemplo3, en donde se 
 * lanzarán y controlarán dos procesos paralelos que sumen los dos subrangos del rango a
 * sumar y se recogerán los resultados parciales y se sumarán.  
 * 
 */


public class CrearProcesoSumar {
	private int numInicial;
	private int numFinal;
	private String ficheroResultado;
	private Process p;
	
	// geters y setters

	public Process getP() {
		return p;
	}

	
	// Método que realiza la suma de dos números mediante la clase Sumar y guarda el
	// resultado en un fichero.
	public CrearProcesoSumar(int numInicial, int numFinal, String ficheroResultado) {
		// Asignaciones
		this.numInicial = numInicial;
		this.numFinal = numFinal;
		this.ficheroResultado = ficheroResultado;
		String clase = "psp_2024.procesos.sumar.Sumar";
		String numI = String.valueOf(numInicial);
		String numF = String.valueOf(numFinal);
		//Construcción del proceso tipo java con sus opciones, clase, y argumentos
		ProcessBuilder pb = new ProcessBuilder("java", clase, numI, numF);
		//ProcessBuilder pb = new ProcessBuilder("java", "-cp", "C:\\\\Users\\\\Eugenio\\\\eclipse-workspace\\\\programacion_servicios_y_procesos\\\\bin", clase, numI, numF);
			
		//Asignación del directorio de trabajo que permita al anterior proceso encontrar
		//los ejecutables que necesita
		pb.directory(new File("C:\\Users\\Eugenio\\eclipse-workspace_java\\psp_2024\\bin"));
        
		//Escritura del resultado mediante redirectOutput
		//pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); //redirección a salida estándar: pantalla --> aquí no tiene efecto
		pb.redirectOutput(new File(ficheroResultado));

		
		try {
			//Lanzamiento del proceso y asignación a un objeto Process que permita
			//controlarlo
			p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Método encargado de leer el resultado escrito por el anterior en el fichero de 
	//resultados y guardarlo en una variable.
	public int getResultadoSuma()
	{
		int resultado = 0;
		FileReader lectorFichero;
				
		try {
			lectorFichero = new FileReader(ficheroResultado);
		
			BufferedReader br = new BufferedReader(lectorFichero);
			
			String result = br.readLine();
			resultado = Integer.valueOf(result);
						
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}

}
