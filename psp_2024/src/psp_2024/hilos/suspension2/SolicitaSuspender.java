package psp_2024.hilos.suspension2;

// Clase que implementa dos métodos sincronizados que permiten suspender y 
// reanudar la ejecución de un programa que se ejecuta en otra clase
// (tal y como puede ver en la clase Mihilo en este mismo paquete).

public class SolicitaSuspender {

	//variable que compartirán los métodos para poder interoperar
	private boolean suspender;

	//este método entra en suspensión implementada por wait() mientras suspender
	//sea true
	public synchronized void esperandoParaReanudar() throws InterruptedException {
		
		while (suspender)
			/*
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("El hilo se ha terminado estando en suspensión");
				System.exit(0);
			} //SUSPENDER HILO HASTA RECIBIR notify() o notifyAll()
			*/
			wait();
		
	}

	//este método asigna un valor a suspender y lo notifica
	public synchronized void set(boolean b) {
		suspender = b; // permite el cambio de estado sobre el objeto
		notifyAll(); // reanuda o no el wait según el valor de suspender
	}

}
