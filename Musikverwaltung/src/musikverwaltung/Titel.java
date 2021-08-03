package musikverwaltung;

public class Titel {
	protected String name;
	protected String interpret;
	protected String album;
	protected int jahr;
	protected String genre;
	protected String path;
	public Wave_player player;
	
	
	
	
	
	
	public Titel (String name, String inter, String album, int jahr, String genre, String path) {
		
		
		
		this.name = name;
		this.interpret = inter;
		this.album = album;
		this.jahr = jahr;
		this.genre = genre;
		//Audio
		this.path = "C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"; //Windows Path Beispiel
		this.player = new Wave_player(path);
		
	}
	
	public void printMe() {
		System.out.println(name + "; " + interpret + "; " + album + "; " + jahr + "; " + genre);
	}
	
	@Override
	public String toString() {
		return (name + "; " + interpret + "; " + album + "; " + jahr + "; " + genre);
	}
	
	
	/*Liefert Anzeige für Titel im Player
	 * 
	 * 
	 */
	public String player_out() {
		
		
		return (name + " - " + interpret);
	
	}
	
	public String player_out_bearbeiten() {
		
		
		return(name + " - " + interpret + " - "  + album + " - " + genre);
		
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
	
	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
