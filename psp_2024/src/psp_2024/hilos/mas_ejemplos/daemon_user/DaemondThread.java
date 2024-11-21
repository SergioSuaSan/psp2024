package psp_2024.hilos.mas_ejemplos.daemon_user;

/*
 * Los thread que han sido cualificado como daemon terminan de una forma diferente. Cuando la VM
detecta que sólo permanecen en ejecución thread Daemon termina su ejecución.
Los daemon thread son utilizados para ejecutar tareas auxiliares de otros thread normales, cuando
estos han terminado aquellos no tienen función y finalizan.
En el ejemplo es interesante comprobar que cuando finaliza main, y la VM descubre que sólo queda
el thread t , este finaliza de forma abrupta y no sale normalmente por la rama finally.

 */

public class DaemondThread implements Runnable {

	public void run() {

		System.out.println("Comienza run()");

		try {

			while (true) {

				try {
					Thread.sleep(500);

				} catch (InterruptedException e) {
				}
				;

				System.out.println("run() ha despertado");

			}

		} finally {

			System.out.println("Termina run()");
		}

	}

	public static void main(String[] args) {
		System.out.println("Comienza main()");
		Thread t = new Thread(new DaemondThread());
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		;
		System.out.println("Termina main()");
	}
}