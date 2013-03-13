package tests;

import core.*;
import static core.Lettre.*;
import static java.lang.System.out;
import static tests.Util.*;


/**
 * Pas beaucoup de test fait ici car c'est presque pareil de la Class Grille que j'ai déjà testé 
 * soigneusement
 * @author Daniel
 *
 */
public class GroupeGrilleIndependantesTest {
	
	public static void main(String[] args) {
		// test gagne vrai
		out.println("test gagne vrai");
		GroupeGrilleAbstrait ggi1 = Util.initGroupe(true, tableauToGrille(X,O,X,O,null,O,O,O,X),
														tableauToGrille(null,null,null,null,null,null,null,null,null),
														tableauToGrille(X,X,null,O,O,X,O,O,O));
		out.println(ggi1);
		out.println(show(ggi1.getVainqueur()));
		
		// test gagne faux
		out.println("\ntest gagne faux");
		GroupeGrilleAbstrait ggi2 = Util.initGroupe(true, tableauToGrille(X,null,null,X,O,X,O,X,O),
													tableauToGrille(X,O,O,O,O,X,null,null,X),
													tableauToGrille(null,null,null,null,null,null,null,null,null));
		out.println(ggi2);
		out.println(show(ggi2.getVainqueur()));
	}

}
