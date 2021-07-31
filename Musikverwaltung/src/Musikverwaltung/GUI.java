package Musikverwaltung;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	JFrame benutzer;
	public GUI() {
		initialize();
	}

	/**
	 * Inhalt Benutzermodus.
	 */
	private void initialize() {
		benutzer = new JFrame();
		benutzer.setTitle("Benutzermodus");
		benutzer.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		benutzer.setBounds(100, 100, 403, 236);
		benutzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		benutzer.getContentPane().setLayout(null);
		
		JLabel lblwiedergabe = new JLabel("Aktuelle Wiedergabe:");
		lblwiedergabe.setBounds(10, 26, 367, 14);
		benutzer.getContentPane().add(lblwiedergabe);
		
		JLabel lblsongplaying = new JLabel("Liste - Playlist - Song");
		lblsongplaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblsongplaying.setBounds(10, 51, 367, 14);
		benutzer.getContentPane().add(lblsongplaying);
		
		JButton btnback = new JButton("");
		btnback.setIcon(new ImageIcon(GUI.class.getResource("/Bilder/Back.png")));
		btnback.setBounds(120, 76, 30, 25);
		benutzer.getContentPane().add(btnback);
		
		JButton btnplay = new JButton("");
		btnplay.setIcon(new ImageIcon(GUI.class.getResource("/Bilder/Play.png")));
		btnplay.setBounds(160, 76, 30, 25);
		benutzer.getContentPane().add(btnplay);
		
		JButton btnpause = new JButton("");
		btnpause.setIcon(new ImageIcon(GUI.class.getResource("/Bilder/Pause.png")));
		btnpause.setBounds(200, 76, 30, 25);
		benutzer.getContentPane().add(btnpause);
		
		JButton btnfoward = new JButton("");
		btnfoward.setIcon(new ImageIcon(GUI.class.getResource("/Bilder/Forward.png")));
		btnfoward.setBounds(240, 76, 30, 25);
		benutzer.getContentPane().add(btnfoward);
		
		JLabel lblplaylist = new JLabel("Aktuelle Playlist:");
		lblplaylist.setBounds(10, 112, 367, 14);
		benutzer.getContentPane().add(lblplaylist);
		
		JComboBox<String> comboBoxplaylist = new JComboBox<String>();
		comboBoxplaylist.setBackground(SystemColor.window);
		comboBoxplaylist.setBounds(10, 137, 367, 20);
		benutzer.getContentPane().add(comboBoxplaylist);
		
		JMenuBar menuBar = new JMenuBar();
		benutzer.setJMenuBar(menuBar);
		
		JMenu mndatei = new JMenu("Datei");
		menuBar.add(mndatei);
		
		JMenuItem mntmverwaltungsmodus = new JMenuItem("Verwaltungsmodus");
		mntmverwaltungsmodus.addActionListener(new ActionListener() {
			/**
			 * Inhalt Verwaltungsmodus.
			 */
			public void actionPerformed(ActionEvent e) {
				JFrame verwaltung = new JFrame();
				verwaltung.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
				verwaltung.setBounds(100, 100, 403, 236);
				verwaltung.getContentPane().setLayout(null);
				benutzer.setVisible(false);
				verwaltung.setVisible(true); 
				verwaltung.setTitle("Verwaltungsmodus");
				
				JMenuBar menuBar = new JMenuBar();
				verwaltung.setJMenuBar(menuBar);
				
				JMenu mndatei = new JMenu("Datei");
				menuBar.add(mndatei);
				
				JMenuItem mntmbenutzer = new JMenuItem("Benutzermodus");
				mntmbenutzer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						verwaltung.setVisible(false); 
						benutzer.setVisible(true);
					}
				});
				mndatei.add(mntmbenutzer);
			}
		});
		mndatei.add(mntmverwaltungsmodus); 
			
		JMenuItem mntmbeenden = new JMenuItem("Beenden");
		mndatei.add(mntmbeenden);
		mntmbeenden.addActionListener(e->{System.exit(0);});
		
		JMenu mnbearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnbearbeiten);
		
		JMenu mnplaylist = new JMenu("Playlist");
		mnbearbeiten.add(mnplaylist);
		
		JMenuItem mntmerstellen = new JMenuItem("Erstellen");
		mnplaylist.add(mntmerstellen);
		
		JMenuItem mntmedit = new JMenuItem("Editieren");
		mnplaylist.add(mntmedit);
		
		JMenuItem mntmloeschen = new JMenuItem("Löschen");
		mnplaylist.add(mntmloeschen);
	}
}