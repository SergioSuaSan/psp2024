package ejercicio2;

import java.io.File;

public class CuentaCadenas {

	public static void main(String[] args) {

		//Instanciamos el fichero a utilizar.Como está en el archivo fuente, su path es directamente el archivo
		File fichero = new File("twain.txt");
		
		//Creamos tantos procesos como palabras queramos buscar
		CrearProcesoCadenas foor = new CrearProcesoCadenas("for", fichero);
		CrearProcesoCadenas twain = new CrearProcesoCadenas("Twain", fichero);
		CrearProcesoCadenas god = new CrearProcesoCadenas("God", fichero);
		CrearProcesoCadenas pain = new CrearProcesoCadenas("pain", fichero);
		CrearProcesoCadenas doubt = new CrearProcesoCadenas("doubt", fichero);
		
		//Ejecutamos los procesos sincronizados
		
		try {
			foor.getP().waitFor();
			twain.getP().waitFor();
			god.getP().waitFor();
			pain.getP().waitFor();
			doubt.getP().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
