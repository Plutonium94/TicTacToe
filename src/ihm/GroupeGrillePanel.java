package ihm;

import javax.swing.*;
import static core.Lettre.*;

import java.awt.*;
import core.*;
import java.awt.event.*;

public class GroupeGrillePanel extends GroupeGrilleAbstrait implements MouseListener {
	
    GrillePanel[] grillePanels;
	private Lettre lettreCourante = O;
	private Cas[] vainqueur = null;
	
	JPanel superPanel = new JPanel();
	
	
	public GroupeGrillePanel(int nombreDeGrilles, int taille, boolean independantes) {
		super(nombreDeGrilles,taille,independantes);
		grillePanels = new GrillePanel[nombreDeGrilles];
		frameFormalities();
		addToPanel();
		superPanel.setBackground(Color.GREEN);
	}
	
	public GroupeGrillePanel(GroupeGrilleAbstrait gga) {
		this(gga.getNombreDeGrilles(),gga.getTaille(),gga.sontIndependantes());
	}
	
	public void winCheckFormalities() {
		vainqueur = super.getVainqueur();
		System.out.println(super.toString());
		if(vainqueur !=null) {
			System.out.println("win check formalities entered");
			superPanel.revalidate();
			superPanel.repaint();
		}
	}
	
	private void frameFormalities() {
		superPanel.setSize(300,300);
		superPanel.addMouseListener(this);
		superPanel.setVisible(true);
	}
	
	private void addToPanel() {
		superPanel.setLayout(new BoxLayout(superPanel,BoxLayout.X_AXIS));
		for(int i=0; i<nombreDesGrilles;i++) {
			GrillePanel grillePanel = new GrillePanel(i,taille,this);
			grillePanels[i] = grillePanel;
			superPanel.add(grillePanel.panel);
			Box.createVerticalGlue();
		}
		//frame.add(this.superPanel);
	}
	
	public JPanel getPanel() {
		return superPanel;
		//return new GroupeGrillePanel(this.nombreDesGrilles,this.taille,this.independantes);
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//grillePanel.panel.revalidate();
		//grillePanel.panel.repaint();
		System.out.println("groupegrille panel clicked");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Lettre getLettreCourante() {
		return lettreCourante;
	}
	
	public boolean ajouterLettre(int idGrille, Lettre lettre, int ligne, int colonne) {
		return super.ajouterLettre(idGrille, lettre, ligne, colonne);
	}
	
	public void changerLettre() {
		if(lettreCourante.equals(O)) {
			lettreCourante = X;
		}
		else if(lettreCourante.equals(X)) lettreCourante = O;
		else throw new RuntimeException("Changer lettre inconnue");
	}

}
