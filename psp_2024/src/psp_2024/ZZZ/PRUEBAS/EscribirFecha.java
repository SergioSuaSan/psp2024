package psp_2024.ZZZ.PRUEBAS;

import java.io.IOException;
import java.io.OutputStream;

import psp_2024.ZZZ.PRUEBAS.practica_cmd.Auxiliar;

public class EscribirFecha {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Process p = new ProcessBuilder("CMD","/C", "date").start();
		OutputStream os = p.getOutputStream();
		os.write("02-10-2024".getBytes());
		os.flush();
		
		Auxiliar.salida_comando(p);
		Auxiliar.salida_comando_error(p);
		
	}

}
