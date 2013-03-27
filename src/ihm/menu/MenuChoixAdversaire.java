package ihm.menu;

import devintAPI.*;

@SuppressWarnings("serial")
public class MenuChoixAdversaire extends MenuAbstrait {
	
	public MenuChoixAdversaire() {
		super("Choisir l'adversaire");
	}

	@Override
	protected String[] nomOptions() {
		return new String[]{"Jouer contre un humain","Jouer contre l'ordinateur"};
	}

	@Override
	protected void lancerOption(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String wavAccueil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String wavRegleJeu() {
		// TODO Auto-generated method stub
		return null;
	}

}
