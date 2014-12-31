package garber.paint.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import garber.paint.Canvas;

public class ListeningThread extends Thread{
	
	private Socket socket;
	private Canvas canvas;
	private PaintMessageFactory factory;
	
	public ListeningThread(Canvas canvas, Socket socket){
		this.canvas = canvas;
		this.socket = socket;
		factory = new PaintMessageFactory();
	}
	
	@Override
	public void run(){
		
		BufferedReader reader;
		
		try {
			InputStream in = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				PaintMessage pm = factory.getMessage(line);
				pm.apply(canvas.getGraphics());
			}
			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
