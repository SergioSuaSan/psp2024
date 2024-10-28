package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.detencion_interrupcion_espera;


public class HiloEjemploInterrup extends Thread {
	static int cont = 0;
	
  public void run() {

	 /*
	      while (!isInterrupted()) {
	        System.out.println("En el Hilo");
		    
	      }
	    */

		  
	  try {
      while (!isInterrupted()) {
        System.out.println("En el Hilo");
	    Thread.sleep(100); //Es durante estos lapsos que interrupt() podrá lanzar una excepción
      }
      } catch (InterruptedException e) {
	     System.out.println("HA OCURRIDO UNA EXCEPCIÓN");
	  }
	  
     
      System.out.println("FIN HILO");
   }//run
  
  
   public void interrumpir() {
       interrupt();
   }//interrumpir
   
   public static void main(String[] args) throws InterruptedException {
	HiloEjemploInterrup h = new HiloEjemploInterrup();
    h.start();
	for(long i=0; i<2000000000; i++) {
		//System.out.println("");
		cont++;
		cont++;
		
		//System.out.println(cont);
		
	};//no hago nada, hay que dar tiempo para que la siguiente
									//instrucción tenga una oportunidad.
    //Thread.sleep(15000);
    
	h.interrumpir();
  }//     
}//
