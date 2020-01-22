package com.turtles.gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class MouseGlassMotionListener extends MouseAdapter {

	private MyGlassPane myGlass;

	public MouseGlassMotionListener(MyGlassPane glass) {
		myGlass = glass;
	}

	/**
	 * M�thode fonctionnant sur le m�me principe que la classe pr�c�dente mais cette
	 * fois sur l'action de d�placement
	 */
	public void mouseDragged(MouseEvent event) {
		Component c = event.getComponent();

		Point p = (Point) event.getPoint().clone();
		SwingUtilities.convertPointToScreen(p, c);
		SwingUtilities.convertPointFromScreen(p, myGlass);
		myGlass.setLocation(p);

		myGlass.repaint();

	}
}
