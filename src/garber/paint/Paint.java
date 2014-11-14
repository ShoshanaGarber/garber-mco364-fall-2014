package garber.paint;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.colorchooser.ColorSelectionModel;

import com.sun.xml.internal.ws.api.server.Container;

public class Paint extends JFrame{
	

	private JButton button;
	private JTextArea textArea;
	private JTextArea textArea2;
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
		textArea = new JTextArea("Stroke Width");
		textArea2 = new JTextArea(" " + canvas.getStrokeWidth());
		
	
		add(canvas, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(textArea, BorderLayout.EAST);
		panel.add(textArea2, BorderLayout.EAST);
		
		
		
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);
		
		MouseWheelListener mouseWheelListener = new MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				canvas.setStrokeWidth(e.getWheelRotation());
				textArea2.setText(" " + canvas.getStrokeWidth());
				
			}			
		};
		
		canvas.addMouseWheelListener(mouseWheelListener);
	
		
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
