import java.util.ArrayList;


public class ListeDeCartes {
	
	protected ArrayList<Carte> cardsList = new ArrayList<>();
	protected int taille = 0;
	protected int tailleMax;
	
	
	public ListeDeCartes() {
		
	}
	
	
	
	
	
	public ArrayList<Carte> getCardsList() {
		return this.getCardsList();
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public int getTailleMax() {
		return this.tailleMax;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void setTailleMax(int tailleMax) {
		this.tailleMax = tailleMax;
	}
	
	public void ajouterCarte(Carte carte) {
		
		//peut etre ajouter une verif que la taille max n'a pas ete atteinte (pour le board et pour la defausse)
		
		this.cardsList.add(carte);
		setTaille(this.cardsList.size());
	}
	
	public void retirerPremierCarte() {
		if (this.taille != 0) {
			cardsList.remove(0);
		}
		
		setTaille(this.cardsList.size());
		
	}
	
	public Carte creationDeCarte(String type) {
		
		Carte carte = new Carte(type);
		
		cardsList.add(carte);
		
		return carte;
	}

}
