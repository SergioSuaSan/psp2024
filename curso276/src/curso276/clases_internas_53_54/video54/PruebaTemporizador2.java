package curso276.clases_internas_53_54.video54;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

//Ejemplo de clase interna local (dentro de un método no directamente dentro de
//la clase externa con los cambios consecuentes en el resto del programa).

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj mireloj=new Reloj();
		mireloj.enMarcha(3000, true);
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");
		System.exit(0);
		
	}

}

class Reloj{
	
	public void enMarcha(int intervalo, final boolean sonido) {
		
		class DameLaHora2 implements ActionListener{
			
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
		
		
		ActionListener oyente = new DameLaHora2();
		Timer mitemporizador = new Timer(intervalo, oyente);
		mitemporizador.start();
		
	}
	

}
