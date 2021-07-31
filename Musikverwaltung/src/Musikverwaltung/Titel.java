package Musikverwaltung;

public class Titel {
	protected String name;
	protected String interpret;
	protected String album;
	protected int jahr;
	protected String genre;
	
	public Titel () {}
	
	public Titel (String name, String inter, String album, int jahr, String genre) {
		this.name = name;
		this.interpret = inter;
		this.album = album;
		this.jahr = jahr;
		this.genre = genre;
	}
	
	public void printMe() {
		System.out.println(name + "; " + interpret + "; " + album + "; " + jahr + "; " + genre);
	}
	
	@Override
	public String toString() {
		return (name + "; " + interpret + "; " + album + "; " + jahr + "; " + genre);
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
