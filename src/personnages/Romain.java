package personnages;

import personnages.matos.Equipement;

public class Romain {

	private String nom;
	private int force;

	// TP3
//	private String texte; // -> moved to local

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

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	// TP3 : mise en comment
//	public void recevoirCoup(int forceCoup) {
//
//		// TP2
//		assert isInvariantVerified(forceCoup);
//		int saveForce = this.force;
//
//		this.force -= forceCoup;
//
//		if (this.force < 1) {
//			this.force = 0;
//			parler("J'abandonne !");
//		} else {
//			parler("Aïe");
//		}
//
//		// TP2
//		assert isInvariantVerified(this.force);
//		assert (this.force < saveForce);
//	}

	private Boolean isInvariantVerified(int force) {
		return (force > 0);
	}

	// TP3
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		switch (force) {
//		case 0:
//			parler("Aïe");
		////			break;
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	// TO3
//	private int CalculResistanceEquipement(int forceCoup) {
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force
				+ ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
//		if (!(nbEquipements == 0)) {
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipements;) {
				if ((equipements[i] != null &&
//						equipements[i].equals(Equipement.BOUCLIER)) == true) {
						equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
//			texte =+ resistanceEquipement + "!";
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;

//      if (forceCoup < 0) 
//      forceCoup = 0;
		forceCoup = (forceCoup < 0) ? 0 : forceCoup;
		// ERREUR initiale : sinon bug car soustraciton de nombre négatif

		return forceCoup;
	}

	// TP3
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
//		System.out.println("L'équipement de " + nom.toString() 
//						+ " s'envole sous la force du coup.");
		System.out.println("L'équipement de " + nom
				+ " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] == null) {
//				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
