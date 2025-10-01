package personnages;

import personnages.matos.Equipement;

public class Romain {

	private String nom;
	private int force;

	// TP2
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;

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

	// TP2
	public void sEquiper(Equipement eq) {
		switch (nbEquipements) {
		case 0:
			stockerEquipement(eq);
			break;

		case 1:
			if (!equipements[0].equals(eq)) {
				stockerEquipement(eq);
			} else {
				System.out.println("Le soldat " + nom 
						+ " possède déjà un " + eq);
			}
			break;

		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;

		default:
			System.out.println("ERROR : ne devrait pas arriver");
			break;
		}

	}

	private void stockerEquipement(Equipement eq) {
		equipements[nbEquipements] = eq;
		nbEquipements++;
		System.out.println("Le soldat " + nom
				+ " s’équipe avec un " + eq);
	}

	// tests de Romain
	public static void main(String[] args) {
		System.out.println("TESTS ROMAIN \n");

//		Romain minus = new Romain("Minus", -6);
		Romain minus = new Romain("Minus", 6);

		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		
		System.out.println("\n");
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

}
