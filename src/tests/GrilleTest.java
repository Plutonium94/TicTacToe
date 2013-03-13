package tests;

import java.util.Arrays;

import core.*;
import static java.lang.System.out;
import static core.Lettre.*;
import static tests.Util.*;

public class GrilleTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("colonne test vrai");
		Grille grille1 = tableauToGrille(X,O,null,X,O,O,O,O,null);
		out.println(grille1);
		out.println(Arrays.toString(grille1.getVainqueur()));
		
		out.println("\ncolonne test faux");
		Grille grille2 = tableauToGrille(X,null,null,O,X,O,X,null,O);
		out.println(grille2);
		out.println(show(grille2.getVainqueur()));
		
		out.println("\nligne test vrai");
		Grille grille3 = tableauToGrille(O,X,null,X,X,X,O,O,null);
		out.println(grille3.toString());
		out.println(show(grille3.getVainqueur()));
		
		out.println("\nligne test faux");
		Grille grille4 = tableauToGrille(O,X,O,X,O,X,null,null,null);
		out.println(grille4);
		out.println(show(grille4.getVainqueur()));
		
		out.println("\nanti-slash test vrai");
		Grille grille5 = tableauToGrille(O,null,O,O,O,null,X,null,O);
		out.println(grille5);
		out.println(show(grille5.getVainqueur()));
		
		out.println("\nanti-slash test faux");
		Grille grille6 = tableauToGrille(O,X,null, null,null,X, O,O,null);
		out.println(grille6);
		out.println(show(grille6.getVainqueur()));
		
		out.println("\nslash test vrai");
		Grille grille7 = tableauToGrille(X,O,X,  O,X,O,  X,O,O);
		out.println(grille7);
		out.println(show(grille7.getVainqueur()));
		
		out.println("\nslash test faux");
		Grille grille8 = tableauToGrille(X,X,null, X,null,X, null,X,X);
		out.println(grille8);
		out.println(show(grille8.getVainqueur()));

	}
}
