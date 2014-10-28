package garber.chat;


import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatServer {

	private ServerSocket serverSocket;

	public ChatServer() throws UnknownHostException, IOException {
		this.serverSocket  = new ServerSocket(8080);

	}

	public void chatLine(String chatText) throws IOException { 
		
		OutputStream output = serverSocket.getOutputStream();
		output.write(chatText.getBytes());
		output.write("\n".getBytes());
		output.flush();
	}
	
	public ServerSocket getServerSocket(){
		return serverSocket;
	}

			/**
			 * while (true) {
			 * Socket socket = serverSocket.accept();
			
			ServerThread thread = new ServerThread(socket, chatBox);
			thread.start();
			}
			 */
			
	
		
	
}
