package garber.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawLineListener implements DrawListener{
	
	private Canvas canvas;
	private Graphics2D g2;
	private int y2;
	private int x1;
	private int y1;
	private int x2;

	public DrawLineListener(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		// TODO Auto-generated method stubx1 = e.getX();
		y1 = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		drawLine();
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void drawLine(){
		
		canvas.setGraphics();
		Graphics2D g2 = canvas.getGraphics();
		g2.drawLine(x1, y1, x2, y2);
		canvas.repaint();
	}

	@Override
	public void drawPreview(Graphics2D g) {
		this.g2 = g;
		
	}

}
