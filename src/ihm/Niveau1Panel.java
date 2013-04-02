package ihm;

import java.util.Arrays;

import core.*;

public class Niveau1Panel extends GroupeGrillePanel {
	
	private JeuFrame jeuFrame = null;
	
	public Niveau1Panel() {
		super(1,3,true);
	}
	
	public Niveau1Panel(JeuFrame jf) {
		this();
		this.setJeuFrame(jf);
	}
	
	public void setJeuFrame(JeuFrame jeuFrame) {
		this.jeuFrame = jeuFrame;
	}
	
	@Override
	public void winCheckFormalities() {
		GroupeGrilleIndependantes ggi = new GroupeGrilleIndependantes(grilles);
		System.out.println("win check n1 " +Arrays.deepToString(grilles));
		if((vainqueur = ggi.getVainqueur()) != null) {
			System.out.println("niveau1panel  won");
			jeuFrame.getMessagePanel().setMessage("Niveau 1 gagné");
			jeuFrame.getContentPane().repaint();
			superPanel.revalidate();
			superPanel.repaint();
		}
	}

}
