package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.turtles.Game;

public class InventairePanel extends JPanel{
	
	private Dimension INVENTAIRE_PANEL_DIMENSION = new Dimension(300, 135);
	private JPanel murConteneurPanel = new JPanel();
	private JPanel glaceConteneurPanel = new JPanel();
	 
	private static JLabel nombreMursLabel = new JLabel();
	private static JLabel nombreGlacesLabel = new JLabel();
	private static int nombreMurs;
	private static int nombreGlaces;
	
	private static MurPanel murPanel = new MurPanel("Pierre");
	private static MurPanel glacePanel = new MurPanel("Glace");
	
	private Font font2 = new Font("arial", Font.PLAIN, 30);
	
	
	
	

	
	
	public InventairePanel() {
		super(new GridLayout(2, 1));
		setBackground(new Color(0.0f, 1.0f, 1.0f, 0.0f));
		
		this.setPreferredSize(INVENTAIRE_PANEL_DIMENSION);
		setSize(INVENTAIRE_PANEL_DIMENSION);
		murConteneurPanel.setBackground(new Color(0.0f, 0.0f, 1.0f, 0.0f));
		glaceConteneurPanel.setBackground(new Color(1.0f, 0.0f, 1.0f, 0.0f));
		
		add(murConteneurPanel);
		add(glaceConteneurPanel);
		
		setNombreMurs(3);
		setNombreGlaces(2);
		
		nombreMursLabel.setText(Integer.toString(nombreMurs));
		nombreGlacesLabel.setText(Integer.toString(nombreGlaces));
		nombreMursLabel.setFont(font2);
		nombreGlacesLabel.setFont(font2);
		
		
		
		murConteneurPanel.add(nombreMursLabel);
		glaceConteneurPanel.add(nombreGlacesLabel);
		murConteneurPanel.add(murPanel);
		glaceConteneurPanel.add(glacePanel);
		
		validate();
		
		
		
	}
	
	public int getWidth() {
		return this.INVENTAIRE_PANEL_DIMENSION.width;
		
	}
	
	public int getHeight() {
		return this.INVENTAIRE_PANEL_DIMENSION.height;
	}
	
	public void setNombreMurs(int nombreMurs) {
		this.nombreMurs = nombreMurs;
	}
	
	public void setNombreGlaces(int nombreGlaces) {
		this.nombreGlaces = nombreGlaces;
	}
	
	public static void refreshMurs() {
		nombreMurs = Game.tortues.get(Game.tourDuJoueur).nbMurs();
		nombreGlaces = Game.tortues.get(Game.tourDuJoueur).nbGlaces();
		nombreMursLabel.setText(Integer.toString(nombreMurs));
		nombreGlacesLabel.setText(Integer.toString(nombreGlaces));
	}
	
	
	
	public static void activeLesMurs() {
		murPanel.addMouseListeners();
		glacePanel.addMouseListeners();
	}
	
	public static void desactiveLesMurs() {
		murPanel.removeMouseListeners();
		glacePanel.removeMouseListeners();
	}
}
