package psp_2024.hilos.bloqueos.con_mas_de_2hilos;
public class AlternateCharPrinter {

    public static char ch = 65;

    private static void createAndStartThreads(int count) {
        Object lock = new Object();
        for (int i = 0; i < count; i++) {
            new Thread(new AlternateCharRunner((char) (65 + i), lock)).start();
        }
    }

    public static void main(String[] args) {
        createAndStartThreads(8);
    }

}

class AlternateCharRunner implements Runnable {

    private char ch;
    private Object lock;
	private  static  int runnerCount;

    public AlternateCharRunner(char ch, Object lock) {
        this.ch = ch;
        this.lock = lock;
        runnerCount++;
    }

    @Override
    public void run() {
    	
    	// System.out.println(runnerCount);
    	
        while (true) {
            synchronized (lock) {
            	
				
				  System.out.println(); System.out.println("Hay " + Thread.activeCount() +
				  " hilos activos"); System.out.println();
				 
            	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * System.out.println(); System.out.println("Hay " + Thread.activeCount() +
				 * " hilos activos"); System.out.println();
				 */
            	
            	
            	
                while (ch != AlternateCharPrinter.ch) {
                    try {
                    	
                   	Thread.sleep(100); /*
                        System.out.println();
                        System.out.println("Hay " + Thread.activeCount() + " hilos activos");
                        System.out.println();
                        */
                    	
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(runnerCount);
                    
                    /*	Thread.sleep(1000);
                    System.out.println();
                    System.out.println("Hay " + Thread.activeCount() + " hilos activos");
                    System.out.println();
                    */
                    
                }
               System.out.println(AlternateCharPrinter.ch++);
               //System.out.println(runnerCount);
                if (AlternateCharPrinter.ch == (65 + runnerCount)) {
                    AlternateCharPrinter.ch = 65;
                }
                lock.notifyAll();
            }
        }
    }

}