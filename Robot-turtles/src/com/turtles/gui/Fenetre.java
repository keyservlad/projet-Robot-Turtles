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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.turtles.Carte;
import com.turtles.Game;

public class Fenetre extends JFrame implements ActionListener, KeyListener {

	private JLabel texteInfo = new JLabel();
	private JSlider slider = new JSlider();
	private JButton playButton = new JButton();
	private JButton exitButton = new JButton();

	private static BoardPanel boardPanel = null;
	private static SouthPanel southPanel;

	public static MyGlassPane glass = new MyGlassPane();

	public static NorthPanel northPanel;
	public static WestPanel westPanel = new WestPanel();
	public EastPanel eastPanel = new EastPanel();

	public JPanel otherGlassPan;

	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1920, 1080);

	private final String BackgroundImage = "./ressources/images/Bois6.jpg";
	private Image fond;

	private Color color = Color.black;
	private Font font1 = new Font("arial", Font.PLAIN, 30);

	public Fenetre() {
		super("Robot Turtles");

		afficherFenetreMenu();

		/*
		 * test pour connaitre les coordonnees de son curseur addMouseListener(new
		 * MouseListener() {
		 * 
		 * @Override public void mouseReleased(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mousePressed(MouseEvent e) {
		 * System.out.println(e.getX() + "  " + e.getY());
		 * 
		 * }
		 * 
		 * @Override public void mouseExited(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mouseEntered(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * } });
		 */

	}

	public void afficherFenetreJeu() {

		this.getContentPane().removeAll();
		WestPanel.actualiserCouleur();

		fond = Toolkit.getDefaultToolkit().getImage(BackgroundImage);
		try {
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(fond, 0);
			mt.waitForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setContentPane(new ContentPane(fond));

		this.setLayout(new BorderLayout(5, 5));

		boardPanel = new BoardPanel();
		southPanel = new SouthPanel();
		northPanel = new NorthPanel();

		this.add(boardPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(westPanel, BorderLayout.WEST);

		this.setGlassPane(glass);

		this.validate();
		this.repaint();

	}

	public void afficherFenetreMenu() {
		this.getContentPane().removeAll();

		this.setLayout(null);
		// image de fond pour rendre le bordel joli

		this.setSize(OUTER_FRAME_DIMENSION);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setAlwaysOnTop(false);

		// police personnalisee, peut etre modifiee
		Font font0 = new Font("arial", Font.BOLD, 40);
		texteInfo.setFont(font0);
		// couleur aussi
		texteInfo.setForeground(Color.black);

		texteInfo.setText("Choisissez le nombre de joueurs");

		// permet de placer le texte tout en gardant sa taille

		texteInfo.setBounds(this.getWidth() / 2 - (int) texteInfo.getPreferredSize().getWidth() / 2,
				(int) (this.getHeight() * 0.3), (int) texteInfo.getPreferredSize().getWidth(),
				(int) texteInfo.getPreferredSize().getHeight());

		this.add(texteInfo);

		slider.setMaximum(4);
		slider.setMinimum(2);
		slider.setValue(3);
		// slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);

		// slider.setFont(Font);
		// slider.setForeground(Color.red); couleur des labels
		// possible de design le slider mais ca a l'air chiant

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// modifie la valeur du nombre de joueurs selon l'etat du slider
				Game.nbTortues = (int) ((JSlider) e.getSource()).getValue();

			}
		});

		slider.setBounds(this.getWidth() / 2 - (int) slider.getPreferredSize().getWidth() / 2,
				(int) (this.getHeight() * 0.6), (int) slider.getPreferredSize().getWidth(),
				(int) slider.getPreferredSize().getHeight());

		this.add(slider);

		playButton.setText("Play");
		playButton.addActionListener(this);

		playButton.setBounds((int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.8),
				(int) playButton.getPreferredSize().getWidth(), (int) playButton.getPreferredSize().getHeight());

		this.add(playButton);

		exitButton.setText("Exit");
		exitButton.addActionListener(this);

		exitButton.setBounds((int) (this.getWidth() * 0.4), (int) (this.getHeight() * 0.8),
				(int) exitButton.getPreferredSize().getWidth(), (int) exitButton.getPreferredSize().getHeight());

		this.add(exitButton);

		this.setVisible(true);

		this.validate();
		this.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == playButton) {
			// lance le jeu si on clique sur play
			Game.etatPartie = EtatPartie.DESIGNATIONJOUEUR;

		} else if (arg0.getSource() == exitButton) {
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

	public void afficherEcranTourDuJoueur() {
		this.getContentPane().removeAll();

		switch (Game.tortues.get(Game.tourDuJoueur).getColor()) {
		case "Rouge":
			color = Color.red;
			break;

		case "Verte":
			color = Color.green;
			break;

		case "Bleue":
			color = Color.blue;
			break;

		case "Jaune":
			color = Color.yellow;
			break;
		}

		this.setContentPane(new ContentPane());

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (Game.etatPartie == EtatPartie.DESIGNATIONJOUEUR) {
					Game.etatPartie = EtatPartie.CHOIXACTION;
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.validate();
		this.repaint();

	}

	private class ContentPane extends JPanel {
		private Image image;
		boolean isDesignation = false;

		public ContentPane(Image leFond) {
			super(new CardLayout());
			image = leFond;
			isDesignation = false;
		}

		public ContentPane() {
			super();
			isDesignation = true;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (isDesignation) {
				g.setColor(color);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.black);
				g.setFont(font1);
				switch (Game.tourDuJoueur) {
				case 0:
					g.drawString("C'est au tour du joueur rouge!", 800, 200);
					break;

				case 1:
					g.drawString("C'est au tour du joueur vert!", 800, 200);
					break;

				case 2:
					g.drawString("C'est au tour du joueur bleu!", 800, 200);
					break;

				case 3:
					g.drawString("C'est au tour du joueur jaune!", 800, 200);
					break;

				}

				g.setColor(Color.white);
				g.drawString("Cliquer n'importe où pour continuer!", 750, 800);

			} else {
				g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
			}

		}

	}

	public static int posDeLaCarteSelectionnee(Component component) {
		CardPanel cardPanel = (CardPanel) component;
		return cardPanel.getPosCard();
	}

	public static boolean isCardMovable(Component component) {
		CardPanel cardPanel = (CardPanel) component;
		return cardPanel.getIsMovable();
	}

	public static BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public static SouthPanel getSouthPanel() {
		return southPanel;
	}

	public void passerEnChoixDuJoueur() {
		this.otherGlassPan = new OtherGlassPane();

		for (CardPanel carte : SouthPanel.handPanel.getHandcards()) {
			carte.removeMouseListeners();
		}

		setGlassPane(otherGlassPan);
		otherGlassPan.setVisible(true);

	}

	public void repasserEnJeu() {

		setGlassPane(glass);
		glass.setVisible(false);
	}

	public void passerEnFinDeTour() {
		if (Game.tortues.get(Game.tourDuJoueur).isaFini()) {
			return;
		}
		Game.etatPartie = EtatPartie.FINDETOUR;
		EastPanel.desactiverBouton();
		WestPanel.activerBoutons();

		for (CardPanel carte : SouthPanel.handPanel.getHandcards()) {
			carte.removeMouseListeners();
		}

	}

	public void ajouterListeners() {
		for (CardPanel carte : SouthPanel.handPanel.getHandcards()) {
			carte.addMouseListeners();
		}
	}

	public JPanel getOtherGlassPan() {
		return this.otherGlassPan;
	}

	public void invocation() {

		for (Carte carte : Game.tortues.get(Game.tourDuJoueur).getProgramme().getCardsList()) {

			carte.setIsVisible(true);
			Fenetre.getSouthPanel().getProgrammePanel().drawCards();
			this.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			carte.invocation(Game.tortues.get(Game.tourDuJoueur));
			this.repaint();
			if (Game.tortues.get(Game.tourDuJoueur).isaFini()) {
				return;
			}
		}

		Game.tortues.get(Game.tourDuJoueur).getProgramme().getCardsList().clear();

		Fenetre.getSouthPanel().getProgrammePanel().drawCards();
		this.repaint();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public EastPanel getEastPanel() {
		return this.eastPanel;
	}

}
