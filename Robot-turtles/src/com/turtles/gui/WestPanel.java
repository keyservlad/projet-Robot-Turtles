package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Game;
import com.turtles.Tortue;

public class WestPanel extends JPanel{
	
	private static final Dimension WEST_PANEL_DIMENSION = new Dimension(735, 1080);
	private static JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private static JPanel scorePanel = new JPanel();
	private static JButton changerDeMain;
	private static JButton nePasChangerDeMain;
	
	public WestPanel() {
		super(new BorderLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
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
		northPanel.add(new JLabel("C'est au tour du joueur " + Game.tortues.get(Game.tourDuJoueur).getColor()));
		for (Tortue tortue : Game.tortues) {
			scorePanel.add(new JLabel("Joueur " + tortue.getColor() + " : " + tortue.getScore())); 
		}
		
	}
	

}
