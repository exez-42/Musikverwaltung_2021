package Musikverwaltung;

import java.util.ArrayList;

import Musikverwaltung.Titel;

public class TitelDB {
	static ArrayList<Titel> alleTitel = new ArrayList<Titel>();
	
	static void einf(Titel s) {
		boolean enthalten = false;
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).toString() == s.toString()) { //funktioniert noch nicht
				enthalten = true;
			}
		}
		if (enthalten) {
			System.out.println(" - Song ist bereits enthalten -");
		}
		else {
			alleTitel.add(s);
		}
	}
	
	public static void loesche(Titel s) {
		alleTitel.remove(s); // (+ entfernen aus allen Playlists)
	}
	
	public static ArrayList<Titel> getListInterpret (String interpret) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getInterpret() == interpret) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}
	
	public static ArrayList<Titel> getListAlbum (String album) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getAlbum() == album) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}
	
	public static ArrayList<Titel> getListJahr (int jahr) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getJahr() == jahr) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}
	
	public static ArrayList<Titel> getListGenre (String genre) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getGenre() == genre) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}
	
	
	
}
