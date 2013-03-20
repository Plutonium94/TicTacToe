package core;


/**
 * Cette classe mod�lise un groupe des grilles qui sont d�pandantes de l'une et l'autre.
 * @author Daniel 
 *
 */
public class GroupeGrilleDependantes extends GroupeGrilleAbstrait {
	
	/**
	 * Initialize un groupe des grilles d�pandantes avec le nombre des grilles et
	 * leur taille (m�me pour chaque grille).
	 * @param nombreDesGrilles
	 * @param taille
	 */
	public GroupeGrilleDependantes(int nombreDeGrilles) {
		super(nombreDeGrilles, nombreDeGrilles, false);
	}
	
	/**
	 * Renvoie l'alignement gagnant de la partie si cette derni�re est termin�e.
	 * Sinon renvoie null
	 * @return un Cas[] si la partie est termin�e, null sinon.
	 */
	public Cas[] getVainqueur() {
		Cas[] res;
		// cherche l'alignement classique ind�pendant
		if((res = super.getVainqueur()) != null) return res;
		if((res = this.getAlignementColonneNonInclineZ()) != null) return res;
		if((res = this.getAlignmentColonneInclineZ()) != null) return res;
		if((res = this.getAlignementLigneInclineZ()) != null) return res;
		if((res = this.getAlignementAntiSlashZ()) != null) return res;
		if((res = this.getAlignementSlashZ()) != null) return res;
		return null;
	}
	
	/**
	 * Renvoie un tableau des Cas, si tous les cas � m�me endroit sur les grilles
	 * ont la m�me lettre. S'il n'y a aucun alignement, renvoie null; 
	 * @return
	 */
	private Cas[] getAlignementColonneNonInclineZ() {
		int nombreDeGrilles = this.getNombreDeGrilles();
		int taille = getTaille();
		Grille[] grilles = this.getGrilles();
		System.out.println(super.toString());
		for(int ligne=0;ligne<taille;ligne++) {
			for(int colonne=0; colonne<taille;colonne++) {
				boolean estAligne = true;
				Cas[] res = new Cas[nombreDeGrilles];
				Lettre lettre = grilles[0].getValeurCas(ligne,colonne);
				res[0] = new Cas(grilles[0],lettre,ligne,colonne);
				for(int numeroGrille=1;numeroGrille<grilles.length;numeroGrille++) {
					if(estAligne && lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne))) {
						estAligne = true;
						res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
					} else estAligne = false;
				}
				if(estAligne) {
					System.out.println("culprit colonne non inclinee Z : " + "["+ligne+","+colonne+"]");
					return res;
				}
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
			for(int numeroGrille=1,ligne =1;numeroGrille<taille;numeroGrille++,ligne++) {
				if(estAligne && lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne)) ) {
					res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
					estAligne = true;
				} else estAligne = false;
			}
			if(estAligne) {
				System.out.println("culprit colonne incline Z : " + colonne);
				return res;
			}
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
			for(int numeroGrille = 1,colonne = 1; numeroGrille < grilles.length; numeroGrille++,colonne++) {
				if(estAligne && lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne))) {
					res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
					estAligne = true;
				} else estAligne = false;
			}
			if(estAligne) {
				System.out.println("Culprit : ligne incline " + ligne);
				return res;
			}
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
		System.out.println("Culprit : \\ Z");
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
		Lettre lettre = grilles[0].getValeurCas(taille-1, taille-1);
		res[0] = new Cas(grilles[0], lettre, taille-1,taille-1);
		for(int numeroGrille = 0, ligne = taille-1 , colonne = taille-1 ; numeroGrille < grilles.length; numeroGrille++,ligne--,colonne--) {
			if(lettre != null && lettre.equals(grilles[numeroGrille].getValeurCas(ligne, colonne))) {
				res[numeroGrille] = new Cas(grilles[numeroGrille],lettre,ligne,colonne);
			} else return null;
		}
		System.out.println("Culprit : / Z");
		return res;
	}
	
	/**
	 * Renvoie une repr�sentation textuelle du groupe des grilles ind�pendantes.
	 */
	public String toString() {
		return "GroupeGrilleDepandantes [ nombreDesGrilles : " + super.getNombreDeGrilles() + 
				", taille : " + super.getTaille() + " ]";
	}

}
