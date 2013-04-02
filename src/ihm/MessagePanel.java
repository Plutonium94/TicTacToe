package ihm;

import java.awt.Color;

import javax.swing.*;


@SuppressWarnings("serial")
public class MessagePanel extends JPanel {
	
	JLabel msgLabel;
	
	public MessagePanel(String message) {
		msgLabel = new JLabel(message);
		this.setBackground(Color.CYAN);
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

}
