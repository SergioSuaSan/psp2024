package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.File;
import java.io.IOException;

public class RedireccionArchivos {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder(	"CMD");
		
		File fentrada = new File("C:\\Users\\diurno\\eclipse-workspace\\psp_2024\\bin\\psp_2024\\ZZZ\\PRUEBAS\\comandos.bat");
		File fsalida = new File("salida.txt");
		File ferror = new File("error.txt");
		
		
		pb.redirectInput(fentrada);
		pb.redirectOutput(fsalida);
		pb.redirectError(ferror);
		
		try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
