package musikverwaltung;

import java.awt.EventQueue;

public class Main {

	/**
	 * Programmstart.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
