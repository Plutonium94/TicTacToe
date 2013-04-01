package ihm;

import javax.swing.*;
import static core.Lettre.*;

import java.awt.*;
import core.*;
import java.awt.event.*;

/**
 * Représentation graphique d'une groupe des grilles
 * @author Daniel
 *
 */
public abstract class GroupeGrillePanel extends GroupeGrilleAbstrait implements MouseListener {
	
    GrillePanel[] grillePanels;
	private Lettre lettreCourante = O;
	protected Cas[] vainqueur = null;
	// Cet attribut ggd est une mauvaise conception mais utile pour
	// voir si on a gagné le niveau 3
	private GroupeGrilleDependantes ggd = null;
	
	// Le panel effectif
	JPanel superPanel = new JPanel();
	

	public GroupeGrillePanel(int nombreDeGrilles, int taille, boolean independantes) {
		super(nombreDeGrilles,taille,independantes);
		grillePanels = new GrillePanel[nombreDeGrilles];
		if(!independantes) {
			initGGD();
		}
		frameFormalities();
		addToPanel();
		superPanel.setBackground(Color.WHITE);
	}
	
	public GroupeGrillePanel(GroupeGrilleAbstrait gga) {
		this(gga.getNombreDeGrilles(),gga.getTaille(),gga.sontIndependantes());
	}
	
	/**
	 * Initialize la variable ggd. Utile que pour voir si 
	 * le niveau trois a été gagné
	 */
	private void initGGD() {
		ggd = new GroupeGrilleDependantes(this.nombreDesGrilles);
		for(int grilleId = 0; grilleId< this.grilles.length; grilleId++) {
			for(int ligne = 0; ligne < taille ; ligne++) {
				for(int colonne = 0; colonne < taille; colonne++) {
					ggd.ajouterLettre(grilleId, this.grilles[grilleId].getValeurCas(ligne, colonne), ligne, colonne);
				}
			}
		}
	}
	
	/**
	 * Vérifie si le niveau est gagné.
	 */
	/*
	public void winCheckFormalities() {
		if(this.independantes) vainqueur = super.getVainqueur();
		else {
			// Vérifie si le niveau 3 est gagné.
			 
			System.out.println("ggd's vainqueur");
			initGGD();
			vainqueur = ggd.getVainqueur();
		}
		if(vainqueur !=null) {
			// mis à jour de l'écran (panel) si gagné
			System.out.println("win check formalities entered");
			superPanel.revalidate();
			superPanel.repaint();
		}
	}*/
	
	public abstract void winCheckFormalities();
	
	
	
	@Override
	public Cas[] getVainqueur() {
		return this.vainqueur;
	}
	
	/**
	 * setup du panel
	 */
	private void frameFormalities() {
		superPanel.setSize(300,300);
		superPanel.addMouseListener(this);
		superPanel.setVisible(true);
	}
	
	/**
	 * Rajoute des composantes au panel
	 */
	private void addToPanel() {
		superPanel.setLayout(new BoxLayout(superPanel,BoxLayout.X_AXIS));
		for(int i=0; i<nombreDesGrilles;i++) {
			GrillePanel grillePanel = new GrillePanel(i,taille,this);
			grillePanels[i] = grillePanel;
			superPanel.add(grillePanel.panel);
			Box.createVerticalGlue();
		}
	}
	
	public JPanel getPanel() {
		return superPanel;
		//return new GroupeGrillePanel(this.nombreDesGrilles,this.taille,this.independantes);
	}
	

	@Override
	/**
	 * Malheuresement et mysterieusement 
	 * cette méthode n'est pas appelée
	 */
	public void mouseReleased(MouseEvent arg0) {
		//grillePanel.panel.revalidate();
		//grillePanel.panel.repaint();
		System.out.println("groupegrille panel clicked");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Lettre getLettreCourante() {
		return lettreCourante;
	}
	
	/**
	 * Rajoute une lettre donnée dans la ligne et colonne données à la grille dont l'id est
	 * donné
	 */
	public boolean ajouterLettre(int idGrille, Lettre lettre, int ligne, int colonne) {
		return super.ajouterLettre(idGrille, lettre, ligne, colonne);
	}
	
	/**
	 * Change la lettre courante.
	 * X -> O et O -> X
	 */
	public void changerLettre() {
		if(lettreCourante.equals(O)) {
			lettreCourante = X;
		}
		else if(lettreCourante.equals(X)) lettreCourante = O;
		else throw new RuntimeException("Changer lettre inconnue");
	}

}
