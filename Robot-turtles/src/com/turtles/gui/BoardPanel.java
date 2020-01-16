package com.turtles.gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BoardPanel extends JPanel{
	
	private final String nom_fichier_image = "./ressources/images/background.jpeg";
	
	public void paintComponent(Graphics g){
	    try {
	      Image img = ImageIO.read(new File(nom_fichier_image));
	      
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }                
	  }
	
	private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(450, 450);
	
	
	final TilePanel[][] boardTiles;
	
	public BoardPanel() {
		super(new GridLayout(8, 8, 2, 2));
		
		this.boardTiles = new TilePanel[8][8];
		
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				final TilePanel tilePanel = new TilePanel(this, i, j);
				this.boardTiles[i][j] = tilePanel;
				add(tilePanel);
				
			}
			
			
			
			
		}
		
		
		setPreferredSize(BOARD_PANEL_DIMENSION);
		setSize(this.getPreferredSize());
		validate();
		
	}
	
	public void drawBoard() {
		removeAll();
		for (final TilePanel tilePanelRow[] : boardTiles) {
			for (final TilePanel tilePanel : tilePanelRow) {
				tilePanel.drawTile();
				add(tilePanel);
			}
			
			validate();
			repaint();
			
		}
		
		
	}

}
