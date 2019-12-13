package com.turtles;
import java.util.ArrayList;
import java.util.HashMap;

public class Tortue {
	
	// ajouter les murs egalement
	
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
	
	private HashMap<String, Integer> inventaire = new HashMap<String, Integer>();		// on cree une map avec les murs (pierre et glace et plus tard caisse) et le nombre restant dans l'inventaire du joueur
	
	
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
		
		this.inventaire.put("murDeGlace", 2);
		this.inventaire.put("murDePierre", 3);
		
		
		
		
		
		
	}
	
	public HashMap<String, Integer> getInventaire(){
		return this.inventaire;
	}
	
	
	
	
	public void avance() {
		
		// on doit verifier que la position est valide avant de deplacer grace a la fonction deplacementvalide()
		
		if (Game.plateau.deplacementValide(this.direction, this.xPos, this.yPos, this.color)) {
			switch(this.direction) {
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
		} else {
			System.out.println("deplacement invalide");
		}
		
		
	}
	
	
	
	public void turnleft() {
		switch(this.direction) {
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
		switch(this.direction) {
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
	
	public int getIndex(String color) {
		int i = 0;
		int j = 0;
		for (Tortue tortue : Game.tortues) {
			if (color == tortue.getColor()) {
				j = i;
			}
			i++;
		}
		return j;
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
		
		ArrayList<Carte> handList = main.getCardsList();
		ArrayList<Carte> deckList = deck.getCardsList();
		
		handList.add(deckList.get(0));
		main.setCardsList(handList);
		
		
		deck.retirerPremiereCarte();
	}
	
	public void afficheLaMain() {
		
		System.out.print("Votre main : ");
		this.main.afficheLaListe();
	}
	
	
	public void afficheInventaire() {
		System.out.print("Votre Inventaire : ");
		System.out.print("murs de glace : " + this.inventaire.get("murDeGlace") + " - murs de pierre : " + this.inventaire.get("murDePierre") + "\n");
		
	}
	
	
	
	
	public void envoyerUneCarteAuCimetiere(Carte carte) {
		this.defausse.ajouterCarte(carte);
	}
	
	public void invoquerUneCarte(Carte carte) {
		
		// ajouter une condition si le board est full TODO
		
		this.programme.ajouterCarte(carte);
		this.main.retirerUneCarte(carte.getIndex(this.main.getCardsList()));
		
	}
	
	public void videLaMain() {
		this.main.cardsList.clear();
	}
	
	public void afficheLeProgramme() {
		System.out.print("votre programme : ");
		this.programme.afficheLaListe();
	}
	
	public void retirerMurDeGlaceInventaire() {
		if (this.inventaire.get("murDeGlace") != 0) {
			this.inventaire.replace("murDeGlace", this.inventaire.get("murDeGlace") - 1);
		}else {
			//TODO
		}
		
		
	}
	
	public void retirerMurDePierreInventaire() {
		if (this.inventaire.get("murDePierre") != 0) {
			this.inventaire.replace("murDePierre", this.inventaire.get("murDePierre") - 1);
		}else {
			//TODO
		}
		
		
	}



	public void actionLaser() {
		switch (this.direction) {
		case 'S':
			for (int i = this.yPos + 1; i < 7; i++) {
				
				if (Game.plateau.getPlateau()[i][this.xPos] == 'G') {
					Game.plateau.melt(i, this.xPos);
					break;
					
				}else if(Game.plateau.getPlateau()[i][this.xPos] == 'M') {
					
				}
				
				else if (Game.plateau.getPlateau()[i][this.xPos] == 'R' || 
						Game.plateau.getPlateau()[i][this.xPos] == 'V' || 
						Game.plateau.getPlateau()[i][this.xPos] == 'B' || 
						Game.plateau.getPlateau()[i][this.xPos] == 'J') {
					
					for (Tortue tortue : Game.tortues) {
						
						
						
						if (tortue.getSymbol() == (Game.plateau.getUneCase(this.xPos, i))) {

							Game.resetTortue(tortue);
							break;
						}
					}
					break;
				}
			}
			break;
			
		case 'N':
			for (int i = this.yPos - 1; i > 0; i--) {
				
				if (Game.plateau.getPlateau()[i][this.xPos] == 'G') {
					Game.plateau.melt(i, this.xPos);
					break;
					
				}else if(Game.plateau.getPlateau()[i][this.xPos] == 'M') {
					
				}
				
				else if (Game.plateau.getPlateau()[i][this.xPos] == 'R' || 
						Game.plateau.getPlateau()[i][this.xPos] == 'V' || 
						Game.plateau.getPlateau()[i][this.xPos] == 'B' || 
						Game.plateau.getPlateau()[i][this.xPos] == 'J') {
					
					for (Tortue tortue : Game.tortues) {
						
						
						
						if (tortue.getSymbol() == (Game.plateau.getUneCase(this.xPos, i))) {

							Game.resetTortue(tortue);
							break;
						}
					}
					break;
				}
			}
			break;
			
		case 'E':
			for (int i = this.xPos + 1; i < 7; i++) {
				
				if (Game.plateau.getPlateau()[this.yPos][i] == 'G') {
					Game.plateau.melt(this.yPos, i);
					break;
					
				}else if(Game.plateau.getPlateau()[this.yPos][i] == 'M') {
					
				}
				
				else if (Game.plateau.getPlateau()[this.yPos][i] == 'R' || 
						Game.plateau.getPlateau()[this.yPos][i] == 'V' || 
						Game.plateau.getPlateau()[this.yPos][i] == 'B' || 
						Game.plateau.getPlateau()[this.yPos][i] == 'J') {
					
					for (Tortue tortue : Game.tortues) {
						
						
						
						if (tortue.getSymbol() == (Game.plateau.getUneCase(i, this.yPos))) {

							Game.resetTortue(tortue);
							break;
						}
					}
					break;
				}
			}
			break;
			
		case 'W':
			for (int i = this.xPos - 1; i > 0; i--) {
				
				if (Game.plateau.getPlateau()[this.yPos][i] == 'G') {
					Game.plateau.melt(this.yPos, i);
					break;
					
				}else if(Game.plateau.getPlateau()[this.yPos][i] == 'M') {
					
				}
				
				else if (Game.plateau.getPlateau()[this.yPos][i] == 'R' || 
						Game.plateau.getPlateau()[this.yPos][i] == 'V' || 
						Game.plateau.getPlateau()[this.yPos][i] == 'B' || 
						Game.plateau.getPlateau()[this.yPos][i] == 'J') {
					
					for (Tortue tortue : Game.tortues) {
						
						
						
						if (tortue.getSymbol() == (Game.plateau.getUneCase(i, this.yPos))) {

							Game.resetTortue(tortue);
							break;
						}
					}
					break;
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
	
	
	
	
	// fonction deck vide TODO
	

}