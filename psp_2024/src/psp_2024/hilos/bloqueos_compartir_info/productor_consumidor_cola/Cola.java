package psp_2024.hilos.bloqueos_compartir_info.productor_consumidor_cola;

import java.util.ArrayList;

/**
 * Clase que representa una cola de elementos
 * En este ejemplo será lo que se conoce como un recurso compartido, 
 * puesto que dos hilos accederán de forma concurrente a ella
 */
public class Cola {

	private int limite;
	private ArrayList<Integer> datos;
	Integer elemento;
	private boolean vaciandose;
	private boolean llenandose;
	
	public Cola(int limite) {
		
		this.limite = limite;
		datos = new ArrayList<Integer>(limite);
		vaciandose = false;
		llenandose = true;
	}
	
	public ArrayList<Integer> getDatos() {
		return datos;
	}
	
	/**
	 * Operación que añade los elementos a la cola
	 * El método se declara como sincronizado para que Java nos asegure que 
	 * nunca lo ejecuta más de un hilo al mismo tiempo
	 * @param elemento El elemento que se quiere añadir
	 * @throws InterruptedException 
	 */
	public synchronized void anadir(int elemento)  {
		
		/*
		 * Mientras la cola está llena o está vaciándose hay que esperar
		 */
				
		while (datos.size() == limite || vaciandose == true) {

			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}
		
		//después ya se pueden ir añadiendo los elementos (ojo a los
		//límites del array)
		if (datos.size()<limite-1) {
		llenandose = true;
		datos.add(elemento);
		/*
		try {
			Thread.currentThread().sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		System.out.println("Se produce: " + elemento); 
		}//cuando se llena se modifican los factores para que 
		//pueda empezar a vaciarse
		else {llenandose = false;
				notifyAll();}
		
		
	}
	
	/**
	 * Operación que elimina los elementos de la cola
	 * El método se declara como sincronizado para 
	 * que Java nos asegure que nunca lo ejecuta 
	 * más de un hilo al mismo tiempo
	 * @return El elemento eliminado
	 */
	public synchronized Integer eliminar() {
		
		/*
		 * Mientras la cola está vacía o está llenándose hay que esperar
		 */
		
		while (datos.size() == 0 || llenandose == true) {
			try {
				wait();
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		//después ya se pueden ir recogiendo los elementos de la cola
		if (datos.size()>0) {
			elemento = datos.remove(0);
			//así funciona como una cola; descomentando la instrucción
			//siguiente se convierte en una pila
			//Integer elemento = datos.remove(datos.size()-1);
			/*
			try {
				Thread.currentThread().sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	  	  //visualiza valor
	  	  System.out.println("Se consume: " + elemento);  
	  	  //System.out.println("Tamaño cola: " + datos.size());
		vaciandose = true;
		}//cuando se vacía se modifican los factores para que 
		//pueda empezar a llenarse
		else {vaciandose = false;
				notifyAll();}
		
		
		return elemento;
		
	}


}
