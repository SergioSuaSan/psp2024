package psp_2024.hilos.bloqueos_compartir_info.productor_consumidor_cola;

/**
 * Clase que produce elementos y los añade en la cola
 * @author Santiago Faci
 * @version curso 2014-2015
 */
public class Productor extends Thread {

	private Cola cola;
	private int tamano;
	
	public Productor(Cola cola, int tamano) {
		this.cola = cola;
		this.tamano = tamano;
	}
	
	public void run() {
		
		for (int i = 0; i < tamano; i++) {			
			//System.out.println("Productor " + getName() + " - " + i);
			cola.anadir(i);			
		}
		
	}
}
