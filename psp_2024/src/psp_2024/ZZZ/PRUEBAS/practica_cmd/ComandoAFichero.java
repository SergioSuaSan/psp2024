package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ComandoAFichero {

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		//Para la escritura de los resultados de los comandos en salida.txt
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe comando");
		String comando = sc.nextLine();
		
		salida_texto(comando);
				
				
				
		

	}
	
	public static void salida_texto(String comando) throws FileNotFoundException {
		FileOutputStream archivo_w = new FileOutputStream("salida.txt");
		OutputStreamWriter fw = new OutputStreamWriter(archivo_w);
		BufferedWriter bw = new BufferedWriter(fw);
		// TODO Auto-generated method stub
		
		//Crea un nuevo proceso con La lista completa de comandos de comandos.bat
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", comando);
		File fsalida = new File("salida.txt");
		pb.redirectOutput(fsalida);
		Process p;
		
		try {
			p = pb.start();

			InputStream is = p.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is);
			BufferedReader br2 = new BufferedReader(isr2);

			String resultado = null;
			while((resultado = br2.readLine())!= null) {					
					//System.out.println(resultado); //
					bw.write(resultado + "\n");
			}
			
			int c;
	        is = p.getErrorStream();			
			while ((c = is.read()) != -1) System.out.print((char) c);
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error");
			}
				
		}
			
		


	
}
