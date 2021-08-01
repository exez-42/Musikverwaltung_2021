package musikverwaltung;

import java.util.ArrayList;

public class Playlist {

	
	private static ArrayList<Playlist> all_pl = new ArrayList<Playlist>();
	private String pl_name;
	private ArrayList<Titel> playlist;
	
	
	
	
	
	public Playlist(String pl_name) {
		
		this.pl_name = pl_name;
		playlist = new ArrayList<Titel>();
		
	}

	//Print Ausgaben
	@Override
	public String toString() {
		return ("Playlist Name : " + this.pl_name + "\nAnzahl an Tracks : " + this.playlist.size());
	}

	public void drucke_playlist() {	
	System.out.print(this.toString() + "\n");
	
		for (int i = 0; i < playlist.size(); i++) {
		playlist.get(i).toString();
		System.out.print("\n");
		}
	}
	
	//
	
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
	
	add_playlist_to_db(this);
	
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
		add_playlist_to_db(this);
		
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
		
		
	add_playlist_to_db(this);	
	}
	
	//abstract void add_Jahrzehnt(int jahrzehnt) {}

	
	
	private void add_playlist_to_db(Playlist a) {
		
	if(!(all_pl.contains(a))) {
		
		all_pl.add(a);
		
		
	}else {
		
	all_pl.remove(a);
	all_pl.add(a);
		
		
	}	
		
		
		
		
	}
	
	
	
	/*
	 * Getter / Setter
	 * 
	 */
	
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
