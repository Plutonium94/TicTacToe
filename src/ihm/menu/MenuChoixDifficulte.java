package ihm.menu;

import ihm.JeuFrame;
import devintAPI.MenuAbstrait;

@SuppressWarnings("serial")
public class MenuChoixDifficulte extends MenuAbstrait {

	public MenuChoixDifficulte() {
		super("Choisir la difficulté");
	}
	@Override
	protected String[] nomOptions() {
		return new String[]{"Facile","Moyenne","Difficile","Retour"};
	}

	@Override
	protected void lancerOption(int i) {
		this.dispose();
		switch(i) {
			case 0 : new JeuFrame();
			case 1 : new JeuFrame();
			case 2 : new JeuFrame();
			case 3 : new MenuChoixAdversaire();
		}

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
