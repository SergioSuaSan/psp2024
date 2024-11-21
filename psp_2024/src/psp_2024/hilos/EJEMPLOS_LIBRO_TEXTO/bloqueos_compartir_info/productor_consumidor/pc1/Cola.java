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
 * La clase Cola define 2 atributos y dos métodos. En el atributo numero se guarda el número
 * entero y el atributo disponible se utiliza para indicar si hay disponible o no un número 
 * en la cola. El método put() guarda un entero en el atributo numero y hace que este esté 
 * disponible en la cola para que pueda ser consumido poniendo el valor true en disponible 
 * (cola llena). El método get() devuelve el entero de la cola si está disponible 
 * (disponible=true) y antes pone la variable a false indicando cola vacía; si el número no 
 * está en la cola (disponible=false) devuelve -1 (esto cambiará en los métodos de las clases
 * Cola de los otros paquetes, en donde el método get tendrá que esperar a que haya un nuevo
 * número disponible mediante un bucle while).
 */

public class Cola {
    private int numero;
    private boolean disponible = false;//inicialmente cola vacia

    public int get() {
	    if(disponible) {      //hay número en la cola
		disponible = false; //se pone cola vacía
            return numero;      //se devuelve
	    }
          return -1;	//no hay número disponible, cola vacía	
    }


    
    public void put(int valor) {
        numero = valor;    //coloca valor en la cola 
        disponible = true; //disponible para consumir, cola llena	
    }
    
    

    
    
}
