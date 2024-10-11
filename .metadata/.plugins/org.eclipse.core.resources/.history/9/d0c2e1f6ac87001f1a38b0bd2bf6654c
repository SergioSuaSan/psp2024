package psp_2024.procesos.primos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CrearProcesoPrimos1 {

	private int numInicial;
	private int numFinal;

	private Process p;
	
	// getters y setters

	public Process getP() {
		return p;
	}

	
	// Método que realiza l
	public CrearProcesoPrimos1(int numInicial, int numFinal) {
		// Asignaciones
		this.numInicial = numInicial;
		this.numFinal = numFinal;

		String clase = "psp_2024.procesos.primos.PrimosEntreSi_1";
		String numI = String.valueOf(numInicial);
		String numF = String.valueOf(numFinal);
		//Construcción del proceso tipo java con sus opciones, clase, y argumentos
		ProcessBuilder pb = new ProcessBuilder("java", clase, numI, numF);
		//ProcessBuilder pb = new ProcessBuilder("java", "-cp", "C:\\Users\\Eugenio\\eclipse-workspace\\programacion_servicios_y_procesos\\bin", clase, numI, numF);
			
		//Asignación del directorio de trabajo que permita al anterior proceso encontrar
		//los ejecutables que necesita
		pb.directory(new File("C:\\Users\\Eugenio\\eclipse-workspace_java\\psp_2024\\bin"));

		
		try {
			//Lanzamiento del proceso y asignación a un objeto Process que permita
			//controlarlo
			p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Método encargado de leer el resultado 
	public void getResultado() throws IOException
	{
		InputStream is = p.getInputStream();
		InputStreamReader ir = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(ir);
		String linea = null;
		while((linea= br.readLine())!= null){
			System.out.println(linea);
		
	}
	}
	
}
