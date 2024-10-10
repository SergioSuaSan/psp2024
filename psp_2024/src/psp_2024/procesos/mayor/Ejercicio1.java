package psp_2024.procesos.mayor;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Usamos la clase para crear 2 ficheros con el resultado de las 2 comparaciones mayores
		CrearProcesoMayor p1 = new CrearProcesoMayor(4,113,".\\src\\psp_2024\\procesos\\mayor\\fich1.txt");
		CrearProcesoMayor p2 = new CrearProcesoMayor(15,6,".psp_2024\\src\\psp_2024\\procesos\\mayor\\fich2.txt");
		try {
			p1.getP().waitFor();
			p2.getP().waitFor();
			int x = p1.getResultadoMayor();
			int y = p2.getResultadoMayor();
			CrearProcesoMayor p3 = new CrearProcesoMayor(x,y,".\\psp_2024\\src\\psp_2024\\procesos\\mayor\\fich3.txt");	
			p3.getP().waitFor();
			int z = p3.getResultadoMayor();
			System.out.println(z);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
