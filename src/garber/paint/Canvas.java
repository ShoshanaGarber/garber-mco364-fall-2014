package garber.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private Integer x;
	private Integer y;
	private Integer prevx;
	private Integer prevy;

	private Color color;
	BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public void setPoint(Integer endx, Integer endy) {

		if (x != null && y != null) {
			prevx = x;
			prevy = y;
		}

		this.x = endx;
		this.y = endy;

		Graphics g = image.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);

		if (prevx != null && prevy != null) {
			if (x.equals(prevx + 1) && y.equals(prevy + 1)) {
				g.fillOval(x, y, 5, 5);

			} else {

				g2.setStroke(new BasicStroke(5));
				g2.drawLine(prevx + 1, prevy + 1, x, y);
			}
		} else {
			g2.fillOval(x, y, 5, 5);
		}

	}

	public void setColor(Color color) {

		this.color = color;
	}

	public void clearPoint() {
		this.x = null;
		this.y = null;
		
	}

}
