package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import psp_2024.ZZZ.PRUEBAS.practica_cmd.PracticaCmd;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LecturaEscrituraArchivos_V2_PARA_ALUMNOS {

/*
 * 
 */
	
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub

		
		//Para la lectura de comandos del archivo comandos.bat
		FileInputStream fis = new FileInputStream(".\\src\\psp_2024\\ZZZ\\PRUEBAS\\comandos.bat");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//Para la escritura de los resultados de los comandos en salida.txt
		FileOutputStream archivo_w = new FileOutputStream("salida.txt");
		OutputStreamWriter fw = new OutputStreamWriter(archivo_w);
		BufferedWriter bw = new BufferedWriter(fw);
		//Para la escritura de los resultados de los comandos en error.txt
		FileOutputStream archivo_we = new FileOutputStream("error.txt");
		OutputStreamWriter fwe = new OutputStreamWriter(archivo_we);
		BufferedWriter bwe = new BufferedWriter(fwe);
		
		
		//Cadena en donde se irán guardando las lineas para cada comando
		String linea_com = null;
		//Lista de Strings donde se guardarán los tokens de los comandos
		List<String> comando = new ArrayList<String>();

		//Variable para controlar el valor de salida de la terminación del proceso
		int exitVal;
		
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
				
				//Para ver por consola las salidas en vez de llevarlas a archivos
				//PracticaCmd.salida_comando(p);
				//PracticaCmd.salida_comando_error(p);
				
				//
				//
				//Salida normal
				InputStream is = p.getInputStream();
				InputStreamReader isr2 = new InputStreamReader(is);
				BufferedReader br2 = new BufferedReader(isr2);

				String resultado = null;
				while((resultado = br2.readLine())!= null) {					
						//System.out.println(resultado); //
						bw.write(resultado + "\n");
				}
				
				
				//Salida error
				InputStream isE = p.getErrorStream();
				InputStreamReader isr2E = new InputStreamReader(isE);
				BufferedReader br2E = new BufferedReader(isr2E);

				String resultadoE = null;
				while((resultadoE = br2E.readLine())!= null) {					
						//System.out.println(resultado); //
						bwe.write(resultadoE + "\n");
				}
				
				/*
				//
				//
				exitVal = p.waitFor();
				bwe.write(linea_com + " --> " + "Valor de Salida: " 
				+ String.valueOf(exitVal) + "\n\n");
				//System.out.println("Valor de Salida: " + exitVal);
				*/
				
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
		bw.close();
		bwe.close();
		br.close();
		
		
	}

}
