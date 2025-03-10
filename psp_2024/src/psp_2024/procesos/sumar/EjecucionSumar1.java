package psp_2024.procesos.sumar;

import java.io.IOException;

public class EjecucionSumar1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Creamos dos procesos que sumarán  todos los números consecutivos desde el inicial hasta el final y los pondrán en un fichero de texto
		
		CrearProcesoSumar cps = new CrearProcesoSumar(15, 55, "primero.txt");
		CrearProcesoSumar cps2 = new CrearProcesoSumar(555, 999, "segundo.txt");
		
		//Obligamos a que los procesos terminen antes de poder guardarlos en variables
		cps.getP().waitFor();
		cps2.getP().waitFor();
		
		//Guardamos el resultado de los procesos ya terminados en variables
		int primerResultado = cps.getResultadoSuma();
		int segundoResultado = cps2.getResultadoSuma();
		
		//Imprimimos la suma de los dos resultados anteriores
		System.out.println(primerResultado+segundoResultado);
		
		
		

	}

}
