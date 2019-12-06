package com.turtles.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.turtles.Game;
import com.turtles.Plateau;




public class TilePanel extends JPanel{
	
	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
	private final int tilex;
	private final int tiley;
	
	private final String tortueRougeIconPath = "./ressources/images/turtle2.png";
	private final String tortueVerteIconPath = "./ressources/images/turtle4.png";		// reprendre ici , faire des images en png, tres petites
	private final String tortueBleueIconPath = "./ressources/images/turtle1.png";
	private final String tortueJauneIconPath = "./ressources/images/turtle3.png";
	private final String murIconPath = "./ressources/images/WALL.png";
	private final String glaceIconPath = "./ressources/images/ICE.png";
	private final String rubyIconPath = "./ressources/images/RUBY.png";
	
	public TilePanel(final BoardPanel boardPanel, final int tiley, final int tilex){
		super(new GridBagLayout());
		this.tilex = tilex;
		this.tiley = tiley;
		setPreferredSize(TILE_PANEL_DIMENSION);
		//setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); couleur noire
		setBackground(new Color(1.0f, 1.0f, 1.0f ,0.55f)); // couleur blanche (on prend entre 0 et 1 r, g, b et le 4 argument est la transparence
		// ne pas oublier qu'on peut changer de couleur chaque tuile individuellement, cela peut servir...
		
		assignTilePieceIcon(Game.plateau);
		validate();
		
	}
	
	private void assignTilePieceIcon(final Plateau plateau) {
		this.removeAll();
		
		if (plateau.getPlateau()[this.tiley][this.tilex] != ' ') {
			
			
			try {
				BufferedImage image = null;
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
					image = ImageIO.read(new File(tortueRougeIconPath));
					break;
					
				case 'V':
					image = ImageIO.read(new File(tortueVerteIconPath));
					break;
					
				case 'B':
					image = ImageIO.read(new File(tortueBleueIconPath));
					break;
					
				case 'J':
					image = ImageIO.read(new File(tortueJauneIconPath));
					break;
					
				
					
				}
				
				add(new JLabel(new ImageIcon(image)));
				
				
				
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

	

}
