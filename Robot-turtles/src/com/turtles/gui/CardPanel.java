package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Carte;
import com.turtles.Game;
import com.turtles.Plateau;

public class CardPanel extends JPanel{
	
	private static final Dimension CARD_PANEL_DIMENSION = new Dimension(10, 20);
	private final int posCard;
	private String type;
	
	private final String BlueCardIconPath = "./ressources/images/cards/BlueCard.png";
	private final String LaserIconPath = "./ressources/images/cards/LaserCard.png";
	private final String PurpleCardIconPath = "./ressources/images/cards/PurpleCard.png";
	private final String YellowCardIconPath = "./ressources/images/cards/YellowCard.png";
	
	CardPanel(final HandPanel handPanel, final int posCard, int tourDuJoueur){
		
		super(new GridBagLayout());
		
		this.posCard = posCard;
		
		setPreferredSize(CARD_PANEL_DIMENSION);
		setBackground(new Color(1.0f, 1.0f, 1.0f ,0.55f));
		
		assignImage(Game.tortues.get(tourDuJoueur).getMain().getCardsList().get(posCard));
		validate();
	}

	private void assignImage(Carte carte) {
		this.removeAll();
		
		
		
		
		try {
			BufferedImage image = null;
			if (carte.getType().contentEquals("Bleue")) {
				image = ImageIO.read(new File(BlueCardIconPath));
				this.setType("Bleue");
			}else if(carte.getType().contentEquals("Jaune")) {
				image = ImageIO.read(new File(YellowCardIconPath));
				this.setType("Jaune");
			}else if(carte.getType().contentEquals("Violette")) {
				image = ImageIO.read(new File(PurpleCardIconPath));
				this.setType("Violette");
			}else if (carte.getType().contentEquals("Laser")) {
				image = ImageIO.read(new File(LaserIconPath));
				this.setType("Laser");
			}else {
				System.out.println("erreur");
			}
				
				
				
			
			add(new JLabel(new ImageIcon(image)));
			
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
