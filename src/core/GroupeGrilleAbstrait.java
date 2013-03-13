package core;

import java.util.*;

/**
 * Cette classe mod�lise un groupe des grilles.
 * Un groupe de grilles est donn�e par le nombre des grills, la taille de chacune de ces grilles et
 * leur ind�pendance par rapport � l'une et l'autre.
 * 
 * Cette classe contient la m�thode getVainqueur, pour obtenir le vainqueur d'une partie si celle-ci est termin�e.
 * Cette m�thode consid�re que les grilles sont ind�pendantes.
 * 
 * Attention ! Toute num�rotation commence � partir du z�ro.
 *
 * @author Daniel
 *
 */
public abstract class GroupeGrilleAbstrait {
	
	private int nombreDesGrilles;
	private Grille[] grilles;
	private int taille;
	private boolean independantes;
	
	/**
	 * Initialize un groupe abstrait des grilles avec le nombre des grilles, leur taille (de chaque grilles)
	 * et un boolean qui signifie si les grilles sont ind�pendantes ou pas.
	 * @param nombreDesGrilles le nombre des grilles
	 * @param taille la taille de chaque grille (m�me pour toutes)
	 * @param independantes un boolean qui signifie si les grilles sont ind�pendantes ou pas.
	 */
	public GroupeGrilleAbstrait(int nombreDesGrilles,int taille, boolean independantes) {
		this.nombreDesGrilles = nombreDesGrilles;
		this.independantes = independantes;
		this.taille = taille;
		grilles = new Grille[nombreDesGrilles];
		for(int i=0; i<nombreDesGrilles;i++) {
			grilles[i] = new Grille(i,taille);
		}
	}
	
	/**
	 * Renvoie les cas formant l'alignement gagnant de la partie (si elle est termin�e), sous format d'un Cas[].
	 * Si la partie n'est pas termin�e cette m�thode renvoie null.
	 * Attention ! Cette m�thode consid�re que les grilles sont ind�pendantes de l'une et l'autre.
	 * @return Si la partie est termin�e, un Cas[] contenant les cas d'alignement.
	 *         Sinon, null
	 */
	public Cas[] getVainqueur() {
		Cas[] res = new Cas[taille];
		for(int i=0; i< grilles.length; i++) {
			if((res = grilles[i].getVainqueur()) != null) return res;
		}
		return null;
	}
	
	/**
	 * V�rifie si toutes les grilles du groupe sont complets.
	 * @return Si toutes les grilles sont complets true. Sinon false.
	 */
	public boolean sontComplets() {
		for(Grille grille : grilles) {
			if(!grille.estComplet()) return false;
		}
		return true;
	}
	
	/**
	 * Renvoie vrai si les grilles sont ind�pendantes, faux sinon.
	 * @return Si les grilles sont ind�pendantes true.
	 * 		   Sinon false.
	 */
	public boolean sontIndependantes() {
		return this.independantes;
	}
	
	/**
	 * Renvoie le nombre des grilles
	 * @return le nombre des grilles
	 */
	public int getNombreDeGrilles() {
		return this.nombreDesGrilles;
	}
	
	/**
	 * Renvoie la taille des grilles (m�me pour toutes)
	 * @return la taille
	 */
	public int getTaille() {
		return taille;
	}
	
	/**
	 * Renvoie tous les grilles 
	 * @return un Grille[] contenent les grilles
	 */
	public Grille[] getGrilles() {
		return grilles;
	}
	
	public boolean ajouterLettre(int idGrille, Lettre lettre,int ligne, int colonne ) {
		if(grilles[idGrille].getValeurCas(ligne, colonne) == null) {
			grilles[idGrille].ajouterLettre(lettre, ligne, colonne);
			return true;
		}
		else return false;
	}
	
	/**
	 * Renvoie une repr�sentation textuelle d'un groupe abstrait des grilles.
	 */
	public String toString() {
		return this.getClass().getSimpleName() + " [ nombreDeGrilles : " + this.nombreDesGrilles
				+ ", independantes : " + this.independantes 
				+ ", grilles : " + Arrays.toString(grilles) + " ]";
	}
	

}
