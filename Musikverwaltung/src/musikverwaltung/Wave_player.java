package musikverwaltung;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Wave_player {
	
	public static File datei;
	private Clip clip;
	private float gain;
	private String pathname;
	private String status = "xxx";
	
	
	public Wave_player(String pathname) {

		this.pathname = pathname;
		datei = new File(pathname);
		
		// the reference to the clip 
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 
		try {
			clip.open(AudioSystem.getAudioInputStream(datei.getAbsoluteFile()));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
	
	
	
	
	
	 public void play() {
			
		 
			
		 try {
			 
			 
			 status = "play";
			 clip.start();
			 
			 
		 }catch(Exception e){   
			 e.printStackTrace();
		 }
		 
		 
		 
	 } 

	 
	 public void pause() 
		{ 
		 	
		 	
		 	status = "pause";
			clip.stop(); 
		
		}
	
	 public void stop() {
		 
			pause();
			clip.setMicrosecondPosition(0); 
			 
			 
			 
		 }
	
	 public void play_repeat() {
		 clip.setMicrosecondPosition(0); 
		 
		 
		 
	 }
	
	 public void select() {
		 Scanner scanner = new Scanner(System.in); 
		 
	while(true) {
		
		System.out.println("Eingabe : 1  play"); 
		System.out.println("Eingabe : 2 pause"); 
		System.out.println("Eingabe : 3 repeat"); 
		System.out.println("Eingabe : 4 Stop");
		System.out.println("Eingabe : 0 Player beenden");
		int a = scanner.nextInt(); 
		if (a == 0) { break;}
		auswahl(a);
		
	}	
			 
		 
		 
	 }

	 
public void auswahl(int auswahl) {
		 	
		 
		 switch (auswahl) 
			{ 
				case 1: 
					play(); 
					break; 
				case 2: 
					pause(); 
					break; 
				case 3:
					play_repeat();
					break;
				case 4:
					stop();
					break;
		
				default:
					return;
			}
		 
		 
		 
	 }
	 
	 
	
	

}