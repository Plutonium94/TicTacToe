package core;

/**
 * Cette classe mod�lise un groupe des grilles o� les grilles sont ind�pendantes
 * de l'une et l'autre.
 * @author Daniel
 *
 */
public class GroupeGrilleIndependantes extends GroupeGrilleAbstrait {
	
	/**
	 * Initialize un groupe des grilles ind�pendantes avec le nombre des grilles 
	 * et la taille donn�e
	 * @param nombreDesGrilles
	 * @param taille
	 */
	public GroupeGrilleIndependantes(int nombreDesGrilles,int taille) {
		super(nombreDesGrilles,taille,true);
	}
	
	public Cas[] getVainqueur() {
		Cas[] res = new Cas[getTaille()];
		if((res = super.getVainqueur()) != null) return res;
		return null;
	}
	
	/**
	 * Renvoie une repr�sentation textuelle du groupe des grilles 
	 * ind�pendantes.
	 */
	public String toString() {
		return "GroupeGrillsIndependantes [ nombreDesGrilles : " + super.getNombreDeGrilles() +
				", taille : " + super.getGrilles()[0].getTaille() + " ]";
	}

}
