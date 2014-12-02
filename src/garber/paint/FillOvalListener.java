package garber.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class FillOvalListener implements DrawListener{
	
	private Canvas canvas;
	private Graphics2D g2;
	private Integer firstx;
	private Integer firsty;
	private Integer endx;
	private Integer endy;
	
	public FillOvalListener(Canvas canvas){
		this.canvas = canvas;
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
		firstx = e.getX();
		firsty = e.getY();
        canvas.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
        drawOval();
		
	}

	private void drawOval() {
		
		canvas.setGraphics();
		Graphics2D g2 = canvas.getGraphics();

		g2.fillOval(firstx, firsty, endx, endy);
		canvas.repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		this.g2 = g;
		drawOval();
	}
}