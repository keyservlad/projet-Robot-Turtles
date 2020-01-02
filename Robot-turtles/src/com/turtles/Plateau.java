package com.turtles;

public class Plateau {
	
	public char[][] plateau = new char[8][8];
	
	
	
	public Plateau() {
		initialisationPlateau();
	}
	
	
	public void initialisationPlateau() {
		
		
		
		for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                plateau[i][j] = ' ';
            }
        }
		
		
		
		
	}
	
	public char[][] getPlateau(){
		return plateau;
	}
	
	public void setPlateau(int x, int y, char symbole) {
		this.plateau[y][x] = symbole;
	}
	
	public void afficherPlateau() {
		System.out.println("");
		
		for (int i = 0; i < plateau.length; i++) {
            System.out.print("|");
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print(plateau[i][j]);
            }
            System.out.println("|");
        }
		
		System.out.println("");
		
	}
	
	public void updatePlateau() {
		// a chaque action on va raffraichir le plateau
		viderPlateau();
		
		for (Tortue tortue : Game.tortues) {
			plateau[tortue.getyPos()][tortue.getxPos()] = tortue.getSymbol();
		}
		
		afficherPlateau();
		
		
	}
	
	public void viderPlateau() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (plateau[i][j] == 'R' || plateau[i][j] == 'V' || plateau[i][j] == 'B' || plateau[i][j] == 'J') {
					plateau[i][j] = ' ';
				}
			}
		}
	}
	
	public boolean deplacementValide(char direction, int xPos, int yPos, String color){
		switch(direction) {
		case 'S':
			if (yPos + 1 > 7) {
				return false;
			}
			if (this.plateau[yPos + 1][xPos] == 'X') {
				Game.victoire(color);
			}
			else if ((this.plateau[yPos + 1][xPos] != ' ')) {
				return false;
			}
			
			
			
			
			break;
			
		case 'N':
			if (yPos - 1 < 0) {
				return false;
			}
			if (this.plateau[yPos - 1][xPos] == 'X') {
				Game.victoire(color);
			}
			else if (this.plateau[yPos - 1][xPos] != ' ') {
				return false;
			}
			
			
			break;
			
		case 'E':
			if (xPos > 7) {
				return false;
			}
			if (this.plateau[yPos][xPos + 1] == 'X') {
				Game.victoire(color);
			}
			else if (this.plateau[yPos][xPos + 1] != ' ') {
				return false;
			}
			
			
			break;
			
		case 'W':
			if (xPos - 1 < 0) {
				return false;
			}
			if (this.plateau[yPos][xPos - 1] == 'X') {
				Game.victoire(color);
			}
			else if (this.plateau[yPos][xPos - 1] != ' ') {
				return false;
			}
			
			break;
			
		}
		
		
		
		
		return true;
	}
	
	
	public void melt(int x, int y) {
		this.plateau[y][x] = ' ';
		this.updatePlateau();
	}
	
	public char getUneCase(int x, int y) {
		return this.plateau[y][x];
	}

}
