package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.turtles.Game;

public class FenetreJeu extends JFrame implements ActionListener, KeyListener{ // le keylistener ne marche plus
	
	
	private JLabel texteInfo = new JLabel();
	private JSlider slider = new JSlider();
	private JButton playButton = new JButton();
	private JButton exitButton = new JButton();
	
	
	private static BoardPanel boardPanel = null;
	private static SouthPanel southPanel;
	
	public static MyGlassPane glass = new MyGlassPane();
	
	public static NorthPanel northPanel = new NorthPanel();
	public static WestPanel westPanel = new WestPanel();
	public static EastPanel eastPanel = new EastPanel();
	
	
	
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1366, 768);
	
	private final String BackgroundImage = "./ressources/images/gaelBackground.jpg";
	private Image fond;

	
	public FenetreJeu() {
		super("Robot Turtles");
		
		
		
		afficherFenetreMenu();
		
		
		
	}
	
	public void afficherFenetreJeu() {
		
		this.getContentPane().removeAll();
		
		fond = Toolkit.getDefaultToolkit().getImage(BackgroundImage);
		try{
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(fond,0);
			mt.waitForAll();
		}catch(Exception e){e.printStackTrace();}
		this.setContentPane(new ContentPane(fond));
		
		
		this.setLayout(new BorderLayout());
		
		//final JMenuBar tableMenuBar = createTableMenuBar();
		//this.gameFrame.setJMenuBar(tableMenuBar);
		
		
		this.setSize(OUTER_FRAME_DIMENSION);
		this.setLocationRelativeTo(null);
		//gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boardPanel = new BoardPanel();
		southPanel = new SouthPanel();
		
		
		
		this.add(boardPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(westPanel, BorderLayout.WEST);
		
		
		this.setGlassPane(glass);
		
		
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		
		this.setVisible(true);
		this.setAlwaysOnTop(false);
		
		this.validate();
		this.repaint();
		
	}
	
	public void afficherFenetreMenu() {
		this.getContentPane().removeAll();
		
		this.setLayout(null);
		//image de fond pour rendre le bordel joli
		
		this.setSize(OUTER_FRAME_DIMENSION);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setAlwaysOnTop(false);
		
		
		// police personnalisee, peut etre modifiee
		Font font0 = new Font("arial", Font.BOLD, 30);
		texteInfo.setFont(font0);
		// couleur aussi
		texteInfo.setForeground(Color.black);
		
		texteInfo.setText("Choisissez le nombre de joueurs");
		
		//permet de placer le texte tout en gardant sa taille

		texteInfo.setBounds(this.getWidth() / 2 - (int) texteInfo.getPreferredSize().getWidth() / 2, (int) (this.getHeight() * 0.3) , (int) texteInfo.getPreferredSize().getWidth(), (int) texteInfo.getPreferredSize().getHeight());
		
		this.add(texteInfo);
		
		
		
		slider.setMaximum(4);
		slider.setMinimum(2);
		slider.setValue(3);
		//slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		
		//slider.setFont(Font);
		//slider.setForeground(Color.red); couleur des labels
		// possible de design le slider mais ca a l'air chiant 
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// modifie la valeur du nombre de joueurs selon l'etat du slider
				Game.nbTortues = (int) ((JSlider) e.getSource()).getValue();
				System.out.println(Game.nbTortues);
				
			}
		});
		
		slider.setBounds(this.getWidth() / 2 - (int) slider.getPreferredSize().getWidth() / 2, (int) (this.getHeight() * 0.6) , (int) slider.getPreferredSize().getWidth(), (int) slider.getPreferredSize().getHeight());
		
		this.add(slider);
		
		playButton.setText("Play");
		playButton.addActionListener(this);
		
		playButton.setBounds((int) (this.getWidth() * 0.6), (int)(this.getHeight() * 0.8), (int) playButton.getPreferredSize().getWidth(), (int) playButton.getPreferredSize().getHeight());
		
		this.add(playButton);
		
		
		exitButton.setText("Exit");
		exitButton.addActionListener(this);
		
		exitButton.setBounds((int) (this.getWidth() * 0.4), (int)(this.getHeight() * 0.8), (int) exitButton.getPreferredSize().getWidth(), (int) exitButton.getPreferredSize().getHeight());
		
		this.add(exitButton);
		
		
		this.setVisible(true);
		
		this.validate();
		this.repaint();
		
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
		this.setVisible(false);
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
	
	public static SouthPanel getCardsPanel() {
		return southPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == playButton) {
			// lance le jeu si on clique sur play
			Game.etatPartie = EtatPartie.CHOIXACTION;
			
		}else if (arg0.getSource() == exitButton) {
			// quitte si on appuie sur exit
			System.exit(0);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
	}

}
