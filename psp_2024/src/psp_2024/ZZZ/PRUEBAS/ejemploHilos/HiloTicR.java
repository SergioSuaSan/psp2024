package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class HiloTicR implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("TIC");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



}
