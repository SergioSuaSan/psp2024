package curso276.tipos_enun_48;

import java.util.Scanner;

public class Uso_Tallas {

	//enum Talla {MINI, MEDIANA, GRANDE, MUY_GRANDE};
	
	enum Talla{

		MINI("S"), MEDIANA("M"), GRANDE("L"), MUY_GRANDE("XL");
		
		private String abreviatura;
		
		private Talla(String abreviatura) {
			
			this.abreviatura = abreviatura;
		}
		
		public String dameAbreviatura() {
			
			return abreviatura;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe la talla: MINI, MEDIANA, GRANDE, MUY_GRANDE");
		String entrada_datos = entrada.next().toUpperCase();
		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		System.out.println("Talla " + la_talla);
		System.out.println("Abreviatura: " + la_talla.dameAbreviatura());
		
		//Modos de referirse a una clase como la de Talla
		System.out.println(Talla.class.getName());
		System.out.println(la_talla.getClass().getName());
	}

}
