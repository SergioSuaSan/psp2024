package psp_2024.ZZZ.PRUEBAS.ejemploHilos;

public class HiloTic extends Thread{

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("TIC");
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



}
