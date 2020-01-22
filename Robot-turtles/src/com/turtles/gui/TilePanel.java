package com.turtles.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.turtles.Game;
import com.turtles.Plateau;
import com.turtles.Tortue;

public class TilePanel extends JPanel {

	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
	private final int tilex;
	private final int tiley;

	private final String tortueRougeHaut = "./ressources/images/tortues/rouge/tortue_rouge_haut.png";
	private final String tortueRougeBas = "./ressources/images/tortues/rouge/tortue_rouge_bas.png";
	private final String tortueRougeDroite = "./ressources/images/tortues/rouge/tortue_rouge_droit.png";
	private final String tortueRougeGauche = "./ressources/images/tortues/rouge/tortue_rouge_gauche.png";

	private final String tortueVerteHaut = "./ressources/images/tortues/verte/tortue_verte_haut.png";
	private final String tortueVerteBas = "./ressources/images/tortues/verte/tortue_verte_bas.png";
	private final String tortueVerteDroite = "./ressources/images/tortues/verte/tortue_verte_droit.png";
	private final String tortueVerteGauche = "./ressources/images/tortues/verte/tortue_verte_gauche.png";

	private final String tortueBleueHaut = "./ressources/images/tortues/bleue/tortue_bleue_haut.png";
	private final String tortueBleueBas = "./ressources/images/tortues/bleue/tortue_bleue_bas.png";
	private final String tortueBleueDroite = "./ressources/images/tortues/bleue/tortue_bleue_droit.png";
	private final String tortueBleueGauche = "./ressources/images/tortues/bleue/tortue_bleue_gauche.png";

	private final String tortueJauneHaut = "./ressources/images/tortues/jaune/tortue_jaune_haut.png";
	private final String tortueJauneBas = "./ressources/images/tortues/jaune/tortue_jaune_bas.png";
	private final String tortueJauneDroite = "./ressources/images/tortues/jaune/tortue_jaune_droit.png";
	private final String tortueJauneGauche = "./ressources/images/tortues/jaune/tortue_jaune_gauche.png";

	private final String murIconPath = "./ressources/images/WALL.png";
	private final String glaceIconPath = "./ressources/images/ICE.png";
	private final String rubyIconPath = "./ressources/images/RUBY.png";

	public TilePanel(final BoardPanel boardPanel, final int tiley, final int tilex) {
		super(new GridBagLayout());
		this.tilex = tilex;
		this.tiley = tiley;
		setPreferredSize(TILE_PANEL_DIMENSION);
		// setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); couleur noire
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.55f)); // couleur blanche (on prend entre 0 et 1 r, g, b et le 4
															// argument est la transparence
		// ne pas oublier qu'on peut changer de couleur chaque tuile individuellement,
		// cela peut servir...

		assignTilePieceIcon(Game.plateau);
		validate();

	}

	private void assignTilePieceIcon(final Plateau plateau) {
		this.removeAll();

		if (plateau.getPlateau()[this.tiley][this.tilex] != ' ') {

			try {
				BufferedImage image = null;
				int i = 0;
				int index = 0;

				switch (plateau.getPlateau()[this.tiley][this.tilex]) {
				case 'X':
					image = ImageIO.read(new File(rubyIconPath));
					break;

				case 'G':
					image = ImageIO.read(new File(glaceIconPath));
					break;

				case 'M':
					image = ImageIO.read(new File(murIconPath));
					break;

				case 'R':

					for (Tortue tortue : Game.tortues) {
						if (tortue.getColor().contentEquals("Rouge")) {
							index = i;
						}
						i++;
					}
					switch (Game.tortues.get(index).getDirection()) {
					case 'N':
						image = ImageIO.read(new File(tortueRougeHaut));
						break;

					case 'S':
						image = ImageIO.read(new File(tortueRougeBas));
						break;

					case 'W':
						image = ImageIO.read(new File(tortueRougeGauche));
						break;

					case 'E':
						image = ImageIO.read(new File(tortueRougeDroite));
						break;
					}

					break;

				case 'V':

					for (Tortue tortue : Game.tortues) {
						if (tortue.getColor().contentEquals("Verte")) {
							index = i;
						}
						i++;
					}
					switch (Game.tortues.get(index).getDirection()) {
					case 'N':
						image = ImageIO.read(new File(tortueVerteHaut));
						break;

					case 'S':
						image = ImageIO.read(new File(tortueVerteBas));
						break;

					case 'W':
						image = ImageIO.read(new File(tortueVerteGauche));
						break;

					case 'E':
						image = ImageIO.read(new File(tortueVerteDroite));
						break;
					}

					break;

				case 'B':

					for (Tortue tortue : Game.tortues) {
						if (tortue.getColor().contentEquals("Bleue")) {
							index = i;
						}
						i++;
					}
					switch (Game.tortues.get(index).getDirection()) {
					case 'N':
						image = ImageIO.read(new File(tortueBleueHaut));
						break;

					case 'S':
						image = ImageIO.read(new File(tortueBleueBas));
						break;

					case 'W':
						image = ImageIO.read(new File(tortueBleueGauche));
						break;

					case 'E':
						image = ImageIO.read(new File(tortueBleueDroite));
						break;
					}

					break;

				case 'J':

					for (Tortue tortue : Game.tortues) {
						if (tortue.getColor().contentEquals("Jaune")) {
							index = i;
						}
						i++;
					}
					switch (Game.tortues.get(index).getDirection()) {
					case 'N':
						image = ImageIO.read(new File(tortueJauneHaut));
						break;

					case 'S':
						image = ImageIO.read(new File(tortueJauneBas));
						break;

					case 'W':
						image = ImageIO.read(new File(tortueJauneGauche));
						break;

					case 'E':
						image = ImageIO.read(new File(tortueJauneDroite));
						break;
					}

					break;

				}

				add(new JLabel(new ImageIcon(image.getScaledInstance(50, 50, 50))));

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// TODO case initiale
		}

	}

	public void drawTile() {
		assignTilePieceIcon(Game.plateau);
		validate();
		repaint();
	}

}
