package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MurPanel extends JPanel{
	
	private Dimension MUR_PANEL_DIMENSION = new Dimension(30, 30);
	private MouseGlassListener ml;
	private MouseGlassMotionListener mml;
	
	public MurPanel(String type) {
		switch (type) {
		case "Glace" : 
			setBackground(Color.blue);
			break;
			
			
		case "Pierre" : 
			setBackground(Color.gray);
			break;
			
			
		}
		this.setName("MurPanel");
		this.ml = new MouseGlassListener(Fenetre.glass);
		this.mml = new MouseGlassMotionListener(Fenetre.glass);
		
		//this.addMouseListener(this.ml);
		//this.addMouseMotionListener(this.mml);
		
		
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
