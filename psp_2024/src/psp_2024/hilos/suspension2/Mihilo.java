package psp_2024.hilos.suspension2;

import java.util.Scanner;

//Esta clase implementa un hilo a la vez que lo ejecuta
//Con ella se ejemplifica un caso de suspensión y reanudación de un hilo
//bajo ciertas condiciones (según se introduzca "s" o "r" desde el teclado).
//Para conseguirlo se sirve de los métodos sincronizados de la clase
//SolicitaSuspender dentro de este mismo paquete.

class Mihilo extends Thread {

	/*VARIABLES*/
	//variable que cuenta segundos en run()
	private int contador = 0;
	//variable que controla la finalización de run()
	private boolean stopHilo = false;
	//creación de un hilo basado en la propia clase; como será usado en el main en vez de
	//en un método normal, tiene que ser static (no se puede usar this dentro del main)
	static Mihilo mh = new Mihilo();
	//objeto para controlar la suspensión basado en la clase auxiliar SolicitaSuspender
	private SolicitaSuspender suspender = new SolicitaSuspender();
	
	// variable para el nombre del hilo
	String nombrehilo;
	
	public Mihilo(String nombrehilo) {
		setName(nombrehilo);
	}
	public Mihilo() {
		
	}
	
	
	
	
	/*MÉTODOS*/
	//para deterner run()
	public void pararHilo() {
		stopHilo = true;
	}
	// petición de SUSPENDER HILO
	public void Suspende() {
		suspender.set(true);
	}
	// petición de CONTINUAR (y de iniciar al principio)
	public void Reanuda() {
		suspender.set(false);
	}

	// registra el valor final del contador
	public int valorContador() {
		return contador;
	}
	
	//contenido del hilo: cuenta, muestra la cuenta por segundos, y comprueba el estado de 
	//la suspensión
	public void run() {
		try {
			while (!stopHilo) {

				++contador;
				//System.out.println(contador + " Id de hilo = " + getId());
				System.out.println(contador + "  " + getName());
				sleep(1000);//permite ver la numeración con comodidad

				// detiene o continúa la ejecución del bucle según el valor
				// de suspender
				suspender.esperandoParaReanudar(); 

			}
			System.out.println("El hilo " + getName() + " ha terminado");

		} catch (InterruptedException exception) {
		}
	}


	
	public static void main(String args[]) {

		//primera lectura desde teclado
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Introduce s para suspender el hilo, y r para reanudarlo. \n" 
				+ "Para detener el programa usa * \n");
		String esc = sc.next();

		//arranque del hilo
		mh.start();

		//bucle de lectura desde teclado y consecuente ejecución o suspensión o detención del hilo
		//según el carácter introducido (ejecutar para ver)
		while (esc.equalsIgnoreCase("*") == false) {
			if (esc.equalsIgnoreCase("s") == true) {
				mh.Suspende();
				//System.out.println(mh.getState());
				System.out.println("En suspensión");
			} else if (esc.equalsIgnoreCase("r") == true) {
				mh.Reanuda();
				//System.out.println(mh.getState());
				System.out.println("En ejecución");
			} else {
				mh.Suspende();
				System.out.println("Introduce un carácter correcto. Se suspende el hilo.");
			}

			esc = sc.next();
			
			
		}

		// La siguiente reanudación es para evitar que al salir del bucle con el hilo
		// suspendido no pueda terminarse.

		//mh.Reanuda();

		// Detención del hilo
		mh.pararHilo();
		sc.close();

		
		
		// Registro del resultado de ejecución
		System.out.println("El hilo se ha ejecutado durante " + mh.valorContador() + " segundos.");

	}

}