package garber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawRectangleListener implements DrawListener{
	private Canvas canvas;
	int firstx;
	int firsty;
	int endx;
	int endy;
	
	public DrawRectangleListener(Canvas canvas) {
		this.canvas = canvas;
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		canvas.clearPoint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		firstx = e.getX();
		firsty = e.getY();
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
	public void mousePressed(MouseEvent e) {
		firstx = e.getX();
		firsty = e.getY();
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		endx = e.getX();
		endy= e.getY();
		//canvas.repaint();
	}


	@Override
	public void drawPreview(Graphics2D g) {
		int width, height;
		
        width = Math.abs(firstx - endx);
        height = Math.abs(firsty - endy);
		g.drawRect(firstx,firsty,width,height);
		
	}
	

}
