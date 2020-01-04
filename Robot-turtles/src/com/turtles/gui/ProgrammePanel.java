package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.turtles.Game;

public class ProgrammePanel extends JPanel{
	
	private static final Dimension PROGRAMME_PANEL_DIMENSION = new Dimension(450, 157);
	
	private CardPanel[] handCards;
	
	ProgrammePanel(){
		super(new FlowLayout(FlowLayout.CENTER, 5, 50));
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		//creationCartes();
		
		setPreferredSize(PROGRAMME_PANEL_DIMENSION);
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
			cardPanel.setIsMovable(false);
			this.handCards[i] = cardPanel;
			add(cardPanel);
		}
	}
}
