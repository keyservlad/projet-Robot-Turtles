package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EastPanel extends JPanel{
	
	private ArrayList<JButton> listeBoutons = new ArrayList<>();
	
	private static final Dimension EAST_PANEL_DIMENSION = new Dimension(735, 1080);
	
	public EastPanel() {
		super();
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		setPreferredSize(EAST_PANEL_DIMENSION);
		validate();
	}

}
