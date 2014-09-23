package garber.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(8080);// ip is myself use
															// port
															// 8080-standard
															// listening port
		int counter = 0;
		while (true) {
			Socket socket = serverSocket.accept();// this is how you listen,
													// when someone connects to
													// you a socket is returned
			counter++;
			OneConnection newConnection = new OneConnection(socket, counter);

			newConnection.start();
			
			// this program returns the http request the browser makes when you
			// try
			// to connect to the server

		}
	}
}
