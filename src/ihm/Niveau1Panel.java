package ihm;

import java.util.Arrays;

import core.*;

public class Niveau1Panel extends GroupeGrillePanel {
	
	public Niveau1Panel() {
		super(1,3,true);
	}
	
	@Override
	public void winCheckFormalities() {
		GroupeGrilleIndependantes ggi = new GroupeGrilleIndependantes(grilles);
		System.out.println("win check n1 " +Arrays.deepToString(grilles));
		if((vainqueur = ggi.getVainqueur()) != null) {
			System.out.println("niveau1panel  won");
			superPanel.revalidate();
			superPanel.repaint();
		}
	}

}
