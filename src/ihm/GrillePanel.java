package ihm;

import static java.lang.System.out;
import static ihm.Couleur.*;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Représentation graphique d'une grille
 * @author Daniel
 *
 */
public class GrillePanel extends Grille {
	
	private GroupeGrillePanel ggp;
	
	public static int DEFAULT_SIZE = 300;

	
	JPanel panel;
	private int size = GrillePanel.DEFAULT_SIZE;
	public static boolean marquer = false;
	
	
	public static final Color DARK_BLUE = CLR1.getColor();
	public static final Color YELLOW  = CLR2.getColor();
	
	@SuppressWarnings("serial")
	public GrillePanel(final int id,final int taille,final GroupeGrillePanel ggp) {
		super(id,taille);
		this.ggp = ggp;
		
		panel = new JPanel() {
			@Override
			public void paint(Graphics graphics) {
				// Travail régulière 
				// Met les lettres de la grille correspondnate
				// dans les cases précises
				//System.out.println("repainted repainted repainterd");
				int casWidth = size/taille;
				for(int ligne=0;ligne<taille;ligne++) {
					for(int colonne=0;colonne<taille;colonne++) {
						Color couleur = null;
						if(ligne%2 == colonne%2) {
							couleur = DARK_BLUE;
						} else {
							couleur = YELLOW;
						}
						graphics.setColor(couleur);
						graphics.fillRect(colonne*casWidth, ligne*casWidth, casWidth,casWidth);
						Lettre lettre = getValeurCas(ligne, colonne);
						if(lettre != null) {
							graphics.setColor(couleurContraire(couleur));
							graphics.setFont(new Font("Tahoma",Font.BOLD,36));
							graphics.drawString(lettre.getValeur(), colonne*casWidth+casWidth/2,ligne*casWidth+casWidth/2);
						}/* else if(lettre == null) {
							if(!marquer) {
								graphics.setColor(Color.RED);
								
							} else {
								graphics.setColor(Color.BLACK);
								graphics.drawString("redrawn",50,50);
								
							}
							graphics.fillRect(colonne*casWidth, ligne*casWidth, casWidth,casWidth);
							
						}*/
					}
					
				}
				if(marquer)System.out.println("painter says" + GrillePanel.super.toString());
				marquer = true;
				
				// encadrer les cas courante en rose
				Cas casCourante = ggp.getCasCourante();
				if(id == casCourante.getGrilleId()) {
					graphics.setColor(Color.PINK);
					((Graphics2D)graphics).setStroke(new BasicStroke(13));
					graphics.drawRect(casCourante.getColonne()*casWidth, casCourante.getLigne()*casWidth, casWidth, casWidth);
				} 
				
				// animation victoire
				// encadre les cas gangants en vert epaisse
				Cas[] vainqueur = ggp.getVainqueur();
				if(vainqueur != null) {
					for(Cas c : vainqueur) {
						if( c!= null && c.getGrilleId() == id) {
							int ligne = c.getLigne();
							int colonne = c.getColonne();
							((Graphics2D)graphics).setStroke(new BasicStroke(10));
							graphics.setColor(Color.GREEN);
							graphics.drawRect(colonne*casWidth, ligne*casWidth, casWidth, casWidth);
						}
					}
				}
			}
		};
		panelFormalities();
		panel.addMouseListener(new mouseListener());
	}
	
	
	/**
	 * Setup du panel
	 */
	private void panelFormalities() {
		panel.setBounds(0,0,300,300);
		panel.setVisible(true);
	}
	
	public void clear() {
		super.clear();
	}
	
	public void refresh() {
		ggp = new GrillePanel(this.id,this.taille,this.ggp).ggp;
		panel.revalidate();
		panel.repaint();
	}
	
	
	private class mouseListener extends MouseAdapter {
		@Override
		/**
		 * Ecoute les cliques, met x ou o si clique valide.
		 * Change la lettre courante du GroupeGrillePanel correspondante.
		 * et met à jour le panel
		 */
		public void mouseReleased(MouseEvent arg0) {
			int x = arg0.getX(),y = arg0.getY();
			int casWidth = size/taille;
			Lettre lettreCourante = ggp.getLettreCourante();
			ggp.ajouterLettre(id, lettreCourante, y/casWidth, x/casWidth);
			boolean lettreAjoutee = ajouterLettre(lettreCourante,y/casWidth , x/casWidth);
			panel.revalidate();
			panel.repaint();
			if(lettreAjoutee)ggp.changerLettre();
			ggp.winCheckFormalities();
		}
	}
	
	/**
	 * Renvoie bleu si jaune est donne
	 * Renvoie jaune si bleu est donne
	 * @param c
	 * @return
	 */
	private static Color couleurContraire(Color c) {
		if(c.equals(DARK_BLUE)) return YELLOW;
		else return DARK_BLUE;
	}
	
	/* Override super methods */

}
