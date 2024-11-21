package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.productor_consumidor.pc1;

/*
 * Este paquete forma unidad de estudio con productorConsumidor2 y productorConsumidor3.
 * En ellos se aborda el problema de sincronizar un productor con un consumidor de un
 * determinado recurso -una cola básica en este caso, de un solo elemento entero de entrada 
 * y salida- con la siguiente estrategia de estudio: en este primer paquete se muestra 
 * cómo sería una primera aproximación, fallida al no usar sincronización; en el siguiente 
 * paquete productorConsumidor2 se añade la sincronización necesaria para que no se 
 * interfieran el productor y el consumidor a la hora de acceder y modificar la cola, sino 
 * que se esperen a que el otro acabe de ejecutarse (el método  de consumo tiene que esperar, 
 * primero, a que el de producción inicialice la variable numero y que, después, vaya 
 * indicando si está o no un nuevo número disponible); pero como con eso todavía no se 
 * consigue la salida deseada ya que puede mostrarse y se muestra en alguna de las ejecuciones 
 * que se hace el consumo antes que la producción, de modo que hay que evitarlo pasando el 
 * mensaje que se visualiza en pantalla de producción-consumo a los métodos sincronizados 
 * de la clase Cola, tal y como puede verse en el paquete productorConsumidor3.  
 */

/*
 * Este primer paquete, por consiguiente, consta de 4 clases: una Productor y otra Consumidor
 * preparados como hilos que se sirven de los métodos de la clase Cola para realizar su 
 * función; por último la clase Produc_Consum lanza los hilos, pero al no estar sincronizados
 * los hilos en su acceso al objeto común cola, la salida no resulta la pretendida de ir 
 * alternando producción y consumo de manera que el consumidor vaya recogiendo lo que el 
 * productor va generando.
 */

/*
 * El productor genera números de O a 4 en un bucle for, y los pone en el objeto Cola mediante
 * el método put() de Cola; después se visualiza y se hace un pausa con sleep() -para que 
 * pueda comprobarse mejor la ausencia/presencia de sincronización-, durante este tiempo el 
 * hilo esta en el estado Not Runnable (no ejecutable)
 */

public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); //pone el número
            System.out.println(i + "=>Productor : " + n
                               + ", produce: " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) { }			
			
        }
    }
}


