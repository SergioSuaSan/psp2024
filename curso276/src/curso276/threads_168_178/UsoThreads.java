package curso276.threads_168_178;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/*
 * El siguiente código recoge las clases y métodos desarrollados en los vídeos
 * 168-169 y primera mitad del 170, antes de implementar un botón para cada hilo
 * lanzado en el contexto de la detención de hilos mediante el método interrupt(). 
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
	
	public void  run() {
		
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

		setBounds(600, 300, 400, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		ponerBoton(laminaBotones, "Dale!", new ActionListener() {

			public synchronized void actionPerformed(ActionEvent evento) {
				
				comienza_el_juego();
				try {
					t.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		});

		ponerBoton(laminaBotones, "Salir", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				System.exit(0);
			}
		});
		
		//En vídeo 169 se añade la función de detener a que corresponde
		//este botón y el método detener() y demás asociado.
		/*
		ponerBoton(laminaBotones, "Detener", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				detener();
			}
		});
		*/
		ponerBoton(laminaBotones, "Suspender", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				suspender();
			}
		});
		ponerBoton(laminaBotones, "Reanudar", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				reanudar();
			}
		});

		add(laminaBotones, BorderLayout.SOUTH);

	}

	protected void suspender() {
		// TODO Auto-generated method stub
		sosu = new SolicitaSuspender();
		t.interrupt();
		sosu.set(t.isInterrupted());
		
		
	}

	protected void reanudar() {
		// TODO Auto-generated method stub
		if ( Thread.currentThread().isInterrupted()) {	
			try {
				Thread.interrupted();
				sosu.esperandoParaReanudar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
	}

	// Se ponen botones
	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}

	
	
	// Añade pelota y la mueve 1000 veces
	
	Thread t;  //variable común a comienza_el_juego() y detener()
	public synchronized void comienza_el_juego() {

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
		t = new Thread(r);
		t.start();
		
		

	}

	
	public void detener(){
		
		// t.stop(); //obsoleto, no utilizar
		t.interrupt();
	}

	private LaminaPelota lamina;
	private SolicitaSuspender sosu;
}
