package ihm;

import javax.swing.JPanel;

public enum Niveau {
	
	UN(1,1,3,true),
	DEUX(2,3,3,true),
	TROIS(3,3,3,false);
	
	private GroupeGrillePanel ggp;
	private int numero; 
	
	private Niveau(int numero, int nombreDeGrilles,int taille,boolean independantes) {
		
		switch(numero) {
			case 1 : ggp = new Niveau1Panel(); break;
			case 2 : ggp = new Niveau2Panel(); break;
			case 3 : ggp = new Niveau3Panel(); break;
		}
		this.numero = numero;
	}
	
	public GroupeGrillePanel getGroupeGrillePanel() {
		return ggp;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setJeuFrame(JeuFrame jf) {
		this.ggp.setJeuFrame(jf);
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
	
	public void clear() {
		ggp.clear();
	}
	
	public void refresh() {
		ggp.refresh();
	}
	
	public boolean estTermine() {
		return this.ggp.getVainqueur() != null || this.ggp.sontComplets();
	}
	
	public JPanel getPanel() {
		return this.ggp.getPanel();
	}

}
