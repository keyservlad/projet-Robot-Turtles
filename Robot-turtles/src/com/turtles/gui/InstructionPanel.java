package com.turtles.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel{
	
	private Dimension INSTRUCTION_PANEL_DIMENSION = new Dimension(735, 175);
	private String instructions;
	private JLabel instructionsLabel;
	
	public InstructionPanel() {
		super();
		
		
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
