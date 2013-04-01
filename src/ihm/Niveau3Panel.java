package ihm;

import core.GroupeGrilleDependantes;

public class Niveau3Panel extends GroupeGrillePanel {
	
	public Niveau3Panel() {
		super(3,3,false);
	}
	
	@Override
	public void winCheckFormalities() {
		GroupeGrilleDependantes ggd = new GroupeGrilleDependantes(grilles);
		if((vainqueur = ggd.getVainqueur()) != null) {
			superPanel.revalidate();
			superPanel.repaint();
		}
	}

}
