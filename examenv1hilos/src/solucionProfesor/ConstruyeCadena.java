package solucionProfesor;

import java.util.Scanner;

/*
Este programa genera una cadena alfabética mediante la colaboración de varios hilos
que van añadiendo sincronizadamente letras a la cadena hasta llegar a la indicada como
última letra..
 */

//CLASES

/*
 * Se define la clase cadenaLetras, define un atributo cadena y tres métodos: uno devuelve el
valor de la cadena (getCadena), otro, añade a la cadena una letra minúscula (sigueCadena) y el 
tercero (crearCadena) realiza las comprobaciones y operaciones para que, por una parte, al añadir 
una nueva letra sea la a si la cadena está vacía, o si no es así, ir añadiendo letras minúsculas 
hasta llegar a la que será la letra tope de la serie; cuando llegue a esta, se informará de que 
se ha completado la cadena. 
También se añade un sleep() intencionadamente para que la visualización sea más
pausada.
 */
class CadenaLetras2 {
	private String cadena;
	//private cadenaLetras cl /*= new cadenaLetras("")*/;

	public CadenaLetras2() {
		cadena = "";
	}

	
	String getCadena() {
		return cadena;
	}

	void sigueCadena() {
		char ultima = this.cadena.charAt(cadena.length()-1);
		char siguiente = (char)(((int)ultima)+1);
		this.cadena = cadena.concat(String.valueOf(siguiente));
		//System.out.println("Cadena= " + getCadena());
	}

	 synchronized  void crearCadena(char letra, String nom) {
		
		
		if (getCadena().equals("")) {
			this.cadena = "a";
			//cl = new cadenaLetras(cadena);
			/*
			 * try { Thread.sleep(500); } catch (InterruptedException ex) { }
			 */
		
			
			System.out.println("En ejecución: "+ nom + " Cadena= " + cadena);
			System.out.println(getCadena().charAt(cadena.length()-1) + "<-->" + letra);
		}
		else if (getCadena().charAt(cadena.length()-1) < letra){
			
			this.sigueCadena();
			
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
				System.out.println("fallo");
			}
			
			System.out.println("En ejecución: "+ nom + " Cadena= " + getCadena());
			System.out.println(getCadena().charAt(cadena.length()-1) + "<-->" + letra);
			
			 if (getCadena().charAt(cadena.length()-1) == letra){
					System.out.println("Cadena= " + cadena);
					System.out.println("La cadena se ha completado");			
				}
		}
		/*
		else if (getCadena().charAt(cadena.length()-1) == letra){
			System.out.println("Cadena= " + cadena);
			System.out.println("La cadena se ha completado");			
		}
		*/
		/*
		 if (getCadena().charAt(cadena.length()-1) == letra){
				System.out.println("Cadena= " + cadena);
				System.out.println("La cadena se ha completado");			
			}
			*/
			
		
		/*
		 * if (getCadena().length() > letra-'a'+1) { System.out.println(letra-'a'+1);
		 * System.out.println("Cadena= " + cadena);
		 * System.out.println("Se ha sobrepasado el límite de la cadena: " +
		 * "la última letra es --> " + cadena.charAt(cadena.length()-1)); }
		 */
			
	}// retirar
}

/*
 * A continuación, se crea la clase MontaCadena que extiende Thread y usa la
 * clase cadenaLetras para ir creando la serie de minúsculas. El constructor recibe una 
 * cadena para dar nombre al hilo, un objeto tipo cadenaLetras como se ha dicho y la letra
 * que marca el límite de la serie. El método run() se limita a ejecutar el método de 
 * crearCadena asociado al objeto cadenaLetras, aunque también debe permitir que no haya
 * hilos egoístas que acaparen la ejecución.
 */
class MontaCadena2 extends Thread {
	private CadenaLetras2 c/* = new cadenaLetras()*/;
	private char letraTope;
	//constructor que da nombre al hilo e inicia la cadena
	public MontaCadena2(String n, CadenaLetras2 c, char letraTope) {
		super(n); // en esta ocasión se usa el constructor de Thread(String nombre)
		//this.c = c;
		this.letraTope = letraTope;
		this.c=c;
	}

	public void run() {
		for (int x = 'a'; x <= /*'z'*/ letraTope; x++) {
			c.crearCadena(letraTope, getName());
			
			//Este sleep permite la alternancia entre diferenes instancias del
			//hilo (diferentes hilos) a la hora de construir la cadena al abrir
			//al otro hilo el acceso al objeto compartido.
			try {
			sleep(100);
			}
			catch(Exception e) {
				
			}
			
		}
	}
}

/*
 * Por último se crea el método main() donde primero se define un objeto de la
 * clase cadenaLetras, y a continuación se obtiene la letra tope, con lo cual ya podemos
 * crear dos objetos de la clase MontaCadena que servirán para instanciar los hilos
 * que operen sobre la cadena compartida.
 */
public class ConstruyeCadena {
	public static void main(String[] args) {
		CadenaLetras2 c = new CadenaLetras2();
		System.out.println("Introducir la letra tope: ");
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		//sc.next();
		char letra = l.charAt(0);
		MontaCadena2 h1 = new MontaCadena2("Hilo1", c, letra);
		MontaCadena2 h2 = new MontaCadena2("Hilo2", c,  letra);
		MontaCadena2 h3 = new MontaCadena2("Hilo3", c,  letra);

		h1.start();
		h2.start();
		h3.start();
		sc.close();
	}
}