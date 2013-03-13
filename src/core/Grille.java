package core;

import java.util.*;
import static core.Lettre.*;

/**
 * Cette classe mod�lise une grille. Une grille est donn�e par sa taille.
 * Une grille contient "taille" nombre des lignes et "taille" nombre des colonnes.
 * 
 * 
 * Elle contient la m�thode ajouterLettre pour rajouter la lettre voulu dans le cas voulu
 * si ce dernier est vide.
 * 
 * Elle contient �galement la m�thode getVainqueur qui renvoie le vainqueur, si la partie est termin�e,
 * sous format Cas[].
 * 
 * Attention ! Toute num�rotation commence � partir du z�ro.
 * 
 * @author Daniel
 *
 */
public class Grille {

	
	private final int taille;
	private Lettre[][] tableau;
	/**
	 * L'id permet de diff�rencier les grilles dans un groupe des grilles.
	 * Attention c'est au groupe de donner un id unique � ses grilles.
	 * La classe grille ne s'occupe pas de cela.
	 */
	private final int id;
	
	/**
	 * Cr�e un objet Grille de taille taille
	 * @param taille
	 */
	public Grille(int id,int taille) {
		this.taille = taille;
		this.id = id;
		tableau = new Lettre[taille][taille];
		Arrays.fill(tableau,null);
	}
	
	/**
	 * Si aucun id n'est donn�e, l'id par d�faut est -infini 
	 * @param taille
	 */
	public Grille(int taille) {
		this(taille, Integer.MIN_VALUE);
	}
	
	/**
	 * Ajoute la lettre donn�e dans le cas qui correspond � la ligne et la
	 * colonne donn�e
	 * @param lettre un enum lettre (normalement X ou O)
	 * @param ligne num�ro de ligne
	 * @param colonne num�ro de colonne
	 * @return true si l'ajout est fait, false sinon
	 */
	public boolean ajouterLettre(Lettre lettre,int ligne,int colonne) {
		if(!lettre.equals(X) && !lettre.equals(O)) return false;
		if(ligne < 0 || ligne >= taille) return false;
		if(colonne < 0 || ligne >= taille) return false;
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
				if(tableau[i][j] != null) return false;
			}
		}
		return true;
	}
	
	/**
	 * Renvoie l'alignement gangnant si la partie est termin�, null sinon
	 * @return un tableau de cas qui font partie de l'alignement si la partie est termin�,
	 * 			null sinon
	 */
	public Cas[] getVainqueur() {
		Cas[] res = new Cas[taille];
		for(Lettre lettre : Lettre.values()) {
			for(int i=0; i<this.taille; i++) {
				if((res = this.aligneLigneLettre(lettre, i)) != null) return res;
				else if((res = this.aligneColonneLettre(lettre, i)) != null) return res;
			}
			if((res = this.aligneDiagonaleAntiSlashLettre(lettre)) != null) return res;
			else if((res = this.aligneDiagonaleSlashLettre(lettre)) != null) return res;
		}
		return null;
	}
	
	/**
	 * Renvoie la ligne si tous les cas de la ligne donn�e contiennent la m�me lettre
	 * @param lettre la constante X ou O
	 * @param numeroLigne le num�ro de la ligne
	 * @return S'il y a un alignement, un Cas[] repr�sentant la ligne. Sinon null.
	 */
	private Cas[] aligneLigneLettre(Lettre lettre, int numeroLigne) {
		Cas[] res = new Cas[taille];
		Lettre premierCasDeLigne = this.tableau[numeroLigne][0];
		if(!premierCasDeLigne.equals(lettre)) return null;
		else res[0] = new Cas(this, lettre,numeroLigne,0);
		for(int i=1;i<taille;i++) {
			if(!tableau[numeroLigne][i].equals(premierCasDeLigne)) return null;
			else res[i] = new Cas(this, lettre,numeroLigne,i);
		}
		return res;
	}
	
	/**
	 * Renvoie la colonne si tous les cas de la colonn� donn�e contiennent la m�me lettre
	 * @param lettre la constante X ou O
	 * @param numeroColonne le num�ro de la colonne
	 * @return S'il y a un alignement, un Cas[] repr�sentant la colonne. Sinon null.
	 */
	private Cas[] aligneColonneLettre(Lettre lettre, int numeroColonne) {
		Cas[] res = new Cas[taille];
		Lettre premierCasDeColonne = tableau[0][numeroColonne];
		if(!premierCasDeColonne.equals(lettre)) return null;
		else res[0] = new Cas(this, lettre,0,numeroColonne);
		for(int i=1;i<taille;i++) {
			if(!tableau[i][numeroColonne].equals(premierCasDeColonne)) return null;
			else res[i] = new Cas(this, lettre,i,numeroColonne);
		}
		return res;
	}
	
	/**
	 * Renvoie la diagonale si tous les cas de la diagonale haut-gauche � basse-droite
	 * (formant un anti-slash) contiennent la m�me lettre
	 * @param lettre la constante X ou O
	 * @return S'il y a un alignement, un Cas[] repr�sentant la diagonale. Sinon null.
	 */
	private Cas[] aligneDiagonaleAntiSlashLettre(Lettre lettre) {
		Cas[] res = new Cas[taille];
		Lettre premierCasDeDiagonal = tableau[0][0];
		if(!premierCasDeDiagonal.equals(lettre)) return null;
		else res[0] = new Cas(this,lettre,0,0);
		for(int i = 1; i < taille; i++) {
			if(!tableau[i][i].equals(premierCasDeDiagonal)) return null;
			else res[i] = new Cas(this,lettre, i, i);
		}
		return res;
	}
	
	/**
	 * Renvoie la diagonale si tous les cas de la diagonale haute-droite � basse-gauche
	 * (formant un slash)  contiennent la m�me lettre
	 * @param lettre la constante X ou O
	 * @return S'il y a un alignement, un Cas[] repr�sentant la diagonale. Sinon null.
	 */
	private Cas[] aligneDiagonaleSlashLettre(Lettre lettre) {
		Cas[] res = new Cas[taille];
		Lettre premierCasDeDiagonal = tableau[taille-1][0];
		if(!premierCasDeDiagonal.equals(lettre)) return null;
		else res[0] = new Cas(this, lettre,taille-1,0);
		for(int i=taille-1, j=1; i < taille; i--,j++) {
			if(!tableau[i][j].equals(premierCasDeDiagonal)) return null;
			else res[i] = new Cas(this,lettre,i,j);
		}
		return res;
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
	 * @return la lettre dans le cas sous format String, null si le cas est vide.
	 */
	public Lettre getValeurCas(int ligne,int colonne) {
		Lettre lettre;
		if((lettre = this.tableau[ligne][colonne]) != null) return lettre;
		else return null;
	}
	
	
	/**
	 * Renvoie une repr�sentation textuelle de la grille
	 */
	public String toString() {
		return "Grille [ id : "+ id + ", taille : " + this.taille + ", tableau : " + 
				Arrays.toString(this.tableau) + " ]";
	}

}
