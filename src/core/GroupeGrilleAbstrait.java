package core;

import java.util.*;

/**
 * Cette classe modélise un groupe des grilles.
 * Un groupe de grilles est donnée par le nombre des grills, la taille de chacune de ces grilles et
 * leur indépendance par rapport à l'une et l'autre.
 * 
 * Cette classe contient la méthode getVainqueur, pour obtenir le vainqueur d'une partie si celle-ci est terminée.
 * Cette méthode considère que les grilles sont indépendantes.
 * 
 * Attention ! Toute numérotation commence à partir du zéro.
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
	 * et un boolean qui signifie si les grilles sont indépendantes ou pas.
	 * @param nombreDesGrilles le nombre des grilles
	 * @param taille la taille de chaque grille (même pour toutes)
	 * @param independantes un boolean qui signifie si les grilles sont indépendantes ou pas.
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
	 * Renvoie les cas formant l'alignement gagnant de la partie (si elle est terminée), sous format d'un Cas[].
	 * Si la partie n'est pas terminée cette méthode renvoie null.
	 * Attention ! Cette méthode considère que les grilles sont indépendantes de l'une et l'autre.
	 * @return Si la partie est terminée, un Cas[] contenant les cas d'alignement.
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
	 * Vérifie si toutes les grilles du groupe sont complets.
	 * @return Si toutes les grilles sont complets true. Sinon false.
	 */
	public boolean sontComplets() {
		for(Grille grille : grilles) {
			if(!grille.estComplet()) return false;
		}
		return true;
	}
	
	/**
	 * Renvoie vrai si les grilles sont indépendantes, faux sinon.
	 * @return Si les grilles sont indépendantes true.
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
	 * Renvoie la taille des grilles (même pour toutes)
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
	 * Renvoie une représentation textuelle d'un groupe abstrait des grilles.
	 */
	public String toString() {
		return this.getClass().getSimpleName() + " [ nombreDeGrilles : " + this.nombreDesGrilles
				+ ", independantes : " + this.independantes 
				+ ", grilles : " + Arrays.toString(grilles) + " ]";
	}
	

}
