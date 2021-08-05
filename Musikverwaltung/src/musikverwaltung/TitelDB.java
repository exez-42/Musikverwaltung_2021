package musikverwaltung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import musikverwaltung.Titel;

public class TitelDB {
	static ArrayList<Titel> alleTitel = new ArrayList<Titel>();
	//einzige Titeldatenbank
	
	static ArrayList<String> interpreten = new ArrayList<String>();
	static ArrayList<String> alben = new ArrayList<String>();
	static ArrayList<Integer> jahre = new ArrayList<Integer>();
	static ArrayList<String> genres = new ArrayList<String>();
	
	
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
	
	public static void sortiere(char k) { //Sortiere "alleTitel" nach i (Interpret), a (Album), j (Jahr), g (Genre) oder n (Name)
		ArrayList<Titel> temp = new ArrayList<Titel>();
		ArrayList<Titel> temp2 = new ArrayList<Titel>();
		Comparator<Titel> namensVgl = new NamensVgl();
		switch (k) {
		case 'i':
			for (int i = 0; i < interpreten.size(); i++) {
				temp2 = getListInterpret(interpreten.get(i));
				Collections.sort(temp2, namensVgl);
				for(int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'a':
			for (int i = 0; i < alben.size(); i++) {
				temp2 = getListAlbum(alben.get(i));
				Collections.sort(temp2, namensVgl);
				for(int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'j':
			for (int i = 0; i < jahre.size(); i++) {
				temp2 = getListJahr(jahre.get(i));
				Collections.sort(temp2, namensVgl);
				for(int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'g':
			for (int i = 0; i < genres.size(); i++) {
				temp2 = getListGenre(genres.get(i));
				Collections.sort(temp2, namensVgl);
				for(int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'n':
			Collections.sort(alleTitel, namensVgl);
		}
		if (k != 'n') {
			alleTitel = temp;
		}
	}
	
	static void druckeEigenschaften (char c) { //Listen der Kriterien; muss angepasst werden 
		switch (c) {
		case 'i':
			System.out.println("Alle Interpreten:");
			for (int j = 0; j < interpreten.size(); j++) {
				System.out.println(interpreten.get(j));
			}
			break;
		case 'a':
			System.out.println("Alle Alben:");
			for (int j = 0; j < alben.size(); j++) {
				System.out.println(alben.get(j));
			}
			break;
		case 'j':
			System.out.println("Alle Veröffentlichungsjahre:");
			for (int j = 0; j < jahre.size(); j++) {
				System.out.println(jahre.get(j));
			}
			break;
		case 'g':
			System.out.println("Alle Genres:");
			for (int j = 0; j < genres.size(); j++) {
				System.out.println(genres.get(j));
			}
			break;
		default: 	
		}
	}
	
	
	static void einf(Titel s) {
		boolean enthalten = false;
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).toString().equals(s.toString())) {
				enthalten = true;
			}
		}
		if (enthalten) {
			System.out.println(" - Song ist bereits enthalten -"); //Ausgabe
		}
		else {
			alleTitel.add(s);
			if (!(interpreten.contains(s.getInterpret()))) {
				interpreten.add(s.getInterpret());
				Collections.sort(interpreten, String.CASE_INSENSITIVE_ORDER);
			}
			if (!(alben.contains(s.getAlbum()))) {
				alben.add(s.getAlbum());
				Collections.sort(alben, String.CASE_INSENSITIVE_ORDER);
			}
			if (!(jahre.contains(s.getJahr()))) {
				jahre.add(s.getJahr());
				Collections.sort(jahre);
			}
			if (!(genres.contains(s.getGenre()))) {
				genres.add(s.getGenre());
				Collections.sort(genres, String.CASE_INSENSITIVE_ORDER);
			}
		}
	}
	
	public static void updateEigenschaften(Titel s) {
		boolean inter = false;
		boolean alb = false;
		boolean jahr = false;
		boolean gen = false;
		for (int i = 0; i < alleTitel.size(); i++) {
			if ((inter == false) && (alleTitel.get(i).getInterpret().equals(s.getInterpret()))) {
				inter = true;
			}
			if ((alb == false) && (alleTitel.get(i).getAlbum().equals(s.getAlbum()))) {
				alb = true;
			}
			if ((jahr == false) && (alleTitel.get(i).getJahr() == s.getJahr())) {
				jahr = true;
			}
			if ((gen == false) && (alleTitel.get(i).getGenre().equals(s.getGenre()))) {
				gen = true;
			}
		}
		if (!(inter)) {
			interpreten.remove(s.getInterpret());
			System.out.println(" - letzter Song von " + s.getInterpret() + " wurde entfernt -"); //Ausgabe
		}
		if (!(alb)) {
			alben.remove(s.getAlbum());
			System.out.println(" - letzter Song von dem Album >" + s.getAlbum() + "< wurde entfernt -"); //Ausgabe
		}
		if (!(jahr)) {
			Integer i = s.getJahr();
			jahre.remove(i);
			System.out.println(" - letzter Song aus " + s.getJahr() + " wurde entfernt -"); //Ausgabe
		}
		if (!(gen)) {
			genres.remove(s.getGenre());
			System.out.println(" - letzter " + s.getGenre() + "-Song wurde entfernt -"); //Ausgabe
		}
	}
	
	public static void loesche(Titel s) {
		alleTitel.remove(s); // (+ entfernen aus allen Playlists)
		updateEigenschaften(s);
		
	}
	
	public static void loesche(int i) {
		Titel s = alleTitel.get(i);
		alleTitel.remove(s); // (+ entfernen aus allen Playlists)
		updateEigenschaften(s);
	}
	
	public static ArrayList<Titel> getListInterpret (String interpret) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getInterpret().equals(interpret)) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}
	
	public static ArrayList<Titel> getListAlbum (String album) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getAlbum().equals(album)) {
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
			if (alleTitel.get(i).getGenre().equals(genre)) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}

	public static Titel get_singleTitel(String eindeutiger_titel_string) {
		
		for (int i = 0; i < alleTitel.size(); i++) {
			
		if(alleTitel.get(i).player_out_bearbeiten().equals(eindeutiger_titel_string)) {
			
			return alleTitel.get(i);
			
			
		}	
				
			
			
		}
		
		return null;
	}
	
	public static String[] get_titelDB_array() {
        String[] tmp = new String[alleTitel.size()];
        for (int i = 0; i < alleTitel.size(); i++) {

            tmp[i] = alleTitel.get(i).player_out_bearbeiten();
        }

        if(tmp.length == 0) {

        tmp = new String[1];
        tmp[0] = "Kein Titel gespeichert";
        return tmp;

        }else {return tmp;}

    }
	
	public static String[] get_titelDB_array2() {
		String[] tmp = new String[alleTitel.size()];
		for (int i = 0; i < alleTitel.size(); i++) {
			
			tmp[i] = alleTitel.get(i).toString();	
		}
		
		if(tmp.length == 0) {
		
		tmp = new String[1];
		tmp[0] = "Kein Titel gespeichert";
		return tmp;	
			
		}else {return tmp;}
		
	}
	
		public static void saveDB () throws IOException {
		File f = new File(".\\src\\Daten\\TitelDatenBank.txt"); // Ordner "Daten" in "src" erforderlich!
		OutputStream ostream = new FileOutputStream(f);
		PrintWriter writer = new PrintWriter(ostream);
		for (int i = 0; i < alleTitel.size(); i++) {
			writer.println(alleTitel.get(i).getName());
			writer.println(alleTitel.get(i).getInterpret());
			writer.println(alleTitel.get(i).getAlbum());
			writer.println(alleTitel.get(i).getJahr());
			writer.println(alleTitel.get(i).getGenre());
			writer.println(alleTitel.get(i).getPath());
		}
		System.out.println(" - Datenbank wurde gespeichert -"); //Ausgabe
		writer.close();
	}
	
	public static void initDB () {
		try {
			BufferedReader reader = new BufferedReader ( new FileReader (".\\src\\Daten\\TitelDatenBank.txt"));
			System.out.println(" - Daten gefunden - "); //Ausgabe
			String info, name = null, interpret = null, album = null, genre = null, path = null;
			ArrayList<Titel> geleseneTitel = new ArrayList<Titel>();
			Integer jahr = null;
			int zaehler = 0;
			while ((info = reader.readLine()) != null) {
				System.out.println(zaehler + ": " + info); //Ausgabe
				switch (zaehler) {
				case 0:
					name = info;
					break;
				case 1:
					interpret = info;
					break;
				case 2:
					album = info;
					break;
				case 3:
					jahr = Integer.valueOf(info);
					break;
				case 4:
					genre = info;
					break;
				case 5:
					path = info;
					geleseneTitel.add(new Titel(name, interpret, album, jahr, genre, path));
					break;
				}
				zaehler = (zaehler+1)%6;
			}
			for (int j = 0; j < geleseneTitel.size(); j++) {
				geleseneTitel.get(j).printMe();
				einf(geleseneTitel.get(j));
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(" - Keine oder fehlerhafte Speicherdatei vorhanden - "); //Ausgabe
			return;
		}
	}
	
	
}
