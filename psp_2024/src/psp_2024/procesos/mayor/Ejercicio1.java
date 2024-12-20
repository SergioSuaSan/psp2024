package psp_2024.procesos.mayor;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Usamos la clase para crear 2 ficheros con el resultado de las 2 comparaciones mayores
		CrearProcesoMayor p1 = new CrearProcesoMayor(4,113,".\\src\\psp_2024\\procesos\\mayor\\fich1.txt");
		CrearProcesoMayor p2 = new CrearProcesoMayor(15,6,".\\src\\psp_2024\\procesos\\mayor\\fich2.txt");
		try {
			//Aseguramos que se ejecuten los procesos antes de guardarlos en las variables
			p1.getP().waitFor();
			p2.getP().waitFor();
			//Guardamos los resultados de los procesos en las variables
			int x = p1.getResultadoMayor();
			int y = p2.getResultadoMayor();
			//Creamos un nuevo proceso comparando los números mayores de los anteriores procesos
			//Luego repetimos la forma de realizarse de antes
			CrearProcesoMayor p3 = new CrearProcesoMayor(x,y,".\\src\\psp_2024\\procesos\\mayor\\fich3.txt");	
			p3.getP().waitFor();
			int z = p3.getResultadoMayor();
			//Imprimimos el resultado en pantalla
			System.out.println(z);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
