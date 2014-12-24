package garber.paint.message;

import garber.paint.Canvas;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private Canvas canvas;

	public ClientSide(Canvas canvas) throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.107", 3773);
		
		ListeningThread thread = new ListeningThread(canvas, socket);
		thread.start();
		this.in = socket.getInputStream();
		this.out = socket.getOutputStream();
	}

	public void sendMessage(String message) throws IOException {
		out.write(message.toString().getBytes());
		out.flush();
	}

}
