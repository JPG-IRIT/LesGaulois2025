package personnages;

public class Romain {

	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		
		// TP2
		assert isInvariantVerified(force);
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		
		// TP2
		assert isInvariantVerified(forceCoup);
		int saveForce = this.force;
		
		this.force -= forceCoup;
		
		if (this.force < 1) {
			this.force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		
		// TP2
		assert isInvariantVerified(this.force);
		assert (this.force < saveForce);
	}
	
	
	private Boolean isInvariantVerified(int force) {
		return (force > 0);
	}
	
	// tests de Romain
	public static void main(String[] args) {
		System.out.println("TESTS ROMAIN \n");
		
//		Romain minusRomain = new Romain("Minus", -6);
		Romain minusRomain = new Romain("Minus", 6);
				
	}
	
}
