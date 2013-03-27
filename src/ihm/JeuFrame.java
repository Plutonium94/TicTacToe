package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class JeuFrame extends JFrame {
	
	private final Niveau[] niveaux = Niveau.values();
	private Niveau niveauCourant = Niveau.UN;
	
	private JPanel niveauPanel = niveauCourant.getPanel();
	private JPanel buttonPanel = new ButtonPanel();
	
	public JeuFrame() {
		frameFormalities();
	}
	
	private void frameFormalities() {
		setMinimumSize(new Dimension(500,500));
		setTitle("Tic Tac Toe");
		setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		this.add(niveauPanel); 
		this.add(buttonPanel,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void executer() {
		for(Niveau niveau : niveaux) {
			niveau.getGroupeGrillePanel().getPanel();
		}
	}
	
	public void refresh() {
		this.getContentPane().repaint();
	}
	
	private class ButtonPanel extends JPanel {
		
		private JButton nextLevelButton = new JButton(">");
		private JButton previousLevelButton = new JButton("<");
		
		public ButtonPanel() {
			addToPanel();
			this.setPreviousLevelAction();
			this.setNextLevelAction();
		}
		
		private void addToPanel() {
			add(previousLevelButton);
			add(nextLevelButton);
		}
		
		private void setNextLevelAction() {
			this.nextLevelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					if(niveauCourant.estTermine()) {
						Niveau niveauProchain = niveauCourant.niveauProchain();
						if(niveauProchain != null) {
							niveauCourant = niveauProchain;
							niveauPanel.setVisible(false);
							niveauPanel = niveauCourant.getPanel();
							niveauPanel.setVisible(true);
							niveauPanel.revalidate();
							niveauPanel.repaint();
							JeuFrame.this.add(niveauPanel);
						}
						
					}
				}
			});
		}
		
		private void setPreviousLevelAction() {
			this.previousLevelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					Niveau niveauPrecedent = niveauCourant.niveauPrecedent();
					if(niveauPrecedent != null) {
						niveauCourant = niveauPrecedent;
						niveauPanel.setVisible(false);
						niveauPanel = niveauCourant.getPanel();
						niveauPanel.setVisible(true);
						niveauPanel.revalidate();
						niveauPanel.repaint();
						JeuFrame.this.add(niveauPanel);
						JeuFrame.this.add(niveauPrecedent.getPanel());
					}
				}
			});
		}
		
		
	}

}
