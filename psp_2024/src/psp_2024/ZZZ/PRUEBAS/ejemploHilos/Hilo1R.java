package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class Hilo1R implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Hilo1R h1r = new Hilo1R();
			Thread h2 = new Thread(h1r);
			h2.start();
			
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Se ha decladrado el hilo1r");
	}

}
