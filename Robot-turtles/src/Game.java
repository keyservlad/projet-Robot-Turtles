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
		
		int tourDuJoueur = 0;
		while (true) {
			while(tourDuJoueur < nbTortues) {
				System.out.println("\nC'est au tour de la tortue " + tortues.get(tourDuJoueur).getColor());
				afficheLaMainLePlateauEtLeBoard(tourDuJoueur);
				
				choixMultiple(tourDuJoueur);
				
				finDeTour(tourDuJoueur);
				
				
				
				
				
				
				tourDuJoueur++;
			}
			tourDuJoueur = 0;
		}
		
		
		
		
		
		
		
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
	
	public void afficheLaMainLePlateauEtLeBoard(int tourDuJoueur) {
		plateau.updatePlateau();
		tortues.get(tourDuJoueur).afficheLaMain();
		//tortues.get(tourDuJoueur).afficheLeProgramme();
		tortues.get(tourDuJoueur).afficheInventaire();
		
		
	}
	
	public void choixMultiple(int tourDuJoueur) {
		
		int saisieJoueur;
		do {
			
			System.out.println("Choisissez (1, 2 ou 3)");
			System.out.println("1 - Completer le programme");
			System.out.println("2 - Construire un mur");
			System.out.println("3 - Executer le programme");
			saisieJoueur = Integer.parseInt(scanner.nextLine());
			
		}while (saisieJoueur != 1 && saisieJoueur != 2 && saisieJoueur != 3);
		
		switch(saisieJoueur) {
		case 1:
			String saisieUtilisateur = "";
			do {
				
				
				if (tortues.get(tourDuJoueur).getMain().cardsList.size() != 0) {
					completerProgramme(tourDuJoueur);
					if (tortues.get(tourDuJoueur).getMain().cardsList.size() != 0) {
						do {
							System.out.println("Voulez-vous choisir une autre carte? \n"
									+ "Entrez \"oui\" ou \"non\"");
							saisieUtilisateur = scanner.nextLine();
							}while(!saisieUtilisateur.contentEquals("oui") && !saisieUtilisateur.contentEquals("non"));
					}
					
				}
				
				
				
			}while (tortues.get(tourDuJoueur).getMain().cardsList.size() != 0 && saisieUtilisateur.contentEquals("oui"));
			
			break;
			
		case 2:
			construireMur(tourDuJoueur);
			break;
			
		case 3:
			executerProgramme(tourDuJoueur);
			break;
		}
	}
	
	
	public void changementDeMain(int tourDuJoueur) {
		
		
		
		
		for (Carte carte : tortues.get(tourDuJoueur).getMain().cardsList) {
			tortues.get(tourDuJoueur).envoyerUneCarteAuCimetiere(carte);				//place toute les cartes de sa main au cimetiere
		}
		
		tortues.get(tourDuJoueur).videLaMain();											// vide la main
		
		for (int i = 0; i < 5; i++) {
			tortues.get(tourDuJoueur).pioche();
		}
		
		
	}
	
	public void finDeTour(int tourDuJoueur) {
		
		int saisieJoueur;
		do {
			
			
			System.out.println("1 - garder votre main");
			System.out.println("2 - en piocher une nouvelle");
			saisieJoueur = Integer.parseInt(scanner.nextLine());
			
		}while (saisieJoueur != 1 && saisieJoueur != 2);
		
		switch (saisieJoueur) {
		case 1:
			// ne fait rien
			break;
			
		case 2:
			changementDeMain(tourDuJoueur);
			break;
		}
		
		afficheLaMainLePlateauEtLeBoard(tourDuJoueur);
		
	}
	
	public void completerProgramme(int tourDuJoueur) {
		int saisieJoueur;
		int i;
		do {
			i = 0;
			System.out.println("Choisissez une carte : ");
			
			for (Carte carte : tortues.get(tourDuJoueur).getMain().cardsList) {
				System.out.println(i + " - " + carte.getType());
				i++;
			}
			saisieJoueur = Integer.parseInt(scanner.nextLine());
			
			
		}while(saisieJoueur < 0 || saisieJoueur > i - 1);
		
		tortues.get(tourDuJoueur).invoquerUneCarte(indexToCarteInHand(saisieJoueur, tourDuJoueur)); // invoque une carte sur le programme et le retire de la main
	}
	
	public void construireMur(int tourDuJoueur) {
		
	}
	
	public void executerProgramme(int tourDuJoueur) {
		
	}
	
	public Carte indexToCarteInHand(int index, int tourDuJoueur) {
		
		return tortues.get(tourDuJoueur).getMain().cardsList.get(index);
		
	}

}
