package garber.paint;

import garber.paint.message.PaintMessage;
import garber.paint.message.ShapeMessage;
import garber.paint.message.Type;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
		try {
			drawShape();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	public void drawShape() throws IOException {

		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);

		int width = Math.abs(endx - firstx);
		int height = Math.abs(endy - firsty);

		int x = Math.min(firstx, endx);
		int y = Math.min(firsty, endy);

		PaintMessage message;

		switch (shape) {

		case Rect:
			message = new ShapeMessage(Type.RECT, x, y, width, height, canvas.getColor().getRGB(),
					(int) canvas.getStrokeWidth(), Boolean.FALSE);
			canvas.getModule().sendMessage(message);
			break;
		case Oval:
			message = new ShapeMessage(Type.OVAL, x, y, width, height,  canvas.getColor().getRGB(),
					(int) canvas.getStrokeWidth(), Boolean.FALSE);
			canvas.getModule().sendMessage(message);
			break;
		case FillOval:
			message = new ShapeMessage(Type.OVAL, x, y, width, height,  canvas.getColor().getRGB(),
					(int) canvas.getStrokeWidth(), Boolean.TRUE);
			canvas.getModule().sendMessage(message);
			break;
		case FillRectangle:
			message = new ShapeMessage(Type.RECT, x, y, width, height,  canvas.getColor().getRGB(),
					(int) canvas.getStrokeWidth(), Boolean.TRUE);
			canvas.getModule().sendMessage(message);
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
