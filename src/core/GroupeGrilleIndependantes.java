package core;

import java.util.*;

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
		//System.out.println("In the beginning of ggi getVainquer " + Arrays.deepToString(grilles));
		Cas[] res1 = null;
		Cas[] res2 = new Cas[taille];
		//int marquer =0;
		//boolean hasWinner = false;
		Cas[][] vainqueurs = new Cas[grilles.length][grilles[0].getTaille()];
		for(int i=0; i< grilles.length; i++) {
			vainqueurs[i] = grilles[i].getVainqueur();
			/*Cas[] temp;
			//if(marquer == 0) System.out.println(grilles[i].getVainqueur());
			if(marquer == 0 && (temp = grilles[i].getVainqueur()) != null) {
				res1 = temp;
				System.out.println("res1 initialised");
				marquer++;
			}
			if(marquer != 0 && (res2 = grilles[i].getVainqueur()) != null) {
				if(res1[0].getLettre().equals(res2[0])) {
					hasWinner=true;
				}
			}*/
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
			if(xCpt > oCpt && xCpt > 1 && vainqueurs[i][0].getLettre().equals(Lettre.X)) {
				res.addAll(Arrays.asList(vainqueurs[i]));
			} else if(xCpt < oCpt && oCpt > 1 && vainqueurs[i][0].getLettre().equals(Lettre.O)) {
				res.addAll(Arrays.asList(vainqueurs[i]));
			}
		}
		return res.toArray(new Cas[0]);
		/*if(hasWinner) {
			System.out.println("has winner has winner has winner");
			List<Cas> liste = new ArrayList<Cas>();
			liste.addAll(Arrays.asList(res1));
			liste.addAll(Arrays.asList(res2));
			System.out.println("Hey soul " + liste);
			return liste.toArray(new Cas[0]);
		} if(this.nombreDesGrilles == 1) {
			System.out.println("ggi res1 : " +Arrays.toString(grilles));
			return res1;
		}
		return null;*/
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
