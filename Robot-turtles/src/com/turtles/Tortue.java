package com.turtles;

import java.util.HashMap;

public class Tortue {

	private String color;
	private int xPos;
	private int initialxPos;
	private int yPos;
	private int initialyPos;
	private char initialDirection = 'S';

	private char direction;

	private char symbol;

	private Hand main;
	private Defausse defausse;
	private Deck deck;
	private Programme programme;

	// variable qui permet de savoir si la tortue a fini ou non
	private boolean aFini = false;

	private HashMap<String, Integer> inventaire = new HashMap<String, Integer>(); // on cree une map avec les murs
																					// (pierre et glace et plus tard
																					// caisse) et le nombre restant dans
																					// l'inventaire du joueur

	private int score = 0;

	public Tortue() {

	}

	public Tortue(String color) {
		this.color = color;

		this.direction = 'S';

		setSymbol();

		deck = new Deck();
		main = new Hand();
		for (int i = 0; i < 5; i++) {
			pioche();
		}

		defausse = new Defausse();

		programme = new Programme();
		// creation de listes de cartes

		// creation de l'inventaire
		this.inventaire.put("murDeGlace", 2);
		this.inventaire.put("murDePierre", 3);

	}

	public HashMap<String, Integer> getInventaire() {
		return this.inventaire;
	}

	public void avance() {

		// on doit verifier que la position est valide avant de deplacer grace a la
		// fonction deplacementvalide()

		if (Game.plateau.deplacementValide(this.direction, this.xPos, this.yPos)) {
			switch (this.direction) {
			case 'S':

				this.yPos += 1;
				break;

			case 'N':
				this.yPos -= 1;
				break;

			case 'E':
				this.xPos += 1;
				break;

			case 'W':
				this.xPos -= 1;
				break;
			}

			Game.plateau.updatePlateau();
		}

	}

	// au lieu de faire une fonction à part entiere pour chaque direction, on ruse
	// en tournant deux fois tout simplement
	public void demiTour() {
		turnright();
		turnright();
	}

	public void turnleft() {
		switch (this.direction) {
		case 'S':
			this.direction = 'E';
			break;

		case 'N':
			this.direction = 'W';
			break;

		case 'E':
			this.direction = 'N';
			break;

		case 'W':
			this.direction = 'S';
			break;
		}

		Game.plateau.updatePlateau();
	}

	public void turnright() {
		switch (this.direction) {
		case 'S':
			this.direction = 'W';
			break;

		case 'N':
			this.direction = 'E';
			break;

		case 'E':
			this.direction = 'S';
			break;

		case 'W':
			this.direction = 'N';
			break;
		}

		Game.plateau.updatePlateau();
	}

	public int getxPos() {
		return this.xPos;
	}

	public int getyPos() {
		return this.yPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void setxy(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}

	public String getColor() {
		return this.color;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setSymbol() {
		switch (this.color) {
		case "Rouge":
			this.symbol = 'R';
			break;

		case "Verte":
			this.symbol = 'V';
			break;

		case "Bleue":
			this.symbol = 'B';
			break;

		case "Jaune":
			this.symbol = 'J';
			break;
		}
	}

	public ListeDeCartes getMain() {
		return this.main;
	}

	public ListeDeCartes getDefausse() {
		return this.defausse;
	}

	public ListeDeCartes getDeck() {
		return this.deck;
	}

	public ListeDeCartes getProgramme() {
		return this.programme;
	}

	public char getDirection() {
		return this.direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public void pioche() {

		// si le deck est vide, on va le remplir de la defausse, puis on va melanger le
		// deck et supprimer la defausse
		if (deck.getCardsList().size() == 0) {
			deck.setCardsList(defausse.getCardsList());
			deck.melangeLeDeck();
			defausse.getCardsList().clear();
		}

		main.getCardsList().add(deck.getCardsList().get(0));
		main.setCardsList(main.getCardsList());

		deck.retirerPremiereCarte();
	}

	public int nbMurs() {
		return this.inventaire.get("murDePierre");
	}

	public int nbGlaces() {
		return this.inventaire.get("murDeGlace");
	}

	public void envoyerUneCarteAuCimetiere(Carte carte) {
		this.defausse.ajouterCarte(carte);
	}

	public void videLaMain() {
		this.main.cardsList.clear();
	}

	public void retirerMurDeGlaceInventaire() {
		if (this.inventaire.get("murDeGlace") != 0) {
			this.inventaire.replace("murDeGlace", this.inventaire.get("murDeGlace") - 1);
		}

	}

	public void retirerMurDePierreInventaire() {
		if (this.inventaire.get("murDePierre") != 0) {
			this.inventaire.replace("murDePierre", this.inventaire.get("murDePierre") - 1);
		}

	}

	// le laser va se repandre selon la direction de la tortue si les cases sont
	// vides puis va faire quelque chose si elle atteint une tuile
	public void actionLaser() {
		switch (this.direction) {
		case 'S':
			for (int i = this.yPos + 1; i <= 7; i++) {

				if (Game.plateau.getPlateau()[i][this.xPos] == 'G') {
					Game.plateau.melt(i, this.xPos);
					return;

				} else if (Game.plateau.getPlateau()[i][this.xPos] == 'M') {
					return;
				}

				else if (Game.plateau.getPlateau()[i][this.xPos] == 'R'
						|| Game.plateau.getPlateau()[i][this.xPos] == 'V'
						|| Game.plateau.getPlateau()[i][this.xPos] == 'B'
						|| Game.plateau.getPlateau()[i][this.xPos] == 'J') {

					for (Tortue tortue : Game.tortues) {

						if (tortue.getSymbol() == (Game.plateau.getUneCase(this.xPos, i))) {
							if (Game.tortues.size() == 2) {
								tortue.demiTour();
							} else {
								Game.resetTortue(tortue);
							}
							break;
						}
					}
					return;
				}
			}
			break;

		case 'N':
			for (int i = this.yPos - 1; i >= 0; i--) {

				if (Game.plateau.getPlateau()[i][this.xPos] == 'G') {
					Game.plateau.melt(i, this.xPos);
					return;

				} else if (Game.plateau.getPlateau()[i][this.xPos] == 'M') {
					return;
				}

				else if (Game.plateau.getPlateau()[i][this.xPos] == 'R'
						|| Game.plateau.getPlateau()[i][this.xPos] == 'V'
						|| Game.plateau.getPlateau()[i][this.xPos] == 'B'
						|| Game.plateau.getPlateau()[i][this.xPos] == 'J') {

					for (Tortue tortue : Game.tortues) {

						if (tortue.getSymbol() == (Game.plateau.getUneCase(this.xPos, i))) {

							if (Game.tortues.size() == 2) {
								tortue.demiTour();
							} else {
								Game.resetTortue(tortue);
							}
							break;
						}
					}
					return;
				}
			}
			break;

		case 'E':
			for (int i = this.xPos + 1; i <= 7; i++) {

				if (Game.plateau.getPlateau()[this.yPos][i] == 'G') {
					Game.plateau.melt(this.yPos, i);
					return;

				} else if (Game.plateau.getPlateau()[this.yPos][i] == 'M') {
					return;
				}

				else if (Game.plateau.getPlateau()[this.yPos][i] == 'R'
						|| Game.plateau.getPlateau()[this.yPos][i] == 'V'
						|| Game.plateau.getPlateau()[this.yPos][i] == 'B'
						|| Game.plateau.getPlateau()[this.yPos][i] == 'J') {

					for (Tortue tortue : Game.tortues) {

						if (tortue.getSymbol() == (Game.plateau.getUneCase(i, this.yPos))) {

							if (Game.tortues.size() == 2) {
								tortue.demiTour();
							} else {
								Game.resetTortue(tortue);
							}
							break;
						}
					}
					return;
				}
			}
			break;

		case 'W':
			for (int i = this.xPos - 1; i >= 0; i--) {

				if (Game.plateau.getPlateau()[this.yPos][i] == 'G') {
					Game.plateau.melt(this.yPos, i);
					return;

				} else if (Game.plateau.getPlateau()[this.yPos][i] == 'M') {
					return;
				}

				else if (Game.plateau.getPlateau()[this.yPos][i] == 'R'
						|| Game.plateau.getPlateau()[this.yPos][i] == 'V'
						|| Game.plateau.getPlateau()[this.yPos][i] == 'B'
						|| Game.plateau.getPlateau()[this.yPos][i] == 'J') {

					for (Tortue tortue : Game.tortues) {

						if (tortue.getSymbol() == (Game.plateau.getUneCase(i, this.yPos))) {

							if (Game.tortues.size() == 2) {
								tortue.demiTour();
							} else {
								Game.resetTortue(tortue);
							}
							break;
						}
					}
					return;
				}
			}
			break;

		}

	}

	public int getInitialxPos() {
		return initialxPos;
	}

	public void setInitialxPos(int initialxPos) {
		this.initialxPos = initialxPos;
	}

	public int getInitialyPos() {
		return initialyPos;
	}

	public void setInitialyPos(int initialyPos) {
		this.initialyPos = initialyPos;
	}

	public char getInitialDirection() {
		return initialDirection;
	}

	public void setInitialDirection(char initialDirection) {
		this.initialDirection = initialDirection;
	}

	public boolean isaFini() {
		return aFini;
	}

	public void setaFini(boolean aFini) {
		this.aFini = aFini;
	}

}
