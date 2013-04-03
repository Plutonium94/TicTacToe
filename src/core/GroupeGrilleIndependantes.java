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
	
	public GroupeGrilleIndependantes(Grille[] grilles) {
		super(grilles.length,grilles[0].getTaille(),true);
		for(int grille =0; grille<this.grilles.length; grille++) {
			int grilleSize = this.grilles[grille].getTaille();
			for(int ligne=0; ligne< grilleSize; ligne++) {
				for(int colonne = 0; colonne <grilleSize;colonne++) {
					this.grilles[grille].ajouterLettre(grilles[grille].getValeurCas(ligne, colonne), ligne, colonne);
				}
			}
		}
	}
	
	@Override
	public Cas[] getVainqueur() {
		Cas[][] vainqueurs = new Cas[grilles.length][grilles[0].getTaille()];
		for(int i=0; i< grilles.length; i++) {
			vainqueurs[i] = grilles[i].getVainqueur();
		}
		if(this.nombreDesGrilles == 1) {
			//System.out.println("ggi res1 : " +Arrays.toString(grilles));
			return vainqueurs[0];
		}
		int xCpt = 0;
		int oCpt = 0;
		for(int i = 0; i<vainqueurs.length;i++) {
			if(vainqueurs[i] == null) continue;
			if(vainqueurs[i][0].getLettre().equals(Lettre.X)) xCpt++;
			else oCpt++;
		}
		if(xCpt == oCpt) return null;
		List<Cas> res = new ArrayList<Cas>();
		for(int i=0; i<vainqueurs.length;i++) {
			if(vainqueurs[i]==null) continue;
			if(xCpt > oCpt && xCpt > 1 && vainqueurs[i][0].getLettre().equals(Lettre.X)) {
				res.addAll(Arrays.asList(vainqueurs[i]));
			} else if(xCpt < oCpt && oCpt > 1 && vainqueurs[i][0].getLettre().equals(Lettre.O)) {
				res.addAll(Arrays.asList(vainqueurs[i]));
			}
		}
		return res.toArray(new Cas[0]);
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
