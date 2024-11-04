package curso276.swing_055_064__086_122.elementos_en_la_ventana_58_63;

import java.awt.GraphicsEnvironment;

public class TiposDeFuente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String nombredelafuente: nombresDeFuentes) {
			System.out.println(nombredelafuente);
		}

	}

}
