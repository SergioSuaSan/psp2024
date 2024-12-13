package psp_2024.hilos.bloqueos_compartir_info.productor_consumidor_cola;

/**
 * Clase que consume elementos eliminándolos de la cola
 * @author Santiago Faci
 * @version curso 2014-2015
 */
public class Consumidor extends Thread {

	private Cola cola;
	
	public Consumidor(Cola cola) {
		
		this.cola = cola;
	}
	
	public void run() {
		
		Integer elemento;
		
		do {
			elemento = cola.eliminar();
			//System.out.println("Consumidor " + getName() + " - " + elemento);

		} while (cola.getDatos().size() >= 1 ); 

		
		//}
	}

}
