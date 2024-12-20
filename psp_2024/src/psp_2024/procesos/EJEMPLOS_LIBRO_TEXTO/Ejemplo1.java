package psp_2024.procesos.EJEMPLOS_LIBRO_TEXTO;
import java.io.IOException;

/*
 * Diferentes sintaxis para el lanzamiento de un proceso sencillo:
 * ejecución de un programa del sistema operativo.
 */

public class Ejemplo1 {
   public static void main(String[] args) throws IOException, InterruptedException   {	   
	   ProcessBuilder pb = new ProcessBuilder("mspaint");
	   ProcessBuilder pb1 = new ProcessBuilder("mspaint");
	   //ProcessBuilder pb = new ProcessBuilder("EXCEL").start();  //NO VALE
	   //Process p = new ProcessBuilder("EXCEL").start();
	   //pb.start();
	   Process p = pb.start();
	   p.waitFor();
	   System.out.println(p.exitValue());
	   Process p1 = pb1.start();
	   

   }
}//Ejemplo1