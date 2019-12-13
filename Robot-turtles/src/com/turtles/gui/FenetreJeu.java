package com.turtles.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FenetreJeu {
	
	private JFrame gameFrame = new JFrame();
	
	private final BoardPanel boardPanel;
	private static HandPanel handPanel = null;
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1000, 1000);

	
	public FenetreJeu(int tourDuJoueur) {
		
		
		gameFrame = new JFrame("Robot Turtles");
		gameFrame.setLayout(new BorderLayout());
		
		//final JMenuBar tableMenuBar = createTableMenuBar();
		//this.gameFrame.setJMenuBar(tableMenuBar);
		
		
		gameFrame.setSize(OUTER_FRAME_DIMENSION);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.handPanel = new HandPanel(tourDuJoueur);
		this.boardPanel = new BoardPanel();
		
		
		gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		//this.gameFrame.setResizable(false);
		gameFrame.setAlwaysOnTop(true);
		gameFrame.add(this.handPanel, BorderLayout.SOUTH);
		MouseMovement move = new MouseMovement(handPanel.getComponents());
		
		
		
		
		gameFrame.setVisible(true);
		gameFrame.setAlwaysOnTop(false);
	}


	public static void removeCarte(Component component) {
		handPanel.remove(component);
		
	}
	
	public void cacherGameFrame() {
		this.gameFrame.setVisible(false);
	}
	
	
	
/*
	private JMenuBar createTableMenuBar() {
		
		JMenuBar tableMenuBar = new JMenuBar();
		tableMenuBar.add(createFileMenu());
		
		return tableMenuBar;
		
	}*/
	/*
	private JMenu createFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		
		final JMenuItem openPGN = new JMenuItem("Load PGN File");
		
		openPGN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("open PGN");
			};
		});
			fileMenu.add(openPGN);
			
			final JMenuItem exitMenuItem = new JMenuItem("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
				
			});
			fileMenu.add(exitMenuItem);
			
			return fileMenu;
			
	}*/

}
