package musikverwaltung;

import java.util.Comparator;

public class NamensVgl implements Comparator<Titel>{
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
		}
		else if (name1.length() > name2.length()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
