package psp_2024.procesos.primos;

import java.io.IOException;

public class EjecutaPrimos1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Creamos un proceso  que compare el resto de la división de dos números para determinar si son primos entre si		
		CrearProcesoPrimos1 cpp1 = new CrearProcesoPrimos1(4,24);
		
		//Obligamos a que se realice el proceso antes de poder mostrar el resultado
		cpp1.getP().waitFor();
		
		//Muestra el resultado en pantalla
		cpp1.getResultado();
	}

}
