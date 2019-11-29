import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static int nbTortues;
	public static List<Tortue> tortues = new ArrayList<>();
	public Scanner scanner = new Scanner(System.in);
	
	
	public Tortue tortueRouge;
	public Tortue tortueVerte;
	public Tortue tortueBleue;
	public Tortue tortueJaune;
	
	
	private Tortue tortueRougeInitiale;
	private Tortue tortueVerteInitiale;
	private Tortue tortueBleueInitiale;
	private Tortue tortueJauneInitiale;
	
	
	public static Plateau plateau;
	
	
	public void run() {
		
		creationTortues(choixNbJoueurs());
		
		plateau = new Plateau();
		
		plateau.afficherPlateau();
		
		//tortueRouge.turnright();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		
		tortueRouge.avance();
		tortueRouge.turnleft();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		tortueRouge.avance();
		
		
		
		
		
	}
	
	public int choixNbJoueurs() {
		
		int saisieNbJoueurs;
		do {
			System.out.println("Combien de joueurs (entre 2 et 4 joueurs)?");
			saisieNbJoueurs = Integer.parseInt(scanner.nextLine());
			
		}while(saisieNbJoueurs != 2 && saisieNbJoueurs != 3 && saisieNbJoueurs != 4);
		
		return saisieNbJoueurs;
		
		
	}
	
	public void creationTortues(int nbJoueurs) {
		
		Game.nbTortues = nbJoueurs;	
		
		// création des objets tortue pour chaque cas
		
		
		
		tortueRouge = new Tortue("Rouge");
		tortueVerte = new Tortue("Verte");
		if (nbTortues > 2) {
			tortueBleue = new Tortue("Bleue");
			if (nbTortues > 3) {
				tortueJaune = new Tortue("Jaune");
			}
		}
		
		
		// initialisation des positions des tortues puis ajout à la liste des joueurs
		
		switch(nbTortues) {
		case 2:
			tortueRouge.setxy(1, 0);
			tortueVerte.setxy(5, 0);
			
			
			tortues.add(tortueRouge);
			tortues.add(tortueVerte);
			break;
		case 3:
			tortueRouge.setxy(0, 0);
			tortueVerte.setxy(3, 0);
			
			tortueBleue.setxy(6, 0);
			
			
			tortues.add(tortueRouge);
			tortues.add(tortueVerte);
			tortues.add(tortueBleue);
			break;
		case 4:
			
			tortueRouge.setxy(0, 0);
			tortueVerte.setxy(2, 0);
			
			tortueBleue.setxy(5, 0);
			tortueJaune.setxy(7, 0);
			
			
			
			
			tortues.add(tortueRouge);
			tortues.add(tortueVerte);
			tortues.add(tortueBleue);
			tortues.add(tortueJaune);
			break;
		}
		
		tortueRougeInitiale = tortueRouge;
		tortueVerteInitiale = tortueVerte;
		tortueBleueInitiale = tortueBleue;
		tortueJauneInitiale = tortueJaune;
		
		
		
	}
	
	
	public void renvoiAuDebut(Tortue tortue) {
		switch (tortue.getColor()) {
		case "Rouge":
			tortueRouge = tortueRougeInitiale;
			break;
			
		case "Verte":
			tortueVerte = tortueVerteInitiale;
			break;
			
		case "Bleue":
			tortueBleue = tortueBleueInitiale;
			break;
			
		case "Jaune":
			tortueJaune = tortueJauneInitiale;
			break;
		}
		
		plateau.updatePlateau();
		
	}
	
	public static void victoire(String color) {
		System.out.println(color + " gagne");
		
		for (Tortue tortue : tortues) {
			if (tortue.getColor() == color) {
				tortues.remove(tortue.getIndex(color));
			}
		}
		
		
		
	}

}
