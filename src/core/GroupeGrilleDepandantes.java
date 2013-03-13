package core;


/**
 * Cette classe modélise un groupe des grilles qui sont dépandantes de l'une et l'autre.
 * @author Daniel 
 *
 */
public class GroupeGrilleDepandantes extends GroupeGrilleAbstrait {
	
	/**
	 * Initialize un groupe des grilles dépandantes avec le nombre des grilles et
	 * leur taille (même pour chaque grille).
	 * @param nombreDesGrilles
	 * @param taille
	 */
	public GroupeGrilleDepandantes(int nombreDeGrilles) {
		super(nombreDeGrilles, nombreDeGrilles, false);
	}
	
	/**
	 * Renvoie l'alignement gagnant de la partie si cette dernière est terminée.
	 * Sinon renvoie null
	 * @return un Cas[] si la partie est terminée, null sinon.
	 */
	public Cas[] getVainqueur() {
		Cas[] res;
		// cherche l'alignement classique indépendant
		if((res = super.getVainqueur()) != null) return res;
		if((res = this.getAlignementColonneNonInclineZ()) != null) return res;
		if((res = this.getAlignmentColonneInclineZ()) != null) return res;
		if((res = this.getAlignementLigneInclineZ()) != null) return res;
		if((res = this.getAlignementAntiSlashZ()) != null) return res;
		if((res = this.getAlignementSlashZ()) != null) return res;
		return null;
	}
	
	/**
	 * Renvoie un tableau des Cas, si tous les cas à même endroit sur les grilles
	 * ont la même lettre. S'il n'y a aucun alignement, renvoie null; 
	 * @return
	 */
	private Cas[] getAlignementColonneNonInclineZ() {
		int nombreDeGrilles = this.getNombreDeGrilles();
		int taille = getTaille();
		Grille[] grilles = this.getGrilles();
		boolean estAligne = true;
		for(int ligne=0;ligne<taille;ligne++) {
			for(int colonne=0; colonne<taille;colonne++) {
				Cas[] res = new Cas[nombreDeGrilles];
				Lettre lettre = grilles[0].getValeurCas(ligne,colonne);
				res[0] = new Cas(grilles[0],lettre,ligne,colonne);
				for(int numeroGrille=1;numeroGrille<grilles.length;numeroGrille++) {
					if(estAligne && lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne))) {
						estAligne = true;
						res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
					} else estAligne = false;
				}
				if(estAligne) return res;
			}
		}
		return null;
	}
	
	/**
	 * Alignement dans lequel les grilles & les lignes changent mais les colonnes
	 * ne changent pas.
	 * @return
	 */
	private Cas[] getAlignmentColonneInclineZ() {
		int taille = getTaille();
		Grille[] grilles = this.getGrilles();
		for(int colonne = 0 ; colonne <taille;colonne++) {
			Cas[] res = new Cas[taille];
			Lettre lettre = grilles[0].getValeurCas(0,colonne);
			res[0] = new Cas(grilles[0],lettre,0,colonne);
			boolean estAligne = true;
			for(int numeroGrille=0;numeroGrille<taille;numeroGrille++) {
				for(int ligne = 0; ligne < taille; numeroGrille++) {
					if(estAligne && lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne)) ) {
						res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
						estAligne = true;
					} else estAligne = false;
				}
			}
			if(estAligne) return res;
		}
		return null;
	}
	
	/**
	 * Alignement dans lequel les grilles et les colonnes changent mais les lignes
	 * ne changent pas
	 * @return
	 */
	private Cas[] getAlignementLigneInclineZ() {
		int taille = getTaille();
		Grille[] grilles = getGrilles();
		for(int ligne = 0; ligne <taille; ligne++) {
			Cas[] res = new Cas[taille];
			Lettre lettre = grilles[0].getValeurCas(ligne, 0);
			res[0] = new Cas(grilles[0],lettre,ligne,0);
			boolean estAligne = true;
			for(int numeroGrille = 0; numeroGrille < grilles.length; numeroGrille++) {
				for(int colonne = 0; colonne <taille; colonne++) {
					if(estAligne && lettre != null && grilles[numeroGrille].getValeurCas(ligne, colonne).equals(lettre)) {
						res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
						estAligne = true;
					} else estAligne = false;
				}
			}
			if(estAligne) return res;
		}
		return null;
	}
	
	/*
	 * Alignement de diagonale du cas haut-haut-gauche au cas bas-bas-droit (z-x-y)
	 * (formant un anti-slash)
	 */
	private Cas[] getAlignementAntiSlashZ() {
		int taille = getTaille();
		Grille[] grilles = getGrilles();
		Cas[] res = new Cas[taille];
		Lettre lettre = grilles[0].getValeurCas(0, 0);
		for(int ligne = 0, colonne = 0, numeroGrille=0; ligne < taille; ligne++,colonne++,numeroGrille++) {
			if(lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne))) {
				res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
			} else return null;
		}
		return res;
	}
	
	/**
	 * Alignement de diagonale du cas haut-haut-droit au cas bas-bas-gauche (z-x-y)
	 * (formant un slash)
	 * @return
	 */
	private Cas[] getAlignementSlashZ() {
		int taille = getTaille();
		Grille[] grilles = getGrilles();
		Cas[] res = new Cas[taille];
		Lettre lettre = grilles[0].getValeurCas(taille - 1, 0);
		res[0] = new Cas(grilles[0], lettre, taille-1,0);
		for(int numeroGrille = 0, ligne = taille-1, colonne = 0 ; numeroGrille < grilles.length; numeroGrille++,ligne--,colonne++) {
			if(lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne))) {
				res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
			} else return null;
		}
		return res;
	}
	
	/**
	 * Renvoie une représentation textuelle du groupe des grilles indépendantes.
	 */
	public String toString() {
		return "GroupeGrilleDepandantes [ nombreDesGrilles : " + super.getNombreDeGrilles() + 
				", taille : " + super.getTaille() + " ]";
	}

}
