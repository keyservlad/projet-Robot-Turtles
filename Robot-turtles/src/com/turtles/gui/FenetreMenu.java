package com.turtles.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreMenu extends JFrame{
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1920, 1080);
	
	public FenetreMenu() {
		super("Robot Turtles");
		//image de fond pour rendre le bordel joli
		
		setSize(OUTER_FRAME_DIMENSION);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setResizable(false);
		setAlwaysOnTop(true);
		
		setLayout(new FlowLayout());
		add(new JLabel("Choisissez le nombre de joueurs"));
		
		setVisible(true);
	}
	
	

}
