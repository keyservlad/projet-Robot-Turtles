
public class Plateau {
	
	private char[][] plateau = new char[8][8];
	
	
	
	public Plateau() {
		initialisationPlateau(Game.nbTortues);
	}
	
	
	public void initialisationPlateau(int nbTortues) {
		
		
		
		for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                plateau[i][j] = ' ';
            }
        }
		// rajouter les tortues et les joyaux et les tuiles
		switch(nbTortues) {
		case 2:
			plateau[0][1] = 'R';
			plateau[0][5] = 'V';
			
			plateau[7][3] = 'X';
			
			for (int i = 0; i < 8; i++) {
				plateau[i][7] = 'M';
			}
			
			break;
			
		case 3:
			
			plateau[0][0] = 'R';
			plateau[0][3] = 'V';
			plateau[0][6] = 'B';
			
			plateau[7][0] = 'X';
			plateau[7][3] = 'X';
			plateau[7][6] = 'X';
			
			
			for (int i = 0; i < 8; i++) {
				plateau[i][7] = 'M';
			}
			break;
			
		case 4:
			
			plateau[0][0] = 'R';
			plateau[0][2] = 'V';
			plateau[0][5] = 'B';
			plateau[0][7] = 'J';
			
			
			plateau[7][1] = 'X';
			plateau[7][6] = 'X';
			
			
			break;
		
		}
		
		afficherPlateau();
		
		
		
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
			if (this.plateau[yPos + 1][xPos] == 'X') {
				Game.victoire(color);
			}
			else if ((yPos + 1 > 7) || (this.plateau[yPos + 1][xPos] != ' ')) {
				return false;
			}else 
			
			
			break;
			
		case 'N':
			if (this.plateau[yPos - 1][xPos] == 'X') {
				Game.victoire(color);
			}
			else if ((yPos - 1 < 0) || (this.plateau[yPos - 1][xPos] != ' ')) {
				return false;
			}
			break;
			
		case 'E':
			if (this.plateau[yPos][xPos + 1] == 'X') {
				Game.victoire(color);
			}
			else if ((xPos + 1 > 7) || (this.plateau[yPos][xPos + 1] != ' ')) {
				return false;
			}
			break;
			
		case 'W':
			if (this.plateau[yPos][xPos - 1] == 'X') {
				Game.victoire(color);
			}
			else if ((xPos - 1 < 0) || (this.plateau[yPos][xPos - 1] != ' ')) {
				return false;
			}
			
			break;
			
		}
		
		
		
		
		return true;
	}

}
