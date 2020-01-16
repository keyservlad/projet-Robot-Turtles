package com.turtles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;

import com.turtles.gui.EtatPartie;
import com.turtles.gui.Fenetre;

public class Game {
	
	public static int nbTortues = 3;
	public static List<Tortue> tortues = new ArrayList<>();
	public Scanner scanner = new Scanner(System.in);
	
	
	public static Tortue tortueRouge;
	public static Tortue tortueVerte;
	public static Tortue tortueBleue;
	public static Tortue tortueJaune;
	
	
	
	
	public static Plateau plateau;
	
	
	public static int tourDuJoueur;
	
	public static EtatPartie etatPartie = EtatPartie.DEBUTPARTIE;
	
	public static Fenetre fenetre;
	
	
	private Thread t;
	
	
	
	public void run() {
		
		plateau = new Plateau();
		fenetre = new Fenetre();
		
		
		
		while (etatPartie == EtatPartie.DEBUTPARTIE) { 
			
			fenetre.repaint();
			
		}
		
		creationTortues();
		tourDuJoueur = 0;
		
		while(true) {
			while(tourDuJoueur < nbTortues) {
				fenetre.afficherEcranTourDuJoueur();
				
				while(etatPartie == EtatPartie.DESIGNATIONJOUEUR) {
					fenetre.getContentPane().repaint();
				}
				
				fenetre.afficherFenetreJeu();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				etatPartie = EtatPartie.CHOIXACTION;
				fenetre.passerEnChoixDuJoueur();
				
				while(etatPartie == EtatPartie.CHOIXACTION) {
					t = new Thread();
					t.start();
					
					
				}
				t.stop();
				fenetre.otherGlassPan = new JPanel();
				
				
				while(etatPartie == EtatPartie.COMPLETER) {
					fenetre.repaint();
					
				}
				
				while(etatPartie == EtatPartie.CONSTRUIRE) {

				}

				if (etatPartie == EtatPartie.EXECUTER) {		// c'est ici qu'on met la condition de victoire
					
					fenetre.invocation();
	

				}
				
				while(etatPartie == EtatPartie.FINDETOUR) {
					
				}

				fenetre.repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tourDuJoueur++;

			}
			tourDuJoueur = 0;
		}
		
		
		
	}
	
	public List<Tortue> getTortues(){
		return tortues;
	}
	
	public int choixNbJoueurs() {
		
		int saisieNbJoueurs;
		do {
			System.out.println("Combien de joueurs (entre 2 et 4 joueurs)?");
			saisieNbJoueurs = Integer.parseInt(scanner.nextLine());
			
		}while(saisieNbJoueurs != 2 && saisieNbJoueurs != 3 && saisieNbJoueurs != 4);
		
		return saisieNbJoueurs;
		
		
	}
	
	public void creationTortues() {
		
		
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
			
			plateau.setPlateau(3, 7, 'X');
			//plateau.setPlateau(3, 3, 'G'); test pour le GUi et les images
			
			for (int i = 0; i < 8; i++) {
				plateau.setPlateau(7, i, 'M');
			}
			
			tortueRouge.setInitialxPos(tortueRouge.getxPos());
			tortueVerte.setInitialxPos(tortueVerte.getxPos());
			
			
			
			break;
		case 3:
			tortueRouge.setxy(0, 0);
			tortueVerte.setxy(3, 0);
			
			tortueBleue.setxy(6, 0);
			
			
			tortues.add(tortueRouge);
			tortues.add(tortueVerte);
			tortues.add(tortueBleue);
			
			
			
			plateau.setPlateau(0, 7, 'X');
			plateau.setPlateau(3, 7, 'X');
			plateau.setPlateau(6, 7, 'X');
			
			
			for (int i = 0; i < 8; i++) {
				plateau.setPlateau(7, i, 'M');
			}
			
			tortueRouge.setInitialxPos(tortueRouge.getxPos());
			tortueVerte.setInitialxPos(tortueVerte.getxPos());
			tortueBleue.setInitialxPos(tortueBleue.getxPos());
			
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
			
			
			plateau.setPlateau(1, 7, 'X');
			plateau.setPlateau(6, 7, 'X');
			
			tortueRouge.setInitialxPos(tortueRouge.getxPos());
			tortueVerte.setInitialxPos(tortueVerte.getxPos());
			tortueBleue.setInitialxPos(tortueBleue.getxPos());
			tortueJaune.setInitialxPos(tortueJaune.getxPos());
			
			break;
		}
		
		plateau.updatePlateau();
		
		
		
		
		
	}
	
	
	

	public static void victoire(String color) {
		System.out.println(color + " gagne");
		
		Tortue tortueGagnante = null;;

		for (Tortue tortue : tortues) {
			if (tortue.getColor() == color) {
				tortueGagnante = tortue;
			}
			
		}
		
		tortues.remove(tortueGagnante.getIndex(color));

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
			
			if (tortues.get(tourDuJoueur).getInventaire().get("murDeGlace") == 0 && tortues.get(tourDuJoueur).getInventaire().get("murDePierre") == 0) {
				System.out.println("plus de mur!");
				
			}else {
				construireMur(tourDuJoueur);
			}
			
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
		int x;
		int y;
		int j = 0;
		boolean isRest = false;
		int choixMur;
		char symbole = ' ';

		for (String i : tortues.get(tourDuJoueur).getInventaire().keySet()) {
			if (tortues.get(tourDuJoueur).getInventaire().get(i) != 0) {
				System.out.println(j + " - " + i);
				isRest = true;
			}
			j++;
		}
		
		if (isRest){
			do {
				choixMur = Integer.parseInt(scanner.nextLine()); // faire le choix non pas avec des int mais avec des strings
			}while (choixMur != 0 && choixMur != 1);  // bug mais osef car il va se barrer avec l'IG
			
			symbole = attributionSymbole(choixMur);
			
			do {
				do {
					System.out.println("entrer l'abscisse : ");
					x = Integer.parseInt(scanner.nextLine());

				} while (x < 0 || x > 7);

				do {
					System.out.println("entrer l'ordonnée : ");
					y = Integer.parseInt(scanner.nextLine());
				} while (y < 0 || y > 7);

			} while (isMurValide(x, y) == false);
			
			plateau.setPlateau(x, y, symbole);
			switch (choixMur) {
			case 0:
				tortues.get(tourDuJoueur).retirerMurDeGlaceInventaire();
				break;
				
			case 1:
				tortues.get(tourDuJoueur).retirerMurDePierreInventaire();
			}
			
			plateau.updatePlateau();
			
			
		}

		

	}
	
	public char attributionSymbole(int choixMur) {
		switch (choixMur) {
		case 0:
			return 'G';
		case 1:
			return 'M';
			
		}
		
		return ' ';
	}
	
	public boolean isMurValide(int x, int y) {
		
		if (plateau.getPlateau()[y][x] == ' ') {
			return true;
		}
		
		return false;
		
	}
	
	public void executerProgramme(int tourDuJoueur) {
		
		for ( Carte carte : tortues.get(tourDuJoueur).getProgramme().getCardsList()) {
			carte.invocation(tortues.get(tourDuJoueur));
			tortues.get(tourDuJoueur).getDefausse().ajouterCarte(carte);
			//tortues.get(tourDuJoueur).getProgramme().getCardsList().remove(carte.getIndex(tortues.get(tourDuJoueur).getProgramme().getCardsList()));
		}
		
		tortues.get(tourDuJoueur).getProgramme().clearListe();		
		
		
	}
	
	public Carte indexToCarteInHand(int index, int tourDuJoueur) {
		
		return tortues.get(tourDuJoueur).getMain().cardsList.get(index);
		
	}
	
	

	public static void resetTortue(Tortue tortue) {
		
		switch (tortue.getSymbol()) {
		case 'R':
			
			//  en verifiant que la case n'est pas occupée, aussi il faut completer dans Tortue l'action laser
			tortueRouge.setxPos(tortueRouge.getInitialxPos());
			tortueRouge.setyPos(tortueRouge.getInitialyPos());
			tortueRouge.setDirection(tortueRouge.getInitialDirection());
			
			plateau.updatePlateau();
			break;
			
		case 'V':
			tortueVerte.setxPos(tortueVerte.getInitialxPos());
			tortueVerte.setyPos(tortueVerte.getInitialyPos());
			tortueVerte.setDirection(tortueVerte.getInitialDirection());
			
			plateau.updatePlateau();
			
			break;
			
		case 'B':
			
			tortueBleue.setxPos(tortueBleue.getInitialxPos());
			tortueBleue.setyPos(tortueBleue.getInitialyPos());
			tortueBleue.setDirection(tortueBleue.getInitialDirection());
			
			plateau.updatePlateau();
			
			break;
			
		case 'J':
			
			tortueJaune.setxPos(tortueJaune.getInitialxPos());
			tortueJaune.setyPos(tortueJaune.getInitialyPos());
			tortueJaune.setDirection(tortueJaune.getInitialDirection());
			
			plateau.updatePlateau();
			
			break;
		}
		plateau.updatePlateau();
	}

	
	
	

}
