package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import com.turtles.Game;
import com.turtles.Tortue;

public class NorthPanel extends JPanel {
	
	private static final Dimension NORTH_PANEL_DIMENSION = new Dimension(450, 315);

	public NorthPanel() {
		super(new FlowLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));	//on definit la transparence pour pouvoir voir l'image de fond
		setPreferredSize(NORTH_PANEL_DIMENSION);
		
		
		for (Tortue tortue : Game.tortues) {
			if (!tortue.getColor().contentEquals(Game.tortues.get(Game.tourDuJoueur).getColor())) {
				add(new OpponentsPanel(tortue));
			}
		}
		
		
		validate();
		
	}
}
