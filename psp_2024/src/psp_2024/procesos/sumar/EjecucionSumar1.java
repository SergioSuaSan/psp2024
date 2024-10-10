package psp_2024.procesos.sumar;

import java.io.IOException;

public class EjecucionSumar1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		CrearProcesoSumar2 cps = new CrearProcesoSumar2(15, 55, "primero.txt");
		CrearProcesoSumar2 cps2 = new CrearProcesoSumar2(555, 999, "segundo.txt");
		
		cps.getP().waitFor();
		cps2.getP().waitFor();
		
		
		int primerResultado = cps.getResultadoSuma();
		int segundoResultado = cps2.getResultadoSuma();
		
		System.out.println(primerResultado+segundoResultado);
		
		
		

	}

}
