package com.turtles.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;

import com.turtles.Game;

public class OtherGlassPane extends JPanel{
	
	private Font font0 = new Font("arial", Font.BOLD, 40);
	private Font font1 = new Font("arial", Font.PLAIN, 30);
	private Stroke s;
	
	public OtherGlassPane(){
		super();
		setOpaque(true);
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.3f));
		setSize(Game.fenetre.getSize());
		
		
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println(e.getX() + "   " + e.getY());
				if (e.getX() > 750 && e.getX() < 750 + 400 && e.getY() > 300 && e.getY() < 400) {		// bouton compléter le programme
					Game.etatPartie = EtatPartie.COMPLETER;
					Game.fenetre.repasserEnJeu();
					Game.fenetre.ajouterListeners();
				}
				else if (e.getX() > 750 && e.getX() < 750 + 400 & e.getY() > 500 && e.getY() < 600) {	// bouon contruire un mur
					Game.etatPartie = EtatPartie.CONSTRUIRE;
					Game.fenetre.repasserEnJeu();
				}
				else if (e.getX() > 750 && e.getX() < 750 + 400 & e.getY() > 700 && e.getY() < 800) {	// bouton executer le programme
					Game.etatPartie = EtatPartie.EXECUTER;
					Game.fenetre.repasserEnJeu();
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
		
		validate();
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;

		super.paintComponent(g2d);
		g2d.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.3f));
		g2d.setColor(Color.black);
		s = g2d.getStroke();		//on recupere l'epaisseur du trait
		
		g2d.setFont(font0);
		g2d.drawString("Choisir une action à effectuer pour ce tour :", 550, 200);
		
		
		g2d.setStroke(new BasicStroke(3));
		g2d.drawRect(750, 300, 400, 100); // (x, y, w, h)
		g2d.drawRect(750, 500, 400, 100); // (x, y, w, h)
		g2d.drawRect(750, 700, 400, 100); // (x, y, w, h)
		
		
		g2d.setStroke(s);
		
		g2d.setFont(font1);
		
		g2d.drawString("Compléter le programme", 790, 360);
		g2d.drawString("Construire un mur", 830, 560);
		g2d.drawString("Exécuter le programme", 800, 760);
		
	}
	
	
	
	

}
