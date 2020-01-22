package com.turtles;

public class Plateau {

	public static char[][] plateau = new char[8][8];

	// notre plateau pour tester si un chemin est possible apres le, placement
	// d'un mur

	private static int[][] plateauTest = new int[10][10];

	/**
	 * les valeurs sont : 0 : case non visitée 1 : mur (ou bordure) 2 : case visitée
	 * 9 : case visée
	 */

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

	public char[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(int x, int y, char symbole) {
		plateau[y][x] = symbole;
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
			if (tortue.isaFini() == false) {
				plateau[tortue.getyPos()][tortue.getxPos()] = tortue.getSymbol();
			}
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

	// verifie pour chaque direction du joueur la case vers laquel le joueur va
	// c'est ici qu'on va également gerer les collisions
	public boolean deplacementValide(char direction, int xPos, int yPos) {
		switch (direction) {
		case 'S':
			if (yPos + 1 > 7 || plateau[yPos + 1][xPos] == 'M' || plateau[yPos + 1][xPos] == 'G') {
				Game.tortues.get(Game.tourDuJoueur).demiTour();
				return false;
			}
			if (plateau[yPos + 1][xPos] == 'X') {
				Game.victoire();
			} else if ((plateau[yPos + 1][xPos] == 'R') || (plateau[yPos + 1][xPos] == 'V')
					|| (plateau[yPos + 1][xPos] == 'B') || (plateau[yPos + 1][xPos] == 'J')) {
				for (Tortue tortue : Game.tortues) {
					if (tortue.getSymbol() == plateau[yPos + 1][xPos]) {
						Game.resetTortue(tortue);
					}
					if (tortue.getSymbol() == plateau[yPos][xPos]) {
						Game.resetTortue(tortue);
					}
				}
				return false;
			} else if ((plateau[yPos + 1][xPos] != ' ')) {
				return false;
			}

			break;

		case 'N':
			if (yPos - 1 < 0 || plateau[yPos - 1][xPos] == 'G' || plateau[yPos - 1][xPos] == 'M') {
				Game.tortues.get(Game.tourDuJoueur).demiTour();
				return false;
			}
			if (plateau[yPos - 1][xPos] == 'X') {
				Game.victoire();
			} else if ((plateau[yPos - 1][xPos] == 'R') || (plateau[yPos - 1][xPos] == 'V')
					|| (plateau[yPos - 1][xPos] == 'B') || (plateau[yPos - 1][xPos] == 'J')) {
				for (Tortue tortue : Game.tortues) {
					if (tortue.getSymbol() == plateau[yPos - 1][xPos]) {
						Game.resetTortue(tortue);
					}
					if (tortue.getSymbol() == plateau[yPos][xPos]) {
						Game.resetTortue(tortue);
					}
				}
				return false;
			} else if (plateau[yPos - 1][xPos] != ' ') {
				return false;
			}

			break;

		case 'E':
			if (xPos > 7 || plateau[yPos][xPos + 1] == 'M' || plateau[yPos][xPos + 1] == 'G') {
				Game.tortues.get(Game.tourDuJoueur).demiTour();
				return false;
			}
			if (plateau[yPos][xPos + 1] == 'X') {
				Game.victoire();
			} else if ((plateau[yPos][xPos + 1] == 'R') || (plateau[yPos][xPos + 1] == 'V')
					|| (plateau[yPos][xPos + 1] == 'B') || (plateau[yPos][xPos + 1] == 'J')) {
				for (Tortue tortue : Game.tortues) {
					if (tortue.getSymbol() == plateau[yPos][xPos + 1]) {
						Game.resetTortue(tortue);
					}
					if (tortue.getSymbol() == plateau[yPos][xPos]) {
						Game.resetTortue(tortue);
					}
				}
				return false;
			} else if (plateau[yPos][xPos + 1] != ' ') {
				return false;
			}

			break;

		case 'W':
			if (xPos - 1 < 0 || plateau[yPos][xPos - 1] == 'G' || plateau[yPos][xPos - 1] == 'M') {
				Game.tortues.get(Game.tourDuJoueur).demiTour();
				return false;
			}
			if (plateau[yPos][xPos - 1] == 'X') {
				Game.victoire();
			} else if ((plateau[yPos][xPos - 1] == 'R') || (plateau[yPos][xPos - 1] == 'V')
					|| (plateau[yPos][xPos - 1] == 'B') || (plateau[yPos][xPos - 1] == 'J')) {
				for (Tortue tortue : Game.tortues) {
					if (tortue.getSymbol() == plateau[yPos][xPos - 1]) {
						Game.resetTortue(tortue);
					}
					if (tortue.getSymbol() == plateau[yPos][xPos]) {
						Game.resetTortue(tortue);
					}
				}
				return false;
			} else if (plateau[yPos][xPos - 1] != ' ') {
				return false;
			}

			break;

		}

		return true;
	}

	// fais fondre un mur de glace si le laser atteint un mur glace
	public void melt(int y, int x) {
		plateau[y][x] = ' ';
		this.updatePlateau();
	}

	public char getUneCase(int x, int y) {
		return plateau[y][x];
	}

	public static void reinitialiserPlateauTest() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				plateauTest[i][j] = 0;
			}
		}

		for (int i = 0; i < 10; i++) {
			plateauTest[i][0] = 1;
			plateauTest[0][i] = 1;
			plateauTest[i][9] = 1;
			plateauTest[9][i] = 1;
		}

	}

	// fonction utilisé uniquement pour tester le Pathfinding
	public static void affichePlateauTest() {
		System.out.println("");

		for (int i = 0; i < plateauTest.length; i++) {
			System.out.print("|");
			for (int j = 0; j < plateauTest[i].length; j++) {
				System.out.print(plateauTest[i][j]);
			}
			System.out.println("|");
		}

		System.out.println("");
	}

	public static void creerPlateauTest() {

		reinitialiserPlateauTest();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (plateau[i][j] == 'M') {
					plateauTest[i + 1][j + 1] = 1;
				} else if (plateau[i][j] == 'G') {
					plateauTest[i + 1][j + 1] = 1;
				} else if (plateau[i][j] == 'X') {
					plateauTest[i + 1][j + 1] = 9;
				}

			}
		}

		// affichePlateauTest();

	}

	// il faut tester à chaque fois qu'on pose un mur que tous les joueurs peuvent
	// aller sur un joyau et que toutes les pos initiales puissent aller un joyau
	public static boolean verifierLesChemins(int xMur, int yMur) {

		for (Tortue tortue : Game.tortues) {

			creerPlateauTest();
			plateauTest[yMur + 1][xMur + 1] = 1;

			if (PathFinder.isThereAPath(plateauTest, tortue.getInitialxPos() + 1,
					tortue.getInitialyPos() + 1) == false) {
				// TODO ecrire dans le instruction panel que le mur ne peut pas etre pose ici
				System.out.println("position initiale de " + tortue.getColor() + " ne peut atteindre aucun joyau");
				return false;
			}

			creerPlateauTest();
			plateauTest[yMur + 1][xMur + 1] = 1;

			if (PathFinder.isThereAPath(plateauTest, tortue.getxPos() + 1, tortue.getyPos() + 1) == false) {
				System.out.println("position de " + tortue.getColor() + " ne peut atteindre aucun joyau");
				return false;
			}

		}

		// System.out.println("chemins bons");
		return true;

	}

}
