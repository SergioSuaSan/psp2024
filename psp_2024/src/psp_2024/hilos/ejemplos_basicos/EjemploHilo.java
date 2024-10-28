package psp_2024.hilos.ejemplos_basicos;

public class EjemploHilo {

	public static void main(String[] args) throws InterruptedException {

		//Hilo del main
		//System.out.println("hola mundo");
		Thread.currentThread().setName("hiloprincipal");
		
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
		System.out.println("hilo principal -> " + Thread.currentThread().toString());
		System.out.println("hilos ejecutandose -> " + Thread.currentThread().activeCount());
		
		System.out.println(Thread.currentThread().getId());
		
		
		
		
		
 		// AQUI CREO MIS PROPIOS HILOS
		ThreadGroup grupo = new ThreadGroup("grupo1");
		MiHilo hilo1 = new MiHilo("hilo1", 1, grupo );
		System.out.println("hilo secundario -> " + hilo1.toString());
		System.out.println(hilo1.getState()); 
		hilo1.start(); // lanzo el hilo
		//hilo1.run();

		
		System.out.println("hilos ejecutandose -> " + Thread.currentThread().activeCount());

		MiHilo hilo2 = new MiHilo("hilo2", 10, grupo );
		System.out.println("hilo secundario -> " + hilo2.toString());
		
		
		/*
		try {
			hilo1.join(); // espero a que termine el hilo1
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		//hilo1.stop();
		//hilo1.wait();
		System.out.println(hilo1.getState());
		
		hilo2.start(); // lanzo el hilo
		
		/*
		try {
			hilo2.join(); // espero a que termine el hilo1
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		
		System.out.println("hilos ejecutandose -> " + Thread.currentThread().activeCount());
		//hilo1.yield();
		//hilo2.yield();
		
		System.out.println(hilo1.getState());  
		
		
		

	}

}
