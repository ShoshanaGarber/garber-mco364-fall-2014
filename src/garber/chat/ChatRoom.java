package garber.chat;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatRoom {

	public static void main(String[] args) throws Exception {

		ChatBox chatBox = new ChatBox();
		Socket clientSocket = chatBox.getClientSocket();


		InputStream in = clientSocket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			chatBox.addClientText(line);
		}
		
		
	}
}
