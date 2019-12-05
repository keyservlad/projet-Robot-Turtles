package com.turtles.gui;

import java.awt.*;

import javax.swing.*;



public class TilePanel extends JPanel{
	
	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
	private final int tileId;
	
	
	public TilePanel(final BoardPanel boardPanel, final int tileId){
		super(new GridBagLayout());
		this.tileId = tileId;
		setPreferredSize(TILE_PANEL_DIMENSION);
		//setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); couleur noire
		setBackground(new Color(1.0f, 1.0f, 1.0f ,0.55f)); // couleur blanche (on prend entre 0 et 1 r, g, b et le 4 argument est la transparence
		// ne pas oublier qu'on peut changer de couleur chaque tuile individuellement, cela peut servir...
		validate();
		
	}

	

}
