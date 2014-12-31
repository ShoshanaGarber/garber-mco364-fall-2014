package garber.paint.message;

import garber.paint.Canvas;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {

	private Socket socket;
	private OutputStream out;


	public ClientSide(Canvas canvas) throws UnknownHostException, IOException {

		socket = new Socket("192.168.117.107", 3773);
		this.out = socket.getOutputStream();
		
		ListeningThread thread = new ListeningThread(canvas, socket);
		thread.start();
		
	}

	public void sendMessage(String message) throws IOException {
		out.write(message.toString().getBytes());
		out.flush();
	}

}
