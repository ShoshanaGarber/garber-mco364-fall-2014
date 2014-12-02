package garber.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class FillRectListener  implements DrawListener {
	private Canvas canvas;
	private Integer firstx;
	private Integer firsty;
	private Integer endx;
	private Integer endy;
	private Graphics2D g2;

	public FillRectListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
		drawRec();
        canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		firstx = e.getX();
		firsty = e.getY();
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
	public void mousePressed(MouseEvent e) {
		firstx = e.getX();
		firsty = e.getY();
		canvas.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
		drawRec();
		

	}

	public void clearPoint() {
		this.firstx = null;
		this.firsty = null;
		this.endx = null;
		this.endy = null;

	}
	
	public void drawRec(){
		
		canvas.setGraphics();
		Graphics2D g2 = canvas.getGraphics();

		int width = Math.abs(firstx - endx);
		int height = Math.abs(firsty - endy);
		g2.fillRect(firstx, firsty, width, height);
		canvas.repaint();
	}

	@Override
	public void drawPreview(Graphics2D g) {
        this.g2 = g;
		drawRec();

	}

}
