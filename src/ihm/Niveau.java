package ihm;

public enum Niveau {
	
	UN(1,3,true),
	DEUX(3,3,true),
	TROIS(3,3,false);
	
	private GroupeGrillePanel ggp;
	
	private Niveau(int nombreDeGrilles,int taille,boolean independantes) {
		ggp = new GroupeGrillePanel(nombreDeGrilles,taille,independantes);
	}
	
	public GroupeGrillePanel getGroupeGrillePanel() {
		return ggp;
	}

}
