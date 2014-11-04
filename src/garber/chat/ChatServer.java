package garber.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatServer {

	private ServerSocket serverSocket;
	private Socket socket;

	public ChatServer() throws UnknownHostException, IOException {
		this.serverSocket = new ServerSocket(3778);
		while (true) {
			this.socket = serverSocket.accept();
		}

	}

	public void chatLine(String chatText) throws IOException {

		OutputStream output = socket.getOutputStream();
		output.write(chatText.getBytes());
		output.write("\n".getBytes());
		output.flush();
	}

	public Socket getSocket() {
		return socket;
	}

	/**
	 * while (true) { Socket socket = serverSocket.accept();
	 * 
	 * ServerThread thread = new ServerThread(socket, chatBox); thread.start();
	 * }
	 */

}
