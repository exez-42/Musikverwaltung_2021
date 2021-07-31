package musikverwaltung;

import java.awt.EventQueue;
import java.util.ArrayList;
import musikverwaltung.Titel;
import musikverwaltung.TitelDB;

public class Main {
	
	/**
	 * Programmstart.
	 */
	
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		TitelDB songdb = new TitelDB();
		TitelDB.einf(new Titel("Disco Ulysses (Instrumental)", "Vulfpeck", "Hill Climber", 2018, "Funk", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Shia LaBeouf Live", "Rob Kantor", "Shia", 2014, "Oper", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("T.N.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Firework", "Katy Perry", "Teenage Dream", 2010, "Pop", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Hot Stuff", "The Rolling Stones", "Black and Blue", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("1612", "Vulfpeck", "Fugue State", 2014, "Funk", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Hells Bells", "AC/DC", "Back in Black", 1980, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Psychoticbumpschool", "Bootsy Collins", "Strechin` Out", 1976, "Funk","C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Doin` It", "Herbie Hancock", "Secrets", 1976, "Jazz","C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Sandstorm", "Darude", "Before the Strom", 2001, "Techno","C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Mandalo", "Ulmo Ucin", "Mandalo", 2015, "Oper","C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Thunderstruck", "AC/DC", "The Razors Edge", 1990, "Rock","C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		
		System.out.println("Gesammte Datenbank:");
		druckePlaylist(TitelDB.alleTitel);
		
		TitelDB.loesche(TitelDB.alleTitel.get(3)); //Lösche an Index 3
		System.out.println("\nGesammte Datenbank nach >Lösche Index 3 (Firework - Katy Perry)< :");
		druckePlaylist(TitelDB.alleTitel);
		
		ArrayList<Titel> jahrPlaylist = TitelDB.getListJahr(1976);
		System.out.println("\nDrucke 1976-Playlist:");
		druckePlaylist(jahrPlaylist);
		
		ArrayList<Titel> funkPlaylist = TitelDB.getListGenre("Funk");
		System.out.println("\nDrucke Funk-Playlist:");
		druckePlaylist(funkPlaylist);
		
		ArrayList<Titel> acdcPlaylist = TitelDB.getListInterpret("AC/DC");
		System.out.println("\nDrucke ACDC-Playlist:");
		druckePlaylist(acdcPlaylist);
		
		
		
		
		//AUDIO TEST
		System.out.println("\n -------------------Kleiner Audio Test: -------------------------------------");
		Titel audio_test = new Titel("Fichtls Lied", "Die Woodys", "Woodys BEST OF EXTENDED", 1997, "VOLKSMUSIK", "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav");
		
		System.out.println("\nDrucke Titel:");
		System.out.println(audio_test.toString());
		
		audio_test.player.select();
		
		//AUDIOTEST ENDE
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void druckePlaylist (ArrayList<Titel> playl) {
		for (int i = 0; i < playl.size(); i++) {
			System.out.print((i) + ": "); 
			playl.get(i).printMe();
		}
	}
	

	
	
	

}
