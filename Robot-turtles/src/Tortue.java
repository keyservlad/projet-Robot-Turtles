
public class Tortue {
	
	String color; 
	int xpos;
	int ypos;
	char direction;
	
	public Tortue() {
		
	}
	
	public Tortue(String color) {
		this.color = color;
		this.xpos = /*"pos initiale x"*/0;
		this.ypos = /*"pos initiale y"*/0;
		this.direction = /*direction initial*/0;
		
	}
	
	
	public void avance() {
		
		// verifier l'angle de la tortue et la faire avancer de 1 (soit +/- 1 à y ou x)
		//this.xpos += 1;
	}
	
	public void turnleft() {
		//modifier la valeur de direction
	}
	
	public void turnright() {
		//modifier la valuer de direction
	}
	
	public void retourAuDebut() {
		//renvoie à la case initiale et direction initiale
	}
	
	

}
