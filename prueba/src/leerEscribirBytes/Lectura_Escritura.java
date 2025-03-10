package leerEscribirBytes;

import java.io.*;

public class Lectura_Escritura {
	
	public static void main(String[] args) {
		
		int contador = 0;
		
		int datos_entrada[] = new int[13213];
		
		try {
			FileInputStream archivo_lectura = new FileInputStream("C:\\Users\\diurno\\Desktop\\eclipseDEVELOPER-java-2024-09-R-win32-x86_64\\Descargas\\images.jpg");
			
			boolean final_ar=false;
			
			while (!final_ar) {
				int byte_entrada = archivo_lectura.read();
				
				if (byte_entrada != -1) {
					datos_entrada[contador] = byte_entrada;
				} else {
					final_ar = true;
				}
				
				System.out.println(datos_entrada[contador]);
				
				contador ++;
			}
			archivo_lectura.close();
		} catch (IOException e) {
			System.out.println("Error al acceder a la imagen");
		}
		System.out.println(contador);
		
		crea_fichero(datos_entrada);
		
	}
	
	static void crea_fichero(int datos_nuevo_fichero[]) {
		try {
			FileOutputStream fichero_nuevo = new FileOutputStream("C:\\Users\\diurno\\Desktop\\eclipseDEVELOPER-java-2024-09-R-win32-x86_64\\Descargas\\images_copia.jpg");
			
			for (int i = 0; i < datos_nuevo_fichero.length; i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
			
			fichero_nuevo.close();
					
		}catch (IOException e) {
			System.out.println("Error al copuar el archivo");
		}
	}

}
