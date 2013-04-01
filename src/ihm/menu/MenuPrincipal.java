package ihm.menu;

import devintAPI.MenuAbstrait;

@SuppressWarnings("serial")
public class MenuPrincipal extends MenuAbstrait {

	public MenuPrincipal() {
		super("Tic Tac Toe");
	}

	@Override
	protected String[] nomOptions() {
		return new String[]{"Nouveau Jeu","Quitter"};
	}

	@Override
	protected void lancerOption(int i) {
		this.dispose();
		MenuAbstrait menu = null;
		switch(i) {
			case 0 : menu = new MenuChoixAdversaire(); break;
			case 1 : System.exit(0);
		}
		this.dispose();
		if(menu != null) menu.setVisible(true);
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
