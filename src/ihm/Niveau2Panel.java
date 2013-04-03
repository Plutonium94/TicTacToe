package ihm;

import core.*;

public class Niveau2Panel extends GroupeGrillePanel {
	
	private JeuFrame jeuFrame;
	
	public Niveau2Panel() {
		super(3,3,true);
	}
	
	public Niveau2Panel(JeuFrame jf) {
		this();
		this.setJeuFrame(jf);
	}
	
	public void setJeuFrame(JeuFrame jeuFrame) {
		this.jeuFrame = jeuFrame;
	}
	
	@Override
	public void winCheckFormalities() {
		GroupeGrilleIndependantes ggi = new GroupeGrilleIndependantes(this.grilles);
		//System.out.println("Checking checking ckecing checking checking");
		if((vainqueur = ggi.getVainqueur()) !=null) {
			this.jeuFrame.getMessagePanel().setMessage("Niveau 2 gagné");
			superPanel.revalidate();
			superPanel.repaint();
		}
	}

}
