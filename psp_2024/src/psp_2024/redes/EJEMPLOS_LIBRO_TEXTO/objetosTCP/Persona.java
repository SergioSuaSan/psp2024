package psp_2024.redes.EJEMPLOS_LIBRO_TEXTO.objetosTCP;

import java.io.Serializable;

public class Persona implements Serializable {

	private String nombre;
	private int edad;
	public Persona(String string, int i) {
		// TODO Auto-generated constructor stub
		nombre = string;
		edad = i;
		
	}

	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}




}
