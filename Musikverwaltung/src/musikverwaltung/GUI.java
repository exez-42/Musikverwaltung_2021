package musikverwaltung;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	//Frame
	private JFrame verwaltung;
	private JFrame playlistedit;
	private JFrame playlistcreate;
	private JFrame playlistdelete;
	
	//JMenu
	private JMenu mndatei;
	private JMenu mnplaylisteditor;
	
	//JMenuBar
	private JMenuBar menuBar;
	 
	
	//JMenuItem
	private JMenuItem mntmbenutzer;
	private JMenuItem mntmverwaltung;
	private JMenuItem mntmcreate;
	private JMenuItem mntmedit;
	private JMenuItem mntmdelete;
	private JMenuItem mntmbeenden;
	
	
	//JLabel
	private JLabel lbplayback;
	private JLabel lblsongisplaying;
	private JLabel lblplaylist;
	
	//JButton
	private JButton btnback;
	private JButton btnplay;
	private JButton btnpause;
	private JButton	btnstop;
	private JButton btnfoward;
	
	//JComboBox
	private JComboBox<String> comboBoxplaylist;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxeditplaylist;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxplaylistdelete;
	@SuppressWarnings("rawtypes")
	private JList listdelete;
	
	private JPanel contentPane;
	private JTextField textFieldname;
	private JTextField textFieldartist;
	private JTextField textFieldalbum;
	private JTextField textFielddate;
	private JTextField textFieldgenre;
	private JTextField textFieldsearch;
	private JTextField textFieldplaylistname;
	private JTextField textallsearch;
	private JTextField textFieldfile;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GUI() {
	
		
		/*Titel, TitelDB, Playlisten werden erstellt
		 * 
		 * 
		 * 
		 */
		TitelDB.erzeuge_TitelDB();
		TitelDB.einf(new Titel("T.N.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\2Pac-Changesft.Talent.wav"));
		TitelDB.einf(new Titel("Sommer Sonne Kaktus", "Helge Schneider", "Sommer auf Balkonien", 2013, "Pop","C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\2Pac-Changesft.Talent.wav"));
		TitelDB.einf(new Titel("T.A.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
		TitelDB.einf(new Titel("T.B.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
		TitelDB.einf(new Titel("T.C.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
		TitelDB.einf(new Titel("T.D.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
		TitelDB.einf(new Titel("T.E.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
		TitelDB.einf(new Titel("T.F.T.", "AC/DC", "High Voltage", 1976, "Rock", "C:\\Users\\charl\\OneDrive\\Desktop\\project_musik\\Helge Schneider - Sommer, Sonne Kaktus.wav"));
			
			// Playlisten erstellen
			Playlist.create_Playlist("Sommer_Playlist");
			Playlist.get_playlist_wID("Sommer_Playlist").add_genre("Rock");
			Playlist.create_Playlist("Sommernacht zu zweit");
			Playlist.get_playlist_wID("Sommernacht zu zweit").add_Interpret("Helge Schneider");
			
		/*Ende
		 * 
		 * 
		 * 
		 */
		
		/**
		* Inhalt Benutzermodus.
		*/	
		
		setTitle("Benutzermodus");
		setResizable(false);
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mndatei = new JMenu("Datei");
		menuBar.add(mndatei);
		
		mntmverwaltung = new JMenuItem("Verwaltungsmodus");
		mndatei.add(mntmverwaltung);
		
		mnplaylisteditor = new JMenu("Playlist Editor");
		menuBar.add(mnplaylisteditor);
		
		mntmcreate = new JMenuItem("Erstellen");
		mnplaylisteditor.add(mntmcreate);
		
		mntmedit = new JMenuItem("Bearbeiten");
		mnplaylisteditor.add(mntmedit);
		
		mntmdelete = new JMenuItem("Löschen");
		mnplaylisteditor.add(mntmdelete);
		
		mntmbeenden = new JMenuItem("Beenden");
		mndatei.add(mntmbeenden);
		mntmbeenden.addActionListener(e->{System.exit(0);});
		
		lblplaylist = new JLabel("Aktuelle Playlist:");
		lblplaylist.setBounds(10, 119, 414, 14);
		contentPane.add(lblplaylist);
		
		lbplayback = new JLabel("Aktuelle Wiedergabe:");
		lbplayback.setBounds(10, 26, 414, 14);
		getContentPane().add(lbplayback);
		
		lblsongisplaying = new JLabel();
		lblsongisplaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblsongisplaying.setBounds(10, 51, 414, 14);
		getContentPane().add(lblsongisplaying);
		
		btnback = new JButton("");
		btnback.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Back.png")));
		btnback.setBounds(119, 76, 30, 25);
		getContentPane().add(btnback);
		
		btnplay = new JButton("");
		btnplay.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Play.png")));
		btnplay.setBounds(159, 76, 30, 25);
		getContentPane().add(btnplay);
		
		btnpause = new JButton("");
		btnpause.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Pause.png")));
		btnpause.setBounds(199, 76, 30, 25);
		getContentPane().add(btnpause);
		
		btnstop = new JButton("");
		btnstop.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Stop.png")));
		btnstop.setBounds(239, 76, 30, 25);
		getContentPane().add(btnstop);
		
		btnfoward = new JButton("");
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
			
			comboBoxplaylist = new JComboBox<String>(Playlist.get_all_plname_string());
			comboBoxplaylist.setBackground(SystemColor.window);
			comboBoxplaylist.setBounds(10, 143, 414, 20);
			getContentPane().add(comboBoxplaylist);
			
				/*ComboBox übergibt Playlist und Titel and Label
				 * 
				 */
			
				comboBoxplaylist.addActionListener (new ActionListener () {
				
				    public void actionPerformed(ActionEvent e)
				    {
				    	lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
				       
				    }
				});
		
	
					/*ActionListener Benutzeroberfläsche
					 * 
					 * 
					 */
					
					/*Playbutton bekommt aktuellen Track.player übergeben
					 * + speichert diesen in der Hilfsvariable previos_track von Playlist ab um bei Playlist wechsel diesen stoppen zu können.
					 * 
					 */
					btnplay.addActionListener(e-> { if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {
						
						}else {			
							Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.play();
							
							
							Playlist.set_previos_track((String)comboBoxplaylist.getSelectedItem());
						}
					});

		
						/*Pausebutton wird player.pause() 
						 * 
						 */
						btnpause.addActionListener(e->{	if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {
			
							}else {
								
								Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.pause();								
						}});
		
		
		
		
						btnstop.addActionListener(e-> {if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {
						
							}else {		Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();}	
						});
		
				
		
		
							/*Nächster Titel Track 
							 * stopt laufenden Track 
							 * lädt nächsten Track
							 * repaint() damit neuer Titelname angezeigt wird
							 */
							btnfoward.addActionListener(e-> { if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {}
								else {
									Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track().player.stop(); 
									Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).next_track();	
									lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
								}});
												
							/*letzter Titel Track 
							 * stopt laufenden Track 
							 * lädt letzten Track
							 * repaint() damit neuer Titelname angezeigt wird
							 */
							btnback.addActionListener(e-> {if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {}
								else {
									Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track().player.stop(); 
									Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).previos_track();
									lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
								}});				
							
								/*Titelanzeige
								 * 
								 */
													
								if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {}
								else {
									lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
								}
														
									/*Bei neuer playlist auswahl wird laufender Track aus "alter" Playlist gestoppt.
									 * -> mit  der Hilfsvariable previos_track aus Playlist.
									 */
									comboBoxplaylist.addActionListener(e-> {if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {}
									else{Playlist.get_current_playlist(Playlist.get_previos_track()).get_current_track().player.stop();}
										Playlist.get_current_playlist(Playlist.get_previos_track()).set_current_titel_zero();
									});
			
		/*Logik Ende
		 * 
		 * 
		 */
									
		
		/**
		 * Inhalt Verwaltungsmodus.
		 */
		
		verwaltung = new JFrame();
		verwaltung.setResizable(false);
		verwaltung.getContentPane().setBackground(UIManager.getColor("TextField.inactiveBackground"));
		verwaltung.setBounds(100, 100, 403, 551);
		verwaltung.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		verwaltung.getContentPane().setLayout(null);
		verwaltung.setVisible(false); 
		verwaltung.setTitle("Verwaltungsmodus");
		
		/*Wenn Verwaltungsmodus modus geschlossen wird
		 * -> Benutzermodus wird wieder sichtbar.
		 */
		
		verwaltung.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
		        setVisible(true);
		        e.getWindow().dispose();
		    }
		});
		
		
		
				
		menuBar = new JMenuBar();
		verwaltung.setJMenuBar(menuBar);
				
		mndatei = new JMenu("Datei");
		menuBar.add(mndatei);
	
		mntmbenutzer = new JMenuItem("Benutzermodus");
		mndatei.add(mntmbenutzer);
		mntmbenutzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verwaltung.setVisible(false); 
				setVisible(true);
				
			}
		});
		
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
		textFieldname.setEditable(true);
		textFieldname.setBounds(119, 20, 238, 20);
		paneladd.add(textFieldname);
		textFieldname.setColumns(10);
		
		textFieldartist = new JTextField();
		textFieldartist.setEditable(true);
		textFieldartist.setBounds(119, 51, 238, 20);
		paneladd.add(textFieldartist);
		textFieldartist.setColumns(10);
		
		textFieldalbum = new JTextField();
		textFieldalbum.setEditable(true);
		textFieldalbum.setBounds(119, 82, 238, 20);
		paneladd.add(textFieldalbum);
		textFieldalbum.setColumns(10);
		
		textFielddate = new JTextField();
		textFielddate.setEditable(true);
		textFielddate.setBounds(119, 112, 238, 20);
		paneladd.add(textFielddate);
		textFielddate.setColumns(10);
		
		textFieldgenre = new JTextField();
		textFieldgenre.setEditable(true);
		textFieldgenre.setBounds(119, 140, 238, 20);
		paneladd.add(textFieldgenre);
		textFieldgenre.setColumns(10);
		
		textFieldfile = new JTextField();
		textFieldfile.setEditable(false);
		textFieldfile.setBounds(119, 172, 111, 21);
		paneladd.add(textFieldfile);
		textFieldfile.setColumns(10);
		
		JButton btnaddfile = new JButton("Datei ausw\u00E4hlen");
		btnaddfile.setBounds(10, 171, 99, 23);
		paneladd.add(btnaddfile);
		btnaddfile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// Erstellung unseres FileFilters für Bilddateien
		        FileFilter filter = new FileNameExtensionFilter("Musik", "wav");      
				JFileChooser chooser = new JFileChooser("C:/Beispieldatei");
				chooser.addChoosableFileFilter(filter); 
				chooser.setAcceptAllFileFilterUsed(false);
				int rueckgabeWert = chooser.showOpenDialog(null);
		 			if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
	        				{
	             					// Ausgabe der ausgewaehlten Datei
	            					System.out.println("Die zu öffnende Datei ist: " +
	                 					chooser.getSelectedFile().getAbsoluteFile());
	        				}
    				}
		});
		
		JButton btnaddsong = new JButton("Hinzuf\u00FCgen");
		btnaddsong.setBounds(240, 171, 117, 23);
		paneladd.add(btnaddsong);
		
		JPanel paneldelete = new JPanel();
		paneldelete.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paneldelete.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		paneldelete.setBounds(10, 264, 367, 216);
		verwaltung.getContentPane().add(paneldelete);
		paneldelete.setLayout(null);
		
		JList listsongs = new JList();
		listsongs.setBorder(BorderFactory.createLineBorder(Color.black));
		listsongs.setBounds(10, 18, 347, 130);
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
		
		JButton btntitle = new JButton("Titel");
		btntitle.setBounds(10, 5, 70, 12);
		paneldelete.add(btntitle);
		btntitle.setOpaque(false);
		btntitle.setContentAreaFilled(false);
		
		JButton btnartist = new JButton("Interpr.");
		btnartist.setBounds(80, 5, 70, 12);
		paneldelete.add(btnartist);
		btnartist.setOpaque(false);
		btnartist.setContentAreaFilled(false);
		
		JButton btnalbum = new JButton("Album");
		btnalbum.setBounds(149, 5, 70, 12);
		paneldelete.add(btnalbum);
		btnalbum.setOpaque(false);
		btnalbum.setContentAreaFilled(false);
		
		JButton btnyear = new JButton("Jahr");
		btnyear.setBounds(219, 5, 70, 12);
		paneldelete.add(btnyear);
		btnyear.setOpaque(false);
		btnyear.setContentAreaFilled(false);
		
		JButton btngenre = new JButton("Genre");
		btngenre.setBounds(287, 5, 70, 12);
		paneldelete.add(btngenre);
		btngenre.setOpaque(false);
		btngenre.setContentAreaFilled(false);
			
		mntmverwaltung.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				verwaltung.setVisible(true);
				setVisible(false);
			}
		});
 	
		
		/**
		 * Inhalt Playlist Erstellen.
		 */
		
		
		playlistcreate = new JFrame();
		playlistcreate.setResizable(false);
		playlistcreate.setVisible(false);
		playlistcreate.setBounds(100, 100, 300, 166);
		playlistcreate.setTitle("Playlist - Erstellen");
		
		menuBar = new JMenuBar();
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
		textFieldplaylistname.setBounds(10, 36, 264, 20);
		contentPane.add(textFieldplaylistname);
		textFieldplaylistname.setColumns(10);
		
		JButton btncreateplaylist = new JButton("Erstellen");
		btncreateplaylist.setBounds(10, 67, 105, 25);
		contentPane.add(btncreateplaylist);
		
		JButton btncreatecategory = new JButton("Titel hinzuf\u00FCgen");
		btncreatecategory.setBounds(125, 67, 149, 25);
		contentPane.add(btncreatecategory);
		/*LOGIK PLAYLIST hinzufügen
		 * 
		 * 
		 * 
		 */
		
		
		btncreateplaylist.addActionListener(e-> { 
			boolean tmp = Playlist.create_Playlist(textFieldplaylistname.getText());
			
			if(tmp == true) {
			
			textFieldplaylistname.setText("Playlist wurde hinzugefügt");
			comboBoxplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			comboBoxeditplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));	
			comboBoxplaylistdelete.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			
			
		}else {textFieldplaylistname.setText("ERROR: Playlistname bereits vergeben.");}
			
			
			
		});
		
		
		
		
		
		btncreatecategory.addActionListener(new ActionListener() {
		
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				playlistedit.setVisible(true);
			}
		});
		
		mntmcreate.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				playlistcreate.setVisible(true);
			}
		});
		
		
		/**
		* Inhalt Playlist Bearbeiten.
		*/
		
		playlistedit = new JFrame();
		playlistedit.setResizable(false);
		playlistedit.setVisible(false);
		playlistedit.setTitle("Playlist - Bearbeiten");
		playlistedit.setBounds(100, 100, 622, 516);
		
		JMenuBar menuBaredit = new JMenuBar();
		playlistedit.setJMenuBar(menuBaredit);
		
		JMenu mnmnplaylistwindow = new JMenu("Fenster");
		menuBaredit.add(mnmnplaylistwindow);
		
		JMenuItem mntmclose1 = new JMenuItem("Schlie\u00DFen");
		mnmnplaylistwindow.add(mntmclose1);
		mntmclose1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlistedit.setVisible(false);
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		playlistedit.setContentPane(contentPane);
		contentPane.setLayout(null);
		/*LOGIK PLAYLIST EDITOR
		 * 
		 * 
		 */
		
	
		
		/*Combobox: Listet alle Playlisten auf
		 * 
		 */
		comboBoxeditplaylist = new JComboBox(Playlist.get_all_plname_string());
		
		comboBoxeditplaylist.setBounds(142, 39, 322, 18);
		contentPane.add(comboBoxeditplaylist);
		
		/*JLIST: Listet alle Titel der ausgewählten Playlist auf.
		 * 
		 */
		
		JList listplaylist = new JList();
		JScrollPane playlistScrollPane = new JScrollPane(listplaylist);
		
		playlistScrollPane.setBounds(10, 88, 270, 140);
		listplaylist.setBorder(BorderFactory.createLineBorder(Color.black));
		listplaylist.setBounds(10, 88, 270, 140);
		contentPane.add(playlistScrollPane);  
		

		
		if(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()) == null) {
		
		
		}else {	listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());	
		
			comboBoxeditplaylist.addActionListener (new ActionListener ()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	listplaylist.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array()));
			       
			    }
			});
		}
		
		
		JLabel lblNewLabel = new JLabel("Playlist ausw\u00E4hlen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(243, 10, 121, 18);
		contentPane.add(lblNewLabel);
		
		/*Playlist auswählen
		 * 
		 * 
		 */
		
		JList listall = new JList();
		JScrollPane allScrollPane = new JScrollPane(listall);
		
		allScrollPane.setBounds(326, 88, 270, 140);
		listall.setBorder(BorderFactory.createLineBorder(Color.black));
		listall.setBounds(326, 88, 270, 140);
		contentPane.add(allScrollPane);  
		
		
		/*Liste mit allen Tracks füllen
		 * 
		 * 
		 * 
		 */
		listall.setListData(TitelDB.get_titelDB_array());


		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		JButton btnaddtoplaylist = new JButton("");
		btnaddtoplaylist.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Left.png")));
		btnaddtoplaylist.setBounds(286, 108, 33, 23);
		contentPane.add(btnaddtoplaylist);
			
		JButton btndeletefromplaylist = new JButton("");
		btndeletefromplaylist.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Right.png")));
		btndeletefromplaylist.setBounds(286, 187, 33, 23);
		contentPane.add(btndeletefromplaylist);
		
		/*Löschen / hinzufügen
		 * 
		 * 
		 * 
		 * 
		 */
		
		btnaddtoplaylist.addActionListener(e-> {
			if(listall.getSelectedValue() == null) {}
			else {

			Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).add_singletitel((String) listall.getSelectedValue());
			listplaylist.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array()));
			listdelete.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array()));
			Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).set_current_titel_zero();	

			}





		});



		//löschen

		btndeletefromplaylist.addActionListener(e-> {
			if(listplaylist.getSelectedValue() == null) {} 
			else {Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();	
			
				Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).delete_singletitel((String) listplaylist.getSelectedValue());	
				listplaylist.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array()));
				listdelete.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array()));
				Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).set_current_titel_zero();
				
				
				}
			});


		/*Ende
		*
		*
		*/
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 264, 586, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnsearchedit = new JButton("Manuelle Suche");
		btnsearchedit.setBounds(372, 71, 135, 23);
		panel.add(btnsearchedit);
		
		textallsearch = new JTextField();
		textallsearch.setBounds(322, 38, 239, 22);
		panel.add(textallsearch);
		textallsearch.setColumns(10);
		
		JComboBox comboBoxfilter1 = new JComboBox();
		comboBoxfilter1.setBounds(322, 120, 117, 20);
		panel.add(comboBoxfilter1);
		
		JButton btnapplyfilter = new JButton("Filter anwenden");
		btnapplyfilter.setBounds(449, 119, 127, 23);
		panel.add(btnapplyfilter);
		
		JButton btnaddall = new JButton("Alle hinzuf\u00FCgen");
		btnaddall.setBounds(449, 147, 127, 23);
		panel.add(btnaddall);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nach Interpret");
		rdbtnNewRadioButton.setBounds(6, 54, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNach = new JRadioButton("Nach Titel");
		rdbtnNach.setSelected(true);
		rdbtnNach.setBounds(6, 22, 109, 23);
		panel.add(rdbtnNach);
		
		JRadioButton rdbtnNachAlbum = new JRadioButton("Nach Album");
		rdbtnNachAlbum.setBounds(6, 87, 109, 23);
		panel.add(rdbtnNachAlbum);	
		
		JRadioButton rdbtnNachErscheinungsjahr = new JRadioButton("Nach Erscheinungsjahr");
		rdbtnNachErscheinungsjahr.setBounds(6, 119, 135, 23);
		panel.add(rdbtnNachErscheinungsjahr);
		
		JRadioButton rdbtnNachGenre = new JRadioButton("Nach Genre");
		rdbtnNachGenre.setBounds(6, 147, 135, 23);
		panel.add(rdbtnNachGenre);
		
		JRadioButton rdbtnAufsteigend = new JRadioButton("Aufsteigend");
		rdbtnAufsteigend.setSelected(true);
		rdbtnAufsteigend.setBounds(146, 67, 109, 23);
		panel.add(rdbtnAufsteigend);
		
		JRadioButton rdbtnAbsteigend = new JRadioButton("Absteigend");
		rdbtnAbsteigend.setBounds(146, 93, 109, 23);
		panel.add(rdbtnAbsteigend);
		
		//Grupppierung fuer die radio buttons 
		ButtonGroup groupleft = new ButtonGroup();
		groupleft.add(rdbtnNewRadioButton);
		groupleft.add(rdbtnNach);
		groupleft.add(rdbtnNachAlbum);
		groupleft.add(rdbtnNachErscheinungsjahr);
		groupleft.add(rdbtnNachGenre);
		ButtonGroup groupright = new ButtonGroup();
		groupright.add(rdbtnAufsteigend);
		groupright.add(rdbtnAbsteigend);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(UIManager.getColor("TextField.foreground"));
		panel_1.setBounds(289, 0, 3, 181);
		panel.add(panel_1);
		
		JComboBox comboBoxfilter2 = new JComboBox();
		comboBoxfilter2.setBounds(322, 148, 117, 20);
		panel.add(comboBoxfilter2);
		
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
		mntmedit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				playlistedit.setVisible(true);
			}
		});
			
		
		
		/**
		* Inhalt Playlist Löschen.
		*/
		
		playlistdelete = new JFrame();
		playlistdelete.setResizable(false);
		playlistdelete.setVisible(false);
		playlistdelete.setTitle("Playlist - L\u00F6schen");
		playlistdelete.setBounds(100, 100, 400, 335);
		
		menuBar = new JMenuBar();
		playlistdelete.setJMenuBar(menuBar);
		
		JMenu mnwindow = new JMenu("Fenster");
		menuBar.add(mnwindow);
		
		JMenuItem mntmclose2 = new JMenuItem("Schlie\u00DFen");
		mnwindow.add(mntmclose2);
		mntmclose2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlistdelete.setVisible(false);
				}
			});
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		playlistdelete.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblplaylistdelete = new JLabel("Playlist ausw\u00E4hlen:");
		lblplaylistdelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblplaylistdelete.setBounds(123, 22, 121, 18);
		contentPane.add(lblplaylistdelete);
		
		//Alle Playlisten an Combobox übergeben
		
		comboBoxplaylistdelete = new JComboBox(Playlist.get_all_plname_string());
		comboBoxplaylistdelete.setBounds(54, 51, 267, 18);
		contentPane.add(comboBoxplaylistdelete);
		
		listdelete = new JList();
		JScrollPane deleteScrollPane = new JScrollPane(listdelete);
		
		deleteScrollPane.setBounds(10, 89, 364, 142);
		listdelete.setBorder(BorderFactory.createLineBorder(Color.black));
		listdelete.setBounds(10, 89, 364, 142);
		contentPane.add(deleteScrollPane); 
	
		JButton btnplaylistdelete = new JButton("Playlist entfernen");
		btnplaylistdelete.setBounds(10, 242, 140, 23);
		contentPane.add(btnplaylistdelete);
		
		
		/*Logik Playlist loeschen
		 * 
		 * comboBoxplaylistdelete 
		 * 
		 * listdelete
		 * 
		 * btnplaylistdelete
		 * 
		 */

		/*JList bekommt Titel der aktuellen Playlist als String[] übergeben.
		 * + prüft ob es überhaupt Playlisten gibt
		 */

		if(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()) == null) {}
		else { listdelete.setListData(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()).get_all_titel_array());
			}

		comboBoxplaylistdelete.addActionListener (new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	listdelete.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()).get_all_titel_array()));
		       
		    }
		});


		/*Button bekommt löschen aufforderung von ausgewähler Playlist
		 * + überprüft ob es überhaupt Playlisten gibt
		 * 
		 */
		if(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()) == null) {System.out.println("true");}
		else {    btnplaylistdelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			Playlist.delete_playlist((String) comboBoxplaylistdelete.getSelectedItem()); 
			Playlist.drucke_alle_pl();
			comboBoxplaylistdelete.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			listdelete.setModel(new DefaultComboBoxModel(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()).get_all_titel_array()));
			comboBoxplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			comboBoxeditplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			}                                        
		});
	}

		/*Logik Ende
		 * 
		 * 
		 * 
		 * 
		 */
		
		mntmdelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				playlistdelete.setVisible(true);
			}
		});
	}
}
