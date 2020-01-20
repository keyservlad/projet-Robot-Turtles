package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Game;

public class RessourcesPanel extends JPanel{
	
	private JPanel deckPanel = new JPanel();
	private InventairePanel inventairePanel = new InventairePanel();
	private final String LegendDeck = "./ressources/images/cards/legendDeck.png";
	//private final String LegendDeckVide = "./ressources/images/cards/legendDeckVide.png";
	private Dimension RESSOURCES_PANEL_DIMENSION = new Dimension(735, 175);
	
	public RessourcesPanel() {
		super(null);
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		this.setPreferredSize(RESSOURCES_PANEL_DIMENSION);
		this.setSize(RESSOURCES_PANEL_DIMENSION);
		
		deckPanel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		deckPanel.removeAll();
		try {
			
			deckPanel.add(new JLabel(new ImageIcon(ImageIO.read(new File(LegendDeck)))));
			// deck vide à implémenter dans une fonction drawDeck à rajouter (optionel) 
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		inventairePanel.setBounds(370,10, inventairePanel.getWidth(), inventairePanel.getHeight());
		deckPanel.setLocation(150, 10);
		
		
		
		
		deckPanel.setSize(150,170);
		
		
		add(deckPanel);
		add(inventairePanel);
		validate();
		
		
	}
	
	
	

}
