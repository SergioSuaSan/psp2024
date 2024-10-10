package psp_2024.procesos.mayor;

public class Mayor {
	/*
	 * Clase que nos pide dos números y nos indica el mayor de los dos
	 */

	//Metodo que con dos parámetros te devuelve el mayor de los dos
	private static int elMayor(int x, int y) {
		if(x>y) return x;
		else return y;
	}
	
	//Metodo principal, que te muestra el resultado usando el metodo elMayor
	public static void main(String[] args) {
    
	if (args.length == 2) {	
	int x = Integer.valueOf(args[0]);
    int y = Integer.valueOf(args[1]);
    int resultado = elMayor(x,y);
    System.out.println(resultado);
	}
	}



}
