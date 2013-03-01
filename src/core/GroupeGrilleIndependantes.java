package core;

/**
 * Cette classe modélise un groupe des grilles où les grilles sont indépendantes
 * de l'une et l'autre.
 * @author Daniel
 *
 */
public class GroupeGrilleIndependantes extends GroupeGrilleAbstrait {
	
	/**
	 * Initialize un groupe des grilles indépendantes avec le nombre des grilles 
	 * et la taille donnée
	 * @param nombreDesGrilles
	 * @param taille
	 */
	public GroupeGrilleIndependantes(int nombreDesGrilles,int taille) {
		super(nombreDesGrilles,taille,true);
	}
	
	/**
	 * Renvoie une représentation textuelle du groupe des grilles 
	 * indépendantes.
	 */
	public String toString() {
		return "GroupeGrillsIndependantes [ nombreDesGrilles : " + super.getNombreDeGrilles() +
				", taille : " + super.getGrilles()[0].getTaille() + " ]";
	}

}
