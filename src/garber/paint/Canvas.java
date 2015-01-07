package garber.paint;

import garber.paint.message.ClientSide;
import garber.paint.message.LoopBackNetworkModule;
import garber.paint.message.NetworkModule;
import garber.paint.message.OnlineNetworkModule;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private Graphics2D g2;
	private BasicStroke stroke;

	private Color color;
	private BufferedImage image;
	private DrawListener listener;
	private boolean clear;
	private NetworkModule module;

	public Canvas() throws UnknownHostException, IOException {

		module = new OnlineNetworkModule(this);
		//module = new LoopBackNetworkModule(this);
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);//draw to buffered image and then buffered
		                                                                 //image gets copied to the screen. 
		                                                                 //buffered image is long term storage-graphics object from guffered image
		                                                                 //short term storage is graphics object 
		                                                                 //from paint component
		stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		setColor(Color.BLACK);
		clear = false;
		g2 = (Graphics2D) image.getGraphics();

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
		if (listener != null && !clear) {
			listener.drawPreview((Graphics2D) g);
		} else {
			clear = false;
		}
		

	}

	public void setGraphics(Graphics2D g) {

		g.setColor(getColor());
		g.setStroke(getStroke());

	}

	public void setColor(Color color) {

		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setStrokeWidth(int wheelRotation) {

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
			image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
			Graphics g = image.getGraphics();
			g2 = (Graphics2D) g;
			repaint();
		}
	}

	public BufferedImage getImage() {
		return image;
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
	

	public NetworkModule getModule() {
		
		return module;
	}

}
