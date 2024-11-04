package curso276.swing_055_064__086_122.elementos_en_la_ventana_58_63;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class TrabajandoConColores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoConColor mimarco = new MarcoConColor();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoConColor extends JFrame{
	
	public MarcoConColor() {
		
		setTitle("Prueba con colores");
		setSize(400, 400);
		LaminaConColor milamina = new LaminaConColor();
		add(milamina);
		milamina.setBackground(Color.PINK);
		//milamina.setBackground(SystemColor.window);
	}
}


class LaminaConColor extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.setPaint(Color.RED);
		g2.fill(rectangulo);
		g2.setPaint(Color.BLACK);
		g2.draw(rectangulo);
		
		
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.setPaint(new Color(109, 172, 59).brighter());
		g2.fill(elipse);
		g2.setPaint(Color.YELLOW);
		g2.draw(elipse);

				
		
	}
	
}










