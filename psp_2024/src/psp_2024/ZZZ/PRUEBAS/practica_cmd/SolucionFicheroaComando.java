package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.File;
import java.io.IOException;

public class SolucionFicheroaComando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ProcessBuilder pb = new ProcessBuilder(	"CMD");
		
		File fentrada = new File("C:\\Users\\diurno\\eclipse-workspace\\psp_2024\\bin\\psp_2024\\ZZZ\\PRUEBAS\\comandos.bat");
		File fsalida = new File("salida.txt");
		
		
		pb.redirectInput(fentrada);
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		pb.redirectError(ProcessBuilder.Redirect.INHERIT);
		
		try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
