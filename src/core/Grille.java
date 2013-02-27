package core;

import java.util.*;

public class Grille {
	
	public static final String X = "X";
	public static final String O = "O";
	public static final String VIDE = ""; 
	
	public static final String LIGNE = "L";
	public static final String COLONNE = "C";
	
	public static final String DIAGONAL_SLASH = "slash";
	public static final String DIAGONAL_ANTI_SLASH = "antislash";
	
	private final int taille;
	private String[][] tableau;
	
	/**
	 * Crée un objet Grille de taille taille
	 * @param taille
	 */
	public Grille(int taille) {
		this.taille = taille;
		tableau = new String[taille][taille];
		Arrays.fill(tableau,VIDE);
	}
	
	/**
	 * Ajoute la lettre donnée dans le cas qui correspond à la ligne et la
	 * colonne donnée
	 * @param lettre la constante X ou O
	 * @param ligne numéro de ligne
	 * @param colonne numéro de colonne
	 * @return true si l'ajout est fait, false sinon
	 */
	public boolean ajouterLettre(String lettre,int ligne,int colonne) {
		if(!lettre.equals(X) && !lettre.equals(O)) return false;
		if(ligne < 0 || ligne >= taille) return false;
		if(colonne < 0 || ligne >= taille) return false;
		if(tableau[ligne][colonne] == VIDE ) return false; 
		this.tableau[ligne][colonne] = lettre;
		return true;
	}
	
	/**
	 * Verifie si la grille est complet
	 * @return true si la grille est complet, false sinon
	 */
	public boolean estComplet() {
		for(int i=0;i<taille;i++) {
			for(int j=0;j<taille;j++) {
				if(tableau[i][j].equals(VIDE)) return false;
			}
		}
		return true;
	}
	
	/**
	 * Renvoie le vainqueur et son alignement dans la grille si la partie est terminée.
	 * Exemple : [O,C2] si tous les cas de la colonne 2 contiennent O.
	 *           [X,slash] si tous les cas de la diagonale haut-droite vers bas-gauche contiennent X.
	 * @return une couple formée par la lettre et son alignement si la partie est terminée, null sinon
	 */
	public String[] getVainqueur() {
		for(String lettre : new String[]{O,X}) {
			for(String ligneOuColonne : new String[]{LIGNE,COLONNE}) {
				for(int i=0;i<taille;i++) {
					if(this.aligneLigneColonneLettre(lettre, ligneOuColonne, i)) return new String[]{lettre,ligneOuColonne+i};
				}
			}
			if(this.aligneDiagonaleSlashLettre(lettre)) return new String[]{lettre,DIAGONAL_SLASH};
			if(this.aligneDiagonaleAntiSlashLettre(lettre)) return new String[]{DIAGONAL_ANTI_SLASH};
		}
		return null;
	}
	
	/**
	 * Vérifie s'il y a un alignement dans la grille pour une lettre donnée 
	 * dans une ligne ou une colonne donnée
	 * @param lettre la lettre pour laquelle la rechereche est fait
	 * @param ligneOuColonne un constant qui dit si la recherche est fait dans une ligne ou bien une colonne
	 * @param numeroLigneColonne le numero de la ligne ou la colonne
	 * @return true s'il y a un alignement, false sinon
	 */
	private boolean aligneLigneColonneLettre(String lettre,String ligneOuColonne, int numeroLigneColonne) {
		if(ligneOuColonne.equals(LIGNE)) return aligneLigneLettre(lettre,numeroLigneColonne);
		else if(ligneOuColonne.equals(COLONNE)) return aligneColonneLettre(lettre,numeroLigneColonne);
		else return false;
	}
	
	/**
	 * Vérifie si tous les cas de la ligne donnée contiennent la lettre donnée
	 * @param lettre la constante X ou O
	 * @param numeroLigne le numéro de la ligne
	 * @return true s'il y a un alignement, false sinon
	 */
	private boolean aligneLigneLettre(String lettre, int numeroLigne) {
		String premierCasDeLigne = this.tableau[numeroLigne][0];
		if(!premierCasDeLigne.equals(lettre)) return false;
		for(int i=1;i<taille;i++) {
			if(!tableau[numeroLigne][i].equals(premierCasDeLigne)) return false;
		}
		return true;
	}
	
	/**
	 * Vérifie si tous les cas de la colonné donnée contiennent
	 * @param lettre la constante X ou O
	 * @param numeroColonne le numéro de la colonne
	 * @return true s'il y a un alignement, false sinon
	 */
	private boolean aligneColonneLettre(String lettre, int numeroColonne) {
		String premierCasDeColonne = tableau[0][numeroColonne];
		if(!premierCasDeColonne.equals(lettre)) return false;
		for(int i=1;i<taille;i++) {
			if(!tableau[i][numeroColonne].equals(premierCasDeColonne)) return false;
		}
		return true;
	}
	
	/**
	 * Vérifie si tous les cas de la diagonale haut-gauche vers bas-droite (formant un slash)
	 * de la grille contiennent la lettre donnée
	 * @param lettre la constante X ou O
	 * @return true s'il y a un alignement, false sinon
	 */
	private boolean aligneDiagonaleSlashLettre(String lettre) {
		String premierCasDeDiagonal = tableau[0][0];
		if(!premierCasDeDiagonal.equals(lettre)) return false;
		for(int i = 1; i < taille; i++) {
			if(!tableau[i][i].equals(premierCasDeDiagonal)) return false;
		}
		return true;
	}
	
	/**
	 * Vérifie si tous les cas de la diagonale haut-droite vers bas-gauche (formant un anti-slash)
	 * de la grille contiennent la lettre donnée
	 * @param lettre la constante X ou O
	 * @return true s'il y un alignement, false sinon
	 */
	private boolean aligneDiagonaleAntiSlashLettre(String lettre) {
		String premierCasDeDiagonal = tableau[taille-1][0];
		if(!premierCasDeDiagonal.equals(lettre)) return false;
		for(int i=taille-1, j=1; i < taille; i--,j++) {
			if(!tableau[i][j].equals(premierCasDeDiagonal)) return false;
		}
		return true;
	}
	
	
	
	
	/**
	 * Renvoie une représentation textuelle de la grille
	 */
	public String toString() {
		return "Grille [ taille : " + this.taille + ", tableau : " + Arrays.toString(this.tableau) + " ]";
	}

}
