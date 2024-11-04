package curso276.interfaces_con_eventos_52;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		DameLaHora oyente = new DameLaHora();
		//ActionListener oyente = new DameLaHora();
		Timer mitemporizador = new Timer(2000, oyente);
		mitemporizador.start();
		JOptionPane.showMessageDialog(null, mitemporizador);
		System.exit(0);

	}

}

class DameLaHora implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		
		Date ahora = new Date();
		System.out.println("Se muestra la hora cada 2 segs. " + ahora);
		//Con Eclipse (u otro ide como Inteljidea o netbeans) no suena, tampoco
		//si se ejecuta con javaw, pero sí suena ejecutado desde la línea de
		//comandos con el comando java.
		Toolkit.getDefaultToolkit().beep(); //tampoco suena con la línea de comandos
		System.out.print("\007"); // \007 is the ASCII bell --> sí suena en línea de comandos
	       System.out.flush();
	}


	
}
