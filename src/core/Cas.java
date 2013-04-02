package core;

/**
 * Cette classe modélise un cas de la grille
 * @author Daniel
 *
 */

public class Cas {
	
	private Lettre lettre;
	private int ligne;
	private int colonne;
	private Grille grille;
	
	/**
	 * Initialise un cas avec une grille propriétaire, une lettre, et une ligne et une colonne 
	 * pour indiquer sa position dans la grille
	 * @param grille
	 * @param lettre
	 * @param ligne
	 * @param colonne
	 */
	public Cas(Grille grille, Lettre lettre, int ligne, int colonne) {
		this.grille = grille;
		this.lettre = (lettre);
		this.ligne = (ligne);
		this.colonne = (colonne);
	}
	
	public String toString() {
		if(lettre == null) return "Cas [ ligne : " + ligne + ", colonne : " + colonne +", grilleId : " + grille.getId() + " ]";
		return "Cas [ lettre : " + lettre.getValeur() + " ligne : " + ligne + ", colonne : " + colonne +
				", grille : " + grille.getId() + " ]"; 
	}

	public Lettre getLettre() {
		return lettre;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}
	
	public Grille getGrille() {
		return grille;
	}
	
	public int getGrilleId() {
		return grille.getId();
	}

	
}
