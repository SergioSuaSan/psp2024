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
				if (!cadena.endsWith(String.valueOf(letra)))
				 sigueCadena();
				
			 }
			 //Una vez hecho, le digo al hilo que espere para que pueda cogerlo el siguiente
			 //Y lo notifico
				  try {
					 
					Thread.sleep(10); 
					//wait();//Si primero pones el wait, los dos se quedan esperando y nunca funciona
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	
				  notify();
				  
		 }
			 
		
	
	public void sigueCadena() {
		//Añado el caracter que vale 1 + que el último carácter de la cadena
		cadena = cadena + (char)( cadena.charAt(cadena.length()-1) +1); //CONVERTIRLO A CHAR Y SUMARLE 1	
		 
		
	}
	public String getCadena() {
		return this.cadena;
	}

}
