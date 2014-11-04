package garber.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		this.socket = new Socket("192.168.1.3", 3773);

	}

	public void chatLine(String chatText) throws IOException {
		OutputStream output = socket.getOutputStream();
		output.write(chatText.getBytes());
		output.write("\n".getBytes());
		output.flush();
	}
	
	public Socket getSocket(){
		return socket;
	}
}
