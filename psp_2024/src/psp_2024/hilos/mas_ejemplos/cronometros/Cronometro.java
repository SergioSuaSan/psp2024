package psp_2024.hilos.mas_ejemplos.cronometros;

import java.util.Scanner;

import javax.swing.JFrame;

public class Cronometro implements Runnable {

	Thread crono;
	javax.swing.JLabel tiempo = new javax.swing.JLabel();

	/** Creates new form cronometro */
	public Cronometro() {
		JFrame ventana = new JFrame("Cronometro");
		ventana.add(tiempo);
		ventana.setSize(150, 100);
		ventana.setVisible(true);

		crono = new Thread(this);
		crono.start();
	}

	int minutos = 0, segundos = 0, horas = 0;

	public void run() {
		System.out.println("¿Cuántos segundos quieres contar?");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		try {
			for (int i = 0;i< num; i ++) {
				if (segundos == 59) {
					segundos = 0;
					minutos++;
				}
				if (minutos == 59) {
					minutos = 0;
					horas++;
				}
				segundos++;

				tiempo.setText(horas + ":" + minutos + ":" + segundos);
				System.out.println(tiempo.getText());
				crono.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		new Cronometro();
	}

}