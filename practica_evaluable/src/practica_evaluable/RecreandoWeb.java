package practica_evaluable;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;

public class RecreandoWeb {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		URL url = null;
		// Leemos el contenido de la página
		try {
			url = new URL("http://www.example.com");
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

		System.out.println();

		try {
			URLConnection conexion = url.openConnection();

			// Crear carpeta y archivo en la raíz del servidor Apache
			File carpeta = new File("C:\\xampp\\htdocs\\practica_red_psp_1");
			if (!carpeta.exists())
				carpeta.mkdirs();

			File archivo = new File(carpeta, "ejemplo.html");
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

			// Leer y escribir el contenido de la página
			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;

			System.out.println("Guardando contenido en: " + archivo.getPath());
			while ((linea = reader.readLine()) != null) {
				writer.write(linea);
				writer.newLine();
			}

			reader.close();
			writer.close();

			System.out.println("Archivo guardado exitosamente.");
		} catch (IOException e) {
			e.printStackTrace();

		}

		System.out.println();
		// Creamos proceso para abrir la página en el navegador
		try {
			// Línea de comando dada para en el enunciado adaptada a Chrome
			String comando = "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" http://localhost/practica_red_psp_1/ejemplo.html";
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();

		// Bloque para obtener la información después de abrir la página
		try {
			url = new URL("http://localhost/practica_red_psp_1/ejemplo.html");
			URLConnection conexion = url.openConnection();

			// Del método visualizar
			System.out.println("\tURLcompleta: " + url.toString());
			System.out.println("\tgetProtocol(): " + url.getProtocol());
			System.out.println("\tgetHost(): " + url.getHost());
			System.out.println("\tgetPort(): " + url.getPort());
			System.out.println("\tgetFile(): " + url.getFile());
			System.out.println("\tgetUserinfo(): " + url.getUserInfo());
			System.out.println("\tgetPath(): " + url.getPath());
			System.out.println("\tgetAuthority(): " + url.getAuthority());
			System.out.println("\tgetQuery(): " + url.getQuery());
			System.out.println("\tgetDefaultPort(): " + url.getDefaultPort());

			System.out.println();

			System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");

			// USAMOS UNA ESTRUCTURA Map PARA RECUPERAR CABECERAS
			Map camposcabecera = conexion.getHeaderFields();
			Iterator it = camposcabecera.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry map = (Map.Entry) it.next();
				System.out.println(map.getKey() + " : " + map.getValue());
			}
			System.out.println("Tipo de Contenido [getContentType()]: " + conexion.getContentType());
			System.out.println("Tamaño del contenido: " + conexion.getContentLength());

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();

		// Para utilizar el InnetAdress
		InetAddress dir = null;

		try {
			// LOCALHOST
			dir = InetAddress.getByName("localhost");

			System.out.println("\tMetodo getByName():  " + dir);

			// USAMOS METODOS DE LA CLASE
			System.out.println("\tMetodo getHostName(): " + dir.getHostName());
			System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
			System.out.println("\tMetodo toString(): " + dir.toString());
			System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

	}

}
