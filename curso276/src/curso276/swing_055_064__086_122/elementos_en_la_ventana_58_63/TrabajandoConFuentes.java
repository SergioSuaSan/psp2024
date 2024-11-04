package curso276.swing_055_064__086_122.elementos_en_la_ventana_58_63;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConFuentes mimarco = new MarcoConFuentes();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
	
	
	class MarcoConFuentes extends JFrame{
		
		public MarcoConFuentes() {
			
			setTitle("Prueba con fuentes");
			setSize(400, 400);
			LaminaConFuentes milamina = new LaminaConFuentes();
			add(milamina);
			
			//Para establecer un color común a los elementos gráficos
			//en el frame
			milamina.setForeground(Color.BLUE);
			

		}
	}


	class LaminaConFuentes extends JPanel{
		
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			
			//ahora se usará el color por defecto (azul) al no establecer ninguno
			Font fuente2 = new Font("Trebuchet MS", Font.PLAIN, 18);
			g2.setFont(fuente2);
			g2.drawString("Texto de prueba uno", 100, 100);
			
			
			//con su propio color de fuente
			Font fuente = new Font("Courier New", Font.BOLD, 18);
			g2.setFont(fuente);
			g2.setColor(Color.RED);
			g2.drawString("Texto de prueba dos", 100, 200);
			
			//lo mismo con otra sintaxis
			g2.setFont(new Font("Arial", Font.ITALIC, 24));
			g2.setColor(new Color(100, 200, 100).brighter());
			g2.drawString("Otro texto", 100, 300);
			

			
	
		}
	}	


