package psp_2024.ZZZ.PRUEBAS.practica_cmd;

import java.io.IOException;
import java.io.OutputStream;

public class EscribirFecha {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Process p = new ProcessBuilder("cmd", "/C", "date").start();
		OutputStream os = p.getOutputStream();
		os.write("02-10-24".getBytes());
		
		MetodosAuxiliares.salida_comando(p);
		MetodosAuxiliares.salida_comando_error(p);
	}

}
