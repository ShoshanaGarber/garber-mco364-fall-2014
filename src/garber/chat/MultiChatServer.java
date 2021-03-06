package garber.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer {

	public static void main(String[] ags) throws IOException {

		ServerSocket serverSocket = new ServerSocket(9097);
		BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
		List<Socket> sockets = new ArrayList<Socket>();
		MessageSender sender = new MessageSender(messages, sockets);
		sender.start();

		while (true) {
			Socket socket = serverSocket.accept();
			SocketHandler handler = new SocketHandler(socket, messages);
			handler.start();

		}
	}
}
