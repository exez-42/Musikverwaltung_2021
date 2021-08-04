package musikverwaltung;

import java.util.ArrayList;

public class Playlist {

	/*
	 * Arraylist die alle erstellten Playlisten speichert
	 */
	private static ArrayList<Playlist> all_pl = new ArrayList<Playlist>();
	
	
	/*
	 * Hilfsvariable.
	 * Speichert den track ab der als letzts gespielt hat.
	 * mit dieser Variable kann man bei Playlist wechsel den laufenden Track stoppen.
	 */
	static String previos_track;
	
	
	/*
	 * Name der Playlist & ID
	 * -> kein Name wird doppelt vergeben 
	 * -> somit eindeutig
	 */
	private String pl_name;				
	
	/*
	 * Arraylist die alle Titel der Playlist abseichert 
	 */
	private ArrayList<Titel> playlist;
	
	
	/*
	 * Gibt an welcher Index in der Playlist als letztes gespielt wurde
	 * -> macht vorheriger & nächster Track möglich
	 * 
	 */
	private int current_titel = 0; 	//implementieren
	
	
	
	/*
	 * Privater Kontruktor
	 * 
	 */
	private Playlist(String pl_name) {
		
		this.pl_name = pl_name;
		
		playlist = new ArrayList<Titel>();
		
		
		all_pl.add(this);
	}

	
	
	
	
	
	
	
	/*
	 * indirekter Konstruktor
	 * prüft ob Playlist name schon exestiert 
	 * wenn ja 
	 * 		-> Playlist wird nicht erzeugt
	 * 		-> return true
	 * wenn nein:
	 * 		-> Playlist wird erzeugt
	 * 		-> return true
	 */
	static boolean create_Playlist(String pl_name) {
	boolean name_vergeben = false;
	
	for(int i = 0; i < all_pl.size(); i++) {
		String tmp = all_pl.get(i).getPl_name();
	if(tmp.equals(pl_name)) {
		
		name_vergeben = true;
		
	}	
			
	}
	
	
	if(name_vergeben == true) {
		
		return false;
		
		
	}else {
		
		
		new Playlist(pl_name);
		return true;
		
		 
	}	
	}

	
	
	
	static void delete_playlist(String playlist_name) {
		
	for(int i = 0; i < all_pl.size(); i++) {
		
		if(all_pl.get(i).getPl_name().equals(playlist_name)) {
		
			all_pl.remove(i);
			
		}
	}	
	}
	
	
	
	/*
	 * Liefert geuschte Playlist zurück mit übergebenen eindeutigen Playlist namen
	 * 
	 */
	static Playlist get_playlist_wID(String pl_name) {
		
		for(int i = 0; i < all_pl.size(); i++) {
			
		if(all_pl.get(i).getPl_name().equals(pl_name)) {
			
			return all_pl.get(i);
		}
		
		}
		
		
		return null;
		}
	
	
	/*
	 * Mehtode für Combobox
	 * return -> String Feld mit allen PLaylist namen 
	 */
 	public static String[] get_all_plname_string() {
		
		String[] tmp = new String[all_pl.size()]; 	
		for (int i = 0; i < all_pl.size(); i++) {
		tmp[i] = all_pl.get(i).getPl_name();
	
	}
		
		
		return tmp;
	}
	
	
	public String[] get_all_titel_array() {
		String[] tmp = new String[this.playlist.size()];
		for (int i = 0; i < this.playlist.size(); i++) {
			
			tmp[i] = this.playlist.get(i).player_out_bearbeiten();
			
			
			
		}
		
		if(tmp.length == 0) {
		
		tmp = new String[1];
		tmp[0] = "kein Titel vorhanden";
		return tmp;	
			
		}else {return tmp;}
		
		
		
	}
 	
 	
	/*
	 * return : ausgewählte PLaylist von ComboBox
	 * 
	 */
	public static Playlist  get_current_playlist(String pl_name) {
		
		
		for (int i = 0; i < all_pl.size(); i++) {
			
		if(all_pl.get(i).getPl_name().equals(pl_name)) {return all_pl.get(i);}	
			
			
			
		}
		
		
		
		
		return null;  
	
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*return aktuellen Playlist Titel 
	 * 
	 */
	public Titel get_current_track() {
		
		if( playlist.size() == 0) {
			
			return null;
		}else {
			return playlist.get(current_titel);
			
		}
		
		
		
	}
	
	
	
	/*
	 * aktualisiert current_titel variable +1 
	 * 
	 */
	public void next_track() {
	if(current_titel == (playlist.size()-1)) {
		
		current_titel = 0;
		
		
	}else { 
		
		current_titel += 1;
		
	}
		
		
		
	}
	
	
	/*
	 * aktualisiert current_titel variable -1
	 * 
	 */
	public void previos_track() {
		
		if(current_titel == 0) {
			
			current_titel = (playlist.size() - 1);
			
			
		}else { 
			
			current_titel -= 1;
			
		}
		
		
		
	}


	public void set_current_titel_zero() {
		
	this.current_titel = 0;	
		
		
		
		
	}
	
	
	/*
	 * To String AUsgabe 
	 * Ausgabe : Playlistname + Anzahl Tracks
	 */
	@Override
	public String toString() {
		return ("Playlist Name : " + this.pl_name + "\nAnzahl an Tracks : " + this.playlist.size());
	}

	
	
	/*
	 * To String
	 * Ausgabe : toString() + alleTitelinformationen 
	 */
	public void drucke_playlist() {	
	System.out.print(this.toString() + "\n");
	
		for (int i = 0; i < playlist.size(); i++) {
		playlist.get(i).toString();
		System.out.print("\n");
		}
	}
	
	
	

	/*
	 * Playlist nach Kategorie mit Tracks füllen
	 * 
	 */
	public void add_Interpret(String Interpretname) {	
	//temporärer zwichenspeicher um nach duplicaten zu überprüfen
	ArrayList<Titel> tmp =	TitelDB.getListInterpret(Interpretname);
	
	for (int i = 0; i < tmp.size(); i++) {
		if(!this.playlist.contains(tmp.get(i))) {
		this.playlist.add(tmp.get(i));	
		}else { 
			//titel bereits enthalten
		}

	}	
	
	//add_playlist_to_db(this);
	
	}
	
	public void add_Album(String albumname) {
		
	ArrayList<Titel> tmp =	TitelDB.getListAlbum(albumname);
		
		for (int i = 0; i < tmp.size(); i++) {
			if(!this.playlist.contains(tmp.get(i))) {
			this.playlist.add(tmp.get(i));	
			}else { 
				//titel bereits enthalten
			}

		}
		//add_playlist_to_db(this);
		
	}
	
	public void add_genre(String genre) {
		ArrayList<Titel> tmp =	TitelDB.getListGenre(genre);
		
		for (int i = 0; i < tmp.size(); i++) {
			if(!this.playlist.contains(tmp.get(i))) {
			this.playlist.add(tmp.get(i));	
			}else { 
				//titel bereits enthalten
			}

		}
		
		
	//add_playlist_to_db(this);	
	}
	
	
	/*add_singletitel:
	 * liefert ein Titelobjekt zurück
	 * eindeutige eingabe von einem Titel String 
	 * 
	 */
	public void add_singletitel(String titel) {
	Titel tmp = TitelDB.get_singleTitel(titel);
	if(tmp == null) {}
	else {
	
		
	if(this.playlist.contains(tmp)) {}	
	else { this.playlist.add(tmp); }	
	
		
	}
		
	

	}
	
	
	
	public static void delete_titel_from_all_playlist(String titel_to_string) {
		
		for (int i = 0; i < all_pl.size(); i++) {
			
			all_pl.get(i).delete_singletitel_verwaltung(titel_to_string);
			
		}
		
		
		
	}
	
	
	


	public void delete_singletitel_verwaltung(String titel_to_string) {
		
		for(int i = 0; i < this.playlist.size(); i++) {
			
			if(this.playlist.get(i).toString().equals(titel_to_string)) {
				
				this.playlist.remove(i);
				
				
				
			}	
				
				
				
		
		
		
		
	}
	}
	
	
	public void delete_singletitel(String titel) {
		
	for(int i = 0; i < this.playlist.size(); i++) {
		
	if(this.playlist.get(i).player_out_bearbeiten().equals(titel)) {
		
		this.playlist.remove(i);
		
		
		
	}	
		
		
		
	}	
		
		
		
		
	}
	
	/*
	 * ToString() für alle erstellten Playlisten
	 */
	static void drucke_alle_pl() {
		System.out.println("Druck DB :\n");
		
		for (int i = 0; i < all_pl.size(); i++) {
			System.out.println((i+1) + " : " +  all_pl.get(i).toString());		
		}
		System.out.println("\nEnde Druck \n");
	}
	
	
	
	
	
	/*
	 * Getter / Setter
	 * 
	 */
	
	static void set_previos_track(String s) {
		 previos_track = s;	

	}

	static String get_previos_track() {
		
		return  previos_track;
		
		
	}	

	public String getPl_name() {
		return pl_name;
	}

	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}

	public ArrayList<Titel> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(ArrayList<Titel> playlist) {
		this.playlist = playlist;
	}

	public static ArrayList<Playlist> getAll_pl() {
		return all_pl;
	}

	public static void setAll_pl(ArrayList<Playlist> all_pl) {
		Playlist.all_pl = all_pl;
	}
	
	
	
}
