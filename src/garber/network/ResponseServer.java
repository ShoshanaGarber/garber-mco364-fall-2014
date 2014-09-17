package garber.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(8080);// ip is myself use
															// port
															// 8080-standard
															// listening port
		int counter = 0;
		while (true) {
			Socket socket = serverSocket.accept();// this is how you listen,
													// when someone connects to
													// you a socket is returned

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
			counter++;

		}
		// this program returns the http request the browser makes when you try
		// to connect to the server
	}
}
