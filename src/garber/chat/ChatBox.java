package garber.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBox extends JFrame {

	private JTextArea area;
	private JTextField field;
	private JButton button;
	private ChatClient chatClient;
	private JScrollPane scrollBar;

	public ChatBox() {
		this.setTitle("Chat");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

		area = new JTextArea();
		field = new JTextField();
		button = new JButton();
		scrollBar = new JScrollPane();

		button.setText("SEND");
		field.setLayout(new BorderLayout());
		
		
		try {
			chatClient = new ChatClient();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				area.append("\n" + field.getText());
				
				try {
					chatClient.chatLine(field.getText());
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
		area.add(scrollBar, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public void addClientText(String line) {
		area.append("\n" + line);
	}
	public Socket getClientSocket(){
		return chatClient.getSocket();
	}
	

}
