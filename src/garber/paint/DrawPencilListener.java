package garber.paint;

import garber.paint.message.LineMessage;
import garber.paint.message.PaintMessage;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class DrawPencilListener implements DrawListener {

	private Canvas canvas;
	private Integer x;
	private Integer y;
	private Integer prevx;
	private Integer prevy;

	public DrawPencilListener(Canvas canvas) {
		this.canvas = canvas;
	}

	public void setPoint(Integer endx, Integer endy) throws IOException {
		PaintMessage message;

		if (x != null && y != null) {
			prevx = x;
			prevy = y;
		}

		this.x = endx;
		this.y = endy;

		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);

		if (prevx != null && prevy != null) {

			if (x.equals(prevx + 1) && y.equals(prevy + 1)) {

				message = new LineMessage(x, y, x, y, canvas.getColor().getRGB(), (int) canvas.getStrokeWidth());
				canvas.getModule().sendMessage(message);
			} else {

				message = new LineMessage(prevx + 1, prevy + 1, x, y, canvas.getColor().getRGB(),
						(int) canvas.getStrokeWidth());
				canvas.getModule().sendMessage(message);
			}
		} else {
			message = new LineMessage(x, y, x, y, canvas.getColor().getRGB(), (int) canvas.getStrokeWidth());
			canvas.getModule().sendMessage(message);
		}

	}

	public void resetPoints() {
		this.x = null;
		this.y = null;
		this.prevx = null;
		this.prevy = null;

	}

	@Override
	public void mouseDragged(MouseEvent e) {// hold down the button
		// the magic happens here

		try {
			setPoint(e.getX(), e.getY());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {// move mouse without clicking
		resetPoints();

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

	}


}
