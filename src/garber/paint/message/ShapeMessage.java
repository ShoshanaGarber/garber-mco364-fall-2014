package garber.paint.message;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class ShapeMessage implements PaintMessage {

	private int x;
	private int y;
	private int width;
	private int height;
	private Type shape;
	private boolean fill;
	private int color;
	private int stroke;

	public ShapeMessage(int x, int y, int width, int height, Type shape, boolean fill, int color, int stroke) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shape = shape;
		this.fill = fill;
		this.color = color;
		this.stroke = stroke;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Type getShape() {
		return shape;
	}

	public void setShape(Type shape) {
		this.shape = shape;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public String toString() {
		return "SHAPE " + shape.toString() + " " + x + " " + y + " " + fill + " " + width + " " + height + " " + color
				+ " " + stroke + "\n";
	}

	@Override
	public void apply(Graphics2D g) {
		g.setStroke(new BasicStroke(stroke));
		g.setColor(new Color(color));
		switch (shape) {
		case RECT:
			if (fill) {
				g.fillRect(x, y, width, height);
			} else {
				g.drawRect(x, y, width, height);
			}
			break;
		case OVAL:
			if (fill) {
				g.fillOval(x, y, width, height);
			} else {
				g.drawOval(x, y, width, height);
			}
			break;
		default:
			break;
		}

	}
}
