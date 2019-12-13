package com.turtles.gui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import com.turtles.Game;

public class MouseMovement implements MouseListener, MouseMotionListener{
	private int X, Y;
	
	public MouseMovement (Component... pnls) {
		for (Component pn : pnls) {
			pn.addMouseListener(this);
			pn.addMouseMotionListener(this);
		}
	}
	
	

	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation(e.getX() + e.getComponent().getX() - X, e.getY() + e.getComponent().getY() - Y);
		
		System.out.println(e.getY() + e.getComponent().getY());
		
		if (e.getY() + e.getComponent().getY() < 0 ) {
			//refaire les limites et ajouter l'action de la carte
			switch(FenetreJeu.typeDeLaCarteSelectionnee(e.getComponent())) {
			case "Bleue":
				System.out.println("bleu"); // TODO repprendre ici, refaire les cartes au photoshop, passer le jpanel handpanel devant le boardpanel, GUI part VII, grossir la carte quand on passe dessus, relier Carte avec la cardPanel en passant par toutes les cartes de la main je pense, puis faire l'action de la carte associee au joueur
				break;
				
			case "Jaune":
				break;
				
			case "Violette":
				break;
				
			case "Laser":
				break;
			}
			FenetreJeu.removeCarte(e.getComponent());
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
