package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.turtles.Game;

public class EastPanel extends JPanel{
	
	private ArrayList<JButton> listeBoutons = new ArrayList<>();
	
	private static final Dimension EAST_PANEL_DIMENSION = new Dimension(735, 450);
	
	private InstructionPanel instructionPanel = new InstructionPanel();
	private RessourcesPanel ressourcesPanel = new RessourcesPanel();
	private JPanel middlePanel;
	private JButton endButton;
	private Color colorButton;
	
	public EastPanel() {
		super(new BorderLayout());
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		setPreferredSize(EAST_PANEL_DIMENSION);
		
		middlePanel = new JPanel();
		
		endButton = new JButton("Fin de tour");
		colorButton = endButton.getBackground();
		
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Game.etatPartie == EtatPartie.COMPLETER) {
					//TODO
				}
				
			}
		});
		
		this.desactiverBouton();
		
		endButton.setPreferredSize(new Dimension(100, 30));
		
		this.middlePanel.add(endButton);
	
		add(middlePanel, BorderLayout.CENTER);
		add(ressourcesPanel, BorderLayout.SOUTH);
		add(instructionPanel, BorderLayout.NORTH);
		
		
		
		validate();
	}

	public InstructionPanel getInstructionPanel() {
		return this.instructionPanel;
		
		
	}
	
	public RessourcesPanel getRessourcesPanel() {
		return this.ressourcesPanel;
		
		
	}
	
	public void activerBouton() {
		this.endButton.setEnabled(true);
	}
	
	public void desactiverBouton() {
		this.endButton.setBackground(colorButton);
		this.endButton.setEnabled(false);
	}
	
	public void couleurNormaleBouton() {
		this.endButton.setBackground(colorButton);
	}
	
	public void vouleurVerteBouton() {
		this.endButton.setBackground(Color.green);
	}
}
