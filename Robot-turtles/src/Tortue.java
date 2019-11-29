
public class Tortue {
	
	String color; 
	int xPos;
	int yPos;
	char direction;
	
	char symbol;
	
	
	public Tortue() {
		
	}
	
	
	
	public Tortue(String color) {
		this.color = color;
		
		this.direction = 'S';
		
		setSymbol();
		
	}
	
	public Tortue(String color, int xPos, int yPos) {
		this.color = color;
		this.xPos = /*"pos initiale x"*/0;
		this.yPos = /*"pos initiale y"*/0;
		this.direction = /*direction initial*/0;
		
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

}
