package musikverwaltung;

import java.util.Comparator;

// Comparator-Klasse, welche beim Sortieren nach Name von Titelobjekten zum Einsatz kommt
public class NamensVgl implements Comparator<Titel> {
	/*
	 * \brief compare
	 * 
	 * Vergleichsfunktion von zweit Titel-Objekten, welche für eine alphabetische
	 * Sortierung nach Namen sorgt (Groß- und Kleinschreibung werden ignoriert;
	 * Zahlen kommen von Buchstaben)
	 * 
	 * \param Titel t1, t2 --> die beiden zu vergleichenden Titel 
	 * \return int --> -1 (t1 < t2), 0 (t1 = t2) oder 1 (t1 > t2) 
	 * \pre Titel werden im Verwaltung- oder Bearbeiten-Modus nach Namen sortiert
	 */
	public int compare(Titel t1, Titel t2) {
		String name1 = t1.getName();
		String name2 = t2.getName();
		for (int i = 0; i < Math.min(name1.length(), name2.length()); i++) {
			if (Character.getNumericValue(name1.charAt(i)) < Character.getNumericValue(name2.charAt(i))) {
				return -1;
			}
			if (Character.getNumericValue(name1.charAt(i)) > Character.getNumericValue(name2.charAt(i))) {
				return 1;
			}
		}
		if (name1.length() < name2.length()) {
			return -1;
		} else if (name1.length() > name2.length()) {
			return 1;
		} else {
			return 0;
		}
	}
}
