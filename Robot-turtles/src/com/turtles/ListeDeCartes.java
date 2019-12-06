package com.turtles;
import java.util.ArrayList;


public class ListeDeCartes {
	
	protected ArrayList<Carte> cardsList = new ArrayList<>();
	protected int taille = 0;
	protected int tailleMax;
	
	
	public ListeDeCartes() {
		
	}
	
	
	
	
	
	public ArrayList<Carte> getCardsList() {
		return this.cardsList;
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
	
	public void setCardsList(ArrayList<Carte> cardsList) {
		this.cardsList = cardsList;
	}
	
	public void ajouterCarte(Carte carte) {
		
		//peut etre ajouter une verif que la taille max n'a pas ete atteinte (pour le board et pour la defausse)
		
		this.cardsList.add(carte);
		setTaille(this.cardsList.size());
	}
	
	public void retirerUneCarte(int index) {
		this.cardsList.remove(index);
		setTaille(this.cardsList.size());
	}
	
	public void retirerPremiereCarte() {
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
	
	public void afficheLaListe() {
		
		for (Carte carte : this.cardsList) {
			System.out.print(carte.getType() + " ");
		}
		System.out.println();
	}
	
	public void clearListe() {
		this.cardsList.clear();
	}

}
