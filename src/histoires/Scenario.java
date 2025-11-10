package histoires;

import personnages.Druide;
import personnages.matos.Equipement;
import personnages.Gaulois;
import personnages.Romain;

//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.fabriquerPotion(5, 2);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			System.out.println("\nFRAPPE");
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		System.out.println("\nAUTRE GAULOIS");
		
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			System.out.println("\nFRAPPE");
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);
		
		System.out.println("\nEND\n");
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}