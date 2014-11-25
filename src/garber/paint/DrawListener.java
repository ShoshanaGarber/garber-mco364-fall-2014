package garber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseListener, MouseMotionListener {

	// any method that implements DrawListener must include all methods of mouseListener
	// and mouseMotionListener

	
	void drawPreview(Graphics2D g);
	
	

}
