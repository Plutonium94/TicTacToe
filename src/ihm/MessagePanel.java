package ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


@SuppressWarnings("serial")
public class MessagePanel extends JPanel {
	
	JLabel msgLabel;
	
	public MessagePanel(String message) {
		msgLabel = new JLabel(message);
		msgLabel.setForeground(Color.WHITE);
		msgLabel.setFont(new Font("Courrier New",Font.BOLD,30));
		this.add(msgLabel);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}
	
	public MessagePanel() {
		this("");
	}
	
	public void setMessage(String newMessage) {
		this.msgLabel.setText(newMessage);
		this.revalidate();
		this.repaint();
	}
	
	public void clear() {
		this.setMessage("");
	}

}
