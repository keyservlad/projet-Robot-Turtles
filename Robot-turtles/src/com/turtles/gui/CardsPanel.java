package com.turtles.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CardsPanel extends JPanel {

	public static HandPanel handPanel;
	public static ProgrammePanel programmePanel;

	CardsPanel(int tourDuJoueur) {
		super(new BorderLayout(0, 4));

		handPanel = new HandPanel(this, tourDuJoueur);
		programmePanel = new ProgrammePanel(tourDuJoueur);

		add(handPanel, BorderLayout.SOUTH);
		add(programmePanel, BorderLayout.NORTH);

		validate();
	}

	public void drawHandProgramme() {
		
		handPanel.drawCards();
		programmePanel.drawCards();

		

	}

}
