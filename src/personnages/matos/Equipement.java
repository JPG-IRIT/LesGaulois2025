package personnages.matos;

public enum Equipement {

	CASQUE("casque"), BOUCLIER("bouclier");
	
	private final String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
}
