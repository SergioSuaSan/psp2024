package curso276.swing_055_064__086_122.colocando_ventana_y_mas_56_57;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCentrado marco1 = new MarcoCentrado();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCentrado extends JFrame {
	
	public MarcoCentrado() {
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanopantalla = mipantalla.getScreenSize();
		int alturapantalla = tamanopantalla.height;
		int anchopantalla = tamanopantalla.width;
		setSize(anchopantalla/2, alturapantalla/2);
		setLocation(anchopantalla/4, alturapantalla/4);
		Image miIcono = mipantalla.getImage("src\\curso276\\swing_055_064__086_122\\colocando_ventana_y_mas_56_57\\icono.gif");
		setIconImage(miIcono);
				
	}
}