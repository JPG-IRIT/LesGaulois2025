package Personnages;

import objects.Chaudron;

public class Druide {

	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique." 
				+ " Elle a une force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		if (chaudron.resterPotion()) {
			if (gaulois.getNom().equals("Obélix")) {
				parler("Non " + gaulois
						+ ". Non ! ... Et tu le sais très bien");
			} else {
				int force = chaudron.prendreLouche();
				gaulois.boirePotion(force);
				parler("Tiens, " + gaulois
						+ ", un peu de potion magique.");
			}
		} else {
			parler("Désolé " + gaulois + ", "
					+ "il n'y a plus une seule goute de potion.");
		}
	}
}
