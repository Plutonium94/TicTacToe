package tests;

import core.*;

import static java.lang.System.out;
import static core.Lettre.*;
import static tests.Util.*;

public class GroupeGrilleDepandantesTest {
	
	

	public static void main(String[] args) {
		// alignement classsique reussi
		out.println("alignement classsique reussi");
		GroupeGrilleDependantes ggd1 = (GroupeGrilleDependantes)Util.initGroupe(
				false,
				tableauToGrille(X,O,O,O,X,O,O,O,X),
				tableauToGrille(null,X,null,O,O,null,O,X,X),
				tableauToGrille(null,X,null,O,O,null,O,X,X));
		out.println(ggd1);
		out.println(show(ggd1.getVainqueur()));
		out.println("the end");
		
		// alignement classique echoue
		out.println("\nalignement classique echoue");
		GroupeGrilleDependantes ggd2 = (GroupeGrilleDependantes)Util.initGroupe(
				false,
				tableauToGrille(null,X,null,O,O,null,O,X,X),
				tableauToGrille(null,X,null,O,O,null,O,X,X),
				tableauToGrille(null,X,null,O,O,null,O,X,X));
		out.println(ggd2);
		out.println(show(ggd2.getVainqueur()));
		
		// alignement colonne non-incline Z reussi
		out.println("\nalignement colonne non-incline Z reussi");
		GroupeGrilleDependantes ggd3 = (GroupeGrilleDependantes)Util.initGroupe(
				false,
				tableauToGrille(null,null,O,null,null,null,null,null,X),
				tableauToGrille(null,null,O,null,null,null,null,null,X),
				tableauToGrille(null,null,O,null,null,null,null,null,null));
		out.println(ggd3);
		out.println(show(ggd3.getVainqueur()));
		
		// alignement colonne incliné Z reussi
		out.println("\nalignement colonne incline Z reussi");
		GroupeGrilleDependantes ggd4 = (GroupeGrilleDependantes)Util.initGroupe(
				false,
				tableauToGrille(null,O,null,null,null,null,null,null,null),
				tableauToGrille(X,O,O,O,O,X,null,null,null),
				tableauToGrille(null,null,null,X,O,O,O,O,X));
		out.println(ggd4);
		out.println(show(ggd4.getVainqueur()));
		
		// alignement ligne incline Z reussi
		out.println("\nalignement ligne incline reussi");
		GroupeGrilleDependantes ggd5 = (GroupeGrilleDependantes)Util.initGroupe(false,
					tableauToGrille(O,X,O,null,null,O,null,X,null,X),
					tableauToGrille(null,O,null,null,null,null,X,X,O),
					tableauToGrille(null,null,O,null,null,null,null,null,null));
		out.println(ggd5);
		out.println(show(ggd5.getVainqueur()));
		
		// alignement anti-slash Z reussi
		out.println("\nalignemnt anti-slash Z reussi");
		GroupeGrilleDependantes ggd6 = (GroupeGrilleDependantes)Util.initGroupe(false,
				tableauToGrille(O,null,null,null,null,null,null,null,null),
				tableauToGrille(null,null,null,X,O,O,X,O,O),
				tableauToGrille(X,X,O,null,null,null,X,O,O));
		out.println(ggd6);
		out.println(show(ggd6.getVainqueur()));
		
		// alignement slash Z reussi
		out.println("\nalignement slash Z reussi");
		GroupeGrilleDependantes ggd7 = (GroupeGrilleDependantes)Util.initGroupe(false,
				tableauToGrille(null,null,null,null,null,null,null,null,X),
				tableauToGrille(null,null,null,X,X,O,null,X,O,O),
				tableauToGrille(X,O,O,null,null,null,X,O,O));
		out.println(ggd7);
		out.println(show(ggd7.getVainqueur()));
				
	}
	

}
