package psp_2024.procesos.mayor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrearProcesoMayor {
	
	//Clase que permite utilizar la Clase mayor utilizando como parámetros números y poniendo el resultado en ficheros de texto

	private int num1;
	private int num2;
	private String fich;
	Process p;
	
	//Método que crea el proceso anteriormente dicho
	public CrearProcesoMayor(int i, int j, String fich1) {	
		this.num1 = i;
		this.num2 = j;
		this.fich = fich1;
		String x = String.valueOf(i);
		String y = String.valueOf(j);
		//Si escribimos el comando java sin classpath (o una inadecuada), hay que usar directory
		//ProcessBuilder pb = new ProcessBuilder("java", "psp_2024.procesos.mayor.Mayor", x, y);
		//Si escribimos el comando java con classpath del modo que se ve a continuación
		//no es necesario usar directory
		ProcessBuilder pb = new ProcessBuilder("java", "-cp" , ".\\bin", "psp_2024.procesos.mayor.Mayor", x, y);
		//System.out.println(x);
		//pb.directory(new File("C:\\Users\\Eugenio\\eclipse-workspace_java\\psp_2024\\bin"));
		pb.redirectOutput(new File(this.fich));
		
		pb.redirectError(new File(".\\psp_2024\\src\\psp_2024\\procesos\\mayor\\error1.txt"));
		try {
			this.p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Process getP() {
		return p;
	}

	public void setP(Process p) {
		this.p = p;
	}

	//Metodo que lee el número que está en el fichero de texto
	public int getResultadoMayor()
	{
		int resultado = 0;
		try {
			FileReader  fr = new FileReader(this.fich);
			BufferedReader br = new BufferedReader(fr);
			String result = br.readLine();
			resultado = Integer.valueOf(result);
			br.close();
			return resultado;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return resultado;
	}
	
}
