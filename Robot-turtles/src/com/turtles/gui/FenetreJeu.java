package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreJeu {
	
	public static JFrame gameFrame = new JFrame();
	
	private static BoardPanel boardPanel = null;
	private static CardsPanel cardsPanel;
	
	public static MyGlassPane glass = new MyGlassPane();
	
	public static OpponentsPanel opponentsPanel = new OpponentsPanel();
	public static ScoringPanel scoringPanel = new ScoringPanel();
	public static ButtonsPanel buttonsPanel = new ButtonsPanel();
	
	
	
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1920, 1080);
	
	private final String BackgroundImage = "./ressources/images/gaelBackground.jpg";
	private Image fond;

	
	public FenetreJeu() {
		
		
		gameFrame = new JFrame("Robot Turtles");
		fond = Toolkit.getDefaultToolkit().getImage(BackgroundImage);
		try{
			MediaTracker mt = new MediaTracker(gameFrame);
			mt.addImage(fond,0);
			mt.waitForAll();
		}catch(Exception e){e.printStackTrace();}
		gameFrame.setContentPane(new ContentPane(fond));
		
		
		gameFrame.setLayout(new BorderLayout());
		
		//final JMenuBar tableMenuBar = createTableMenuBar();
		//this.gameFrame.setJMenuBar(tableMenuBar);
		
		
		gameFrame.setSize(OUTER_FRAME_DIMENSION);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.handPanel = new HandPanel(tourDuJoueur);
		boardPanel = new BoardPanel();
		cardsPanel = new CardsPanel();
		
		
		
		gameFrame.add(boardPanel, BorderLayout.CENTER);
		gameFrame.add(cardsPanel, BorderLayout.SOUTH);
		gameFrame.add(buttonsPanel, BorderLayout.EAST);
		gameFrame.add(opponentsPanel, BorderLayout.NORTH);
		gameFrame.add(scoringPanel, BorderLayout.WEST);
		
		
		gameFrame.setGlassPane(glass);
		
		
		
		
		
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		gameFrame.setResizable(false);
		gameFrame.setAlwaysOnTop(true);
		
		gameFrame.setVisible(true);
		
	}

	private class ContentPane extends JPanel {
		private Image image;

		public ContentPane(Image leFond) {
			super(new CardLayout());
			image = leFond;
		}

		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		}

	}

	/*
	 * public static void removeCarte(Component component) {
	 * handPanel.remove(component);
	 * 
	 * }
	 */
	
	public void cacherGameFrame() {
		this.gameFrame.setVisible(false);
	}
	
	public static String typeDeLaCarteSelectionnee(Component component) {
		CardPanel cardPanel = (CardPanel)component;
		return cardPanel.getType();
	}
	
	public static boolean isCardMovable(Component component) {
		CardPanel cardPanel = (CardPanel)component;
		return cardPanel.getIsMovable();
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
