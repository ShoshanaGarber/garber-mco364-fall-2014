package garber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawLineListener implements DrawListener{
	
	private Canvas canvas;
	private Integer y2;
	private Integer x1;
	private Integer y1;
	private Integer x2;

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
		x1 = e.getX();
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
		x2 = e.getX();
		y2 = e.getY();
		canvas.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void drawLine(){
		
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);
		
		g2.drawLine(x1, y1, x2, y2);
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		canvas.setGraphics(g);
		
		g.drawLine(x1, y1, x2, y2);
		
	}

}
