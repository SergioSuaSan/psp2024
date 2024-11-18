package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.incr_decr;

/*
 *  Este archivo forma pareja con CompartirInf2, y ambos forman grupo a su vez con CompartirInf3 y
 *  CompartirInf4. Todos tratan de la sincronización de procesos que comparten objetos/código.
 *  Los dos primeros ejemplifican la sincronización de bloques de código de la siguiente manera:
 *  En este archivo dos procesos diferentes operan concurrentemente y sin sincronización sobre
 *  un objeto contador, mientras en en CompartirInf2 lo harán sincronizadamente.
 *  No hay en este caso una salida coherente predeterminada del programa, puesto que los hilos
 *  pueden interferirse; es decir, no hay necesariamente como resultado del programa que tras 
 *  la ejecución del HiloA contador valga 400 (los 100 de partida + los 300 del bucle), mientras 
 *  que el HiloB valdría 100 (de resultas de restar los 300 del bucle a los 400 que podría 
 *  suponerse que vale el contador después de ejecutarse el HiloA)... Aunque podría suceder
 *  en alguna ejecución así, también puede suceder que el HiloB sea asignado y opere sobre el 
 *  contador antes de que el HiloA termine y que vayan modificando los valores que este va 
 *  asignando al contador.
 */

// CLASES

/*
 *  Esta clase Contador define un atributo contador y tres métodos, uno de ellos incrementa 
 *	una unidad su valor, el otro lo decrementa y el tercero devuelve su valor; el constructor 
 *	asigna un valor inicial al contador:
 */
class Contador {
	private int c = 0;
	Contador(int c) {
		this.c = c;
	}

	public void incrementa() {
		c = c + 1;
	}

	public void decrementa() {
		c = c - 1;
	}

	public int getValor() {
		return c;
	}

}// CONTADOR


/*
 * Para probar el objeto compartido se definen dos clases que extienden Thread. En la clase
HiloA se usa el método del objeto contador que incrementa en uno su valor. En la clase HiloB se
usa el método que decrementa su valor. Se añade un sleep() intencionadamente para probar que
un hilo se duerma y mientras el otro haga otra operación con el contador, así la CPU no realiza
de una sola vez todo un hilo y después otro y podemos observar mejor el efecto.
 */
class HiloA extends Thread {
	private Contador contador;
	
	//constructor que da nombre al hilo e inicia el contador
	public HiloA(String n, Contador c) {
		setName(n); // objeto-hilo this implícito
		contador = c;
	}
	public void run() {
		
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
			try {
				sleep(1);
			} catch (InterruptedException e) {		}
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
		
	}
}// FIN HILOA

class HiloB extends Thread {
	private Contador contador;
	//constructor que da nombre al hilo e inicia el contador
	public HiloB(String n, Contador c) {
		setName(n); // objeto-hilo this implícito
		contador = c;
	}
	public void run() {
		
		for (int j = 0; j < 300; j++) {
			contador.decrementa();
			try {
				sleep(1);
			} catch (InterruptedException e) {}
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
		
	}
}// FIN HILOB


/*
 * A continuación se crea el método main(), donde primero se defme un objeto de la clase
Contador y se le asigna el valor inicial de lOO. En el main se crean los dos hilos pasándoles
dos parámetros: un nombre y el objeto Contador. Seguidamente se inicia la ejecución de los
hilos
 */
public class CompartirInf1 {
	public static void main(String[] args) throws InterruptedException {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		//a.join();
		b.start();       
	}
}
