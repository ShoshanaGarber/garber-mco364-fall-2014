package garber.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	int x;
	int y;
	int endx;
	int endy;
	int prevx;
	int prevy;
	BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public void setPoint(int endx, int endy) {

		prevx = x;
		prevy = y;

		this.x = endx;
		this.y = endy;

		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		if (x == prevx + 1 && y == prevy + 1) {
			g.fillOval(x, y, 10, 10);
		} else {
			g.drawLine(prevx+1, prevy+1, x, y);
		}

	}

}
