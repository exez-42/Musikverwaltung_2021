package musikverwaltung;

import java.util.ArrayList;

public class Playlist {

	
	
	
	/*
	 * static Arraylist all_pl
	 * Alle erstellten Playlisten werden hier gespeichert
	 */
	private static ArrayList<Playlist> all_pl = new ArrayList<Playlist>();
	
	
	/* static String previos_track
	 * Speichert den track ab der als letztes gespielt hat.
	 * 
	 */
	static String previos_track;
	
	
	/*private String pl_name
	 * Name der Playlist
	 * Name dient ebenfalls als eindeutiger Key 
	 * -> keine PL name doppelt vergeben
	 */
	private String pl_name;				
	
	
	/*private Arraylist playlist
	 * 
	 * Arraylist die alle Titel der Playlist abspeicehrt
	 */
	private ArrayList<Titel> playlist;
	
	
	/*private int current_titel
	 * speichert den Index des Titels in der @playlist der gerade gespielt wird.
	 * 
	 */
	private int current_titel = 0; 
	
	
	
	/* private Konstrukor von Playlist
	 * 
	 * 
	 */
	private Playlist(String pl_name) {
		
		this.pl_name = pl_name;
		
		playlist = new ArrayList<Titel>();
		
		
		all_pl.add(this);
	}

	
	
	
	
	
	
	
	/*static boolean create_Playlist(String)
	 * 
	 * Diese Methode ist der indirekte Konstruktor für Playlist der Klassenaußerhalb aufgerufen werden kann.
	 * Dieser prüft ob ein Playlistname bereitsvergeben wurde. 
	 * Ist dies der Fall wird ein false returnt und kein Playlist objekt erstellt da der Playlist name unser eindeutiger Playlist key ist.
	 * 
	 * \param pl_name -> name der Playlist die der Nutzer erstellen möchte
	 *\return -> true falls Playlistobject erstellt wurde 
	 *		-> fals wenn kein Playlistobject erstellt wurde
	 * 
	 * 
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

	
	
	
	
	
	/*static void delete_playlist(String)
	 * 
	 * Diese Mehtode bekommt einen Playlistnamen übergeben. 
	 * Es wird geprüft ob dieser Playlistname einem Playlistobject im static Arraylist @all_pl zugeordnet werden kann.
	 * Wenn ja wird diese aus der all_pl arraylist entfernt 
	 * Falls nein -> passiert nicht 
	 * 
	 * \param @playlist_name -> Name der Playlist die der Nutzer löschen möchte
	 * \return void
	 * 
	 */
	static void delete_playlist(String playlist_name) {
		
	for(int i = 0; i < all_pl.size(); i++) {
		
		if(all_pl.get(i).getPl_name().equals(playlist_name)) {
		
			all_pl.remove(i);
			
		}
	}	
	}
	
	
	
	/*static Playlist get_playlist_wID(String pl_name) 
	 * Diese metode bekommt einen Playlist namen übergeben. 
	 * Falls dieser genau zuordbare Playlist name mit einer Playlist in der static Arraylist @all_pl zugeordnet werden kann. 
	 * Wird genau dieses Playlistobjekt returnt
	 * 
	 * \param @pl_name String der ein Playlistobjekt beschreibt.
	 * \return ein Playlistobject
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
	 * Methode für Comboboxen in der GUI
	 * 
	 * 
	 * 
	 * \return -> String Feld mit allen PLaylist.pl_namen 
	 */
 	public static String[] get_all_plname_string() {
		
		String[] tmp = new String[all_pl.size()]; 	
		for (int i = 0; i < all_pl.size(); i++) {
		tmp[i] = all_pl.get(i).getPl_name();
	
	}
		
		
		return tmp;
	}
	
	/*
	 * 	Mehtode für Comboboxen in der GUI
	 * 
	 * \return ein StringFeld mit alllen Titel namen die in der @playlist gespeichert sind
	 * 
	 */
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
	 * Diese metode bekommt einen Playlist namen übergeben. 
	 * Falls dieser genau zuordbare Playlist name mit einer Playlist in der static Arraylist @all_pl zugeordnet werden kann. 
	 * Wird genau dieses Playlistobjekt returnt
	 * 
	 * \param @pl_name String der ein Playlistobjekt beschreibt.
	 * \return ein Playlistobject
	 * 
	 */
	public static Playlist  get_current_playlist(String pl_name) {
		
		
		for (int i = 0; i < all_pl.size(); i++) {
			
		if(all_pl.get(i).getPl_name().equals(pl_name)) {return all_pl.get(i);}	
			
			
			
		}
		
		
		
		
		return null;  
	
		
		
	}
	

	
	
	/*
	 * Diese Methode liefert den aktuellen Titel der Playlist zurück
	 * Dieser Titel wird über den parameter @current_titel ermittelt
	 * 
	 * \return Titel object
	 */
	public Titel get_current_track() {
		
		if( playlist.size() == 0) {
			
			return null;
		}else {
			return playlist.get(current_titel);
			
		}
		
		
		
	}
	
	
	
	/*next_track()
	 * Diese Methode setzt den parameter @current_titel +1.
	 * Diese passiert wenn im wiedergabe mods der nächste Track ausgewählt wird
	 * 
	 * 
	 * 
	 */
	public void next_track() {
	if(current_titel == (playlist.size()-1)) {
		
		current_titel = 0;
		
		
	}else { 
		
		current_titel += 1;
		
	}
		
		
		
	}
	
	
	/*previos_track()
	 * Diese Methode setzt den parameter @currenttitel -1
	 * DIes passiert wenn im wiedergabe modus der vorherige titel agewählt wird.
	 * 
	 */
	public void previos_track() {
		
		if(current_titel == 0) {
			
			current_titel = (playlist.size() - 1);
			
			
		}else { 
			
			current_titel -= 1;
			
		}
		
		
		
	}


	
	/*set_crrent_titel_zero
	 * 
	 * setzt den Parameter @currenttitel 0. -> ersten Titel der Playlist
	 * 
	 */
	public void set_current_titel_zero() {
		
	this.current_titel = 0;	
		
		
		
		
	}
	
	
	/*toString()
	 * 
	 * return String mit Playlistobjekt informationen
	 */
	@Override
	public String toString() {
		return ("Playlist Name : " + this.pl_name + "\nAnzahl an Tracks : " + this.playlist.size());
	}

	
	
	/*drucke_playlits()
	 *tostringmehtode + Playlist titelinformationen
	 */
	public void drucke_playlist() {	
	System.out.print(this.toString() + "\n");
	
		for (int i = 0; i < playlist.size(); i++) {
		playlist.get(i).toString();
		System.out.print("\n");
		}
	}
	
	
	

	/*add_Interpret()
	 * 
	 * Fügt Titel eines speziellen INterpreten ur Playlist hinzu.
	 * 
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
	
	
	
	/*add_auswahl()
	 * 
	 * Fügt ein übergebenes Array mit Titeln der Playlist hinzu. 
	 * + filtert duplicate
	 * 
	 * 
	 */
	public void add_auswahl(ArrayList<Titel> titelliste) {
		if(titelliste == null) {}
		else {
		for (int i = 0; i < titelliste.size(); i++) {
			
			if(!this.playlist.contains(titelliste.get(i))) {
			this.playlist.add(titelliste.get(i));	
			}else { 
				//titel bereits enthalten
			}

		}
		}
		
		
		
	}
	
	/*add_singletitel()
	 * 
	 * Fügt ein Titel der Playlist i + flitert duplicate
	 * 
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
	
	
	/*delete_titel_from_all_playlist()
	 * 
	 * Dese Mehtode löscht einen Titel aus allen PLaylisten. 
	 * 
	 * \param titel_to_string eindeutiger titelname 
	 * 
	 */
	public static void delete_titel_from_all_playlist(String titel_to_string) {
		
		for (int i = 0; i < all_pl.size(); i++) {
			
			all_pl.get(i).delete_singletitel_verwaltung(titel_to_string);
			
		}
		
		
		
	}
	
	
	

/*delete_titel_from_all_playlist()
 * löscht titel as einer Playlist
 * 
 */
	public void delete_singletitel_verwaltung(String titel_to_string) {
		
		for(int i = 0; i < this.playlist.size(); i++) {
			
			if(this.playlist.get(i).toString().equals(titel_to_string)) {
				
				this.playlist.remove(i);
				
				
				
			}	
				
				
				
		
		
		
		
	}
	}
	
	/*delete_singletitel(String titel)
	 * löscht titel aus einer Playlist
	 * 
	 */
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
