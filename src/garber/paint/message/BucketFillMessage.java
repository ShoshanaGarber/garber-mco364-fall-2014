package garber.paint.message;

import garber.paint.Canvas;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFillMessage implements PaintMessage {

	private int x;
	private int y;
	private int color;
	private Canvas canvas;

	public BucketFillMessage(int x, int y, int color,Canvas canvas) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.canvas = canvas;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String toString() {
		return "BUCKET_FILL " + x + " " + y + " " + color + "\n";

	}

	@Override
	public void apply(Graphics2D g) {
		
		boolean[][] painted = new boolean[canvas.getImage().getHeight()][canvas.getImage().getWidth()];
		Queue<Point> queue = new LinkedList<Point>();
		
		int targetColor = canvas.getImage().getRGB(x, y);
		
		if (canvas.getImage().getRGB(x, y) != targetColor) {
			return;
		}
		queue.add(new Point(x, y));


		while (!queue.isEmpty()) {
			Point p = queue.remove();

			if ((p.x >= 0) && (p.x < canvas.getImage().getWidth() && (p.y >= 0) && (p.y < canvas.getImage().getHeight()))) {
				if (!painted[p.y][p.x] && canvas.getImage().getRGB(p.x, p.y) == targetColor) {
					canvas.getImage().setRGB(p.x,p.y,color);
					
					painted[p.y][p.x] = true;

					queue.add(new Point(p.x + 1, p.y));
					queue.add(new Point(p.x - 1, p.y));
					queue.add(new Point(p.x, p.y + 1));
					queue.add(new Point(p.x, p.y - 1));
				}
			}
		}
		
		
		

	}

}
