package psp_2024.hilos.EJEMPLOS_LIBRO_TEXTO.bloqueos_compartir_info.productor_consumidor;


import java.awt.Toolkit;
import javax.swing.*;
//////////////////////////////////////////////////////////////////
// Hilo demonio. Suena el "bip" de Windows aproximadamente cada tiempo dado
//
public class DemonioAviso extends Thread
{
	int segundos;
  public DemonioAviso(int segundos)
  {
	this.segundos = segundos;
    setDaemon(true);
    start();
  }
  
  public void run()
  {
    //char bip = '\u0007';
    while (true)
    {
      try
      {
    	//System.out.print(bip);
    	//Toolkit.getDefaultToolkit().beep();
        sleep(segundos*1000); // duerme durante los segundos indicados
      }
      catch (InterruptedException e) {}
      //System.out.print(bip);
      Toolkit.getDefaultToolkit().beep();
    }
  }
}
//////////////////////////////////////////////////////////////////
