import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

	public static void main(String[] args) {

		// tiene dos argumentos
		if (args.length < 2)
			return;

		String hostname = args[0];

		int port = Integer.parseInt(args[1]);

		/*
		 * Configurar los argumentos desde 'Configuraciones de depuracion', buscar la
		 * clase y poner los parametros localhost + puerto (en este caso) 5678
		 */
		try (Socket socket = new Socket(hostname, port)) { // Crear el socket y establecer la conexion con el servidor

			// OutputStream del cliente para enviar el mensaje al servidor
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);

			// Leer el mensaje del usuario y enviarlo al servidor
			Scanner lector = new Scanner(System.in);// abro el scanner
			System.out.println("Ingrese un texto para llamar al servidor:"); // escritura
			String texto = lector.nextLine();
			writer.println(texto); // envio al servidor

			// InputStream del cliente para recibir la respuesta del servidor
			InputStream input = socket.getInputStream(); // inputServer (entrada del servidor)
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			// Leer y mostrar respuesta del servidor
			String respuestaRecibida = reader.readLine();
		    System.out.println("Respuesta del servidor: " + respuestaRecibida);

		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());

		}

	}

}
