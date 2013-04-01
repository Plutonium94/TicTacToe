package core;

import java.util.*;

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
	
	GroupeGrilleIndependantes(Grille[] grilles) {
		super(grilles.length,grilles[0].getTaille(),true);
	}
	
	@Override
	public Cas[] getVainqueur() {
		Cas[] res1 = new Cas[taille];
		Cas[] res2 = new Cas[taille];
		int marquer =0;
		boolean hasWinner = false;
		for(int i=0; i< grilles.length; i++) {
			if((res1 = grilles[i].getVainqueur()) != null) marquer++;
			if(marquer != 0 && (res2 = grilles[i].getVainqueur()) != null) hasWinner=true; 
		}
		if(hasWinner) {
			List<Cas> liste = new ArrayList<Cas>();
			liste.addAll(Arrays.asList(res1));
			liste.addAll(Arrays.asList(res2));
			return liste.toArray(new Cas[0]);
		}
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
