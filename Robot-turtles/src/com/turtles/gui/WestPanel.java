package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WestPanel extends JPanel{
	
	private static final Dimension WEST_PANEL_DIMENSION = new Dimension(735, 1080);
	
	public WestPanel() {
		super();
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		setPreferredSize(WEST_PANEL_DIMENSION);
		validate();
	}

}
