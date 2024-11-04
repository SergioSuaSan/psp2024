package curso276.swing_055_064__086_122.colocando_ventana_y_mas_56_57;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1 = new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class miMarco extends JFrame {
	
	public miMarco() {
		//setSize(500, 300);
		//setLocation(500, 300);
		setBounds(500, 300, 550, 250);
		//setResizable(false);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Mi ventana");
		
	}
}