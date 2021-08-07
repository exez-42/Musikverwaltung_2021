package musikverwaltung;

public class Titel {

	//Eigenschaften des Titelobjekts
	protected String name;
	protected String interpret;
	protected String album;
	protected int jahr;
	protected String genre;
	// zum Speichern und Abspielen der Audio-Datei
	protected String path;
	public Wave_player player;

	//Konstruktor
	public Titel(String name, String inter, String album, int jahr, String genre, String path) { // Konstuktor

		this.name = name;
		this.interpret = inter;
		this.album = album;
		this.jahr = jahr;
		this.genre = genre;
		// Audio
		this.path = path;
		this.player = new Wave_player(path);

	}

	/*
	 * \brief toString
	 * 
	 * 		Umwandlung der Eigenschaften eines Titels in einen String, genutzt zur Anzeige im Verwaltungsmodus
	 * 
	 * \param nichts
	 * \return String --> Kombination alle Eigenschaften
	 * \pre Nutzung des Verwaltungs-Modus
	 */
	@Override
	public String toString() {
		return (name + "; " + interpret + "; " + album + "; " + jahr + "; " + genre);
	}

	/*
	 * \brief player_out
	 * 
	 * 		Umwandlung des Namen und Interpreten eines Titels in einen String, genutzt zur Anzeige Abspiel-Modus
	 * 
	 * \param nichts
	 * \return String --> Kombination der beiden Eigenschaften
	 * \pre Nutzung des Abspiel-Modus
	 */
	public String player_out() {
		return (name + " - " + interpret);
	}

	/*
	 * \brief player_out_bearbeiten
	 * 
	 * 		Umwandlung der Eigenschaften eines Titels (außer des Jahres) in einen String, genutzt zur Anzeige im Bearbeiten-Modus
	 * 
	 * \param nichts
	 * \return String --> Kombination der Eigenschaften
	 * \pre Nutzung des Playlist-Bearbeiten-Modus
	 */
	public String player_out_bearbeiten() {
		return (name + " - " + interpret + " - " + album + " - " + genre);
	}

	//Getter der Attribute des Titel-Objekts
	public String getName() {
		return name;
	}

	public String getInterpret() {
		return interpret;
	}

	public String getAlbum() {
		return album;
	}
	
	public int getJahr() {
		return jahr;
	}

	public String getGenre() {
		return genre;
	}

	public String getPath() {
		return path;
	}
}
