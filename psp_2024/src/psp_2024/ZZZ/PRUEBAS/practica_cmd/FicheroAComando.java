package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FicheroAComando {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//Para la lectura de comandos del archivo comandos.bat
		FileInputStream fis = new FileInputStream(".\\src\\psp_2024\\ZZZ\\PRUEBAS\\comandos.bat");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//Cadena en donde se irán guardando las lineas para cada comando
		String linea_com = null;
		//Lista de Strings donde se guardarán los tokens de los comandos
		List<String> comando = new ArrayList<String>();


		//Bucle que funciona mientras la linea de comando no sea nula
		while((linea_com=br.readLine()) != null)
		{
			comando.add("CMD");
			comando.add("/C");
			
			// Divide la linea de comando en tokens para colocarlos correctamente en el CMD
			StringTokenizer st = new StringTokenizer(linea_com," ");//" " es el delimitador
			while (st.hasMoreTokens() ) {
			       String s1 = st.nextToken();
			       comando.add(s1);
			        //System.out.println(s1);
			      }
			
			//Crea un nuevo proceso con La lista completa de comandos de comandos.bat
			ProcessBuilder pb = new ProcessBuilder(comando);
			Process p;
			
			try {
				p = pb.start();
				
				//Para leer el comando utilizaremos un inputstream
				InputStream is = p.getInputStream();
				
				//Mostrar carácter a carácter la salida del input stream 
				int c;
				while ((c = is.read()) != -1) System.out.print((char) c);
				
				/*
				Input y Error no son compatibles, por lo que si el comando es correcto, Error será ignorado, 
				y si el comando es incorrecto, será Input el ignorado
				*/
				
				// El funcionamiento para el Error es el mismo
		        is = p.getErrorStream();			
				while ((c = is.read()) != -1) System.out.print((char) c);
				
				
				//Cerramos el stream
				is.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Comando incorrecto");
			}
			/*
			catch (InterruptedException e) { //
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			*/
			
			//System.out.println(comando);
			
			//Limpiamos la consola de comandos
			comando.clear();
		}
		
		// Cerramos los flujos para que no de error
	
		br.close();
		
	}

}
