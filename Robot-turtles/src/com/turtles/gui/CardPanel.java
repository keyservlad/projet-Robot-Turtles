package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
	
	private static final Dimension CARD_PANEL_DIMENSION = new Dimension(5, 10);
	private final int posCard;
	private String type;
	
	private final String BlueCardIconPath = "./ressources/images/cards/BlueCard-1.png";
	private final String LaserIconPath = "./ressources/images/cards/LaserCard.png";
	private final String PurpleCardIconPath = "./ressources/images/cards/PurpleCard.png";
	private final String YellowCardIconPath = "./ressources/images/cards/YellowCard.png";
	
	private int X, Y, initialX, initialY;
	
	CardPanel(final String typePanel, final int posCard, int tourDuJoueur){
		
		super(new GridBagLayout());
		
		this.posCard = posCard;
		
		setPreferredSize(CARD_PANEL_DIMENSION);
		setBackground(new Color(1.0f, 1.0f, 1.0f ,0.55f));
		if (typePanel.contentEquals("Programme")){
			assignImage(Game.tortues.get(tourDuJoueur).getProgramme().getCardsList().get(posCard));
		}else {
			assignImage(Game.tortues.get(tourDuJoueur).getMain().getCardsList().get(posCard));
		}
		
		
		addMouseListener(new MouseGlassListener(FenetreJeu.glass));
		addMouseMotionListener(new MouseGlassMotionListener(FenetreJeu.glass));
		
/*
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
	
				initialX = e.getComponent().getX();
				initialY = e.getComponent().getY();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				X = e.getX();
				Y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				e.getComponent().setLocation(initialX, initialY);
				
			}
			
		});
		
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				e.getComponent().setLocation(e.getX() + e.getComponent().getX() - X, e.getY() + e.getComponent().getY() - Y);
				
				System.out.println(e.getY() + e.getComponent().getY());
				
				if (e.getY() + e.getComponent().getY() > 10000 ) {
					//refaire les limites et ajouter l'action de la carte
					switch(FenetreJeu.typeDeLaCarteSelectionnee(e.getComponent())) {
					case "Bleue":
						System.out.println("bleu"); // TODO repprendre ici, refaire les cartes au photoshop, passer le jpanel handpanel devant le boardpanel, GUI part VII, grossir la carte quand on passe dessus, relier Carte avec la cardPanel en passant par toutes les cartes de la main je pense, puis faire l'action de la carte associee au joueur
						break;
						
					case "Jaune":
						System.out.println("jaune");
						break;
						
					case "Violette":
						System.out.println("violette");
						break;
						
					case "Laser":
						System.out.println("laser");
						break;
					}
					//FenetreJeu.removeCarte(e.getComponent()); TODO
				}
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		*/
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
	
	public int getInitialX() {
		return this.initialX;
	}
	
	public int getInitialY() {
		return this.initialY;
	}
	
	

}
