package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MurPanel extends JPanel{
	
	private Dimension MUR_PANEL_DIMENSION = new Dimension(40, 40);
	private MouseGlassListener ml;
	private MouseGlassMotionListener mml;
	private final String ICEimage = "./ressources/images/ICE.png";
	private final String WALLimage = "./ressources/images/WALL.png";
	
	public MurPanel(String type) {
		setBackground(new Color(0f, 0f, 0f, 0f));
		switch (type) {
		case "Glace" : 
			try {
				add(new JLabel(new ImageIcon(ImageIO.read(new File(ICEimage)).getScaledInstance(35, 35, 35))));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			this.setName("GlacePanel");
			break;
			
			
		case "Pierre" : 
			
			try {
				add(new JLabel(new ImageIcon(ImageIO.read(new File(WALLimage)).getScaledInstance(35, 35, 35))));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			this.setName("MurPanel");
			break;
			
			
		}
		
		
		setPreferredSize(MUR_PANEL_DIMENSION);
		setSize(MUR_PANEL_DIMENSION);
		validate();
		
	}
	
	
	public void removeMouseListeners() {
		this.removeMouseListener(ml);
		this.removeMouseMotionListener(mml);
	}
	
	public void addMouseListeners() {
		this.ml = new MouseGlassListener(Fenetre.glass);
		this.mml = new MouseGlassMotionListener(Fenetre.glass);
		
		this.addMouseListener(this.ml);
		this.addMouseMotionListener(this.mml);
	}

}
