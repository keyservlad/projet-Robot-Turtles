package com.turtles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Sound {
	public static void Main (String[] args) {
		
	}
	public static void music() {
		try {
			FileInputStream fileInputStream = new FileInputStream("song.mp3");
			Player player = new Player(fileInputStream);
			System.out.println("Song is playing...");
			player.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}


