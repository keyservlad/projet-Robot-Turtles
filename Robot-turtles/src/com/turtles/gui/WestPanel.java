package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Game;
import com.turtles.Tortue;

public class WestPanel extends JPanel {

	private static final Dimension WEST_PANEL_DIMENSION = new Dimension(735, 1080);
	private static JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private static JPanel scorePanel = new JPanel();
	private static JButton changerDeMain;
	private static JButton nePasChangerDeMain;

	public WestPanel() {
		super(new BorderLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		setPreferredSize(WEST_PANEL_DIMENSION);

		changerDeMain = new JButton("Changer de main");
		nePasChangerDeMain = new JButton("Garder sa main");
		changerDeMain.setPreferredSize(new Dimension(150, 30));
		nePasChangerDeMain.setPreferredSize(new Dimension(150, 30));

		changerDeMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desactiverBoutons();
				EastPanel.activerBouton();
				Game.etatPartie = EtatPartie.DESIGNATIONJOUEUR;
				Game.changementDeMain();

			}
		});

		nePasChangerDeMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desactiverBoutons();
				EastPanel.activerBouton();
				Game.etatPartie = EtatPartie.DESIGNATIONJOUEUR;
			}
		});

		southPanel.add(changerDeMain);
		southPanel.add(nePasChangerDeMain);

		scorePanel.setLayout(new GridLayout(4, 1));

		scorePanel.setBackground(new Color(1f, 1f, 1f, 0f));
		northPanel.setBackground(new Color(1f, 1f, 1f, 0f));
		southPanel.setBackground(new Color(1f, 1f, 1f, 0f));

		add(scorePanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);

		desactiverBoutons();

		validate();
	}

	public static void activerBoutons() {
		changerDeMain.setVisible(true);
		nePasChangerDeMain.setVisible(true);
	}

	public static void desactiverBoutons() {
		changerDeMain.setVisible(false);
		nePasChangerDeMain.setVisible(false);
	}

	public static void actualiserCouleur() {
		northPanel.removeAll();
		scorePanel.removeAll();

		JLabel lab = new JLabel("C'est au tour de la tortue " + Game.tortues.get(Game.tourDuJoueur).getColor());
		JLabel lab2 = null;

		northPanel.add(lab);
		for (Tortue tortue : Game.tortues) {
			lab2 = new JLabel("Tortue " + tortue.getColor() + " : " + tortue.getScore());
			scorePanel.add(lab2);
			lab2.setForeground(Color.white);
		}
		lab.setForeground(Color.white);

	}

}
