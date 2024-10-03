package Cliente;
// >> Importe de bibliotecas
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		// >> IP del servidor
		final String HOST = "127.0.0.1";
		// >> Puerto al que se conecta el cliente
		final int PUERTO = 5000;

		 // >> Creacion de variables de lectura 
		DataInputStream in;
		DataOutputStream out;
		
		try {
			// >> Se conecta al host y al puerto
			Socket sc = new Socket(HOST, PUERTO);
			
			// >> Inicia para recibir y enviar datos
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream()); 
			

			// >> Envia,Lee mensaje y envia a la consola
			out.writeUTF("!Hola soy el el cliente");
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			// >> Desconecta servidor
			sc.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();  // >> En caso de falla se escribe en consola
		}
	}

}
