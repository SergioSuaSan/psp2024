package ejercicio1;

	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.List;

	public class Auxiliar {
		// Método para la captura de la salida del proceso hijo en este proceso padre
	    public static void salida_comando(Process p) throws IOException {
	            InputStream is = p.getInputStream();
	            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	            BufferedReader br = new BufferedReader(isr);
	    
	            String cadena = null;
	    
	            while ((cadena = br.readLine()) != null) {
	                System.out.println(cadena);
	            }
	    
	        }
	    
	        // Método para la captura de la salida de error del proceso hijo en este proceso
	        // padre
	        public static void salida_comando_error(Process p) throws IOException {
	            InputStream is = p.getErrorStream();
	            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	            BufferedReader br = new BufferedReader(isr);
	    
	            String cadena = null;
	    
	            while ((cadena = br.readLine()) != null) {
	                System.out.println(cadena);
	            }
	    
	        }
	    
	        // Método que permite ejecutar una lista de Strings como un comando
	        public static void ejecutarCom(List<String> comando) {
	            ProcessBuilder pb;
	            Process proceso;
	    
	            pb = new ProcessBuilder(comando);
	            try {
	                proceso = pb.start();
	                salida_comando(proceso);
	                salida_comando_error(proceso);
	    
	            } catch (IOException e) {
	    
	                e.printStackTrace();
	            }
	        }

}
