package garber.paint.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {
	
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	
	public ClientSide() throws UnknownHostException, IOException{
		socket = new Socket("192.168.117.107", 3773);
		this.in = socket.getInputStream();
		this.out = socket.getOutputStream();
	}
	public void sendMessage(String message){
		
	}

}
