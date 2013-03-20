package jeu;

import core.*;

public class Niveau {
	
	private GroupeGrilleAbstrait gga;
	private int numero;
	
	public static int NIVEAU_UN = 1;
	public static int NIVEAU_DEUX = 2;
	public static int NIVEAU_TROIS = 3;
	
	public Niveau() {
		this(1);
	}
	
	public Niveau(int numeroConstant) {
		this.numero = numeroConstant;
		switch(numero) {
			case 1 : gga = new GroupeGrilleIndependantes(1,3); break;
			case 2 : gga = new GroupeGrilleIndependantes(3,3); break;
			case 3 : gga = new GroupeGrilleDependantes(3); break;
		}
	}
	
	public boolean isTermine() {
		return gga.sontComplets() || gga.getVainqueur() != null;
	}
	
	public int numeroNiveauSuivant() {
		if(this.numero >= 3) return -1;
		return numero + 1;	
	}

}
