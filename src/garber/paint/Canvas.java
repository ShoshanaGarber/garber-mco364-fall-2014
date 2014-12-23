package garber.paint;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private Graphics2D g2;
	private BasicStroke stroke;

	private Color color;
	private BufferedImage[] images;
	private BufferedImage currentImage;
	private DrawListener listener;
	private boolean clear;

	public Canvas() {
		images = new BufferedImage[4];

		for (int i = 0; i < images.length; i++) {
			images[i] = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);// draw
																					// to
																					// buffered
																					// image
																					// and
			//((Graphics2D) images[i].getGraphics()).setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
			// then
			// buffered
		} // image gets copied to the screen.
			// buffered image is long term storage-graphics object from buffered
			// image
			// short term storage is graphics object
			// from paint component
		currentImage = images[0];
		stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		setColor(Color.BLACK);
		clear = false;

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(currentImage, 0, 0, null);
		if (listener != null && !clear) {
			listener.drawPreview((Graphics2D) g);
		} else {
			clear = false;
		}
		for(BufferedImage bf: images){
			g.drawImage(bf, 0, 0, null);
			}

	}

	public void setGraphics(Graphics2D g) {

		g.setColor(getColor());
		g.setStroke(getStroke());

	}

	public void setImage(int imageNum) {
		currentImage = images[imageNum];
	}

	public void setColor(Color color) {

		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setStrokeWidth(int wheelRotation) {
		Graphics g = currentImage.getGraphics();
		g2 = (Graphics2D) g;

		if (wheelRotation < 0) {
			if ((stroke.getLineWidth() - 1) > 0) {
				stroke = new BasicStroke(stroke.getLineWidth() - 1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				g2.setStroke(stroke);
			} else {
				g2.setStroke(stroke);
			}
		} else {
			stroke = new BasicStroke(stroke.getLineWidth() + 1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
			g2.setStroke(stroke);
		}

	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public float getStrokeWidth() {
		return stroke.getLineWidth();
	}

	public void clearCanvas() {
		if (listener != null) {
			clear = true;
			currentImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
			//((Graphics2D) currentImage.getGraphics()).setBackground(new Color(0,0,0,0));
			//((Graphics2D) currentImage.getGraphics()).setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
			repaint();
		}
	}

	public BufferedImage getImage() {
		return currentImage;
	}

	public void changeDrawListener(DrawListener listener) {
		removeMouseMotionListener(this.listener);
		removeMouseListener(this.listener);

		this.listener = listener;
		addMouseMotionListener(listener);
		addMouseListener(listener);

	}

	public Graphics2D getGraphics() {
		return g2;
	}

}
