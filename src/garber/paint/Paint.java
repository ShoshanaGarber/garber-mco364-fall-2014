package garber.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.sun.xml.internal.ws.api.server.Container;

public class Paint extends JFrame{
	
	public Paint(){
		this.setSize(800,600);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		*/
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);
		
	}
	
	public static void main(String[] args){
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
