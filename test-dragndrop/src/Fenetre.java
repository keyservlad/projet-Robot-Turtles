import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	private final String nom_fichier_image = "./ICE.png";
	
	public static void main (String[] args) {
		new Fenetre();
	}
	
	public Fenetre() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		
		JPanel back = new JPanel();
		back.setSize(getSize());
		back.setBackground(Color.white);
		back.setLayout(null);
		back.setLocation(0,  0);
		
		
		JPanel carte = new JPanel();
		//carte.setBackground(Color.white);
		carte.setSize(100,100);
		back.add(carte);
		
		try {
			BufferedImage image = ImageIO.read(new File(nom_fichier_image));
			carte.add(new JLabel(new ImageIcon(image)));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Movement move = new Movement(back.getComponents());
		
		this.add(back);
		setVisible(true);
		
		
	}
	
	
	

}
