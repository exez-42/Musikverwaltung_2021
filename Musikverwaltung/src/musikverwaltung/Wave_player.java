package musikverwaltung;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Wave_player {
	
	//File object von .wav datei
	private File datei;
	//Clip object
	private Clip clip;
	//Dateipfad von .wav datei
	private String pathname;
	
	
	
	public Wave_player(String pathname) {

		this.pathname = pathname;
		this.datei = new File(pathname);
		
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
	
	
	
	
	/*play()
	 * 
	 * spielt (wav)Clip objekt ab 
	 * 
	 */
	 public void play() {
			
		 
			
		 try {
			 
			 
			 clip.start();
			 
			 
		 }catch(Exception e){   
			 e.printStackTrace();
		 }
		 
		 
		 
	 } 

	 /*pause()
	  * 
	  * pausiert Clip objekt
	  * 
	  */
	 public void pause() 
		{ 
		 	
		 	
			clip.stop(); 
		
		}
	
	 
	 /*stop()
	  * 
	  * pausiert clip objekt und setzt zeitstempel zurück auf anfang
	  * 
	  * 
	  */
	 public void stop() {
		 
			pause();
			clip.setMicrosecondPosition(0); 
			 
			 
			 
		 }
	
	 
	 /*play_repeat()
	  * 
	  * setzt Clip zeitstempel auf 0 zurück
	  * 
	  */
	 public void play_repeat() {
		 clip.setMicrosecondPosition(0); 
		 
		 
		 
	 }
	

	 
	 
	 
	
	

}
