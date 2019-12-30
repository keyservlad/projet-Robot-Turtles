package com.turtles.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.turtles.Carte;
import com.turtles.Game;


public class HandPanel extends JPanel{
	
	private static final Dimension HAND_PANEL_DIMENSION = new Dimension(400, 200);
	private CardPanel[] handCards;
	
	public HandPanel(JPanel jpanel, int tourDuJoueur) {
		//super(new GridLayout(1, Game.tortues.get(tourDuJoueur).getMain().getCardsList().size(), 2, 2));
		super(new FlowLayout());
		creationMain();
		
		
		setPreferredSize(HAND_PANEL_DIMENSION);
		validate();
	}
	
	public CardPanel[] getHandcards() {
		return this.handCards;
	}

	public void drawCards() {
		this.removeAll();
		creationMain();
		validate();
		repaint();

	}
	
	public void creationMain() {
		this.handCards = new CardPanel[Game.tortues.get(Game.tourDuJoueur).getMain().getCardsList().size()];
		
		for (int i = 0; i < Game.tortues.get(Game.tourDuJoueur).getMain().getCardsList().size(); i++) {
			CardPanel cardPanel = new CardPanel("Main", i, Game.tourDuJoueur);
			
			this.handCards[i] = cardPanel;
			add(cardPanel);
		}
		
	}

}
