package musikverwaltung;

import java.util.ArrayList;

import musikverwaltung.Titel;

public class TitelDB {
	static ArrayList<Titel> alleTitel = new ArrayList<Titel>();
	//einzige Titeldatenbank
	private static TitelDB Titeldatenbank;
	
	
	
	
	//kontruktor muss private sein -> nur von klasse selbst aufrufbar 
	private TitelDB() {}
	
	
	//Konstruktor für die Main 
	public static TitelDB erzeuge_TitelDB() {
		
		if(Titeldatenbank == null) {
			
			Titeldatenbank = new TitelDB();
			return Titeldatenbank;
		}
		return Titeldatenbank;	
	}
	//ende
	
	
	
	
	
	
	
	
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
