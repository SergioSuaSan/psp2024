package psp_2024.ZZZ.PRUEBAS.escriboyleo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeoDeArchivo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("C:\\Users\\diurno\\eclipse-workspace\\psp_2024\\src\\psp_2024\\ZZZ\\PRUEBAS\\escriboyleo\\escriboyleo.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = null;
		while ((linea=br.readLine())!= null) {
			System.out.println(linea);
		}
	}

}
