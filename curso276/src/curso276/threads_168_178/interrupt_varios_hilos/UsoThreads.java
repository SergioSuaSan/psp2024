package curso276.threads_168_178.interrupt_varios_hilos;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Este código es la continuación de la clase UsoThreads del paquete superior.
 * Aquí se parte, desde el minuto 8 aprox. del vídeo 170, del momento en que para
 * poder detener diferentes hilos se tienen que añadir los botones correspondientes. 
 */
public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame marco = new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}
}

////////////*****************************************************************
//Clase para creación de los hilos
class PelotaHilos implements Runnable {

	public PelotaHilos(Pelota pelota, Component unComponente) {
		this.pelota = pelota;
		this.componente = unComponente;
	}
	
	private Pelota pelota;  //aquí se almacenará la pelota
	private Component componente; //aquí se almacenará la lámina
	
	public void run() {
		
		System.out.println("Estado de detención del hilo al comenzar: " + Thread.currentThread().isInterrupted());
	//	for (int i = 0; i <= 1000; i++) {
	//	while (!Thread.interrupted()) {
		while (!Thread.currentThread().isInterrupted()) {
			
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			
		}
		
		System.out.println("Estado de detención del hilo al detener: " + Thread.currentThread().isInterrupted());
		
	}
	
	
	
	

	
}


////////////*****************************************************************


//////////////////////////////////////////////////////////////////////////////

// Movimiento de la pelota
class Pelota {
	// Mueve la pelota invirtiendo posición si choca con límites
	public void mueve_pelota(Rectangle2D limites) {

		x += dx;
		y += dy;

		if (x < limites.getMinX()) {
			x = limites.getMinX();
			dx = -dx;

		}

		if (x + TAMX >= limites.getMaxX()) {
			x = limites.getMaxX() - TAMX;
			dx = -dx;

		}

		if (y < limites.getMinY()) {
			y = limites.getMinY();
			dy = -dy;

		}

		if (y + TAMY >= limites.getMaxY()) {
			y = limites.getMaxY() - TAMY;
			dy = -dy;

		}

	}

	// Forma de la pelota en su posición inicial
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, TAMX, TAMY);
	}

	private static final int TAMX = 15;
	private static final int TAMY = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;

}


//////////////////////////////////////////////////////////////////////////////

// Lámina que dibuja las pelotas
class LaminaPelota extends JPanel {

	// Añadimos pelota a la lámina
	public void add(Pelota b) {
		pelotas.add(b);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (Pelota b : pelotas) {
			g2.fill(b.getShape());
		}

	}

	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}


//////////////////////////////////////////////////////////////////////////////

// Marco con lámina y botones
class MarcoRebote extends JFrame {

	public MarcoRebote() {

		setBounds(500, 300, 500, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		//nueva implementación de los botones
		arranca1 = new JButton("Hilo1");
		
		arranca1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comienza_el_juego(evento);
			}
			
		});
		
		laminaBotones.add(arranca1);
		
		
		arranca2 = new JButton("Hilo2");
		
		arranca2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comienza_el_juego(evento);
			}
			
		});
		
		laminaBotones.add(arranca2);
		
		
		arranca3 = new JButton("Hilo3");
		
		arranca3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comienza_el_juego(evento);
			}
			
		});
		
		laminaBotones.add(arranca3);
		
		
		
		detener1 = new JButton("Stop1");
		
		detener1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}
			
		});
		
		laminaBotones.add(detener1);
		
		
		detener2 = new JButton("Stop2");
		
		detener2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}
			
		});
		
		laminaBotones.add(detener2);
		
		
		detener3 = new JButton("Stop3");
		
		detener3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}
			
		});
		
		laminaBotones.add(detener3);
		
		/////Hasta aquí la creación de botones
		
		
		
		add(laminaBotones, BorderLayout.SOUTH);

	}



	
	
	private JButton addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		return null;
	}





	// Añade pelota y la mueve 1000 veces
	
	Thread t1, t2, t3;  
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
	
	
	public void comienza_el_juego(ActionEvent e) {

		Pelota pelota = new Pelota();

		lamina.add(pelota);

		/* bucle original en la versión monotarea
		for (int i = 0; i <= 1000; i++) {

			pelota.mueve_pelota(lamina.getBounds());
			lamina.paint(lamina.getGraphics());
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		
		//Código para añadir instancias de hilos multitarea
		Runnable r = new PelotaHilos(pelota, lamina);
		//Thread t = new Thread(r);
		
		if(e.getSource().equals(arranca1)) {
			t1 = new Thread(r);
			t1.start();
			
		}else if(e.getSource().equals(arranca2)) {
			t2 = new Thread(r);
			t2.start();
		}else if(e.getSource().equals(arranca3)) {
			t3 = new Thread(r);
			t3.start();			
		}

		

	}

	
	public void detener(ActionEvent e){
		
		if (e.getSource().equals(detener1)) {
			t1.interrupt();
		}else if (e.getSource().equals(detener2)) {
			t2.interrupt();
		}else if (e.getSource().equals(detener3)) {
			t3.interrupt();
		}
		
	}

	private LaminaPelota lamina;
}
