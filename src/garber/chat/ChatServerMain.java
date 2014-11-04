package garber.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerMain {
	public static void main(String[] args) throws Exception {

		ChatBoxServer chatBoxServer = new ChatBoxServer();
		Socket socket = chatBoxServer.getSocket();

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			chatBoxServer.addServerText(line);
		}
	}
}
