package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class HiloTacR implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("TAC");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
