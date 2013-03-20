package ihm;

import javax.swing.*;
import java.awt.*;

public class JeuFrame extends JFrame {
	
	private static final long serialVersionUID = -3599124633401542609L;
	private final Niveau[] niveaux = Niveau.values();
	
	public JeuFrame() {
		frameFormalities();
	}
	
	private void frameFormalities() {
		setMinimumSize(new Dimension(500,500));
		setTitle("Tic Tac Toe");
		setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		this.setContentPane(Niveau.TROIS.getGroupeGrillePanel().getPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void executer() {
		for(Niveau niveau : niveaux) {
			niveau.getGroupeGrillePanel().getPanel();
		}
	}

}
