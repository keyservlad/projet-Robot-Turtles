package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.turtles.Game;

public class EastPanel extends JPanel {
	private static final Dimension EAST_PANEL_DIMENSION = new Dimension(735, 450);

	private InstructionPanel instructionPanel = new InstructionPanel();
	private RessourcesPanel ressourcesPanel = new RessourcesPanel();
	private JPanel middlePanel;
	private static JButton endButton;
	private static Color colorButton;

	public EastPanel() {
		super(new BorderLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		setPreferredSize(EAST_PANEL_DIMENSION);

		middlePanel = new JPanel();

		endButton = new JButton("Fin de tour");
		colorButton = endButton.getBackground();

		endButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Game.etatPartie = EtatPartie.DESIGNATIONJOUEUR;

			}
		});

		// this.desactiverBouton();

		endButton.setPreferredSize(new Dimension(100, 30));

		this.middlePanel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		this.middlePanel.add(endButton);

		add(middlePanel, BorderLayout.CENTER);
		add(ressourcesPanel, BorderLayout.SOUTH);
		add(instructionPanel, BorderLayout.NORTH);

		validate();
	}

	public InstructionPanel getInstructionPanel() {
		return this.instructionPanel;

	}

	public RessourcesPanel getRessourcesPanel() {
		return this.ressourcesPanel;

	}

	public static void activerBouton() {
		endButton.setEnabled(true);
	}

	public static void desactiverBouton() {
		endButton.setBackground(colorButton);
		endButton.setEnabled(false);
	}

	public void couleurNormaleBouton() {
		endButton.setBackground(colorButton);
	}

	public void vouleurVerteBouton() {
		endButton.setBackground(Color.green);
	}
}
