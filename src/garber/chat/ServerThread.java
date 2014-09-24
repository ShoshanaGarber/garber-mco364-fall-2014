package garber.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;
	private ChatBox chatBox;

	public ServerThread(Socket socket, ChatBox chatBox) {
		this.socket = socket;
		this.chatBox = chatBox;
	}

	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				chatBox.addClientText(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
