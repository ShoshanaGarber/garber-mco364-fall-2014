package garber.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class OvalListener implements DrawListener{
	
	private Canvas canvas;
	private Integer firstx;
	private Integer firsty;
	private Integer endx;
	private Integer endy;
	
	public OvalListener(Canvas canvas){
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

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
        drawOval();
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
		canvas.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private void drawOval() {
		
		
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);

		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);
		g2.drawOval(firstx, firsty, width, height);
		canvas.repaint();
		
	}


	@Override
	public void drawPreview(Graphics2D g) {
		canvas.setGraphics(g);
		
		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);
		g.drawOval(firstx, firsty, width, height);
	}
	
	

}
