package com.turtles.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Fenetre {
	
	private final JFrame gameFrame;
	
	private final BoardPanel boardPanel;
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
	
	
	public Fenetre() {
		super();
		
		this.gameFrame = new JFrame("Robot Turtles");
		this.gameFrame.setLayout(new BorderLayout());
		
		final JMenuBar tableMenuBar = createTableMenuBar();
		this.gameFrame.setJMenuBar(tableMenuBar);
		
		
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		
		this.boardPanel = new BoardPanel();
		
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		this.gameFrame.setVisible(true);
	}

	private JMenuBar createTableMenuBar() {
		
		JMenuBar tableMenuBar = new JMenuBar();
		tableMenuBar.add(createFileMenu());
		
		return tableMenuBar;
		
	}

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
			
	}

}
