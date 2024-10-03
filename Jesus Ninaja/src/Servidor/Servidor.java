package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor = null; // >> Se define socket en "servidor"
		Socket sc = null; // >> Variable que interactuar con el cliente
		DataInputStream in;
		DataOutputStream out; 
		
		// >> Puerto del servidor
		final int PUERTO = 5000; 
		
		try {
			// >> Crea el servidor
			servidor = new ServerSocket(PUERTO);
			
			// >> Indica que el servidor inico
			System.out.println("Servidor iniciado");
			
			// >> Bucle infinito para la espera de la conexion de un cliente 
			while (true) {
				sc = servidor.accept();
				System.out.println("Cliente conectado"); // >> Indica que el cliente se conecto
				
				in = new DataInputStream(sc.getInputStream()); // >> Recibe
				out = new DataOutputStream(sc.getOutputStream()); // >>Envía
				
				// >> Lee y recibe el mensaje del cliente
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				
				// >> Responde con un mensaje predetermidado
				out.writeUTF("!Hola desde el servidor");
				

				// >> Cliente se desconecta y se imprime su desconexion en el servidor 
				sc.close();
				System.out.println("Cliente desconectado");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
