package garber.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BucketFillListener implements DrawListener {

	private Canvas canvas;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		fill(x, y);
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void fill(int x, int y) {

		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphics(g2);
		Color color = canvas.getColor();// color chosen

		BufferedImage image = canvas.getImage();

		int targetColor = image.getRGB(x, y);// color of pixel clicked on

		floodFill(x, y, targetColor, color, image);
	}

	public void floodFill(int x, int y, int targetColor, Color replacementColor, BufferedImage image) {

		
		boolean[][] painted = new boolean[image.getHeight()][image.getWidth()];
		Queue<Point> queue = new LinkedList<Point>();
		
		if (x != 0)
			x--;
		if (y != 0)
			y--;
		
		if (image.getRGB(x, y) != targetColor) {
			return;
		}
		queue.add(new Point(x, y));


		while (!queue.isEmpty()) {
			Point p = queue.remove();

			if ((p.x >= 0) && (p.x < image.getWidth() && (p.y >= 0) && (p.y < image.getHeight()))) {
				if (!painted[p.y][p.x] && image.getRGB(p.x, p.y) == targetColor) {
					image.setRGB(p.x, p.y, replacementColor.getRGB());
					painted[p.y][p.x] = true;

					queue.add(new Point(p.x + 1, p.y));
					queue.add(new Point(p.x - 1, p.y));
					queue.add(new Point(p.x, p.y + 1));
					queue.add(new Point(p.x, p.y - 1));
				}
			}
		}
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
