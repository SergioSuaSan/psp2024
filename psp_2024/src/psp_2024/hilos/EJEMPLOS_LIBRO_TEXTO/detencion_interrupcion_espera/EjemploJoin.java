package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.detencion_interrupcion_espera;


class HiloJoin extends Thread {
  private int n;
  
  public HiloJoin(String nom, int n) {
    super(nom);  
    this.n=n;	
  }
  public void run() {
    for(int i=1; i<= n; i++)  {
       System.out.println(getName() + ": " + i);
       try {
           sleep(500); 
       } catch (InterruptedException ignore) {}    	   
    }
	System.out.println("Fin Bucle "+getName());
  }
 }//




public class EjemploJoin {
  public static void main(String[] args)  {
   HiloJoin h1 = new HiloJoin("Hilo1",2);
   HiloJoin h2 = new HiloJoin("Hilo2",5);
   HiloJoin h3 = new HiloJoin("Hilo3",17);
   
   h1.start();
   h2.start();
   h3.start();
   
   
   try {
       h1.join(); h2.join(); h3.join(); 
   } catch (InterruptedException e) { }		

  System.out.println("FINAL DE PROGRAMA");	
 }
}//