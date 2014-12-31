package garber.paint;

import garber.paint.message.BucketFillMessage;
import garber.paint.message.PaintMessage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BucketFillListener implements DrawListener {

	private Canvas canvas;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		try {
			floodFill(x, y);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	public void floodFill(int x, int y) throws IOException {
		
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
	    canvas.setGraphics(g2);
	    Color color = canvas.getColor();

		PaintMessage m = new BucketFillMessage(x, y, color.getRGB(), canvas);
		canvas.getModule().sendMessage(m);

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
