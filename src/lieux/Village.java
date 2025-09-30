package lieux;

import personnages.Gaulois;

// TP POO2
public class Village {

	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0; 
	
	public Village(String nom, Gaulois chef, final int NB_VILAGEOIS_MAX) {
		this.nom = nom;
		this.chef = chef;
		villageois = new Gaulois[NB_VILAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterVillageois(Gaulois g) {
		villageois[nbVillageois] = g;
		nbVillageois++;
	}
	
	public Gaulois trouverVillageois(int num) {
		if (num <= nbVillageois) {
			return villageois[num - 1];
		} else {
			System.out.println("Il n’y a pas autant"
					+ "d'habitants dans notre village !");
			return null;
		}
	}
	
	public void afficherVillageois() {
		String msg = "";
		msg += "Village : " + nom + "\n";
		msg += "   chef : " + chef + "\n";
		msg += "   villageois : " + "\n";
		for (int i = 0; i < nbVillageois; i++) {
			msg += "      - " + villageois[i] + "\n"; 
		}
		System.out.println(msg);
	}


	// tests du village
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", 
										abraracourcix, 30) ;
		
		Gaulois gaulois = village.trouverVillageois(30);
		
		System.out.println("\n");
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		
		gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		
		System.out.println("\n");
		
		village.afficherVillageois();
		
		System.out.println("\n");
		
		Gaulois obelix = new Gaulois("Obélix", 16);
		village.ajouterVillageois(obelix);
		obelix.setVillage(village);
		obelix.setMessage(" J'habite le village : ");
		
		asterix.setVillage(village);
		asterix.setMessage(" J'habite le village : ");
		
		abraracourcix.setVillage(village);
		abraracourcix.setMessage(" Je suis le chef du village : ");
		
		Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);
		doublePolemix.setMessage(" Je voyage de village en village");
		
		village.afficherVillageois();
	
		System.out.println("\n");
		
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
	
	
	
}
