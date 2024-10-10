package psp_2024.procesos.sumar;

/*
 * Esta clase contiene un procedimiento suma que suma mediante un bucle todos los números
 * enteros dentro de un rango, y un procedimiento principal main que recoge dos argumentos
 * tipo String que servirán como límites para dicho rango (y que se introducen en Eclipse 
 * desde el menú contextual runAs-->run Configurations-->Arguments).
 * Esta clase va a servir de base para la creación de un proceso en la clase 
 * CrearProcesoSumar en este mismo paquete, que a su vez permitirá ejemplificar en la
 * clase Ejemplo3 cómo dividir la suma de un rango en la de dos subrangos con sus propios
 * procesos asociados.
 */



public class Sumar {

	private static int suma(int numI, int numF) {

		//int resultado = numI + numF;
		int resultado = 0;
		
		for (int i = numI; i <= numF; i++) {
			resultado = resultado + i;
		}
		
		
		return resultado;
	}

	public static void main(String[] args) {

		if (args.length == 2) {
			int numI = Integer.valueOf(args[0]);
			int numF = Integer.valueOf(args[1]);
			int resultado = suma(numI, numF);
			System.out.println(resultado);
		} else {
			// no hago nada
		}
	}
}
