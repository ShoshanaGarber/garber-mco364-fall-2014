package garber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPencilListener implements DrawListener{

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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	

}
