package garber.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBox extends JFrame {

	private JTextArea area;
	private JTextField field;
	private JButton button;

	public ChatBox() {
		this.setTitle("Chat");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

		area = new JTextArea();
		field = new JTextField();
		button = new JButton();

		button.setText("SEND");
		field.setLayout(new BorderLayout());

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				area.append("\n" + field.getText());
				try {
					new ChatClient(field.getText());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				field.setText("");

			}
		});

		this.add(area);
		this.add(field, BorderLayout.SOUTH);
		field.add(button, BorderLayout.EAST);

		this.setVisible(true);
	}

	public void addClientText(String line) {
		area.append("\n" + line);
	}

}
