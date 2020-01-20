package com.turtles.gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import com.turtles.Carte;
import com.turtles.Game;

public class MouseGlassListener extends MouseAdapter {

	private MyGlassPane myGlass;
	private BufferedImage image;
	private char symboleMur = ' ';

	public MouseGlassListener(MyGlassPane glass) {
		myGlass = glass;
	}

	public void mousePressed(MouseEvent event) {

		// On récupère le composant pour en déduire sa position
		Component composant = event.getComponent();
		if (composant.getName().contentEquals("CardPanel")) {

			if (Fenetre.isCardMovable(composant) == false) {
				System.out.println("carte non bougeable");
				return;
			}

			composant.hide();
			Point location = (Point) event.getPoint().clone();

			// Les méthodes ci-dessous permettent, dans l'ordre,
			// de convertir un point en coordonnées d'écran
			// et de reconvertir ce point en coordonnées fenêtres
			SwingUtilities.convertPointToScreen(location, composant);
			SwingUtilities.convertPointFromScreen(location, myGlass);

			// Les instructions ci-dessous permettent de redessiner le composant
			image = new BufferedImage(composant.getWidth(), composant.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = image.getGraphics();
			composant.paint(g);

			// On passe les données qui vont bien à notre GlassPane
			myGlass.setLocation(location);
			myGlass.setImage(image);

			// On n'oublie pas de dire à notre GlassPane de s'affichaient
			myGlass.setVisible(true);

		} else if (composant.getName().contentEquals("MurPanel") || composant.getName().contentEquals("GlacePanel")) {

			// TODO non bougeable quand = à 0

			
			if (composant.getName().contentEquals("MurPanel")) {
				symboleMur = 'M';
			}else if (composant.getName().contentEquals("GlacePanel")) {
				symboleMur = 'G';
			}
			
			Point location = (Point) event.getPoint().clone();

			// Les méthodes ci-dessous permettent, dans l'ordre,
			// de convertir un point en coordonnées d'écran
			// et de reconvertir ce point en coordonnées fenêtres
			SwingUtilities.convertPointToScreen(location, composant);
			SwingUtilities.convertPointFromScreen(location, myGlass);

			// Les instructions ci-dessous permettent de redessiner le composant
			image = new BufferedImage(composant.getWidth(), composant.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = image.getGraphics();
			composant.paint(g);

			// On passe les données qui vont bien à notre GlassPane
			myGlass.setLocation(location);
			myGlass.setImage(image);

			// On n'oublie pas de dire à notre GlassPane de s'affichaient
			myGlass.setVisible(true);
		}

	}

	public void mouseReleased(MouseEvent event) {

		// On récupère le composant pour en déduire sa position
		Component composant = event.getComponent();

		if (composant.getName().contentEquals("MurPanel") || composant.getName().contentEquals("GlacePanel")) {

			// TODO idem
			/*
			 * if (Fenetre.isCardMovable(composant) == false) { return; }
			 */

			composant.show();
			Point location = (Point) event.getPoint().clone();
			// Les méthodes ci-dessous permettent, dans l'ordre,
			// de convertir un point en coordonnées d'écran
			// et de reconvertir ce point en coordonnées fenêtre
			SwingUtilities.convertPointToScreen(location, composant);
			SwingUtilities.convertPointFromScreen(location, myGlass);

			// On passe les données qui vont bien à notre GlassPane
			myGlass.setLocation(location);
			myGlass.setImage(null);
			// On n'oublie pas de ne plus l'afficher
			myGlass.setVisible(false);
			
			Game.construireMur(event.getXOnScreen(), event.getYOnScreen(), symboleMur);
			Fenetre.getBoardPanel().drawBoard();
			InventairePanel.desactiveLesMurs();
			Game.etatPartie = EtatPartie.FINDETOUR;


		}

		else if (composant.getName().contentEquals("CardPanel")) {
			if (Fenetre.isCardMovable(composant) == false) {
				return;
			}
			composant.show();
			Point location = (Point) event.getPoint().clone();
			// Les méthodes ci-dessous permettent, dans l'ordre,
			// de convertir un point en coordonnées d'écran
			// et de reconvertir ce point en coordonnées fenêtre
			SwingUtilities.convertPointToScreen(location, composant);
			SwingUtilities.convertPointFromScreen(location, myGlass);

			// On passe les données qui vont bien à notre GlassPane
			myGlass.setLocation(location);
			myGlass.setImage(null);
			// On n'oublie pas de ne plus l'afficher
			myGlass.setVisible(false);

			int posCarteSelect = Fenetre.posDeLaCarteSelectionnee(composant);
			
			if (location.getY() < 800) {

				int i = 0;
				for (Carte carte : Game.tortues.get(Game.tourDuJoueur).getMain().getCardsList()) {
					if (posCarteSelect == i) {
						Game.tortues.get(Game.tourDuJoueur).getProgramme().ajouterCarte(carte);
						carte.setIsVisible(false);
						break;

					}
					i++;
				}

				int j = 0;
				for (Carte carte : Game.tortues.get(Game.tourDuJoueur).getMain().getCardsList()) {
					if (posCarteSelect == j) {

						Game.tortues.get(Game.tourDuJoueur).getMain().retirerUneCarte(j);
						break;
					}

					j++;
				}

				Fenetre.getSouthPanel().drawHandProgramme(); // TODO changer le cardsPanel

				Game.fenetre.ajouterListeners();
				
			}
		}
	}

	public void dropMur(int xScreen, int yScreen) {

		int[] indiceTile = { 0, 0 };
		int x = 0;
		int y = 0;

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
		}
		

	}

}
