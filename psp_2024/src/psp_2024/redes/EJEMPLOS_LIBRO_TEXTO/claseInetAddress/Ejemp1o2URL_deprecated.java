package psp_2024.redes.EJEMPLOS_LIBRO_TEXTO.claseInetAddress;

import java.net.*;
import java.io.*;

public class Ejemp1o2URL_deprecated {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://www.elaltozano.es");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		BufferedReader in;
		try {
			InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}// Ejemplo2URL
