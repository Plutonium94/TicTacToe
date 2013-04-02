package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
/**
 * La classe qui est appéle par le main (sans les menus).
 * @author Daniel
 *
 */
public class JeuFrame extends JFrame {
	
	private final Niveau[] niveaux = Niveau.values();
	private Niveau niveauCourant = Niveau.UN;
	
	private JPanel niveauPanel = niveauCourant.getPanel();
	private JPanel buttonPanel = new ButtonPanel();
	private JPanel messagePanel = new MessagePanel();
	
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
		this.add(messagePanel, BorderLayout.EAST);
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
	
	/**
	 * Contient 2 boutons < & > pour aller s'ils existent aux niveaux précedentes et aux niveaux 
	 * suivantes (si gagnés) respectivement.
	 * @author Daniel
	 *
	 */
	private class ButtonPanel extends JPanel {
		
		private JButton nextLevelButton = new JButton(">");
		private JButton previousLevelButton = new JButton("<");
		
		public ButtonPanel() {
			addToPanel();
			this.setPreviousLevelAction();
			this.setNextLevelAction();
		}
		
		/**
		 * Rajoute composantes au frame
		 */
		private void addToPanel() {
			add(previousLevelButton);
			add(nextLevelButton);
		}
		
		/**
		 * Passe au niveau prochain (si gagné) sur appui du bouton
		 */
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
		
		/**
		 * Aller au niveau précedente sur click
		 */
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
