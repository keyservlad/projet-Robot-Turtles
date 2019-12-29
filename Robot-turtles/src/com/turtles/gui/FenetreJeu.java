package com.turtles.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import com.turtles.Carte;

public class FenetreJeu {
	
	public static JFrame gameFrame = new JFrame();
	
	private static BoardPanel boardPanel = null;
	private static CardsPanel cardsPanel;
	
	public static MyGlassPane glass = new MyGlassPane();
	
	
	
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1000, 1000);

	
	public FenetreJeu(int tourDuJoueur) {
		
		
		gameFrame = new JFrame("Robot Turtles");
		gameFrame.setLayout(new BorderLayout());
		
		//final JMenuBar tableMenuBar = createTableMenuBar();
		//this.gameFrame.setJMenuBar(tableMenuBar);
		
		
		gameFrame.setSize(OUTER_FRAME_DIMENSION);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.handPanel = new HandPanel(tourDuJoueur);
		this.boardPanel = new BoardPanel();
		this.cardsPanel = new CardsPanel(tourDuJoueur);
		
		
		
		gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		//this.gameFrame.setResizable(false);
		gameFrame.setAlwaysOnTop(true);
		gameFrame.add(this.cardsPanel, BorderLayout.SOUTH);
		
		gameFrame.setGlassPane(glass);
		
		gameFrame.setVisible(true);
		gameFrame.setAlwaysOnTop(false);
		
		
		
	}

/*
	public static void removeCarte(Component component) {
		handPanel.remove(component);
		
	}*/
	
	public void cacherGameFrame() {
		this.gameFrame.setVisible(false);
	}
	
	public static String typeDeLaCarteSelectionnee(Component component) {
		CardPanel cardPanel = (CardPanel)component;
		return cardPanel.getType();
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
	
	
	public static BoardPanel getBoardPanel() {
		return boardPanel;
	}
	
	public static CardsPanel getCardsPanel() {
		return cardsPanel;
	}

}
