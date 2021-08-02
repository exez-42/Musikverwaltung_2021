package musikverwaltung;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldname;
	private JTextField textFieldartist;
	private JTextField textFieldalbum;
	private JTextField textFielddate;
	private JTextField textFieldgenre;
	private JTextField textFieldsearch;
	private JTextField textFieldplaylistname;
	private JTextField textField;
	
	
	

	/**
	 * Inhalt Benutzermodus.
	 */
	
	
	
	public GUI() {
	
		
		/*Titel, TitelDB, Playlisten werden erstellt
		 * 
		 * 
		 * 
		 */
		TitelDB.erzeuge_TitelDB();
		TitelDB.einf(new Titel("T.N.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\2Pac-Changesft.Talent.wav"));
		TitelDB.einf(new Titel("Thunderstruck", "AC/DD", "The Razors Edge", 1990, "Rock","C:\\Users\\charl\\OneDrive\\Desktop\\project\\Musikverwaltung\\musik_titel\\DieWoodys-FichtlsLied.wav"));
		TitelDB.einf(new Titel("Sommer Sonne Kaktus", "Helge Schneider", "Sommer auf Balkonien", 2013, "Pop","C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
		
			Playlist.create_Playlist("Sommer_Playlist");
			Playlist.get_playlist_wID("Sommer_Playlist").add_Interpret("Helge Schneider");
			Playlist.get_playlist_wID("Sommer_Playlist").add_genre("Rock");
			Playlist.create_Playlist("Sommernacht zu zweit");
			Playlist.get_playlist_wID("Sommernacht zu zweit").add_Interpret("AC/DD");

		
		/*Ende
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setTitle("Benutzermodus");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbplayback = new JLabel("Aktuelle Wiedergabe:");
		lbplayback.setBounds(10, 26, 414, 14);
		getContentPane().add(lbplayback);
		
		
		
		
		JLabel lblsongisplaying = new JLabel();
		lblsongisplaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblsongisplaying.setBounds(10, 51, 414, 14);
		getContentPane().add(lblsongisplaying);
		
		
		
		
		
		
		
		
		
		
		JButton btnback = new JButton("");
		btnback.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Back.png")));
		btnback.setBounds(119, 76, 30, 25);
		getContentPane().add(btnback);
		
		JButton btnplay = new JButton("");
		btnplay.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Play.png")));
		btnplay.setBounds(159, 76, 30, 25);
		getContentPane().add(btnplay);
		
		JButton btnpause = new JButton("");
		btnpause.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Pause.png")));
		btnpause.setBounds(199, 76, 30, 25);
		getContentPane().add(btnpause);
		
		JButton btnstop = new JButton("");
		btnstop.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Stop.png")));
		btnstop.setBounds(239, 76, 30, 25);
		getContentPane().add(btnstop);
		
		JButton btnfoward = new JButton("");
		btnfoward.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Forward.png")));
		btnfoward.setBounds(279, 76, 30, 25);
		getContentPane().add(btnfoward);
		
		
		/*Logik Implementierung Benutzeroberfläsche
		 * 
		 * 
		 */

		/*ComboBox bekommt alle PlaylistNamen Übergeben
		 * 
		 */
		JComboBox<String> comboBoxplaylist = new JComboBox<String>(Playlist.get_all_plname_string());
		comboBoxplaylist.setBackground(SystemColor.window);
		comboBoxplaylist.setBounds(10, 143, 414, 20);
		getContentPane().add(comboBoxplaylist);
		
		
		
		/*ActionListener Benutzeroberfläsche
		 * 
		 * 
		 */
		
		/*Playbutton bekommt aktuellen Track.player übergeben
		 * + speichert diesen in der Hilfsvariable previos_track von Playlist ab um bei Playlist wechsel diesen stoppen zu können.
		 * 
		 */
		btnplay.addActionListener(e-> {Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.play();
										Playlist.set_previos_track((String)comboBoxplaylist.getSelectedItem()); });
		
		
		/*Pausebutton wird player.pause() 
		 * 
		 */
		btnpause.addActionListener(e->Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.pause());
		btnstop.addActionListener(e-> Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop());
		
		
		
		/*Nächster Titel Track 
		 * stopt laufenden Track 
		 * lädt nächsten Track
		 * repaint() damit neuer Titelname angezeigt wird
		 */
		btnfoward.addActionListener(e-> {Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track().player.stop(); 
										Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).next_track();
										repaint();});
										//repaint hinzufügen
		
		/*letzter Titel Track 
		 * stopt laufenden Track 
		 * lädt letzten Track
		 * repaint() damit neuer Titelname angezeigt wird
		 */
		btnback.addActionListener(e-> {Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track().player.stop(); 
										Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).previos_track();});				
										//repaint hinzufügen
	
				
		/*Titelanzeige
		 * 
		 */
		lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
		
	
		/*Bei neuer playlist auswahl wird laufender Track aus "alter" Playlist gestoppt.
		 * -> mit  der Hilfsvariable previos_track aus Playlist.
		 */
		comboBoxplaylist.addActionListener(e-> Playlist.get_current_playlist(Playlist.get_previos_track()).get_current_track().player.stop());                                 
		
		
		
		/*Logik Ende
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		

		
		
		
		JLabel lblplaylist = new JLabel("Aktuelle Playlist:");
		lblplaylist.setBounds(10, 119, 414, 14);
		contentPane.add(lblplaylist);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mndatei = new JMenu("Datei");
		menuBar.add(mndatei);
		
		JMenuItem mntmverwaltung = new JMenuItem("Verwaltungsmodus");
		mntmverwaltung.addActionListener(new ActionListener() {
			
			/**
			 * Inhalt Verwaltungsmodus.
			 */
			
			public void actionPerformed(ActionEvent e) {
				JFrame verwaltung = new JFrame();
				verwaltung.getContentPane().setBackground(UIManager.getColor("TextField.inactiveBackground"));
				verwaltung.setBounds(100, 100, 403, 551);
				verwaltung.getContentPane().setLayout(null);
				setVisible(false);
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
						setVisible(true);
						
					}
				});
				mndatei.add(mntmbenutzer);
				
				JLabel lbladd = new JLabel("Hinzuf\u00FCgen");
				lbladd.setBounds(10, 11, 90, 14);
				verwaltung.getContentPane().add(lbladd);
				
				JLabel lbldelete = new JLabel("Entfernen");
				lbldelete.setBounds(10, 246, 57, 14);
				verwaltung.getContentPane().add(lbldelete);
				
				JPanel paneladd = new JPanel();
				paneladd.setBackground(UIManager.getColor("TextField.inactiveBackground"));
				paneladd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				paneladd.setBounds(10, 29, 367, 206);
				verwaltung.getContentPane().add(paneladd);
				paneladd.setLayout(null);
				
				JLabel lblname = new JLabel("Titel:");
				lblname.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblname.setBounds(10, 23, 46, 14);
				paneladd.add(lblname);
				
				JLabel lblartist = new JLabel("Interpret:");
				lblartist.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblartist.setBounds(10, 54, 59, 14);
				paneladd.add(lblartist);
				
				JLabel lblalbum = new JLabel("Album:");
				lblalbum.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblalbum.setBounds(10, 85, 46, 14);
				paneladd.add(lblalbum);
				
				JLabel lbldate = new JLabel("Erscheinungsjahr:");
				lbldate.setFont(new Font("Tahoma", Font.BOLD, 11));
				lbldate.setBounds(9, 115, 100, 14);
				paneladd.add(lbldate);
				
				JLabel lblgenre = new JLabel("Genre:");
				lblgenre.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblgenre.setBounds(10, 143, 46, 14);
				paneladd.add(lblgenre);
				
				textFieldname = new JTextField();
				textFieldname.setEditable(false);
				textFieldname.setBounds(119, 20, 238, 20);
				paneladd.add(textFieldname);
				textFieldname.setColumns(10);
				
				textFieldartist = new JTextField();
				textFieldartist.setEditable(false);
				textFieldartist.setBounds(119, 51, 238, 20);
				paneladd.add(textFieldartist);
				textFieldartist.setColumns(10);
				
				textFieldalbum = new JTextField();
				textFieldalbum.setEditable(false);
				textFieldalbum.setBounds(119, 82, 238, 20);
				paneladd.add(textFieldalbum);
				textFieldalbum.setColumns(10);
				
				textFielddate = new JTextField();
				textFielddate.setEditable(false);
				textFielddate.setBounds(119, 112, 238, 20);
				paneladd.add(textFielddate);
				textFielddate.setColumns(10);
				
				textFieldgenre = new JTextField();
				textFieldgenre.setEditable(false);
				textFieldgenre.setBounds(119, 140, 238, 20);
				paneladd.add(textFieldgenre);
				textFieldgenre.setColumns(10);
				
				JButton btnaddfile = new JButton("Datei ausw\u00E4hlen");
				btnaddfile.addActionListener(new ActionListener() {
			
					public void actionPerformed(ActionEvent arg0) {
				
						JFileChooser chooser = new JFileChooser();
						int rueckgabeWert = chooser.showOpenDialog(null);
				 			if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
			        				{
			             					// Ausgabe der ausgewaehlten Datei
			            					System.out.println("Die zu öffnende Datei ist: " +
			                 					chooser.getSelectedFile().getAbsoluteFile());
			        				}
		    				}
				});
				
				btnaddfile.setBounds(119, 172, 111, 23);
				paneladd.add(btnaddfile);
				
				JButton btnaddsong = new JButton("Hinzuf\u00FCgen");
				btnaddsong.setBounds(240, 171, 117, 23);
				paneladd.add(btnaddsong);
				
				JPanel paneldelete = new JPanel();
				paneldelete.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				paneldelete.setBackground(UIManager.getColor("TextField.inactiveBackground"));
				paneldelete.setBounds(10, 264, 367, 216);
				verwaltung.getContentPane().add(paneldelete);
				paneldelete.setLayout(null);
				
				List listsongs = new List();
				listsongs.setBounds(10, 10, 347, 138);
				paneldelete.add(listsongs);
				
				JButton btndeletesong = new JButton("L\u00F6schen");
				btndeletesong.setBounds(10, 154, 111, 23);
				paneldelete.add(btndeletesong);
				
				JButton btnsearch = new JButton("Suchen");
				btnsearch.setBounds(10, 188, 111, 23);
				paneldelete.add(btnsearch);
				
				textFieldsearch = new JTextField();
				textFieldsearch.setColumns(10);
				textFieldsearch.setBounds(131, 189, 226, 20);
				paneldelete.add(textFieldsearch);
				}
			});
		mndatei.add(mntmverwaltung); 
			
		JMenuItem mntmbeenden = new JMenuItem("Beenden");
		mndatei.add(mntmbeenden);
		mntmbeenden.addActionListener(e->{System.exit(0);});
		
		JMenu mnplaylisteditor = new JMenu("Playlist Editor");
		menuBar.add(mnplaylisteditor);
		
		JMenuItem mntmcreate = new JMenuItem("Erstellen");
		mntmcreate.addActionListener(new ActionListener() {
			
			/**
			 * Inhalt Playlist Erstellen.
			 */
			
			public void actionPerformed(ActionEvent e) {
				JFrame playlistcreate = new JFrame();
				playlistcreate.setVisible(true);
				playlistcreate.setBounds(100, 100, 300, 279);
				playlistcreate.setTitle("Playlist - Erstellen");
				
				JMenuBar menuBar = new JMenuBar();
				playlistcreate.setJMenuBar(menuBar);
				
				JMenu mnplaylistwindow = new JMenu("Fenster");
				menuBar.add(mnplaylistwindow);
			
				JMenuItem mntmclose = new JMenuItem("Schlie\u00DFen");
				mnplaylistwindow.add(mntmclose);
				mntmclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						playlistcreate.setVisible(false);
						}
					});
				
				
				contentPane = new JPanel();
				contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				playlistcreate.setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblplaylistname = new JLabel("Name eingeben:");
				lblplaylistname.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblplaylistname.setBounds(10, 11, 99, 14);
				contentPane.add(lblplaylistname);
				
				textFieldplaylistname = new JTextField();
				textFieldplaylistname.setBounds(10, 36, 250, 20);
				contentPane.add(textFieldplaylistname);
				textFieldplaylistname.setColumns(10);
				
				JButton btncreateplaylist = new JButton("Erstellen");
				btncreateplaylist.setBounds(10, 67, 105, 25);
				contentPane.add(btncreateplaylist);
				
				JButton btncreatecategory = new JButton("Nach Kategorie erstellen");
				btncreatecategory.setBounds(10, 181, 180, 25);
				contentPane.add(btncreatecategory);
				
				@SuppressWarnings("rawtypes")
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(10, 113, 180, 23);
				contentPane.add(comboBox);
				
				@SuppressWarnings("rawtypes")
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(10, 147, 180, 23);
				contentPane.add(comboBox_1);
			}
		});
		mnplaylisteditor.add(mntmcreate);
		
		JMenuItem mntmedit = new JMenuItem("Bearbeiten");
		mntmedit.addActionListener(new ActionListener() {
			
			/**
			 * Inhalt Playlist Bearbeiten.
			 */
			
			public void actionPerformed(ActionEvent e) {
				JFrame playlistedit = new JFrame();
				playlistedit.setVisible(true);
				playlistedit.setTitle("Playlist - Bearbeiten");
				playlistedit.setBounds(100, 100, 622, 516);
				
				JMenuBar menuBar = new JMenuBar();
				playlistedit.setJMenuBar(menuBar);
				
				JMenu mnmnplaylistwindow = new JMenu("Fenster");
				menuBar.add(mnmnplaylistwindow);
				
				JMenuItem mntmclose = new JMenuItem("Schlie\u00DFen");
				mnmnplaylistwindow.add(mntmclose);
				mntmclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						playlistedit.setVisible(false);
						}
					});
				
				contentPane = new JPanel();
				contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				playlistedit.setContentPane(contentPane);
				contentPane.setLayout(null);
				
				List list = new List();
				list.setBounds(10, 88, 270, 140);
				contentPane.add(list);
				
				JLabel lblNewLabel = new JLabel("Playlist ausw\u00E4hlen:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(243, 10, 121, 18);
				contentPane.add(lblNewLabel);
				
				@SuppressWarnings("rawtypes")
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(142, 39, 322, 18);
				contentPane.add(comboBox);
				
				List list_1 = new List();
				list_1.setBounds(326, 88, 270, 140);
				contentPane.add(list_1);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Left.png")));
				btnNewButton.setBounds(286, 108, 33, 23);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Right.png")));
				btnNewButton_1.setBounds(286, 187, 33, 23);
				contentPane.add(btnNewButton_1);
				
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(10, 264, 586, 181);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JButton btnNewButton_2 = new JButton("Manuelle Suche");
				btnNewButton_2.setBounds(441, 54, 135, 23);
				panel.add(btnNewButton_2);
				
				textField = new JTextField();
				textField.setBounds(337, 22, 239, 22);
				panel.add(textField);
				textField.setColumns(10);
				
				@SuppressWarnings("rawtypes")
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(337, 88, 239, 20);
				panel.add(comboBox_1);
				
				JButton btnNewButton_4 = new JButton("Filter anwenden");
				btnNewButton_4.setBounds(441, 119, 135, 23);
				panel.add(btnNewButton_4);
				
				JButton btnNewButton_5 = new JButton("Zur\u00FCcksetzen");
				btnNewButton_5.setBounds(441, 147, 135, 23);
				panel.add(btnNewButton_5);
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Nach Interpret");
				rdbtnNewRadioButton.setBounds(6, 54, 109, 23);
				panel.add(rdbtnNewRadioButton);
				
				JRadioButton rdbtnNach = new JRadioButton("Nach Titel");
				rdbtnNach.setSelected(true);
				rdbtnNach.setBounds(6, 22, 109, 23);
				panel.add(rdbtnNach);
				
				JRadioButton rdbtnAufsteigend = new JRadioButton("Aufsteigend");
				rdbtnAufsteigend.setSelected(true);
				rdbtnAufsteigend.setBounds(146, 67, 109, 23);
				panel.add(rdbtnAufsteigend);
				
				JRadioButton rdbtnAbsteigend = new JRadioButton("Absteigend");
				rdbtnAbsteigend.setBounds(146, 93, 109, 23);
				panel.add(rdbtnAbsteigend);
				
				JRadioButton rdbtnNachAlbum = new JRadioButton("Nach Album");
				rdbtnNachAlbum.setBounds(6, 87, 109, 23);
				panel.add(rdbtnNachAlbum);
				
				JRadioButton rdbtnNachErscheinungsjahr = new JRadioButton("Nach Erscheinungsjahr");
				rdbtnNachErscheinungsjahr.setBounds(6, 119, 135, 23);
				panel.add(rdbtnNachErscheinungsjahr);
				
				JRadioButton rdbtnNachGenre = new JRadioButton("Nach Genre");
				rdbtnNachGenre.setBounds(6, 147, 135, 23);
				panel.add(rdbtnNachGenre);
				
				Panel panel_1 = new Panel();
				panel_1.setBackground(UIManager.getColor("TextField.foreground"));
				panel_1.setBounds(289, 0, 3, 181);
				panel.add(panel_1);
				
				JLabel lblNewLabel_1 = new JLabel("Sotieren:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(10, 246, 81, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Playlist");
				lblNewLabel_2.setBounds(115, 68, 46, 14);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Song Bibliothek");
				lblNewLabel_3.setBounds(418, 68, 93, 14);
				contentPane.add(lblNewLabel_3);
				
				JLabel lblNewLabel_1_1 = new JLabel("Suchen:");
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_1.setBounds(304, 246, 81, 14);
				contentPane.add(lblNewLabel_1_1);
			}
		});
		mnplaylisteditor.add(mntmedit);
		
		JMenuItem mntmdelete = new JMenuItem("L\u00F6schen");
		mntmdelete.addActionListener(new ActionListener() {
			
			/**
			 * Inhalt Playlist Löschen.
			 */
			
			public void actionPerformed(ActionEvent e) {
				JFrame playlistdelete = new JFrame();
				playlistdelete.setVisible(true);
				playlistdelete.setTitle("Playlist - L\u00F6schen");
				playlistdelete.setBounds(100, 100, 400, 335);
				
				JMenuBar menuBar = new JMenuBar();
				playlistdelete.setJMenuBar(menuBar);
				
				JMenu mnwindow = new JMenu("Fenster");
				menuBar.add(mnwindow);
				
				JMenuItem mntmclose = new JMenuItem("Schlie\u00DFen");
				mnwindow.add(mntmclose);
				mntmclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						playlistdelete.setVisible(false);
						}
					});
				
				contentPane = new JPanel();
				contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				playlistdelete.setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Playlist ausw\u00E4hlen:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(123, 22, 121, 18);
				contentPane.add(lblNewLabel);
				
				@SuppressWarnings("rawtypes")
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(54, 51, 267, 18);
				contentPane.add(comboBox);
				
				List list = new List();
				list.setBounds(10, 89, 364, 142);
				contentPane.add(list);
				
				JButton btnNewButton = new JButton("Playlist entfernen");
				btnNewButton.setBounds(10, 242, 140, 23);
				contentPane.add(btnNewButton);
			}
		});
		mnplaylisteditor.add(mntmdelete);
	}
}
