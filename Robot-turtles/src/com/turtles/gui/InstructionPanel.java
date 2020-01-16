package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel{
	
	private Dimension INSTRUCTION_PANEL_DIMENSION = new Dimension(735, 175);
	private String instructions;
	private JLabel instructionsLabel;
	
	public InstructionPanel() {
		super();
		
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.f));
		//this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		instructionsLabel = new JLabel();
		add(instructionsLabel);
		
		this.setPreferredSize(INSTRUCTION_PANEL_DIMENSION);
		this.setSize(INSTRUCTION_PANEL_DIMENSION);
		validate();
		
		
		
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
		instructionsLabel.setText(instructions);
		
	}
	
	public String getInstructions() {
		return this.instructions;
	}

}
