package test_fonctionnel;

import java.nio.file.spi.FileSystemProvider;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {

	public static void main(String[] args) {
		System.out.println("BEGIN Les Gaulois 2025 \n");
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		
		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		
		Romain minus = new Romain("Minus", 6);
		
		System.out.println("Dans la forêt " + asterix + " et " + obelix 
				+ " tombent nez à nez sur le romain " + minus.getNom());
		
		for (int i = 1; i <= 3; i++) {
			asterix.frapper(minus);
		}
		
		System.out.println();
		
		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 14);
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		
		for (int i = 1; i <= 3; i++) {
			asterix.frapper(brutus);
		}
	}
	
}
