import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static int nbTortues;
	public List tortues = new ArrayList<>();
	public Scanner scanner = new Scanner(System.in);
	
	
	public void run() {
		choixNbJoueur();
		Plateau plateau = new Plateau();
		
		plateau.afficherTableau();
		
		
		
		
		
		
		
	}
	
	public void choixNbJoueur() {
		
		int saisieNbJoueurs;
		do {
			System.out.println("Combien de joueurs (entre 2 et 4 joueurs)?");
			saisieNbJoueurs = Integer.parseInt(scanner.nextLine());
			
		}while(saisieNbJoueurs != 2 && saisieNbJoueurs != 3 && saisieNbJoueurs != 4);
		
		
		this.nbTortues = saisieNbJoueurs;
		
		switch(nbTortues) {
		case 2:
			tortues.add('R');
			tortues.add('V');
			break;
		case 3:
			tortues.add('R');
			tortues.add('V');
			tortues.add('B');
			break;
		case 4:
			tortues.add('R');
			tortues.add('V');
			tortues.add('B');
			tortues.add('J');
		}
	}

}
