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
 * En el método main() que usa las clases anteriores creamos 3 objetos, un objeto de la clase
 * Cola , un objeto de la clase Productor y otro objeto de la clase Consumidor. Al constructor 
 * de las clases Productor y Consumidor le pasamos el objeto compartido de la clase Cola y un 
 * número entero que lo identifique. Y se ejecutan los hilos productor y consumidor. El 
 * resultado es la correcta ejecución tanto de la secuencia de generación sincronizada de 
 * producción y consumo de la cola, así como de su correcta visualización. 
 */

public class Produc_Consum {
  public static void main(String[] args) {  
    Cola cola = new Cola();
	
    Productor p = new Productor(cola/*, 1*/);	
	Consumidor c = new Consumidor(cola/*, 1*/);
	
    p.start();
	c.start();

	
  }
}