package com.turtles.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.turtles.Game;

public class ProgrammePanel extends JPanel{
	
	private static final Dimension HAND_PANEL_DIMENSION = new Dimension(400, 200);
	
	private CardPanel[] handCards;
	
	ProgrammePanel(int tourDuJoueur){
		super(new GridLayout(1, Game.tortues.get(tourDuJoueur).getProgramme().getCardsList().size(), 2, 2));
		
		//creationCartes();
		
		setPreferredSize(HAND_PANEL_DIMENSION);
		validate();
	}
	
	public void drawCards() {
		this.removeAll();
		creationCartes();
		validate();
		repaint();
	}
	
	public void creationCartes() {
		this.handCards = new CardPanel[Game.tortues.get(Game.tourDuJoueur).getProgramme().getCardsList().size()];
		
		for (int i = 0; i < Game.tortues.get(Game.tourDuJoueur).getProgramme().getCardsList().size() ; i++) {
			CardPanel cardPanel = new CardPanel("Programme", i, Game.tourDuJoueur);
			
			this.handCards[i] = cardPanel;
			add(cardPanel);
		}
	}
}