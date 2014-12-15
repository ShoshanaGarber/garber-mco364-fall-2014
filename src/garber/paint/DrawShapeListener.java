package garber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawShapeListener implements DrawListener {

	private Canvas canvas;
	private int firstx;
	private int firsty;
	private int endx;
	private int endy;
	private Shape shape;

	public DrawShapeListener(Canvas canvas, Shape shape) {
		this.canvas = canvas;
		this.shape = shape;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {// only happens when you press
												// and
		// release
		// TODO Auto-generated method stub

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
		drawShape();

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

	public void drawShape() {

		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);

		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);

		int x = Math.min(firstx, endx);
		int y = Math.min(firsty, endy);

		switch (shape) {

		case Rect:
			g2.drawRect(x, y, width, height);
			break;
		case Oval:
			g2.drawOval(x, y, width, height);
			break;
		case FillOval:
			g2.fillOval(x, y, width, height);
			break;
		case FillRectangle:
			g2.fillRect(x, y, width, height);
			break;

		}

	}

	@Override
	public void drawPreview(Graphics2D g) {
		canvas.setGraphics(g);

		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);

		int x = Math.min(firstx, endx);
		int y = Math.min(firsty, endy);

		switch (shape) {

		case Rect:
			g.drawRect(x, y, width, height);
			break;
		case Oval:
			g.drawOval(x, y, width, height);
			break;
		case FillOval:
			g.fillOval(x, y, width, height);
			break;
		case FillRectangle:
			g.fillRect(x, y, width, height);
			break;

		}

	}

}
