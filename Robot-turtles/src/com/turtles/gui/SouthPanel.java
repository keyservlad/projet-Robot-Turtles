package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class SouthPanel extends JPanel {

	public static HandPanel handPanel;
	public static ProgrammePanel programmePanel;
	
	private static final Dimension SOUTH_PANEL_DIMENSION = new Dimension(450, 315);

	SouthPanel() {
		super(new BorderLayout(0, 4));
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

		handPanel = new HandPanel(this);
		programmePanel = new ProgrammePanel();

		add(handPanel, BorderLayout.SOUTH);
		add(programmePanel, BorderLayout.NORTH);
		
		setPreferredSize(SOUTH_PANEL_DIMENSION);

		validate();
		repaint();
	}

	public void drawHandProgramme() {
		
		handPanel.drawCards();
		programmePanel.drawCards();

	}
	
	

}
