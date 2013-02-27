package core;

import java.util.*;

public class Grille {
	
	public static final String X = "X";
	public static final String O = "O";
	public static final String VIDE = ""; 
	
	public static final String LIGNE = "ligne";
	public static final String COLONNE = "colonne";
	
	private final int size;
	private String[][] tableau;
	
	public Grille(int size) {
		this.size = size;
		tableau = new String[size][size];
	}
	
	public boolean gagne() {
		
	}
	
	private boolean aligneLigneColonneLettre(String lettre,String ligneOuColonne, int nu)
	
	public boolean ajouterLettre(String lettre,int ligne,int colonne) {
		if(!lettre.equals(X) && !lettre.equals(O)) return false;
		if(ligne < 0 || ligne >= size) return false;
		if(colonne < 0 || ligne >= size) return false;
		if(tableau[ligne][colonne] == VIDE ) return false; 
		this.tableau[ligne][colonne] = lettre;
		return true;
	}
	
	
	public String toString() {
		return "Grille [ size : " + this.size + ", tableau : " + Arrays.toString(this.tableau) + " ]";
	}

}
