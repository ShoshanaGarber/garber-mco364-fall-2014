package garber.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class OneConnection extends Thread {

	private Socket socket;
	private int counter;

	public OneConnection(Socket socket, int counter) throws Exception {
		this.socket = socket;
		this.counter = counter;
	}

	@Override
	public void run() {

		try {
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while (!"".equals((line = reader.readLine()))) {
				System.out.println(line);
			}
			OutputStream out = socket.getOutputStream();
			String response = "<h2>This is the " + counter + "th request</h2>";
			
			out.write("HTTP/1.1 200 OK\n".getBytes());
			out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			out.write(("Content-Length: " + response.length() + "\n\n").getBytes());
			out.write(response.getBytes());
			out.flush();
			out.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
