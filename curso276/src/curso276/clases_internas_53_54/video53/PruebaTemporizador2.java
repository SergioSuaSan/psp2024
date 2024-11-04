package curso276.clases_internas_53_54.video53;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

//Ejemplo de clase interna a otra clase

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj mireloj=new Reloj(3000, true);
		mireloj.enMarcha();
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");
		System.exit(0);
		
	}

}

class Reloj{
	
	int intervalo;
	boolean sonido;
	
	public Reloj(int intervalo, boolean sonido) {
		
		this.intervalo=intervalo;
		this.sonido=sonido;
		
	}
	
	public void enMarcha() {
		
		ActionListener oyente = new DameLaHora2();
		Timer mitemporizador = new Timer(intervalo, oyente);
		mitemporizador.start();
		
	}
	
	private class DameLaHora2 implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			Date ahora = new Date();
			System.out.println("Se pone la hora cada 3 seg. " + ahora);
			if (sonido) {
				//Con Eclipse (u otro ide como Inteljidea o netbeans) no suena, tampoco
				//si se ejecuta con javaw, pero sí suena ejecutado desde la línea de
				//comandos con el comando java.
				Toolkit.getDefaultToolkit().beep(); //tampoco suena con la línea de comandos
				System.out.print("\007"); // \007 is the ASCII bell --> sí suena en línea de comandos
				
			}
		}
	}
}
