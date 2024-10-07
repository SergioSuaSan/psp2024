package psp_2024.procesos.EJEMPLOS_LIBRO_TEXTO;

import java.io.IOException;


import psp_2024.ZZZ.PRUEBAS.practica_cmd.Auxiliar;

public class EjercicioLeerNombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String clase = "psp_2024.procesos.EJEMPLOS_LIBRO_TEXTO.LeerNombre";
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", ".\\bin", clase, "Funciona por favor y gracias");
		try {
			Process p = pb.start();
			Auxiliar.salida_comando(p);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
