package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {
	
	private static final Dimension NORTH_PANEL_DIMENSION = new Dimension(450, 315);

	public NorthPanel() {
		super();
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));	//on definit la transparence pour pouvoir voir l'image de fond
		setPreferredSize(NORTH_PANEL_DIMENSION);
		validate();
		
	}
}
