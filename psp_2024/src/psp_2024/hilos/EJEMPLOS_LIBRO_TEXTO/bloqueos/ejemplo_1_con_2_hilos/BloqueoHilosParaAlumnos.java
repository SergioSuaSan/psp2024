package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos.ejemplo_1_con_2_hilos;

/*
 * Este archivo forma pareja con el de BloqueoHilosInicial, y sirven mediante sus clases 
 * para ilustrar un caso típico en que se necesita un bloqueo en la ejecución de diferentes
 * hilos para conseguir una salida de programa con un determinado patrón, que en este
 * ejemplos es una secuencia de A's y B's alternadas.
 */

//En esta segunda y correcta aproximación se consigue la salida alternada de A's y B's
//mediante la inclusión apropiada de los métodos wait y notify (o notifyAll) dentro del
//bloque sincronizado.

/*
 * creamos una clase que define un método que recibe un String y lo pinta:
 */
class ObjetoCompartido {	
	public void PintaCadena (String s) {
		System.out.print(s);
	}
  }// ObjetoCompartido


/*
 * La clase HiloCadena extiende Thread; en su método run invoca al método PintaCadenaO
del objeto compartido dentro de un bucle for. Se necesita por tanto mantener una cierta 
coordinación entre los dos hilos, para ello se usan los métodos wait, notify (o notifyAll):
dentro del bloque sincronizado y después de pintar la cadena se invocará al método notify
del objeto compartido para despertar al hilo que esté esperando el objeto (notifyAll cuando 
varios hilos esperan el objeto). Inmediatamente después se llama al método wait del objeto 
para que el hilo quede suspendido y el que estaba en espera tome el objeto para pintar la 
cadena; el hilo permanecerá suspendido hasta que se produzca un notify sobre el objeto. 
El último notifyQ es necesario para que los hilos finalicen correctamente y ninguno
quede bloqueado:
 */
class HiloCadena extends Thread {
	private ObjetoCompartido objeto;
    String cad;
	public HiloCadena (ObjetoCompartido c, String s) {		
		this.objeto = c;
		this.cad=s;
	}
	public void run() {
		  //////////////////INICIO DEL BLOQUE SINCRONIZADO

		//INSERTAR INSTRUCCIONES PARA LA VISUALIZACIÓN DEL MENSAJE DEL OBJETO
		//COMPARTIDO DE MANERA LOS HILOS QUE LO ACCEDAN VAYAN ALTERNÁNDOSE
		//(WAIT - NOTIFY)
		
		  //////////////////FIN DEL BLOQUE SINCRONIZADO
		  System.out.print("\n"+cad + " finalizado");
		}//run

}//HiloCadena


/*
 * Para usar las clases anteriores definimos un método main en el que se crea un objeto de 
esa clase que además será compartido por dos hilos del tipo HiloCadena. Los hilos usarán el 
método del objeto compartido para pintar una cadena, esta cadena es enviada al crear el hilo 
(new HiloCadena (objeto compartido, cadena)):
 */
public class BloqueoHilosParaAlumnos {
	public static void main(String[] args) {

		//INSTANCIACIÓN DE OBJETO COMPARTIDO, INSTANCIACIÓN E INICIALIZACIÓN DE HILOS 
		
	}
}//BloqueoHilos

