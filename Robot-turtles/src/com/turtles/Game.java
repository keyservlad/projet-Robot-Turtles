package com.turtles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;

import com.turtles.gui.EtatPartie;
import com.turtles.gui.Fenetre;
import com.turtles.gui.InventairePanel;

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
				
				InventairePanel.refreshMurs();
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
					fenetre.repaint();
				}
				

				if (etatPartie == EtatPartie.EXECUTER) {		// c'est ici qu'on met la condition de victoire
					
					fenetre.invocation();
	

				}
				
				
				fenetre.passerEnFinDeTour();
				while(etatPartie == EtatPartie.FINDETOUR) {
					fenetre.repaint();
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
	
	
	public void creationTortues() {
		
		
		// cr�ation des objets tortue pour chaque cas
		
		
		tortueRouge = new Tortue("Rouge");
		tortueVerte = new Tortue("Verte");
		if (nbTortues > 2) {
			tortueBleue = new Tortue("Bleue");
			if (nbTortues > 3) {
				tortueJaune = new Tortue("Jaune");
			}
		}
		
		
		// initialisation des positions des tortues puis ajout � la liste des joueurs
		
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
	

	
	
	public static void changementDeMain() {
		
		for (Carte carte : tortues.get(tourDuJoueur).getMain().cardsList) {
			tortues.get(tourDuJoueur).envoyerUneCarteAuCimetiere(carte);				//place toute les cartes de sa main au cimetiere
		}
		
		tortues.get(tourDuJoueur).videLaMain();											// vide la main
		
		for (int i = 0; i < 5; i++) {
			tortues.get(tourDuJoueur).pioche();
		}
		
		
	}
	
	
	
	public static void construireMur(int xScreen, int yScreen, char symbole) {
		
		int x = 0;
		int y = 0;
		boolean isRest = false;
		String typeMur = "";

		
		switch(symbole) {
		case 'G':
			typeMur = "murDeGlace";
			break;
			
		case 'M':
			typeMur = "murDePierre";
			break;
		}
		
		for (String i : tortues.get(tourDuJoueur).getInventaire().keySet()) {
			if (tortues.get(tourDuJoueur).getInventaire().get(i) != 0 && i.contentEquals(typeMur)) {
				isRest = true;
			}
		}
		
		
		if (isRest){
			
			if (yScreen > 343 && yScreen <= 395) {
				y = 0;
			} else if (yScreen > 395 && yScreen <= 446) {
				y = 1;
			} else if (yScreen > 446 && yScreen <= 500) {
				y = 2;
			} else if (yScreen > 500 && yScreen <= 551) {
				y = 3;
			} else if (yScreen > 551 && yScreen <= 604) {
				y = 4;
			} else if (yScreen > 604 && yScreen <= 655) {
				y = 5;
			} else if (yScreen > 655 && yScreen <= 700) {
				y = 6;
			} else if (yScreen > 700 && yScreen <= 758) {
				y = 7;
			}else {
				return;
			}

			if (xScreen > 740 && xScreen <= 794) {
				x = 0;
			} else if (xScreen > 794 && xScreen <= 850) {
				x = 1;
			} else if (xScreen > 850 && xScreen <= 905) {
				x = 2;
			} else if (xScreen > 905 && xScreen <= 960) {
				x = 3;
			} else if (xScreen > 960 && xScreen <= 1015) {
				x = 4;
			} else if (xScreen > 1015 && xScreen <= 1070) {
				x = 5;
			} else if (xScreen > 1070 && xScreen <= 1125) {
				x = 6;
			} else if (xScreen > 1125 && xScreen <= 1180) {
				x = 7;
			}else {
				return;
			}
			
			if (isMurValide(x, y)) {
				if(Plateau.verifierLesChemins(x, y)) {
					plateau.setPlateau(x, y, symbole);
					InventairePanel.desactiveLesMurs();
					Game.etatPartie = EtatPartie.FINDETOUR;
					switch (symbole) {
					case 'G':
						tortues.get(tourDuJoueur).retirerMurDeGlaceInventaire();
						break;
						
					case 'M':
						tortues.get(tourDuJoueur).retirerMurDePierreInventaire();
					}
				}else {
					// TODO instruction panel "il est interdit de bloquer un joueur ou une position initiale"
				}
			}else {
				// TODO instruction panel "case non dispo"
			}
			
			
			
			InventairePanel.refreshMurs();
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
	
	public static boolean isMurValide(int x, int y) {
		
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
			
			//  en verifiant que la case n'est pas occup�e, aussi il faut completer dans Tortue l'action laser
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
