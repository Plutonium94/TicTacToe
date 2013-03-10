package core;

import java.util.*;

/**
 * Cette classe mod�lise une grille. Une grille est donn�e par sa taille.
 * Une grille contient "taille" nombre des lignes et "taille" nombre des colonnes.
 * 
 * Cette classe contient des constants pour pouvoir diff�rencier des lignes des colonnes
 * et les deux diagonals ainsi que des lettres.
 * 
 * Elle contient la m�thode ajouterLettre pour rajouter la lettre voulu dans le cas voulu
 * si ce dernier est vide.
 * 
 * Elle contient �galement la m�thode getVainqueur qui renvoie le vainqueur, si la partie est termin�e,
 * sous format String[].
 * Exemple : {X,C0} si tous les cas de la colonne 0 contiennent X.
 * 
 * Attention ! Toute num�rotation commence � partir du z�ro.
 * 
 * @author Daniel
 *
 */
public class Grille {
	
	/**
	 * Un constant qui signifie la lettre X.
	 */
	public static final String X = "X";
	/**
	 * Un constant qui signifie la lettre O.
	 */
	public static final String O = "O";
	/**
	 * Un constant qui signifie qu'un cas est vide.
	 */
	public static final String VIDE = ""; 
	/**
	 * Un constant qui signifie un cas
	 */
	public static final String CAS = "CAS";
	/**
	 * Un constant qui signifie une ligne.
	 */
	public static final String LIGNE = "L";
	/**
	 * Un constant qui signifie une colonne.
	 */
	public static final String COLONNE = "C";
	/**
	 * Un constant qui signifie le diagonal haut-droite vers bas-gauche.
	 */
	public static final String DIAGONAL_SLASH = "slash";
	/**
	 * Un constant qui signifie le diagonal haut-gauche vers bas-droite.
	 */
	public static final String DIAGONAL_ANTI_SLASH = "antislash";
	
	private final int taille;
	private String[][] tableau;
	
	/**
	 * Cr�e un objet Grille de taille taille
	 * @param taille
	 */
	public Grille(int taille) {
		this.taille = taille;
		tableau = new String[taille][taille];
		Arrays.fill(tableau,VIDE);
	}
	
	/**
	 * Ajoute la lettre donn�e dans le cas qui correspond � la ligne et la
	 * colonne donn�e
	 * @param lettre la constante X ou O
	 * @param ligne num�ro de ligne
	 * @param colonne num�ro de colonne
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
	 * Renvoie le vainqueur et son alignement dans la grille si la partie est termin�e.
	 * Exemple : [O,C2] si tous les cas de la colonne 2 contiennent O.
	 *           [X,slash] si tous les cas de la diagonale haut-droite vers bas-gauche contiennent X.
	 * @return une couple form�e par la lettre et son alignement si la partie est termin�e, null sinon
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
	 * V�rifie s'il y a un alignement dans la grille pour une lettre donn�e 
	 * dans une ligne ou une colonne donn�e
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
	 * V�rifie si tous les cas de la ligne donn�e contiennent la lettre donn�e
	 * @param lettre la constante X ou O
	 * @param numeroLigne le num�ro de la ligne
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
	 * V�rifie si tous les cas de la colonn� donn�e contiennent
	 * @param lettre la constante X ou O
	 * @param numeroColonne le num�ro de la colonne
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
	 * V�rifie si tous les cas de la diagonale haut-gauche vers bas-droite (formant un slash)
	 * de la grille contiennent la lettre donn�e
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
	 * V�rifie si tous les cas de la diagonale haut-droite vers bas-gauche (formant un anti-slash)
	 * de la grille contiennent la lettre donn�e
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
	 * Renvoie la taille de la grille
	 * @return taille
	 */
	public int getTaille() {
		return taille;
	}
	
	/**
	 * Renvoie la valeur du cas form� par la ligne et colonne donn�e
	 * @param ligne
	 * @param colonne
	 * @return la lettre dans le cas
	 */
	public String getValeurCas(int ligne,int colonne) {
		return this.tableau[ligne][colonne];
	}
	
	
	/**
	 * Renvoie une repr�sentation textuelle de la grille
	 */
	public String toString() {
		return "Grille [ taille : " + this.taille + ", tableau : " + Arrays.toString(this.tableau) + " ]";
	}

}
