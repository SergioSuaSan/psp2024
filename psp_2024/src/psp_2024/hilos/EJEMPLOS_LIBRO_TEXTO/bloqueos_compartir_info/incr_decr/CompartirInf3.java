package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.incr_decr; 
//CLASES

/*
 * Se define la clase Cuenta, define un atributo saldo y tres métodos, uno devuelve el
valor del saldo, otro, resta al saldo una cantidad y el tercero realiza las comprobaciones para
hacer la retirada de dinero, es decir, que el saldo actual sea >= que la cantidad que se quiere
retirar; el constructor inicia el saldo actual. También se añade un sleep() intencionadamente 
para que un hilo se duerma y mientras el otro haga las operaciones.
 */
class Cuenta {
	private int saldo;

	Cuenta(int s) {
		saldo = s;
	}

	int getSaldo() {
		return saldo;
	}

	void restar(int cantidad) {
		saldo = saldo - cantidad;
	}

	/*
	synchronized void RetirarDinero(int cant, String nom) {
	
		if (getSaldo() >= cant) {
			System.out.println(nom + ": SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
			try {
				//wait(1); //Bloquea el hilo que está trabajando, permitiendo que otro hilo acceda, pero siempre con acceso exclusivo
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}

			restar(cant);

			System.out.println("\t" + nom + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");
		} else {
			System.out.println(nom + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO => " + getSaldo());
		}
	}// retirar
	 */
	void RetirarDinero(int cant, String nom) {
			
			if (getSaldo() >= cant) {
				System.out.println(nom + ": SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
				try {
				    //wait(1); //Bloquea el hilo que está trabajando, permitiendo que otro hilo acceda, pero siempre con acceso exclusivo
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}
	
				restar(cant);
	
				System.out.println("\t" + nom + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");
			} else {
				System.out.println(nom + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
			}
			if (getSaldo() < 0) {
				System.out.println("SALDO NEGATIVO => " + getSaldo());
			}
		
	}// retirar
}

/*
 * A continuación, se crea la clase SacarDinero que extiende Thread y usa la
 * clase Cuenta para retirar el dinero. El constructor recibe una cadena, para
 * dar nombre al hilo; y la cuenta que será compartida por varias personas. En
 * el método run() se realiza un bucle donde se invoca al método RetirarDinero()
 * de la clase Cuenta varias veces con la cantidad a retirar, en este caso
 * siempre es 10 y cuatro veces, y el nombre del hilo.
 */
class SacarDinero extends Thread {
	private Cuenta c;
	//constructor que da nombre al hilo e inicia la cuenta
	public SacarDinero(String n, Cuenta c) {
		super(n); // en esta ocasión se usa el constructor de Thread(String nombre)
		this.c = c;
	}

	public void run() {
		synchronized (c) {
			for (int x = 1; x <= 8; x++) {
				c.RetirarDinero(10, getName());
			}
		}
	}
}

/*
 * Por último se crea el método main() donde primero se define un objeto de la
 * clase Cuenta y se le asigna un saldo inicial de 40. A continuación se crean
 * dos objetos de la clase SacarDinero, imaginemos que son las dos personas que
 * comparten la cuenta, y se inician los hilos.
 */
public class CompartirInf3 {
	public static void main(String[] args) throws InterruptedException {
		Cuenta c = new Cuenta(140);
		SacarDinero h1 = new SacarDinero("Ana", c);
		SacarDinero h2 = new SacarDinero("Juan", c);
		SacarDinero h3 = new SacarDinero("Maria", c);

		h1.start();
		//h1.join();
		h2.start();
		h3.start();
		
	}
}