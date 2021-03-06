package ihm;

import javax.swing.*;

import static core.Lettre.*;

import java.awt.*;
import core.*;
import java.awt.event.*;

/**
 * Repr�sentation graphique d'une groupe des grilles
 * @author Daniel
 *
 */
public abstract class GroupeGrillePanel extends GroupeGrilleAbstrait implements MouseListener {
	
    GrillePanel[] grillePanels;
	private Lettre lettreCourante = O;
	protected Cas[] vainqueur = null;
	// Cet attribut ggd est une mauvaise conception mais utile pour
	// voir si on a gagn� le niveau 3
	private GroupeGrilleDependantes ggd = null;
	private Cas casCourante = new Cas(grilles[0],O,1,1);
	private JeuFrame jeuFrame;
	
	// Le panel effectif
	JPanel superPanel = new JPanel();
	

	public GroupeGrillePanel(int nombreDeGrilles, int taille, boolean independantes) {
		super(nombreDeGrilles,taille,independantes);
		if(nombreDeGrilles != 1) this.casCourante = new Cas(grilles[1],Lettre.O,1,1);
		else {
			this.casCourante = new Cas(grilles[0],Lettre.O,1,1);
		}
		grillePanels = new GrillePanel[nombreDeGrilles];
		
		if(!independantes) {
			initGGD();
		}
		
		addToPanel();
		superPanel.setBackground(Color.WHITE);
		frameFormalities();
	}
	
	public GroupeGrillePanel(GroupeGrilleAbstrait gga) {
		this(gga.getNombreDeGrilles(),gga.getTaille(),gga.sontIndependantes());
	}
	
	/**
	 * Initialize la variable ggd. Utile que pour voir si 
	 * le niveau trois a �t� gagn�
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
	 * V�rifie si le niveau est gagn�.
	 */
	/*
	public void winCheckFormalities() {
		if(this.independantes) vainqueur = super.getVainqueur();
		else {
			// V�rifie si le niveau 3 est gagn�.
			 
			System.out.println("ggd's vainqueur");
			initGGD();
			vainqueur = ggd.getVainqueur();
		}
		if(vainqueur !=null) {
			// mis � jour de l'�cran (panel) si gagn�
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
		superPanel.addKeyListener(new MyKeyAdapter());
		superPanel.setVisible(true);
		/*if(this.casCourante == null ) System.out.println("cas courante null");
		else System.out.println("cas courante : " + this.casCourante);*/
		superPanel.setFocusable(true);
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
	}
	
	public Cas getCasCourante() {
		return this.casCourante;
	}
	

	@Override
	/**
	 * Malheuresement et mysterieusement 
	 * cette m�thode n'est pas appel�e
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
		
	}
	
	public Lettre getLettreCourante() {
		return lettreCourante;
	}
	
	public void setJeuFrame(JeuFrame jf) {
		this.jeuFrame = jf;
	}
	
	public JeuFrame getJeuFrame() {
		return this.jeuFrame;
	}
	
	/**
	 * Rajoute une lettre donn�e dans la ligne et colonne donn�es � la grille dont l'id est
	 * donn�
	 */
	public boolean ajouterLettre(int idGrille, Lettre lettre, int ligne, int colonne) {
		for(GrillePanel gp : this.grillePanels) {
			if(gp.getId() == idGrille) {
				gp.ajouterLettre(lettre, ligne, colonne);
			}
		}
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
	
	public void clear() {
		for(int grille=0;grille<grilles.length;grille++) {
			this.grillePanels[grille].clear();
		}
	}
	
	public void refresh() {
		for(GrillePanel gp : this.grillePanels) {
			gp.panel.setVisible(false);
			this.superPanel.remove(gp.panel);
			
			//gp.panel.setVisible(true);
			this.superPanel.add(gp.panel);
			gp.refresh();
			gp.panel.setVisible(true);
			
		}
		this.superPanel.revalidate();
		this.superPanel.repaint();
	}
	
	private class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			if(getNombreDeGrilles() > 1 ) {
				System.out.println("greater code : " + code);
			}
			int grilleId = casCourante.getGrilleId();
			int ligne = casCourante.getLigne();
			int colonne = casCourante.getColonne();
			switch(code) {
				case KeyEvent.VK_UP : if(ligne > 0) ligne--; break;
				case KeyEvent.VK_DOWN : if(ligne < casCourante.getGrille().getTaille()-1) ligne++; break;
				case KeyEvent.VK_LEFT : {
					if(colonne > 0) {
						colonne--; 
					}
					else if(grilleId != 0){
						grilleId--;
						colonne = casCourante.getGrille().getTaille() - 1;
					}
					break;
				}
				case KeyEvent.VK_RIGHT : { 
					if(colonne < casCourante.getGrille().getTaille()-1) {
						colonne++; 
					} else if(grilleId != getNombreDeGrilles()- 1) {
						grilleId++;
						colonne = 0;
					}
					break;
				}
				case KeyEvent.VK_SPACE : {
					boolean b = ajouterLettre(casCourante.getGrilleId(),lettreCourante,ligne,colonne); 
					if(b) {
						changerLettre();
						winCheckFormalities();
					}
					break;
				}
			}
			//if(b) System.out.println("Boobobobobooboboboboboobobobobob");
			casCourante = new Cas(grilles[grilleId],null,ligne,colonne);
			refresh();
		}
	}

}
