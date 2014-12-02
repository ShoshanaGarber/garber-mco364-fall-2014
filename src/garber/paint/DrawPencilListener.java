package garber.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawPencilListener implements DrawListener{

	private Canvas canvas;
	private Integer x;
	private Integer y;
	private Integer prevx;
	private Integer prevy;
	private Graphics2D g2;

	public DrawPencilListener(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public void setPoint(Integer endx, Integer endy) {
		
		if (x != null && y != null) {
			prevx = x;
			prevy = y;
		}

		this.x = endx;
		this.y = endy;

		canvas.setGraphics();
		Graphics2D g2 = canvas.getGraphics();

		if (prevx != null && prevy != null) {

			if (x.equals(prevx + 1) && y.equals(prevy + 1)) {
				g2.fillOval(x, y, 5, 5);

			} else {

				g2.drawLine(prevx + 1, prevy + 1, x, y);
			}
		} else {
			g2.fillOval(x, y, 5, 5);
		}

	}

	public void clearPoint() {
		this.x = null;
		this.y = null;
		this.prevx = null;
		this.prevy = null;

	}

	

	@Override
	public void mouseDragged(MouseEvent e) {// hold down the button
		// the magic happens here

		setPoint(e.getX(), e.getY());
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {// move mouse without clicking
		clearPoint();

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
		this.g2 = g;
		
	}
	

}
