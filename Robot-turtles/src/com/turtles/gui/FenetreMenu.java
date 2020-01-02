package com.turtles.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.turtles.Game;

public class FenetreMenu extends JFrame implements ActionListener{		//TODO replacer tout correctement et bosser un peu le visuel, ne pas oublier le mode debug avec la methode set()
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(1920, 1080);
	private JLabel texteInfo = new JLabel();
	private JSlider slider = new JSlider();
	private JButton playButton = new JButton();
	private JButton exitButton = new JButton();
	
	public FenetreMenu() {
		super("Robot Turtles");
		this.setLayout(null);
		//image de fond pour rendre le bordel joli
		
		setSize(OUTER_FRAME_DIMENSION);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setResizable(false);
		setAlwaysOnTop(true);
		
		
		// police personnalisee, peut etre modifiee
		Font font0 = new Font("arial", Font.BOLD, 30);
		texteInfo.setFont(font0);
		// couleur aussi
		texteInfo.setForeground(Color.black);
		
		texteInfo.setText("Choisissez le nombre de joueurs");
		
		//permet de placer le texte tout en gardant sa taille

		texteInfo.setBounds(this.getWidth() / 2 - (int) texteInfo.getPreferredSize().getWidth() / 2, (int) (this.getHeight() * 0.3) , (int) texteInfo.getPreferredSize().getWidth(), (int) texteInfo.getPreferredSize().getHeight());
		
		add(texteInfo);
		
		
		
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
		
		add(slider);
		
		playButton.setText("Play");
		playButton.addActionListener(this);
		
		playButton.setBounds((int) (this.getWidth() * 0.6), (int)(this.getHeight() * 0.8), (int) playButton.getPreferredSize().getWidth(), (int) playButton.getPreferredSize().getHeight());
		
		add(playButton);
		
		
		exitButton.setText("Exit");
		exitButton.addActionListener(this);
		
		exitButton.setBounds((int) (this.getWidth() * 0.4), (int)(this.getHeight() * 0.8), (int) exitButton.getPreferredSize().getWidth(), (int) exitButton.getPreferredSize().getHeight());
		
		add(exitButton);
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
	}
	
	public void set() { // permet de modifier les valeurs avec le mod debug en live pour placer les comoosants de maniere tres precise
		this.texteInfo.setBounds(this.getWidth() / 2 - (int) texteInfo.getPreferredSize().getWidth() / 2, this.getHeight() / 2, (int) texteInfo.getPreferredSize().getWidth(), (int) texteInfo.getPreferredSize().getHeight());
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == playButton) {
			// lance le jeu si on clique sur play
			Game.isTourFini = true;
			
		}else if (arg0.getSource() == exitButton) {
			// quitte si on appuie sur exit
			System.exit(0);
		}
		
	}
	
	

}
