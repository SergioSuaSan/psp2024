package psp_2024.ZZZ.PRUEBAS.prueba_vocales;

import java.io.File;

import javax.swing.JOptionPane;

public class BuscaVocales {

	public static void main(String[] args) {

		//Instanciación del objeto fichero a utilizar 
		File fichero = new File(".\\src\\psp_2024\\ZZZ\\PRUEBAS\\prueba_vocales\\fichero_vocales2.txt");
		
		//Instanciación de los objetos CrearProcesoVocales: uno para cada vocal
		CrearProcesoVocales cpva = new CrearProcesoVocales('a', fichero);
		CrearProcesoVocales cpve = new CrearProcesoVocales('e', fichero);
		CrearProcesoVocales cpvi = new CrearProcesoVocales('i', fichero);
		CrearProcesoVocales cpvo = new CrearProcesoVocales('o', fichero);
		CrearProcesoVocales cpvu = new CrearProcesoVocales('u', fichero);
		try {
			//Ejecución de los procesos sincronizados.
			cpva.getP().waitFor();
			cpve.getP().waitFor();
			cpvi.getP().waitFor();
			cpvo.getP().waitFor();
			cpvu.getP().waitFor();
			
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		

	}

}
