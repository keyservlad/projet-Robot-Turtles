package com.turtles;
import java.io.*;
import sun.audio.*;


public class Sound {
	
	private final static String nom_music ="./ressources/MenuTheme.wav";
			
	public static void Main (String[] args) {
		
	}
	
	@SuppressWarnings("restriction")
	public static void music() {
		AudioPlayer BGP=AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;
		ContinuousAudioDataStream loop=null;
		try {
		BGM=new AudioStream(new FileInputStream(nom_music));
		MD = BGM.getData();
		loop=new ContinuousAudioDataStream(MD);
		}catch (IOException error){}
		BGP.start(loop);
	}
	
}
