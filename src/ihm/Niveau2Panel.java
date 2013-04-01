package ihm;

import core.*;

public class Niveau2Panel extends GroupeGrillePanel {
	
	public Niveau2Panel() {
		super(3,3,true);
	}
	
	@Override
	public void winCheckFormalities() {
		GroupeGrilleIndependantes ggi = new GroupeGrilleIndependantes(this.grilles);
		if((vainqueur = ggi.getVainqueur()) !=null) {
			superPanel.revalidate();
			superPanel.repaint();
		}
	}

}
