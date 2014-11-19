package garber.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPencilListener implements MouseMotionListener {

	private Canvas canvas;
	int lastx;
	int lasty;

	public DrawPencilListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {// hold down the button
		// the magic happens here

		canvas.setPoint(e.getX(), e.getY());
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {// move mouse without clicking
		canvas.clearPoint();

	}
	

}
