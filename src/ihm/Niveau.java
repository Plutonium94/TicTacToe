package ihm;

import javax.swing.JPanel;

public enum Niveau {
	
	UN(1,1,3,true),
	DEUX(2,3,3,true),
	TROIS(3,3,3,false);
	
	private GroupeGrillePanel ggp;
	private int numero; 
	
	private Niveau(int numero, int nombreDeGrilles,int taille,boolean independantes) {
		ggp = new GroupeGrillePanel(nombreDeGrilles,taille,independantes);
		this.numero = numero;
	}
	
	public GroupeGrillePanel getGroupeGrillePanel() {
		return ggp;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public Niveau niveauProchain() {
		if(numero == 3) return null;
		if(numero == 2) return TROIS;
		else return DEUX;
	}
	
	public Niveau niveauPrecedent() {
		if(numero == 1) return null;
		if(numero == 2) return UN;
		else return DEUX;
	}
	
	public boolean estTermine() {
		return this.ggp.getVainqueur() != null || this.ggp.sontComplets();
	}
	
	public JPanel getPanel() {
		return this.ggp.getPanel();
	}

}
