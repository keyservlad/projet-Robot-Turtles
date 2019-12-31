package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel{
	
	private ArrayList<JButton> listeBoutons = new ArrayList<>();
	
	public ButtonsPanel() {
		super();
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		setPreferredSize(new Dimension(200, 200));
		validate();
	}

}
