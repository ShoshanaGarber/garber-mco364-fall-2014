package garber.paint.message;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import garber.paint.Canvas;

public class ListeningThread extends Thread {

	private Socket socket;
	private Canvas canvas;
	private PaintMessageFactory factory;

	public ListeningThread(Canvas canvas, Socket socket) {
		this.canvas = canvas;
		this.socket = socket;
		factory = new PaintMessageFactory(canvas);
	}

	@Override
	public void run() {

		try {
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					builder.append(line);
					PaintMessage pm = factory.getMessage(line);
					if (pm != null) {
						pm.apply((Graphics2D) canvas.getImage().getGraphics());
						canvas.repaint();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
