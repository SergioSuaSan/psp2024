package psp_2024.ZZZ.PRUEBAS.escriboyleo;

import java.io.IOException;

public class EjecutoLasOtras {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ProcessBuilder pb1 = new ProcessBuilder("java",
				"-cp", ".\\bin", "psp_2024.ZZZ.PRUEBAS.escriboyleo.LeoDeArchivo");
		ProcessBuilder pb2 = new ProcessBuilder("java",
				"-cp", ".\\bin", "psp_2024.ZZZ.PRUEBAS.escriboyleo.LeoDeArchivo");
		
		Process p1 = pb1.start();
		p1.waitFor();
		
		pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		
		Process p2 = pb2.start();
		p2.waitFor();
		
		
		
		
		
	}
	
	

}
