package curso276.swing_055_064__086_122.elementos_en_la_ventana_58_63;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaDibujo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoConDibujos2 mimarco2 = new MarcoConDibujos2();
		mimarco2.setVisible(true);
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoConDibujos2 extends JFrame{
	
	public MarcoConDibujos2() {
		
		setTitle("prueba de dibujo");
		setSize(400, 400);
		LaminaConFiguras2 milamina = new LaminaConFiguras2();
		add(milamina);
	}
}


class LaminaConFiguras2 extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.draw(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		double CentroenX = rectangulo.getCenterX();
		double CentroenY = rectangulo.getCenterY();
		double radio = Math.sqrt(Math.pow(100, 2) + Math.pow(75, 2));
		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX+radio, CentroenY+radio);
		g2.draw(circulo);
				
		
	}
	
}










