package ihm;

import core.GroupeGrilleDependantes;

public class Niveau3Panel extends GroupeGrillePanel {
	
	private JeuFrame jeuFrame;
	
	public Niveau3Panel() {
		super(3,3,false);
	}
	
	public Niveau3Panel(JeuFrame jf) {
		this();
		this.setJeuFrame(jf);
	}
	
	public void setJeuFrame(JeuFrame jeuFrame) {
		this.jeuFrame = jeuFrame;
	}
	
	@Override
	public void winCheckFormalities() {
		GroupeGrilleDependantes ggd = new GroupeGrilleDependantes(grilles);
		if((vainqueur = ggd.getVainqueur()) != null) {
			jeuFrame.getMessagePanel().setMessage("Niveau 3 gagné");
			superPanel.revalidate();
			superPanel.repaint();
		}
	}

}
