package ejercicio1;

public class CadenaLetras {
	private String cadena;
	public CadenaLetras() {
		this.cadena = "";
	}
	public synchronized void crearCadena(char letra, String cadena) {
		
		
		//Si la cadena está vacía, la empiezo. Si no, la continuo
			 if(cadena.equals("")) {
				 this.cadena = "a";
				
			 } else {
				
				 sigueCadena();
				 System.out.println("prueba");
			 }
			 //Una vez hecho, le digo al hilo que espere para que pueda cogerlo el siguiente
			 //Y lo notifico
				  try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  notify();
		 }
			 
		
	
	public void sigueCadena() {
		//Añado el caracter que vale 1 + que el último carácter de la cadena
		cadena =cadena + cadena.charAt(cadena.length()-1);
		 
		
	}
	public String getCadena() {
		return this.cadena;
	}

}
