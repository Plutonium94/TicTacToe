package core;

import java.util.*;

/**
 * Cette classe modélise un groupe des grilles.
 * Un groupe de grilles est donnée par le nombre des grills, la taille de chacune de ces grilles et
 * leur indépendance par rapport à l'une et l'autre.
 * 
 * Cette classe contient la méthode getVainqueur, pour obtenir le vainqueur d'une partie si celle-ci est terminée.
 * Elle renvoie ses résultats sous format String : {numero de Grille, Lettre, Alignement}
 * Exemple : {G2, X, L0} signifie que tous les cas de la ligne 0 de la grille 2 contiennent X.
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
		Arrays.fill(grilles, new Grille(taille));
	}
	
	/**
	 * Renvoie le vainqueur de la partie (si elle est terminée), son alignement et sa grille sous
	 * format d'un String[]. Si la partie n'est pas terminée cette méthode renvoie null.
	 * Exemple : {G0, O, L2} signifie que tous les cas de la ligne 2 de la grille 0 contiennent O.
	 * Exmeple : {G1, X, C0} signifie que tous les cas de la colonne 0 de la grille 1 contiennent X. 
	 * @return Si la partie est terminée, un String[] contenant la lettre, alignement et grille de la vainqueur.
	 *         Sinon, null
	 */
	public String[] getVainqueur() {
		String[] res = new String[3];
		for(int i=0; i< grilles.length; i++) {
			String[] vainqueurDeGrille = grilles[i].getVainqueur();
			if(vainqueurDeGrille != null) {
				System.arraycopy(vainqueurDeGrille, 0, res, 1, 2);
				res[0] = "G" + i;
				return res;
			}
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
	
	/**
	 * Renvoie une représentation textuelle d'un groupe abstrait des grilles.
	 */
	public String toString() {
		return this.getClass().getSimpleName() + " [ nombreDeGrilles : " + this.nombreDesGrilles
				+ ", independantes : " + this.independantes 
				+ ", grilles : " + Arrays.toString(grilles) + " ]"; 
	}
	

}
