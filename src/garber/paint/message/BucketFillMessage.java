package garber.paint.message;

import garber.paint.Canvas;

import java.awt.Graphics2D;

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
		return "BUCKET_FILL " + x + " " + y + " " + color + "\\n";

	}

	@Override
	public void apply(Graphics2D g) {
		canvas.getImage().setRGB(x,y,color);
		
		
		

	}

}
