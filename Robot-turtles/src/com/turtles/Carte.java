package com.turtles;
import java.util.ArrayList;

import com.turtles.gui.FenetreJeu;

public class Carte {
	
	private String type;
	
	public Carte() {
		
	}
	
	public Carte(String type) {
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void invocation(Tortue tortue) {
		
		// TODO faire passer la carte de la main au board (peut etre)
		
		switch (this.type) {
		case "Bleue":
			actionCarteBleue(tortue);
			break;
			
		case "Jaune":
			actionCarteJaune(tortue);
			break;
			
		case "Violette":
			actionCarteViolette(tortue);
			break;
			
		case "Laser":
			actionCarteLaser(tortue);
			break;
		}
		FenetreJeu.getBoardPanel().drawBoard();		// redessine le board à chaque fois qu'une action est effectuée
	}
	
	
	public void actionCarteBleue(Tortue tortue) {
		tortue.avance();
	}
	
	public void actionCarteJaune(Tortue tortue) {
		tortue.turnleft();
	}
	
	public void actionCarteViolette(Tortue tortue) {
		tortue.turnright();
	}
	
	public void actionCarteLaser(Tortue tortue) {
		tortue.actionLaser();
	}
	
	public int getIndex(ArrayList<Carte> list) {
		int i = 0;
		for (Carte carte : list) {
			if (carte.type == this.type) {
				return i;
			}
			i++;
		}
		
		
		return 0;
	}

}
