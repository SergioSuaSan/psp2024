package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.productor_consumidor;

/*
 * Este paquete forma unidad de estudio con productorConsumidor1 y productorConsumidor2.
 * En ellos se aborda el problema de sincronizar un productor con un consumidor de un
 * determinado recurso -una cola básica en este caso, de un solo elemento entero de entrada 
 * y salida- con la siguiente estrategia de estudio: en el primer paquete se muestra 
 * cómo sería una primera aproximación, fallida al no usar sincronización; en el segundo 
 * paquete productorConsumidor2 se añade la sincronización necesaria para que no se 
 * interfieran el productor y el consumidor a la hora de acceder y modificar la cola, sino 
 * que se esperen a que el otro acabe de ejecutarse (el método  de consumo tiene que esperar, 
 * primero, a que el de producción inicialice la variable numero y que, después, vaya 
 * indicando si está o no un nuevo número disponible); pero como con eso todavía no se consigue 
 * la salida deseada ya que puede mostrarse y se muestra en alguna de las ejecuciones 
 * que se hace el consumo antes que la producción, de modo que hay que evitarlo pasando el 
 * mensaje que se visualiza en pantalla de producción-consumo a los métodos sincronizados 
 * de la clase Cola, tal y como se ve en este paquete productorConsumidor3. 
 */

/*
 * Este tercer paquete, por consiguiente, consta de 4 clases: una Productor y otra Consumidor
 * preparados como hilos que se sirven de los métodos de la clase Cola para realizar su 
 * función; por último la clase Produc_Consum lanza los hilos sincronizados en lo que respecta
 * a los métodos get y put del objeto cola que comparten el productor y el consumidor, que
 * esta vez si mostrarán una salida correcta por pantalla/consola porque incluyen en su 
 * código sincronizado los mensajes de visualización. 
 */

/*
 * La clase Consumidor es muy similar a la clase Productor, solo que en Jugar de poner un
 * número en el objeto Cola lo recoge llamando al método get(). En este caso no se ha puesto 
 * pausa, con esto hacemos que el consumidor sea más rápido que el productor.
 */

public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola c/*, int n*/) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(); //recoge el n�mero
          
        }
    }
}
