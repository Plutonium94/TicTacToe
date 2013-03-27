package ihm.menu;

import devintAPI.MenuAbstrait;

@SuppressWarnings("serial")
public class MenuChoixDifficulte extends MenuAbstrait {

	public MenuChoixDifficulte() {
		super("Choisir la difficulté");
	}
	@Override
	protected String[] nomOptions() {
		return new String[]{"Facile","Moyenne","Difficile"};
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
