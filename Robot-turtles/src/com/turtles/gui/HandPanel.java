package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import com.turtles.Game;

public class HandPanel extends JPanel {

	private static final Dimension HAND_PANEL_DIMENSION = new Dimension(450, 157);
	private CardPanel[] handCards;

	public HandPanel(JPanel jpanel) {
		super(new FlowLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
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
			CardPanel cardPanel = new CardPanel(i, Game.tourDuJoueur, true, "Hand");

			this.handCards[i] = cardPanel;
			add(cardPanel);
		}

	}

}
