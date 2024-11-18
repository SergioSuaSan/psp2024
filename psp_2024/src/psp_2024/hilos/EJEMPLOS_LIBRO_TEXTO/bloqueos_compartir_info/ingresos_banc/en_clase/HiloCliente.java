package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.ingresos_banc.en_clase;

public class HiloCliente implements Runnable {

	private Thread hilo;
	private Cuenta cuenta;
	private int dinero;
	private String nombre;

	public HiloCliente(String nombre, int prioridad, ThreadGroup g, Cuenta cuenta1/* , int dinero */) {
		//inicializaciones del hilo con su prioridad y nombre, y de la cuentea.
	}

	//getHilo()



	public int generardinero() {
		//generar dinero aleatorio entre 1 y 20
		return (int) Math.random()*20+1;
	}



	@Override
	public void run() {

		synchronized (cuenta) {

			//variables para ingreso, auxiliar y límite a ingresar
			 int limite, ingreso;

			//inicialización del límite a un valor prefijado
			limite = 100;

			while (cuenta.getSaldo() < limite) {
				// se genera dinero y se guarda en la variable ingreso
				ingreso = generardinero();

				//se comprueba que el nuevo ingreso no supera el límite y si lo hace se reajusta
				if (cuenta.getSaldo() + ingreso >limite) 
				{
					ingreso = cuenta.getSaldo() + ingreso -limite;
					
				}

				//se ingresa el dinero
				cuenta.ingresarDinero(ingreso);
				
				
				System.out.println(this.nombre + " ha ingresado " + ingreso + " euros. ");

				//se actualiza el valor del dinero

				//sleep y wait
			}
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("el total ingresado por " + this.nombre + " es " + this.dinero + " euros");
		}
	}

}