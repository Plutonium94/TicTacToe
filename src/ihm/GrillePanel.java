package ihm;

import static java.lang.System.out;
import static ihm.Couleur.*;
import static core.Lettre.*;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GrillePanel extends Grille {
	
	private GroupeGrillePanel ggp;
	
	public static int DEFAULT_SIZE = 300;

	
	JPanel panel;
	private int size = GrillePanel.DEFAULT_SIZE;
	
	@SuppressWarnings("serial")
	public GrillePanel(final int id,final int taille,final GroupeGrillePanel ggp) {
		super(id,taille);
		this.ggp = ggp;

		panel = new JPanel() {
			@Override
			public void paint(Graphics graphics) {
				int casWidth = size/taille;
				for(int i=0;i<taille;i++) {
					for(int j=0;j<taille;j++) {
						Color couleur = null;
						if(i%2 == j%2) {
							couleur = Color.BLUE;
						} else {
							couleur = Color.YELLOW;
						}
						graphics.setColor(couleur);
						graphics.fillRect(i*casWidth, j*casWidth, casWidth,casWidth);
						Lettre lettre = getValeurCas(i, j);
						//out.println("Lettre : " + lettre);
						if(lettre != null) {
							graphics.setColor(couleurContraire(couleur));
							graphics.setFont(new Font("Tahoma",Font.BOLD,36));
							graphics.drawString(lettre.getValeur(), i*casWidth+casWidth/2,j*casWidth+casWidth/2);
						}
					}
				}
				
				// animation victoire
				Cas[] vainqueur = ggp.getVainqueur();
				if(ggp.getVainqueur() != null) {
					out.println("xon");
					for(Cas c : vainqueur) {
						if(c.getGrilleId() == id) {
							int ligne = c.getLigne();
							int colonne = c.getColonne();
							graphics.setColor(Color.RED);
							graphics.drawRect(ligne*casWidth, colonne*casWidth, casWidth, casWidth);
						}
					}
				}
			}
		};
		panelFormalities();
		panel.addMouseListener(new mouseListener());
		
	}
	
	
	
	private void panelFormalities() {
		panel.setBounds(0,0,300,300);
		panel.setVisible(true);
	}
	
	
	
	private class mouseListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent arg0) {
			int x = arg0.getX(),y = arg0.getY();
			int casWidth = size/taille;
			Lettre lettreCourante = ggp.getLettreCourante();
			ggp.ajouterLettre(id, lettreCourante, y/casWidth, x/casWidth);
			ajouterLettre(lettreCourante,x/casWidth , y/casWidth);
			panel.revalidate();
			panel.repaint();
			ggp.changerLettre();
			ggp.winCheckFormalities();
		}
	}
	
	private static Color couleurContraire(Color c) {
		if(c.equals(Color.)) return Color.YELLOW;
		else return Color.BLUE;
	}

}
