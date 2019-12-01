import java.util.Collections;

public class Deck extends ListeDeCartes{
	
	
	public Deck(){
		super();
		
		for (int i = 0; i < 18; i++) {
			super.creationDeCarte("Bleue");
		}
		
		for (int j = 0; j < 8; j++) {
			super.creationDeCarte("Jaune");
			super.creationDeCarte("Violette");
		}
		
		for (int k = 0; k < 3; k++) {
			super.creationDeCarte("Laser");
		}
		
		melangeLeDeck();
		
	}
	
	
	
	public void melangeLeDeck() {
		Collections.shuffle(this.cardsList);
	}
	
	
	
	
	

}
