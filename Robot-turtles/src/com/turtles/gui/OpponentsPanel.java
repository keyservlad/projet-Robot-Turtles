package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Game;
import com.turtles.Tortue;

public class OpponentsPanel extends JPanel {

	private static final Dimension OPPONENTS_PANEL_DIMENSION = new Dimension(600, 350);

	public OpponentsPanel(Tortue tortue) {
		super(new BorderLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		setPreferredSize(OPPONENTS_PANEL_DIMENSION);

		add(new OpponentHandPanel(tortue), BorderLayout.NORTH);
		add(new OpponentInventoryPanel(tortue), BorderLayout.SOUTH);

		validate();

	}

	private class OpponentHandPanel extends JPanel {

		private Dimension OPPONENTS_HAND_PANEL_DIMENSION = new Dimension(600, 157);
		private CardPanel[] handCards;

		public OpponentHandPanel(Tortue tortue) {
			super();
			setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
			creationMain(tortue);
			setPreferredSize(OPPONENTS_HAND_PANEL_DIMENSION);
			validate();

		}

		private void creationMain(Tortue tortue) {

			this.handCards = new CardPanel[tortue.getMain().getCardsList().size()];

			for (int i = 0; i < tortue.getMain().getCardsList().size(); i++) {

				int tourDuJoueur = 0;
				int j = 0;
				for (Tortue tortu : Game.tortues) {
					if (tortu.getColor().contentEquals(tortue.getColor())) {
						tourDuJoueur = j;
					}
					j++;
				}
				CardPanel cardPanel = new CardPanel(i, tourDuJoueur, false, "Hand");

				this.handCards[i] = cardPanel;
				add(cardPanel);
			}

		}

	}

	private class OpponentInventoryPanel extends JPanel {

		private Dimension INVENTAIRE_PANEL_DIMENSION = new Dimension(300, 135);
		private JPanel murConteneurPanel = new JPanel();
		private JPanel glaceConteneurPanel = new JPanel();

		private JLabel nombreMursLabel = new JLabel();
		private JLabel nombreGlacesLabel = new JLabel();
		private int nombreMurs;
		private int nombreGlaces;

		private MurPanel murPanel = new MurPanel("Pierre");
		private MurPanel glacePanel = new MurPanel("Glace");

		private Font font2 = new Font("arial", Font.PLAIN, 30);

		public OpponentInventoryPanel(Tortue tortue) {
			super(new GridLayout(1, 2));
			setBackground(new Color(0.0f, 1.0f, 1.0f, 0.0f));

			this.setPreferredSize(INVENTAIRE_PANEL_DIMENSION);
			setSize(INVENTAIRE_PANEL_DIMENSION);
			murConteneurPanel.setBackground(new Color(0.0f, 0.0f, 1.0f, 0.0f));
			glaceConteneurPanel.setBackground(new Color(1.0f, 0.0f, 1.0f, 0.0f));

			add(murConteneurPanel);
			add(glaceConteneurPanel);

			this.nombreMurs = tortue.nbMurs();
			this.nombreGlaces = tortue.nbGlaces();

			nombreMursLabel.setFont(font2);
			nombreGlacesLabel.setFont(font2);
			nombreMursLabel.setForeground(Color.white);
			nombreGlacesLabel.setForeground(Color.white);

			nombreMursLabel.setText(Integer.toString(nombreMurs));
			nombreGlacesLabel.setText(Integer.toString(nombreGlaces));

			murConteneurPanel.add(nombreMursLabel);
			glaceConteneurPanel.add(nombreGlacesLabel);
			murConteneurPanel.add(murPanel);
			glaceConteneurPanel.add(glacePanel);

			validate();

		}

	}
}
