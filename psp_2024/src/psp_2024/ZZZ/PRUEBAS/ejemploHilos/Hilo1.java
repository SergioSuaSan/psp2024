package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class Hilo1 extends Thread {

	public void run() {
		
		System.out.println("Se ha ejecutado el hilo");
	
	
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilo1 h1 = new Hilo1();
		h1.start();

	}

}
