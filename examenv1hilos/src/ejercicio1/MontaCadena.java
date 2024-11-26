package ejercicio1;

public class MontaCadena extends Thread {
	private CadenaLetras c;
	private char letraTope;
	
	public MontaCadena( String string, CadenaLetras c, char letra) {
		this.c = c;
		this.letraTope = letra;
		
	}
	
	public void run() {
		//Ejecutamos el crear cadena mientras no acabe en la letra tope
		while (!c.getCadena().endsWith(String.valueOf(letraTope)))
		c.crearCadena(letraTope, c.getCadena());
		System.out.println(getName() + ":" + c.getCadena());
		
		
		
	}
	



}
