package curso276.swing_055_064__086_122.elementos_en_la_ventana_58_63;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class FuentesInstaladas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuente = JOptionPane.showInputDialog("Introducir nombre de fuente");
		boolean estalafuente = false;
		
		String[] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String nombredelafuente: nombresDeFuentes) {
			if(nombredelafuente.equalsIgnoreCase(fuente)) {
				estalafuente = true;
			}
			
		}

		if(estalafuente) {
		System.out.println("La fuente está instalada");
		}else {
			System.out.println("La fuente no está instalada");
		}

}
}
