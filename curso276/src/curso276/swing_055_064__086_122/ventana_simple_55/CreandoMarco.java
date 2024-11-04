package curso276.swing_055_064__086_122.ventana_simple_55;

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
		setSize(500, 300);
	}
}