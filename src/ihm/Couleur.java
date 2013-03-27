package ihm;

import static java.awt.Color.*;

import java.awt.Color;

/**
 * Représente des couleurs fixes.
 * @author Daniel
 *
 */
public enum Couleur {
	CLR1(new Color(0,0,80)),
	CLR2(Color.YELLOW);
	
	private Color color;
	
	private Couleur(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	

}
