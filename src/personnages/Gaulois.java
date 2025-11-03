package personnages;

import lieux.Village;
import personnages.matos.Equipement;

public class Gaulois {

	private String nom;
//	private int force;  // TP3 : comment

	// TP3
//	private int force, nb_trophees;
	private int force;
	private int  nbTrophees;
//	private Equipement trophees[] = new Equipement[100];
	private Equipement[] trophees = new Equipement[100];

	private int effetPotion = 1;

	// TP2
	private Village village;
	private String msg;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village v) {
		this.village = v;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public void sePresenter() {
		String s = "";
		s += "Bonjour, je m'apelle " + nom
				+ "." + msg;
		if (!(village == null)) {
			s += village.getNom();
		}

		parler(s);
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	// TP3 : comment
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	// TP3
	private String prendreParole() {
//		String texte = "Le gaulois " + nom + " : ";
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		String nomRomain = romain.getNom();
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
//		int forceCoup = force / 3;
//		romain.recevoirCoup(forceCoup);
//	}

	// TP3 : comment
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force * effetPotion) / 3);
//		effetPotion -= 1;
//		if (effetPotion < 1) {
//			effetPotion = 1;
//		}
//	}

	// TP3
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " +
				romain.getNom());
//		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		Equipement[] tropheesRecus = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecus != null 
					 && i < tropheesRecus.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRecus[i];
		}
//		return;
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	@Override
	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + "]";
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

}
