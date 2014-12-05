package garber.paint;


import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class FillRectListener implements DrawListener {
	private Canvas canvas;
	private Integer firstx;
	private Integer firsty;
	private Integer endx;
	private Integer endy;

	public FillRectListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		endy = e.getY();
		drawRec();

	}

	public void drawRec() {

		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);

		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);
		
		int x = Math.min(firstx, endx);
		int y = Math.min(firsty, endy);

		g2.fillRect(x, y, width, height);
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		
		canvas.setGraphics(g);

		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);
		
		int x = Math.min(firstx, endx);
		int y = Math.min(firsty, endy);

		g.fillRect(x, y, width, height);

	}

}
