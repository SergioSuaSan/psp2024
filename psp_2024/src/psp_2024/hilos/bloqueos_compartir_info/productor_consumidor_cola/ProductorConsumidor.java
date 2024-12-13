package psp_2024.hilos.bloqueos_compartir_info.productor_consumidor_cola;

import java.util.Scanner;

/**
 * Ejemplo Productor-Consumidor con un productor y un consumidor
 */
public class ProductorConsumidor {
	
	//private static final int TAMANO = 100;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Introducir el tamaño de la lista: ");
		Scanner sc = new Scanner(System.in);
		int tamano = sc.nextInt();
		
		
		//Cola cola = new Cola(tamano+1);
		//Productor productor = new Productor(cola, tamano+1);
		//Consumidor consumidor = new Consumidor(cola);
		
		
		/*
		 * System.out.println("¿Cuántas veces hay que repetir la operación? "); Scanner
		 * sc1 = new Scanner(System.in); int veces = sc.nextInt();
		 */
		
	//	for(int i = 0; i<veces; i++) {
			Cola cola = new Cola(tamano+1);
			Productor productor = new Productor(cola, tamano+1);
			productor.start();
			if (productor.isAlive()) {
				Thread.sleep(100);
			}
			//Thread.sleep(500);
			Consumidor consumidor = new Consumidor(cola);
			consumidor.start();
			if (consumidor.isAlive()) {
				Thread.sleep(100);
			}
			//Thread.sleep(500);

			System.out.println("**********************");
			
	//	}
		//System.out.println("**********************");
		sc.close();
		
		
		//System.out.println("Fin Programa");
	}

}
