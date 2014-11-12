package garber.paint;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;

import com.sun.xml.internal.ws.api.server.Container;

public class Paint extends JFrame{
	

	private JButton button;
	private Canvas canvas;
	
	
	public Paint(){
		this.setSize(800,600);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		*/
		
		canvas = new Canvas();
		
		JPanel panel = new JPanel();
		
		
		button = new JButton("Pick to Change Background");
		
	
		add(canvas, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);
	
		
		ActionListener actionListener = new ActionListener() {
			
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  
		        Color initialBackground = button.getBackground();
		        Color background = JColorChooser.showDialog(null,
		            "JColorChooser Sample", initialBackground);
		        if (background != null) {
		          button.setBackground(background);
		          canvas.setColor(background);
		        }
		      }
		    };
		    button.addActionListener(actionListener);
		    panel.add(button, BorderLayout.SOUTH);

	}
		
	
	public static void main(String[] args){
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
