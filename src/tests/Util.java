package tests;

import java.util.Arrays;

import core.*;
import core.Lettre;

public class Util {
	
	public static Grille tableauToGrille(Lettre... lettres) {
		int taille = (int)Math.sqrt(lettres.length);
		Grille res = new Grille(taille);
		for(int i=0;i<lettres.length;i++) {
			res.ajouterLettre(lettres[i], i/taille, i%taille);
		}
		return res; 
	}
	
	
	public static String show(Object[] objets) {
		//if(objects == n)
		return Arrays.toString(objets);
	}
	
	public static GroupeGrilleAbstrait initGroupe(boolean indepandantes,Grille... grilles) {
		GroupeGrilleAbstrait res;
		int taille = grilles[0].getTaille();
		if(indepandantes) {
			res = new GroupeGrilleIndependantes(grilles.length,taille);
		} else {
			res = new GroupeGrilleDependantes(grilles.length);
		}
		for(int numeroGrille = 0;numeroGrille<grilles.length;numeroGrille++) {
			for(int ligne = 0; ligne <taille; ligne++ ) {
				for(int colonne = 0; colonne < taille; colonne++) {
					res.ajouterLettre(numeroGrille, grilles[numeroGrille].getValeurCas(ligne, colonne), ligne, colonne);
				}
			}
		}
		return res;
	}

}
