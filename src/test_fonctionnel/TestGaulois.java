package test_fonctionnel;

import Personnages.Gaulois;
import Personnages.Romain;

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
		
	}
	
}
