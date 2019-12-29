package com.turtles.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Menu extends JButton implements MouseListener{
	
	
	private static final long serialVersionUID = -7959162769265591220L;
	private JFrame menuFrame;
	
	public Menu(){
		
		menuFrame = new JFrame();
		menuFrame.setTitle("Menu");
		menuFrame.setSize(new Dimension(1000, 1000));

		menuFrame.setLocationRelativeTo(null);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuFrame.setResizable(false);
		
		JPanel bStart = new JPanel();
		bStart.setSize(new Dimension(200, 200));
		bStart.setLocation(0, 0);
		
		
	    bStart.add(new JButton("Start"));
	    bStart.add(new JButton("Quit"));
		
		menuFrame.add(bStart);
		
		
		menuFrame.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
