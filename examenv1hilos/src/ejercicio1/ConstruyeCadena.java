package ejercicio1;

import java.util.Scanner;

public class ConstruyeCadena {
	public static void main(String[] args) {
		//Creamos la propiedad
		CadenaLetras c = new CadenaLetras();
		
		//Indicamos al usuario que introduzca la letra tope
		System.out.println("Introducir la letra tope");
		Scanner teclado = new Scanner(System.in);
		String palabra = teclado.nextLine(); 
		char letra = palabra.charAt(0);
		teclado.close();
		
		//Creamos dos instancias de la clase MontaCadena que tenga como parámetro
		//la cadena compartida y la letra tope
		MontaCadena hilo1 = new MontaCadena("Hilo1", c, letra);
		MontaCadena hilo2 = new MontaCadena("Hilo2", c, letra);
		
		//Ejecutamos los hilos
		hilo1.start();
		hilo2.start();
		//De esta forma el programa no puede terminar hasta que los hilos hayan terminado
		try {
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		//Sacamos la cadena y terminamos el programa	
		System.out.println("La cadena es " + c.getCadena());
		System.out.println("La cadena se ha completado");

	}

}
