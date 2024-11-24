package psp_2024.hilos.ejemplos_basicos;

public class MiHilo extends Thread {

	public MiHilo(String nombre, int prioridad, ThreadGroup grupo) {
		super(grupo, nombre);
		this.setPriority(prioridad);  // eliminar "this" para entender a qué se refiere
	}

	public void run()
	{
		for(int i=1; i <=3; i++)
		{
		
			System.out.println(this.getName());
		
			try {
				MiHilo.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
