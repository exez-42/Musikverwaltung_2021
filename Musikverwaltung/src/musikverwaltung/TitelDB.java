package musikverwaltung;

import java.io.BufferedReader;
import java.io.File;
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
	static ArrayList<Titel> alleTitel = new ArrayList<Titel>(); // Datenbank für Titel-Objekte

	//Listen zum automatisierten Halten von allen vorkommenden Eigenschaften der Titelobjekte
	static ArrayList<String> interpreten = new ArrayList<String>(); 
	static ArrayList<String> alben = new ArrayList<String>();
	static ArrayList<Integer> jahre = new ArrayList<Integer>();
	static ArrayList<String> genres = new ArrayList<String>();

	private static TitelDB Titeldatenbank;

	private TitelDB() {}

	// Konstruktor für die Main
	public static TitelDB erzeuge_TitelDB() {

		if (Titeldatenbank == null) {

			Titeldatenbank = new TitelDB();
			return Titeldatenbank;
		}
		return Titeldatenbank;
	}

	/*
	 *\brief sortiere
	 *
	 *		Diese Funktion sortiert die ArrayList<Titel> alleTitel, nach einem bestimmten Kriterium
	 *		(i (Interpret), a (Album), j (Jahr), g (Genre) oder n (Name))
	 * 		Wenn i, a, j ode g gewählt wird, wird innerhalb einer Gruppe (z.B. alle Titel aus 1976)
	 * 		zusätzlich alphabetisch nach Namen sortiert
	 * 
	 *\param char k --> Abkürzung für das gewählte Kriterium
	 *\return nichts
	 *\pre der Benutzer lässt im Verwaltungs- oder Playlist-Bearbeiten-Modus sortieren
	 */
	public static void sortiere(char k) {
		ArrayList<Titel> temp = new ArrayList<Titel>();
		ArrayList<Titel> temp2 = new ArrayList<Titel>();
		Comparator<Titel> namensVgl = new NamensVgl();
		switch (k) {
		case 'i':
			for (int i = 0; i < interpreten.size(); i++) {
				temp2 = getListInterpret(interpreten.get(i));
				Collections.sort(temp2, namensVgl);
				for (int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'a':
			for (int i = 0; i < alben.size(); i++) {
				temp2 = getListAlbum(alben.get(i));
				Collections.sort(temp2, namensVgl);
				for (int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'j':
			for (int i = 0; i < jahre.size(); i++) {
				temp2 = getListJahr(jahre.get(i));
				Collections.sort(temp2, namensVgl);
				for (int j = 0; j < temp2.size(); j++) {
					temp.add(temp2.get(j));
				}
			}
			break;
		case 'g':
			for (int i = 0; i < genres.size(); i++) {
				temp2 = getListGenre(genres.get(i));
				Collections.sort(temp2, namensVgl);
				for (int j = 0; j < temp2.size(); j++) {
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

	/*
	 * \brief einf
	 * 		
	 * 		Die Funktion fügt ein Titelobjekt der Datenbank ('alleTitel') hinzu,
	 * 		fügt ggf. neue Eigenschaften in die jeweilige Liste (wenn z. B. erster Song einer Band eingefügt wird)
	 * 		und sortiert diese
	 * 
	 * \param Titel s --> das Titelobjekt welches eingefügt werden soll
	 * \return nichts
	 * \pre im Verwaltungsmodus wurden alle Eigenschaften eingtragen und der "Hinzufügen"-Button wurde betätigt
	 */
	static void einf(Titel s) {
		boolean enthalten = false;
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).toString().equals(s.toString())) {
				enthalten = true;
			}
		}
		if (!(enthalten)) {
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

	/*
	 * \brief updateEigenschaften
	 * 
	 * 		Diese Funktion checkt nach dem Löschen eines Songs, ob ein Wert aus einer Eigenschaftsliste entfernt werden muss und tut dies ggf.
	 * 
	 * \param Titel s --> der gelöschte Titel
	 * \return nichts
	 * \pre ein Song wird aus der Datenbank gelöscht (im Verwaltungsmodus)
	 */
	public static void updateEigenschaften(Titel s) {
		boolean inter = false;
		boolean alb = false;
		boolean jahr = false;
		boolean gen = false;
		for (int i = 0; i < alleTitel.size(); i++) { //überprüfen, ob es mindestens einen weiteren (nicht gelöschten) Song mit der selben Eigenschafte gibt
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
		if (!(inter)) { //falls der letzte Song eines Interpreten gelöscht wurde...
			interpreten.remove(s.getInterpret()); //...wird dieser Interpret aus der entsprechenden Liste entfernt
		}
		if (!(alb)) {
			alben.remove(s.getAlbum());
		}
		if (!(jahr)) {
			Integer i = s.getJahr();
			jahre.remove(i);
		}
		if (!(gen)) {
			genres.remove(s.getGenre());
		}
	}

	/*
	 * \brief loesche
	 * 
	 * 		Ein Titel wird aus der Datenbank entfernt und die Eigenschaftslisten werden ggf. geupdated
	 * 
	 * \param int i --> Stelle des zu löschenden Titel in der ArrayList<Titel> alleTitel
	 * \return nichts
	 * \pre ein Titel soll im Verwaltungsmodus gelöscht werden
	 */

	public static void loesche(int i) {
		Titel s = alleTitel.get(i);
		alleTitel.remove(s);
		updateEigenschaften(s);
	}

	/*
	 * \brief getListInterpret
	 * 
	 * 		Eine Funktion, welche alle Titel eines bestimmten Interpreten liefert
	 * 
	 * \param String interpret --> der ausgewählte Interpret
	 * \return ArrayList<Titel> playlist --> Liste mit den gewünschten Titelobjekten
	 * \pre es sollen im Playlist-Bearbeiten-Modus alle Titel eines gewünschten Interpreten zu einer Playlist hinzugefügt werden
	 */
	public static ArrayList<Titel> getListInterpret(String interpret) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getInterpret().equals(interpret)) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}

	//analog zu "getListInterpret", nur mit Alben
	public static ArrayList<Titel> getListAlbum(String album) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getAlbum().equals(album)) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}

	//analog zu "getListInterpret", nur mit Erscheinungsjahren
	public static ArrayList<Titel> getListJahr(int jahr) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getJahr() == jahr) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}

	//analog zu "getListInterpret", nur mit Genres
	public static ArrayList<Titel> getListGenre(String genre) {
		ArrayList<Titel> playlist = new ArrayList<Titel>();
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).getGenre().equals(genre)) {
				playlist.add(TitelDB.alleTitel.get(i));
			}
		}
		return playlist;
	}

	/*
	 *\brief getListFilter
	 * 
	 * 		Eine Funktion, welche die einzelnen Filter-Funktionen (siehe oben) zu einer verbindet
	 * 
	 * \param String f1 --> das ausgewählte Kriterium (Interpret, Album, Jahr oder Genre)
	 * 		  Objekt f2 --> der konkrete gewünschte Wert
	 * \return ArrayList<Titel> tmp --> Liste der gefilterten Titel
	 * \pre Filterung mit Hilfe der ComboBoxen im Playlist-Bearbeiten-Modus
	 */
	public static ArrayList<Titel> getListFilter(String f1, Object f2) {
		ArrayList<Titel> tmp = new ArrayList<Titel>();
		switch (f1) {
		case "Interpret":
			tmp = getListInterpret((String) f2);
			break;
		case "Album":
			tmp = getListAlbum((String) f2);
			break;
		case "Erscheinungsjahr":
			tmp = getListJahr((Integer) f2);
			break;
		case "Genre":
			tmp = getListGenre((String) f2);
			break;
		}
		return tmp;
	}

	/*
	 * \brief get_singleTitel
	 * 
	 * 		Funktion, welche die Datenbank nach einem bestimmten Titel durchsucht (Schlüssel: Kombination der Eigenschaften der Titelobjekts) 
	 * 
	 * \param String eindeutiger_titel_string --> Sting, welcher in den Listen im Playlist-Bearbeiten-Modus angezeigt wird
	 * \return wenn Titelobjekt vorhanden: gesuchtes Objekt; sonst: null
	 * \pre ein bestimmter Titel wird im Bearbeiten-Modus aus Playlist entfernt oder hinzugefügt
	 */
	public static Titel get_singleTitel(String eindeutiger_titel_string) {
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).player_out_bearbeiten().equals(eindeutiger_titel_string)) {
				return alleTitel.get(i);
			}
		}
		return null;
	}

	/*
	 * \brief get_suche
	 * 	
	 * 		Funktion welche alle Songs, nach einer manuellen Suche im Bearbeiten-Modus, als entsprechenden String zurückgibt
	 * 	
	 * \param String eingabe --> String, welcher überpruft wird (wenn er in einer Eigenschaft eines Titel-Objekts vorkommt, wird dieses ausgegeben)
	 * \return String[] tmp --> Feld von Strings, in welcher die Songs in der 'player_out_bearbeiten' - Form gespeichert sind (Titel - Interpret - Album - Genre)
	 * \pre Manuelle (und nicht leere) Suche im Playlist-Bearbeiten-Modus
	 */
	public static String[] get_suche(String eingabe) {
		String[] tmp = new String[alleTitel.size()];
		int zaehler = 0;
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).toString().toUpperCase().contains(eingabe.toUpperCase())) { //toUpperCase vor dem Vergleich --> die Groß/Klein-Schreibung wird ignoriert
				tmp[zaehler] = alleTitel.get(i).player_out_bearbeiten();
				zaehler++;
			}
		}
		return tmp;
	}

	/*
	 * \brief get_suche2
	 * 	
	 * 		Funktion welche alle Songs, nach einer manuellen Suche im Verwaltungs-Modus, als entsprechenden String zurückgibt
	 * 	
	 * \param String eingabe --> String, welcher überpruft wird (wenn er in einer Eigenschaft eines Titel-Objekts vorkommt, wird dieses ausgegeben)
	 * \return String[] tmp --> Feld von Strings, in welcher die Songs in der 'toString' - Form gespeichert sind (Titel; Interpret; Album; Jahr; Genre)
	 * \pre Manuelle (und nicht leere) Suche im Verwaltungs-Modus
	 */
	public static String[] get_suche2(String eingabe) {
		String[] tmp = new String[alleTitel.size()];
		int zaehler = 0;
		for (int i = 0; i < alleTitel.size(); i++) {
			if (alleTitel.get(i).toString().toUpperCase().contains(eingabe.toUpperCase())) {
				tmp[zaehler] = alleTitel.get(i).toString();
				zaehler++;
			}
		}
		return tmp;
	}

	/*
	 * \brief get_titelDB_array
	 * 
	 * 		Funktion, welche für den Bearbeiten-Modus alle Titel der Datenbank als String liefert (Inhalt des "Song Bibliothek"-Feldes)
	 * 
	 * \param nichts
	 * \return String[] tmp --> Feld von String, in welcher jeder Titel in der 'player_out_bearbeiten' - Form gespeichert ist (Titel - Interpret - Album - Genre)
	 * \pre im Bearbeiten-Modus sollen alle Titel der Datenbank angezeigt werden (es werden keine Filter angewand)
	 */
	public static String[] get_titelDB_array() {
		String[] tmp = new String[alleTitel.size()];
		for (int i = 0; i < alleTitel.size(); i++) {
			tmp[i] = alleTitel.get(i).player_out_bearbeiten();
		}
		if (tmp.length == 0) {
			tmp = new String[1];
			tmp[0] = "Kein Titel gespeichert";
			return tmp;
		} else {
			return tmp;
		}
	}
	
	/*
	 * \brief get_titelDB_array2
	 * 
	 * 		Funktion, welche für den Verwaltungs-Modus alle Titel der Datenbank als String liefert
	 * 
	 * \param nichts
	 * \return String[] tmp --> Feld von String, in welcher jeder Titel in der "toSting" - Form gespeichert sind (Titel; Interpret; Album; Jahr; Genre)
	 * \pre im Bearbeiten-Modus sollen alle Titel der Datenbank angezeigt werden (es werden keine Filter angewand)
	 */
	public static String[] get_titelDB_array2() {
		String[] tmp = new String[alleTitel.size()];
		for (int i = 0; i < alleTitel.size(); i++) {
			tmp[i] = alleTitel.get(i).toString();
		}
		if (tmp.length == 0) {
			tmp = new String[1];
			tmp[0] = "Kein Titel gespeichert";
			return tmp;
		} else {
			return tmp;
		}

	}

	/*
	 * \brief sabeDB
	 * 
	 * 		Funktion zum Speichern der Datenbank (passiert automatisch beim Verlassen des Programms)
	 * 		Alle Titelobjekte aus 'alleTitel' werden der Reihe nach durchgegangen und alle Eigenschaften werden in eine txt-Datei geschreiben
	 * 
	 * \param nichts
	 * \return nichts
	 * \pre das Programm wird beendet
	 */
	public static void saveDB() throws IOException {
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
		writer.close();
	}

	/*
	 * \brief initDB
	 * 
	 * 		Die Datenbank wird wird mit gespeicherten Titelobjekten gefüllt (wenn vorhanden)
	 * 		Beim Start des Programms wird nach der entsprechenden SpeicherDatei gesucht, 
	 * 		wenn Suche die erfolgreich ist und Datei nicht fehlerhaft bearbeitet wurde, wird sie eingelesen, 
	 * 		die gespeicherten Titelobjekte werden rekonstruiert
	 * 
	 * \param nichts
	 * \return nichts
	 * \pre wird automatisch bei Programmstart ausgeführt
	 */
	public static void initDB() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(".\\src\\Daten\\TitelDatenBank.txt"));
			String info, name = null, interpret = null, album = null, genre = null, path = null;
			ArrayList<Titel> geleseneTitel = new ArrayList<Titel>();
			Integer jahr = null;
			int zaehler = 0;
			while ((info = reader.readLine()) != null) {
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
				zaehler = (zaehler + 1) % 6;
			}
			for (int j = 0; j < geleseneTitel.size(); j++) {
				einf(geleseneTitel.get(j));
			}
			reader.close();
		} catch (Exception e) {
			return;
		}
	}
}
