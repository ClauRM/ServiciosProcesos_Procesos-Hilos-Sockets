import java.util.Date;
import java.net.*;
import java.io.*;

// Socket server
public class TimeServer {

   public static void main(String[] args) {
       if (args.length < 1) return;

       int port = Integer.parseInt(args[0]);

       try (ServerSocket serverSocket = new ServerSocket(port)) { // intento crear el serversocket

           System.out.println("Server is listening on port " + port);

           while (true) {
               Socket socket = serverSocket.accept(); //creacion del socket, el programa se queda esperando aqui hasta recibir conexiones
               System.out.println("New client connected");
               OutputStream output = socket.getOutputStream();
               PrintWriter writer = new PrintWriter(output, true);
               writer.println(new Date().toString());
           }
           //socket.close(); //cerrar el socket

       } catch (IOException ex) {
           System.out.println("Server exception: " + ex.getMessage());
           ex.printStackTrace();
       }
   }
}