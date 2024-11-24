package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class EjecutaTicTacR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloTicR h1 = new HiloTicR();
		HiloTacR h2 = new HiloTacR();
		Thread n1 = new Thread(h1);
		Thread n2 = new Thread(h2);
		n1.start();
		n2.start();
		

	}

}
