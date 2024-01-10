import java.io.*;
import java.net.*;

//Socket server
public class Servidor {

	public static void main(String[] args) {

		// si el numero de parametros es incorrecto ni siquiera se ejecuta
		if (args.length < 1)
			return;
		/*
		 * Los dos parametros que necesita son el ordenador (IP) y el puerto Los
		 * parametros se pasan desde la opcion 'Configuraciones de depuracion', buscar
		 * la clase y poner los parametros puerto (en este caso) 5678
		 */
		int port = Integer.parseInt(args[0]); // convertimos segundo parametro a entero

		try (ServerSocket serverSocket = new ServerSocket(port)) { // crear el servidor socket en el puerto indicado
																	// como argumento
			System.out.println("Esperando conexión en el puerto " + port + "...");

			// bucle de espera activa
			while (true) {
				// abrir socket y esperar conexiones para procesar
				Socket socket = serverSocket.accept(); // Aceptar la conexión
				System.out.println("Cliente conectado."); // cuando recibe conexion

				// InputStream para recibir mensajes del cliente
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				String mensajeRecibido = reader.readLine();// lectura

				// OutputStream para enviar la respuesta al cliente
				OutputStream output = socket.getOutputStream();// enviar la salida del socket
				PrintWriter writer = new PrintWriter(output, true);// escribe lo que ha recibido como salida

				// validar si el mensaje recibido es 'quit'
				if (mensajeRecibido.equals("quit")) {
					writer.println("Se termina proceso del servidor.");
					socket.close();// cerrar el socket
				} else {
					writer.println("Número de caracteres en el texto: " + mensajeRecibido.length());
				}

			}

		} catch (IOException ex) { // excepcion en caso de que no funcione
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

}
