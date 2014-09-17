package garber.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkRequest {
	
	//to connect to each other use a socket instead of URL
	public static void main(String[] args) throws IOException{
		
		Socket socket = new Socket("www.amazon.com", 80);
		InputStream in = socket.getInputStream();//reads info from socket(amazon server)
		OutputStream out = socket.getOutputStream();//sends data to socket(")
		String request = "GET /index.html\n\n";//part of HTTP protocol 
	    out.write(request.getBytes());//String to byte array and sends request to server
	    out.flush();//sends data out
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    
	    String line;
	    while((line = reader.readLine())!=null){
	    	System.out.println(line);
	    }
	    //this program reads and writes data to a socket
	}

}