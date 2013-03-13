package core;

public enum Lettre {
	
	X("X"),
	O("O");
	
	private String valeur;
	
	private Lettre(String valeur) {
		this.valeur = valeur;
	}
	
	public String getValeur() {
		return this.valeur;
	}
	
	public String toString() {
		return valeur;
	}
}
