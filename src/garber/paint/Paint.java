package garber.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Paint extends JFrame {

	private JButton colorButton;
	private JButton drawButton;
	private JButton ovalButton;
	private JButton rectButton;
	private JButton lineButton;
	private JButton fillovalButton;
	private JButton fillrectButton;
	private JButton clearButton;
	private JLabel label;
	private JLabel label2;
	private Canvas canvas;
	private JPanel panel;

	public Paint() {
		this.setSize(800, 600);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		canvas = new Canvas();

		panel = new JPanel();

		colorButton = new JButton("Change Color");
		drawButton = new JButton("Pencil");
		ovalButton = new JButton("Oval");
		rectButton = new JButton("Rectangle");
		lineButton = new JButton("Line");
		fillovalButton = new JButton("Fill Oval");
		fillrectButton = new JButton("Fill Rectangle");
		clearButton = new JButton("Clear");
		label = new JLabel("Stroke Width");
		label2 = new JLabel(" " + canvas.getStrokeWidth());

		add(canvas, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(label, BorderLayout.EAST);
		panel.add(label2, BorderLayout.EAST);

		MouseWheelListener mouseWheelListener = new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				canvas.setStrokeWidth(e.getWheelRotation());
				label2.setText(" " + canvas.getStrokeWidth());

			}
		};

		canvas.addMouseWheelListener(mouseWheelListener);

		ActionListener colorListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Color initialColor = colorButton.getBackground();
				Color color = JColorChooser.showDialog(null, "JColorChooser Sample", initialColor);
				if (color != null) {
					colorButton.setBackground(color);
					canvas.setColor(color);
				}
			}
		};

		ActionListener clearListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				canvas.clearCanvas();
			}
		};

		ActionListener drawListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

				JButton buttonClicked = (JButton) e.getSource();

				if (buttonClicked.equals(drawButton)) {
					DrawListener drawPencilListener = new DrawPencilListener(canvas);
					canvas.changeDrawListener(drawPencilListener);			

				} else if (buttonClicked.equals(rectButton)) {
					DrawListener rectListener = new DrawRectangleListener(canvas);
					canvas.changeDrawListener(rectListener);

				} else if (buttonClicked.equals(ovalButton)) {
					DrawListener ovalListener = new OvalListener(canvas);
					canvas.changeDrawListener(ovalListener);
					

				}else if (buttonClicked.equals(lineButton)) {
					DrawListener lineListener = new DrawLineListener(canvas);
					canvas.changeDrawListener(lineListener);
					

				}else if (buttonClicked.equals(fillrectButton)) {
					DrawListener fillRectListener = new FillRectListener(canvas);
					canvas.changeDrawListener(fillRectListener);
					
					
				}else if (buttonClicked.equals(fillovalButton)) {
					DrawListener fillOvalListener = new FillOvalListener(canvas);
					canvas.changeDrawListener(fillOvalListener);
					

				}
			}

		};

		colorButton.addActionListener(colorListener);
		drawButton.addActionListener(drawListener);
		rectButton.addActionListener(drawListener);
		ovalButton.addActionListener(drawListener);
		clearButton.addActionListener(clearListener);
		lineButton.addActionListener(drawListener);
		fillovalButton.addActionListener(drawListener);
		fillrectButton.addActionListener(drawListener);	
		
		panel.add(colorButton, BorderLayout.SOUTH);
		panel.add(drawButton, BorderLayout.WEST);
		panel.add(ovalButton, BorderLayout.EAST);
		panel.add(rectButton, BorderLayout.EAST);
		panel.add(lineButton, BorderLayout.WEST);
		panel.add(fillovalButton, BorderLayout.NORTH);
		panel.add(fillrectButton, BorderLayout.NORTH);
		panel.add(clearButton, BorderLayout.EAST);
	}


	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
