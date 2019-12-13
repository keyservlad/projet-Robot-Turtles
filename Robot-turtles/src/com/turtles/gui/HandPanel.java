package com.turtles.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.turtles.Carte;
import com.turtles.Game;


public class HandPanel extends JPanel{
	
	private static final Dimension HAND_PANEL_DIMENSION = new Dimension(400, 200);
	private CardPanel[] handCards;
	
	public HandPanel(int tourDuJoueur) {
		super(new GridLayout(1, Game.tortues.get(tourDuJoueur).getMain().getCardsList().size(), 2, 2));

		this.handCards = new CardPanel[Game.tortues.get(tourDuJoueur).getMain().getCardsList().size()];
		
		for (int i = 0; i < Game.tortues.get(tourDuJoueur).getMain().getCardsList().size(); i++) {
			CardPanel cardPanel = new CardPanel(this, i, tourDuJoueur);
			
			this.handCards[i] = cardPanel;
			add(cardPanel);
		}
		
		setPreferredSize(HAND_PANEL_DIMENSION);
		validate();
	}
	
	

}
