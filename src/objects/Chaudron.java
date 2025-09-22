package objects;

public class Chaudron {

	int quantitePotion;
	int forcePotion;
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		return quantitePotion > 0;
	}
	
	public int prendreLouche() {
		int forceRetour = this.forcePotion;
		this.quantitePotion -= 1;
				
		if (this.quantitePotion == 0 ) {
			this.forcePotion  = 0;
		} 
		
		return forceRetour;
	}
}
