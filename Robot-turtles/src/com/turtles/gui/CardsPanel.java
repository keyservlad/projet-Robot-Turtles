package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CardsPanel extends JPanel {

	public static HandPanel handPanel;
	public static ProgrammePanel programmePanel;

	CardsPanel() {
		super(new BorderLayout(0, 4));
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

		handPanel = new HandPanel(this);
		programmePanel = new ProgrammePanel();

		add(handPanel, BorderLayout.SOUTH);
		add(programmePanel, BorderLayout.NORTH);

		validate();
	}

	public void drawHandProgramme() {
		
		handPanel.drawCards();
		programmePanel.drawCards();

		

	}

}
