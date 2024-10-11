package psp_2024.procesos.primos;

public class PrimosEntreSi_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = Integer.valueOf(args[0]);
		int y = Integer.valueOf(args[1]);
		
		if (sonPrimos(x, y)) {
			System.out.println("Los números son primos entre sí");
		}
		else {
			System.out.println("Los números no son primos entre sí");
		}
	
	}

	/*
	 * Metodo que hace que si el resto de dividir el primer numero entre el segundo es distinto de 0 y viceversa, 
	 * retorna true.
	 */
	static boolean sonPrimos(int x, int y) {
		boolean res = false;
		if(x % y != 0 && y % x != 0 ) {	
			res = true;
		}
		return res;
	}
}