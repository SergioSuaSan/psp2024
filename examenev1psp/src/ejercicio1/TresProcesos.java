package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TresProcesos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejercicio Lanzar Paint. Creamos la funcion correpondiente
		lanzarpaint();
		
		//El segundo ejecutará el comando “nslookup   www.elpais.com” y mostrará el resultado por la consola de Eclipse.
		lanzarcomando();
		
		//El tercero ejecutará la clase java HolaMundo, que sólo escribe “Hola Mundo” por consola. 
		lanzarholamundo();
	}

	private static void lanzarholamundo() {
		
		//Creamos un String que  indique el path de la clase. 
		//No es necesario, pero es más cómodo y facil de controlar
		String clase = "ejercicio1.HolaMundo";
		//Creamos un proceso que utilice la clase holamundo
		//Java abre el .class, que está en bin, no en src, por eso el path es .bin
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", ".\\bin", clase);
		
		//Como antes, rodeamos con try/Catch
		try {
			//Instanciamos el proceso y lo sacamos utilizando el método auxiliar
			Process p = pb.start();
			Auxiliar.salida_comando(p);
			Auxiliar.salida_comando_error(p);
			
			//Obligamos a esperar al proceso padre
			p.waitFor();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void lanzarcomando() {
		//Creamos un proceso que abre la consola de comandos utilizando un ProccesBuilder.
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "nslookup www.elpais.com");
		//Instanciamos el proceso
		Process p;
		
		//Puede conllevar excepciones así que lo mejor es  rodearlo de un try/Catch
		try {
			//Iniciamos el proceso
			p = pb.start();
			
			//Utilizamos estas herramientas para abrir el flujo del proceso, leerlo y poder trabajar con ello
			InputStream is = p.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is);
			BufferedReader br2 = new BufferedReader(isr2);

			//Creamos un string que copiará cada linea leída del buffer y la imprimirá en consola
			String resultado = null;
			while((resultado = br2.readLine())!= null) {					
					System.out.println(resultado); //
					
			}
			
			//En caso de que de error, lo sacamos también en consola. En este caso lo simplificamos utilizando solo caracteres
			int c;
	        is = p.getErrorStream();			
			while ((c = is.read()) != -1) System.out.print((char) c);
			
			//Obligamos al proceso padre a esperar hasta que el proceso hijo da la respuesta
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void lanzarpaint() {
		//Creamos un proceso que abre Paint utilizando un ProccesBuilder.
		ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
		//Instanciamos el proceso
		Process p;
		
		//Puede conllevar excepciones así que lo mejor es  rodearlo de un try/Catch
		try {
			//Iniciamos el proceso
			p = pb.start();
			//Obligamos al proceso padre a esperar hasta que el proceso hijo da la respuesta
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
