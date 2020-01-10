package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Carte;
import com.turtles.Game;

public class CardPanel extends JPanel{
	
	private static final Dimension CARD_PANEL_DIMENSION = new Dimension(100, 135);
	private final int posCard;
	private String type;
	private boolean isMovable = true;
	private boolean isVisible = true;
	
	private final String BlueCardIconPath = "./ressources/images/cards/BlueCard.png";
	private final String LaserIconPath = "./ressources/images/cards/LaserCard.png";
	private final String PurpleCardIconPath = "./ressources/images/cards/PurpleCard.png";
	private final String YellowCardIconPath = "./ressources/images/cards/YellowCard.png";
	
	private final String LegendCardBack = "./ressources/images/cards/legendCardBack.png";
	
	private int X, Y, initialX, initialY;
	
	private MouseGlassListener ml;
	private MouseGlassMotionListener mml;
	
	CardPanel(final int posCard, int tourDuJoueur, boolean isVisible, String panel){
		
		super(new GridBagLayout());
		
		this.posCard = posCard;
		this.isVisible = isVisible;
		
		setPreferredSize(CARD_PANEL_DIMENSION);
		setBackground(new Color(1.0f, 1.0f, 1.0f ,0.0f));
		if (this.isVisible == false){
			assignImage();
		}else {
			if (panel.contentEquals("Hand")) {
				assignImage(Game.tortues.get(tourDuJoueur).getMain().getCardsList().get(posCard));
			}else {
				assignImage(Game.tortues.get(tourDuJoueur).getProgramme().getCardsList().get(posCard));
			}
			
		}
		
		
		validate();
	}

	private void assignImage() {
		this.removeAll();
		try {
			add(new JLabel(new ImageIcon(ImageIO.read(new File(LegendCardBack)))));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	public void assignImage(Carte carte) {
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
	
	public int getPosCard() {
		return this.posCard;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getInitialX() {
		return this.initialX;
	}
	
	public int getInitialY() {
		return this.initialY;
	}
	
	public boolean getIsMovable() {
		return this.isMovable;
	}
	
	public void setIsMovable(boolean isMovable) {
		this.isMovable = isMovable;
	}
	
	public boolean getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public void removeMouseListeners() {
		this.removeMouseListener(ml);
		this.removeMouseMotionListener(mml);
	}
	
	public void addMouseListeners() {
		this.ml = new MouseGlassListener(Fenetre.glass);
		this.mml = new MouseGlassMotionListener(Fenetre.glass);
		
		this.addMouseListener(this.ml);
		this.addMouseMotionListener(this.mml);
	}
	
	

}
