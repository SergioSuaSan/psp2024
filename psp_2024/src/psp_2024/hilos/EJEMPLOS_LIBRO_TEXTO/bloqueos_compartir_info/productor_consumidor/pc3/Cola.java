package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.productor_consumidor.pc3;

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
 * La clase Cola define 2 atributos y dos métodos. En el atributo numero se guarda el número
 * entero y el atributo disponible se utiliza para indicar si hay disponible o no un número 
 * en la cola. El método put() guarda un entero en el atributo numero y hace que este esté 
 * disponible en la cola para que pueda ser consumido poniendo el valor true en disponible 
 * (cola llena). El método get() tiene que esperar a que haya un nuevo número disponible (algo
 * de lo que se encarga el método put()) para proceder a volver a situarse en espera y devolver
 * el número que ha introducido put() en la cola. El método put(), paralelamente y por su parte,
 * tiene que esperar a que get le comunique que no hay ya ningún número disponible para proceder
 * a volver poner disponible un nuevo número para el consumidor get(). En ambos casos, una
 * vez que se sale del bucle de espera se ejecuta la visualización de las operaciones sobre
 * la cola del productor y el consumidor.
 */

public class Cola {
    private int numero;
    private boolean disponible = false;//inicialmente cola vacia

    //////////////////////////// INICIO MÉTODO SINCRONIZADO
    public synchronized int get() {
          //bucle que espera a que haya nuevo número disponible en la cola
    	  while (!disponible) {
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  //visualiza valor
    	  System.out.println("Se consume: " + numero);  
    	  //instrucciones de cambio de estado, notificación a otros hilos y recogida de valor
    	  disponible = false;
    	  notify();
    	  return numero;
    	}
    //////////////////////////// FIN MÉTODO SINCRONIZADO
    
    //////////////////////////// INICIO MÉTODO SINCRONIZADO
    public synchronized void put(int valor) {
    	  //bucle de espera a que se quede vacía la cola
    	  while (disponible){
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  //instrucciones de asignación de valor, cambio de estado y notificación a otros hilos
    	  numero = valor;
    	  disponible = true;
    	  //visualiza valor
    	  System.out.println("Se produce: " + numero);   
    	  notify();
    	}
    //////////////////////////// FIN MÉTODO SINCRONIZADO
     
     
}
