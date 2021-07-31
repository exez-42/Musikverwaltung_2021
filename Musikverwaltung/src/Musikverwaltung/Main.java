package Musikverwaltung;

import java.awt.EventQueue;
import java.util.ArrayList;
import Musikverwaltung.Titel;
import Musikverwaltung.TitelDB;

public class Main {
	/**
	 * Programmstart.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.benutzer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		TitelDB songdb = new TitelDB();
		TitelDB.einf(new Titel("Disco Ulysses (Instrumental)", "Vulfpeck", "Hill Climber", 2018, "Funk"));
		TitelDB.einf(new Titel("Shia LaBeouf Live", "Rob Kantor", "Shia", 2014, "Oper"));
		TitelDB.einf(new Titel("T.N.T.", "AC/DC", "High Voltage", 1976, "Rock"));
		TitelDB.einf(new Titel("Firework", "Katy Perry", "Teenage Dream", 2010, "Pop"));
		TitelDB.einf(new Titel("Hot Stuff", "The Rolling Stones", "Black and Blue", 1976, "Rock"));
		TitelDB.einf(new Titel("1612", "Vulfpeck", "Fugue State", 2014, "Funk"));
		TitelDB.einf(new Titel("Hells Bells", "AC/DC", "Back in Black", 1980, "Rock"));
		TitelDB.einf(new Titel("Psychoticbumpschool", "Bootsy Collins", "Strechin` Out", 1976, "Funk"));
		TitelDB.einf(new Titel("Doin` It", "Herbie Hancock", "Secrets", 1976, "Jazz"));
		TitelDB.einf(new Titel("Sandstorm", "Darude", "Before the Strom", 2001, "Techno"));
		TitelDB.einf(new Titel("Mandalo", "Ulmo Ucin", "Mandalo", 2015, "Oper"));
		TitelDB.einf(new Titel("Thunderstruck", "AC/DC", "The Razors Edge", 1990, "Rock"));
		
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
	}
	
	
	public static void druckePlaylist (ArrayList<Titel> playl) {
		for (int i = 0; i < playl.size(); i++) {
			System.out.print((i) + ": "); 
			playl.get(i).printMe();
		}
	}

}
