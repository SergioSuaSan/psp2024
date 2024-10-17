package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class EjecutaTicTac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread h1 = new HiloTic();
		Thread h2 = new HiloTac();
		h1.start();
		h2.start();
		

	}

}
