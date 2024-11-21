package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.productor_consumidor.pc2;

/*
 * Este paquete forma unidad de estudio con productorConsumidor1 y productorConsumidor3.
 * En ellos se aborda el problema de sincronizar un productor con un consumidor de un
 * determinado recurso -una cola básica en este caso, de un solo elemento entero de entrada 
 * y salida- con la siguiente estrategia de estudio: en el primer paquete se muestra 
 * cómo sería una primera aproximación, fallida al no usar sincronización; en este segundo 
 * paquete productorConsumidor2 se añade la sincronización necesaria para que no se 
 * interfieran el productor y el consumidor a la hora de acceder y modificar la cola, sino 
 * que se esperen a que el otro acabe de ejecutarse (el método  de consumo tiene que esperar, 
 * primero, a que el de producción inicialice la variable numero y que, después, vaya 
 * indicando si está o no un nuevo número disponible); pero como con eso todavía no se consigue 
 * la salida deseada ya que puede mostrarse y se muestra en alguna de las ejecuciones 
 * que se hace el consumo antes que la producción, de modo que hay que evitarlo pasando el 
 * mensaje que se visualiza en pantalla de producción-consumo a los métodos sincronizados 
 * de la clase Cola, tal y como se ve en el paquete productorConsumidor3. 
 */

/*
 * Este segundo paquete, por consiguiente, consta de 4 clases: una Productor y otra Consumidor
 * preparados como hilos que se sirven de los métodos de la clase Cola para realizar su 
 * función; por último la clase Produc_Consum lanza los hilos sincronizados en lo que respecta
 * a los métodos get y put del objeto cola que comparten el productor y el consumidor, pero al
 * estar los mensajes de visualización fuera de esos métodos sincronizados su orden puede no
 * ser el pretendido, y mostrarse eventualmente el mensaje de consumo antes del de producción
 * porque se ejecute antes el hilo de consumo.
 */

/*
 * En el método main() que usa las clases anteriores creamos 3 objetos, un objeto de la clase
 * Cola , un objeto de la clase Productor y otro objeto de la clase Consumidor. Al constructor 
 * de las clases Productor y Consumidor le pasamos el objeto compartido de la clase Cola y un 
 * número entero que lo identifique. Y se ejecutan los hilos productor y consumidor. El 
 * resultado, aunque correcto por lo que toca a la numeración correlativa de los bucles 0-4
 * de productor y consumidor, puede no ser correcto dentro de cada paso -adelantándose el
 * consumidor al productor en lo que a los mensajes de visualización se refiere- ya que la
 * sincronización no opera fuera de los bloques synchronized de la clase Cola. 
 */



public class Produc_Consum {
  public static void main(String[] args) {  
    Cola cola = new Cola();
	
    Productor p = new Productor(cola, 1);	
	Consumidor c = new Consumidor(cola, 1);
	
    p.start();
	c.start();

  }
}