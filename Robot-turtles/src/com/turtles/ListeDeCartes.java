package com.turtles;

import java.util.ArrayList;

public class ListeDeCartes {

	protected ArrayList<Carte> cardsList = new ArrayList<>();
	protected int taille = 0;

	public ListeDeCartes() {

	}

	public ArrayList<Carte> getCardsList() {
		return this.cardsList;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void setCardsList(ArrayList<Carte> cardsList) {
		this.cardsList = cardsList;
	}

	public void ajouterCarte(Carte carte) {

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

}
