package musikverwaltung;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
import javax.swing.DefaultListModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	//JFrame
	private JFrame verwaltung;
	private JFrame playlistedit;
	private JFrame playlistcreate;
	private JFrame playlistdelete;
	
	//JMenu
	private JMenu mndatei;
	private JMenu mnplaylisteditor;
	private JMenu mnplaylistwindow;
	private JMenu mnmnplaylistwindow;
	private JMenu mnwindow;
	
	//JMenuBar
	private JMenuBar menuBar;
	private JMenuBar menuBaredit;
	 
	//JMenuItem
	private JMenuItem mntmbenutzer;
	private JMenuItem mntmverwaltung;
	private JMenuItem mntmcreate;
	private JMenuItem mntmedit;
	private JMenuItem mntmdelete;
	private JMenuItem mntmbeenden;
	private JMenuItem mntmclose;
	private JMenuItem mntmclose1;
	private JMenuItem mntmclose2;
	
	//JPanel
	private JPanel contentPane;
	private JPanel panel;
	private Panel panel_1;
	
	//JLabel
	private JLabel lbplayback;
	private JLabel lblsongisplaying;
	private JLabel lblplaylist;
	private JLabel lbladd;
	private JLabel lbldelete;
	private JPanel paneladd;
	private JPanel paneldelete;
	private JLabel lblname;
	private JLabel lblartist;
	private JLabel lblalbum;
	private JLabel lblgenre;
	private JLabel lblplaylistname;
	private JLabel lblchooseplaylist;
	private JLabel lblsort;
	private JLabel lbleditplaylist;
	private JLabel lbleditsongs;
	private JLabel lblsearch;
	private JLabel lbldate;
	private JLabel lblplaylistdelete;
		
	//JButton
	private JButton btnback;
	private JButton btnplay;
	private JButton btnpause;
	private JButton	btnstop;
	private JButton btnfoward;
	private JButton btnaddfile;
	private JButton btnaddsong;
	private JButton btndeletesong;
	private JButton btnsearch;
	private JButton btntitle;
	private JButton btnartist;
	private JButton btnalbum;
	private JButton btnyear;
	private JButton btngenre;
	private JButton btncreateplaylist;
	private JButton btncreatecategory;
	private JButton btnaddtoplaylist;
	private JButton btndeletefromplaylist;
	private JButton btnsearchedit;
	private JButton btnapplyfilter;
	private JButton btnaddall;
	private JButton btneditsort;
	private JButton btnplaylistdelete;
	
	//JRadioButton
	private JRadioButton rdbtnartist;
	private JRadioButton rdbtntitle;
	private JRadioButton rdbtnalbum;
	private JRadioButton rdbtnyear;
	private JRadioButton rdbtngenre;
	private JRadioButton rdbtnAufsteigend;
	private JRadioButton rdbtnAbsteigend;
	
	//JTextField
	private JTextField textFieldname;
	private JTextField textFieldartist;
	private JTextField textFieldalbum;
	private JTextField textFielddate;
	private JTextField textFieldgenre;
	private JTextField textFieldsearch;
	private JTextField textFieldplaylistname;
	private JTextField textallsearch;
	private JTextField textFieldfile;
	
	//JList
	@SuppressWarnings("rawtypes")
	private JList listsongs;
	@SuppressWarnings("rawtypes")
	private JList listall;
	@SuppressWarnings("rawtypes")
	private JList listdelete;
	@SuppressWarnings("rawtypes")
	private JList listplaylist;
	
	//JScrollPane
	private JScrollPane songsScrollPane;
	private JScrollPane allScrollPane;
	private JScrollPane playlistScrollPane;
	private JScrollPane deleteScrollPane;
	
	//JComboBox
	private JComboBox<String> comboBoxplaylist;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxeditplaylist;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxplaylistdelete;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxfilter2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxfilter1;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GUI() {
	
		TitelDB.erzeuge_TitelDB();
		TitelDB.initDB();
		
		/**
		* Inhalt Benutzermodus.
		*/	
		
		setTitle("Benutzermodus");
		setResizable(false);
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*Wenn Benutzermodus geschlossen wird
		 * -> Datenbank wird gespeichert
		 */
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    
		    public void windowClosing(java.awt.event.WindowEvent e) {
		    	try {
				TitelDB.saveDB();  //Speichert die Datenbank ab
			} catch (IOException e1) {}
		        e.getWindow().dispose();  // schlie??t den Benutzermodus
		    }
		});
		
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
		
		mntmdelete = new JMenuItem("L??schen");
		mnplaylisteditor.add(mntmdelete);
		
		mntmbeenden = new JMenuItem("Beenden");
		mndatei.add(mntmbeenden);
		mntmbeenden.addActionListener(e-> {
			try {
				TitelDB.saveDB();
			} catch (IOException e1) {}
			System.exit(0);
			});
		
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
		
		/*Logik Implementierung Benutzeroberfl??sche
		 * 
		 * 
		 */
		/*ComboBox bekommt alle PlaylistNamen ??bergeben
		 * 
		 */
			
			comboBoxplaylist = new JComboBox<String>(Playlist.get_all_plname_string());
			comboBoxplaylist.setBackground(SystemColor.window);
			comboBoxplaylist.setBounds(10, 143, 414, 20);
			getContentPane().add(comboBoxplaylist);
			
				/*ComboBox ??bergibt Playlist und Titel and Label
				 * 
				 */
			
				comboBoxplaylist.addActionListener(e-> {
					
					if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track() == null) {}
					else {
						lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
						Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();
					}
			    	
			    });
	
						/*ActionListener Benutzeroberfl??sche
						 * 
						 * 
						 */
						
						/*Playbutton bekommt aktuellen Track.player ??bergeben
						 * + speichert diesen in der Hilfsvariable previos_track von Playlist ab um bei Playlist wechsel diesen stoppen zu k??nnen.
						 * 
						 */
						btnplay.addActionListener(e-> { if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {
							
							}else {			
								if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track() == null) {}
								else {
	
									Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.play();
	
								}
									Playlist.set_previos_track((String)comboBoxplaylist.getSelectedItem());
								}
						});


		
							/*Pausebutton wird player.pause() 
							 * 
							 */
							btnpause.addActionListener(e->{	if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {
		
							}else {
							
								if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track() == null) {}
								else {		Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.pause();			}
		
							}});
		
		

								btnstop.addActionListener(e-> {if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {
		
								}else {	
		
									if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track() == null) {}
									else {	Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();		}
									}	
								});
		
					
									/*N??chster Titel Track 
									 * stopt laufenden Track 
									 * l??dt n??chsten Track
									 * repaint() damit neuer Titelname angezeigt wird
									 */
										btnfoward.addActionListener(e-> { if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {}
										else {
											if(Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track() == null) {}
											else {Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track().player.stop(); 
											Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).next_track();	
											lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());}												
										}});
												
											/*letzter Titel Track 
											 * stopt laufenden Track 
											 * l??dt letzten Track
											 * repaint() damit neuer Titelname angezeigt wird
											 */
												btnback.addActionListener(e-> {if(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()) == null) {}
												else {					
													if(Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track() == null) {}
													else {
														Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).get_current_track().player.stop(); 
														Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).previos_track();
														lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());		
													}
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
														else{
	
	
	
															if(Playlist.get_current_playlist(Playlist.get_previos_track()) == null  ){       }
															else {
	
															if(Playlist.get_current_playlist(Playlist.get_previos_track()).get_current_track() == null) {}
															else {		Playlist.get_current_playlist(Playlist.get_previos_track()).get_current_track().player.stop();										}
	
															Playlist.get_current_playlist(Playlist.get_previos_track()).set_current_titel_zero();
															}
															}
														});
			
		/*Benutzermodus Logik Ende
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
		mntmbenutzer.addActionListener(e -> {
				verwaltung.setVisible(false); 
				setVisible(true);
			});
		
		lbladd = new JLabel("Hinzuf\u00FCgen");
		lbladd.setBounds(10, 11, 90, 14);
		verwaltung.getContentPane().add(lbladd);
		
		lbldelete = new JLabel("Entfernen");
		lbldelete.setBounds(10, 246, 57, 14);
		verwaltung.getContentPane().add(lbldelete);
		
		paneladd = new JPanel();
		paneladd.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		paneladd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paneladd.setBounds(10, 29, 367, 206);
		verwaltung.getContentPane().add(paneladd);
		paneladd.setLayout(null);
		
		lblname = new JLabel("Titel:");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblname.setBounds(10, 23, 46, 14);
		paneladd.add(lblname);
		
		lblartist = new JLabel("Interpret:");
		lblartist.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblartist.setBounds(10, 54, 59, 14);
		paneladd.add(lblartist);
		
		lblalbum = new JLabel("Album:");
		lblalbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblalbum.setBounds(10, 85, 46, 14);
		paneladd.add(lblalbum);
		
		lbldate = new JLabel("Erscheinungsjahr:");
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldate.setBounds(9, 115, 100, 14);
		paneladd.add(lbldate);
		
		lblgenre = new JLabel("Genre:");
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
		
		btnaddfile = new JButton("Datei ausw\u00E4hlen");
		btnaddfile.setBounds(10, 171, 99, 23);
		paneladd.add(btnaddfile);
		
		btnaddfile.addActionListener(e -> {
				// Erstellung unseres FileFilters f??r Musikdateien
		        FileFilter filter = new FileNameExtensionFilter("Musik", "wav");      
				JFileChooser chooser = new JFileChooser("");
				chooser.addChoosableFileFilter(filter); 
				chooser.setAcceptAllFileFilterUsed(false);
				int rueckgabeWert = chooser.showOpenDialog(null);
		 			if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
	        				{
	            					textFieldfile.setText(chooser.getSelectedFile().getPath());
	        				}
    				});
		
		btnaddsong = new JButton("Hinzuf\u00FCgen");
		btnaddsong.setBounds(240, 171, 117, 23);
		paneladd.add(btnaddsong);
		btnaddsong.addActionListener(e -> {
				boolean infosKomplett = true;
				String name = textFieldname.getText();
				String artist = textFieldartist.getText();
				String album = textFieldalbum.getText();
				String genre = textFieldgenre.getText();
				String path = textFieldfile.getText();
				Integer jahr = null;
				if (name.isEmpty()) {
					textFieldname.setText("Bitte Songtitel eintragen!");
					textFieldname.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e){
			            	textFieldname.setText("");
			            }
					});
					infosKomplett = false;
				}
				if (artist.isEmpty()) {
					textFieldartist.setText("Bitte Interpret eintragen!");
					textFieldartist.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e){
			            	textFieldartist.setText("");
			            }
					});
					infosKomplett = false;
				}
				if (album.isEmpty()) {
					textFieldalbum.setText("Bitte Albumtitel eintragen!");
					textFieldalbum.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e){
			            	textFieldalbum.setText("");
			            }
					});
					infosKomplett = false;
				}
				if (textFielddate.getText().isEmpty()) {
					textFielddate.setText("Bitte Erscheinungsjahr eintragen!");
					textFielddate.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e){
			            	textFielddate.setText("");
			            }
					});
					infosKomplett = false;
				}
				else {
					try {
						jahr = Integer.valueOf(textFielddate.getText());
					} catch (Exception ex) {
						textFielddate.setText("Bitte g??ltiges Erscheinungsjahr eintragen!");
						textFielddate.addMouseListener(new MouseAdapter(){
				            public void mouseClicked(MouseEvent e){
				            	textFielddate.setText("");
				            }
						});
						infosKomplett = false;
					}
				}
				if (genre.isEmpty()) {
					textFieldgenre.setText("Bitte Genre eintragen!");
					textFieldgenre.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e){
			            	textFieldgenre.setText("");
			            }
					});
					infosKomplett = false;
				}
				if (path.isEmpty()) {
					infosKomplett = false;
				}
				if (infosKomplett) {
					TitelDB.einf(new Titel(name, artist, album, jahr, genre, path));
					listsongs.setListData(TitelDB.get_titelDB_array2());
					listall.setListData(TitelDB.get_titelDB_array());
				}
			});
		
		paneldelete = new JPanel();
		paneldelete.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paneldelete.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		paneldelete.setBounds(10, 264, 367, 216);
		verwaltung.getContentPane().add(paneldelete);
		paneldelete.setLayout(null);
		
		
		listsongs = new JList();
		listsongs.setListData(TitelDB.get_titelDB_array2());
		songsScrollPane = new JScrollPane(listsongs);
		songsScrollPane.setBounds(10, 18, 347, 130);
		listsongs.setBorder(BorderFactory.createLineBorder(Color.black));
		listsongs.setBounds(10, 18, 347, 130);
		paneldelete.add(songsScrollPane);  	
		

		/*Logik Track aus Datenbank l??schen
		 * 
		 * 
		 */
		
		btndeletesong = new JButton("L\u00F6schen");
		btndeletesong.setBounds(10, 154, 111, 23);
		paneldelete.add(btndeletesong);
		btndeletesong.addActionListener(e -> {		//aus Datenbank l??schen
				if (!(listsongs.isSelectionEmpty())) {
					
					if(!(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()) == null)) {
						Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();	
						Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).set_current_titel_zero();
						Playlist.delete_titel_from_all_playlist((String)listsongs.getSelectedValue());

					}
					
					for (int i = 0; i < TitelDB.alleTitel.size(); i++) {
						if (TitelDB.alleTitel.get(i).toString().equals(((String)listsongs.getSelectedValue()))) {
							TitelDB.loesche(i);
							listsongs.setListData(TitelDB.get_titelDB_array2());
							listall.setListData(TitelDB.get_titelDB_array());
							listdelete.setListData(TitelDB.get_titelDB_array());
							if (Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()) != null) {
								listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());
							}
						}
					}
				}
			});
		
		btnsearch = new JButton("Suchen");
		btnsearch.setBounds(10, 188, 111, 23);
		paneldelete.add(btnsearch);
		btnsearch.addActionListener(e -> {
			if (textFieldsearch.getText().isEmpty()) {
				listsongs.setListData(TitelDB.get_titelDB_array2());
			}
			else {
				listsongs.setListData(TitelDB.get_suche2((String) textFieldsearch.getText()));
			}
		});
		
		textFieldsearch = new JTextField();
		textFieldsearch.setColumns(10);
		textFieldsearch.setBounds(131, 189, 226, 20);
		paneldelete.add(textFieldsearch);
		
				btntitle = new JButton("Titel");
				btntitle.setBounds(10, 5, 70, 12);
				paneldelete.add(btntitle);
				btntitle.setOpaque(false);
				btntitle.setContentAreaFilled(false);
				btntitle.addActionListener(e -> {
						TitelDB.sortiere('n');
						listsongs.setListData(TitelDB.get_titelDB_array2());
		    		});
				
				btnartist = new JButton("Interpr.");
				btnartist.setBounds(80, 5, 70, 12);
				paneldelete.add(btnartist);
				btnartist.setOpaque(false);
				btnartist.setContentAreaFilled(false);
				btnartist.addActionListener(e -> {
						TitelDB.sortiere('i');
						listsongs.setListData(TitelDB.get_titelDB_array2());
		    		});
			
				btnalbum = new JButton("Album");
				btnalbum.setBounds(149, 5, 70, 12);
				paneldelete.add(btnalbum);
				btnalbum.setOpaque(false);
				btnalbum.setContentAreaFilled(false);
				btnalbum.addActionListener(e -> {
						TitelDB.sortiere('a');
						listsongs.setListData(TitelDB.get_titelDB_array2());
		    		});
				
				btnyear = new JButton("Jahr");
				btnyear.setBounds(219, 5, 70, 12);
				paneldelete.add(btnyear);
				btnyear.setOpaque(false);
				btnyear.setContentAreaFilled(false);
				btnyear.addActionListener(e -> {
						TitelDB.sortiere('j');
						listsongs.setListData(TitelDB.get_titelDB_array2());
		    		});
				
				btngenre = new JButton("Genre");
				btngenre.setBounds(287, 5, 70, 12);
				paneldelete.add(btngenre);
				btngenre.setOpaque(false);
				btngenre.setContentAreaFilled(false);
				btngenre.addActionListener(e -> {
						TitelDB.sortiere('g');
						listsongs.setListData(TitelDB.get_titelDB_array2());
		    		});
			
		mntmverwaltung.addActionListener(e -> {
				verwaltung.setVisible(true);
				setVisible(false);
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
		
		mnplaylistwindow = new JMenu("Fenster");
		menuBar.add(mnplaylistwindow);
	
		mntmclose = new JMenuItem("Schlie\u00DFen");
		mnplaylistwindow.add(mntmclose);
		mntmclose.addActionListener(e -> {
				playlistcreate.setVisible(false);
				});
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		playlistcreate.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblplaylistname = new JLabel("Name eingeben:");
		lblplaylistname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblplaylistname.setBounds(10, 11, 99, 14);
		contentPane.add(lblplaylistname);
		
		textFieldplaylistname = new JTextField();
		textFieldplaylistname.setBounds(10, 36, 264, 20);
		contentPane.add(textFieldplaylistname);
		textFieldplaylistname.setColumns(10);
		
		btncreateplaylist = new JButton("Erstellen");
		btncreateplaylist.setBounds(10, 67, 105, 25);
		contentPane.add(btncreateplaylist);
		
		btncreatecategory = new JButton("Titel hinzuf\u00FCgen");
		btncreatecategory.setBounds(125, 67, 149, 25);
		contentPane.add(btncreatecategory);
		
		/**LOGIK Playlist hinzuf??gen
		 * 
		 */
		
		btncreateplaylist.addActionListener(e-> { 
			boolean tmp = Playlist.create_Playlist(textFieldplaylistname.getText());
			String tmp2 = textFieldplaylistname.getText();
			
			if (tmp2.isEmpty()) {			
				Playlist.delete_playlist((String) textFieldplaylistname.getText()); 
				textFieldplaylistname.setText("ERROR: Bitte Playlistname eingeben.");	
				
				}
			
			else if(tmp == true) {
			
			textFieldplaylistname.setText("Playlist wurde hinzugef??gt");
			comboBoxplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			comboBoxeditplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));	
			comboBoxplaylistdelete.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));}
			
			else {textFieldplaylistname.setText("ERROR: Playlistname bereits vergeben.");}
			
			});	
		
		textFieldplaylistname.addMouseListener(new MouseAdapter(){
            		public void mouseClicked(MouseEvent e){
            		textFieldplaylistname.setText("");
            		}
		});
		
		
		
		
		btncreatecategory.addActionListener(e -> {
				playlistedit.setVisible(true);
			});
		
		mntmcreate.addActionListener(e -> {
				playlistcreate.setVisible(true);
			});
		
		
		/**
		* Inhalt Playlist Bearbeiten.
		*/
		
		playlistedit = new JFrame();
		playlistedit.setResizable(false);
		playlistedit.setVisible(false);
		playlistedit.setTitle("Playlist - Bearbeiten");
		playlistedit.setBounds(100, 100, 622, 516);
		
		menuBaredit = new JMenuBar();
		playlistedit.setJMenuBar(menuBaredit);
		
		mnmnplaylistwindow = new JMenu("Fenster");
		menuBaredit.add(mnmnplaylistwindow);
		
		mntmclose1 = new JMenuItem("Schlie\u00DFen");
		mnmnplaylistwindow.add(mntmclose1);
		mntmclose1.addActionListener(e -> {
				playlistedit.setVisible(false);
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
		
		comboBoxeditplaylist.addActionListener(e -> {
			    
			    	listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());
			       
			    });
		
		/*JLIST: Listet alle Titel der ausgew??hlten Playlist auf.
		 * 
		 */
		
		listplaylist = new JList();
		playlistScrollPane = new JScrollPane(listplaylist);
		
		playlistScrollPane.setBounds(10, 88, 270, 140);
		listplaylist.setBorder(BorderFactory.createLineBorder(Color.black));
		listplaylist.setBounds(10, 88, 270, 140);
		contentPane.add(playlistScrollPane);  
		
		if(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()) == null) {
		
		
		}else {	listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());	
		}
		
		
		lblchooseplaylist = new JLabel("Playlist ausw\u00E4hlen:");
		lblchooseplaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblchooseplaylist.setBounds(243, 10, 121, 18);
		contentPane.add(lblchooseplaylist);
		
		/*Playlist ausw??hlen
		 * 
		 * 
		 */
		
		listall = new JList();
		
		allScrollPane = new JScrollPane(listall);
		
		allScrollPane.setBounds(326, 88, 270, 140);
		listall.setBorder(BorderFactory.createLineBorder(Color.black));
		listall.setBounds(326, 88, 270, 140);
		contentPane.add(allScrollPane);  
		
		
		/*Liste mit allen Tracks f??llen
		 * 
		 */
		listall.setListData(TitelDB.get_titelDB_array()); 
		
		
		btnaddtoplaylist = new JButton("");
		btnaddtoplaylist.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Left.png")));
		btnaddtoplaylist.setBounds(286, 108, 33, 23);
		contentPane.add(btnaddtoplaylist);
			
		btndeletefromplaylist = new JButton("");
		btndeletefromplaylist.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Right.png")));
		btndeletefromplaylist.setBounds(286, 187, 33, 23);
		contentPane.add(btndeletefromplaylist);
		
		/*L??schen / hinzuf??gen
		 * 
		 */
		
		btnaddtoplaylist.addActionListener(e-> {
			if(listall.getSelectedValue() == null) {}
			
			else if(comboBoxeditplaylist.getSelectedItem() == null) {}	
			
			else {
			Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).add_singletitel((String) listall.getSelectedValue());
			Playlist.get_current_playlist((String) comboBoxplaylist.getSelectedItem()).set_current_titel_zero();	
			listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());
			listdelete.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());
			lblsongisplaying.setText(Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player_out());
			}
		});

		//add_auswahl(ArrayList<Titel> titelliste)
		

		//l??schen

		btndeletefromplaylist.addActionListener(e-> {
			if(listplaylist.getSelectedValue() == null) {} 
			else {Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();	
			
				Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).delete_singletitel((String) listplaylist.getSelectedValue());	
				Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).set_current_titel_zero();
				listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());
				listdelete.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());
				
				
				}
			});
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 264, 586, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnsearchedit = new JButton("Manuelle Suche");
		btnsearchedit.setBounds(372, 71, 135, 23);
		panel.add(btnsearchedit);
		btnsearchedit.addActionListener(e -> {
			if (textallsearch.getText().isEmpty()) {
				listall.setListData(TitelDB.get_titelDB_array());
			}
			else {
				listall.setListData(TitelDB.get_suche((String) textallsearch.getText()));
			}
		});
		
		textallsearch = new JTextField();
		textallsearch.setBounds(322, 38, 239, 22);
		panel.add(textallsearch);
		textallsearch.setColumns(10);
		
		comboBoxfilter2 = new JComboBox();
		comboBoxfilter2.setBounds(322, 148, 117, 20);
		panel.add(comboBoxfilter2);
		
		String filterListe[] = {"Alle Songs", "Interpret", "Album", "Erscheinungsjahr", "Genre"};
		comboBoxfilter1 = new JComboBox(filterListe);
		comboBoxfilter1.setBounds(322, 120, 117, 20);
		panel.add(comboBoxfilter1);
		comboBoxfilter1.addActionListener(e -> {
			if (comboBoxfilter1.getSelectedItem().equals("Alle Songs")) {
				comboBoxfilter2.removeAllItems();
			}
			if (comboBoxfilter1.getSelectedItem().equals("Interpret")) {
				comboBoxfilter2.removeAllItems();
				for (int i = 0; i < TitelDB.interpreten.size(); i++) {
					comboBoxfilter2.addItem(TitelDB.interpreten.get(i));
				}
			}
			if (comboBoxfilter1.getSelectedItem().equals("Album")) {
				comboBoxfilter2.removeAllItems();
				for (int i = 0; i < TitelDB.alben.size(); i++) {
					comboBoxfilter2.addItem(TitelDB.alben.get(i));
				}
			}
			if (comboBoxfilter1.getSelectedItem().equals("Erscheinungsjahr")) {
				comboBoxfilter2.removeAllItems();
				for (int i = 0; i < TitelDB.jahre.size(); i++) {
					comboBoxfilter2.addItem(TitelDB.jahre.get(i));
				}
			}
			if (comboBoxfilter1.getSelectedItem().equals("Genre")) {
				comboBoxfilter2.removeAllItems();
				for (int i = 0; i < TitelDB.genres.size(); i++) {
					comboBoxfilter2.addItem(TitelDB.genres.get(i));
				}
			}
		});
		
		btnapplyfilter = new JButton("Filter anwenden");
		btnapplyfilter.setBounds(449, 119, 127, 23);
		panel.add(btnapplyfilter);
		btnapplyfilter.addActionListener(e -> {
			if (comboBoxfilter1.getSelectedItem().equals("Alle Songs")) {
				listall.setListData(TitelDB.get_titelDB_array());   
			}
			else {
				ArrayList<Titel> tmp = new ArrayList<Titel>();
				tmp = TitelDB.getListFilter((String) comboBoxfilter1.getSelectedItem(), comboBoxfilter2.getSelectedItem());
				String[] tmp2 = new String[tmp.size()];
				for (int i = 0; i < tmp.size(); i++) {
					tmp2[i] = tmp.get(i).player_out_bearbeiten();
				}
				listall.setListData(tmp2);
			}
			});
		
		btnaddall = new JButton("Alle hinzuf\u00FCgen");
		btnaddall.setBounds(449, 147, 127, 23);
		panel.add(btnaddall);
		btnaddall.addActionListener(e -> {
			if (comboBoxfilter1.getSelectedItem().equals("Alle Songs")) {
				Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).add_auswahl(TitelDB.alleTitel);
			}
			else {
			Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).add_auswahl(TitelDB.getListFilter((String) comboBoxfilter1.getSelectedItem(), comboBoxfilter2.getSelectedItem()));
			}
			listplaylist.setListData(Playlist.get_current_playlist((String) comboBoxeditplaylist.getSelectedItem()).get_all_titel_array());	
		});
		
		rdbtnartist = new JRadioButton("Nach Interpret");
		rdbtnartist.setBounds(6, 54, 109, 23);
		panel.add(rdbtnartist);
		
		rdbtntitle = new JRadioButton("Nach Titel");
		rdbtntitle.setSelected(true);
		rdbtntitle.setBounds(6, 22, 109, 23);
		panel.add(rdbtntitle);
		
		rdbtnalbum = new JRadioButton("Nach Album");
		rdbtnalbum.setBounds(6, 87, 109, 23);
		panel.add(rdbtnalbum);	
		
		rdbtnyear = new JRadioButton("Nach Jahr");
		rdbtnyear.setBounds(6, 119, 135, 23);
		panel.add(rdbtnyear);
		
		rdbtngenre = new JRadioButton("Nach Genre");
		rdbtngenre.setBounds(6, 147, 135, 23);
		panel.add(rdbtngenre);
		
		rdbtnAufsteigend = new JRadioButton("Aufsteigend");
		rdbtnAufsteigend.setSelected(true);
		rdbtnAufsteigend.setBounds(146, 67, 109, 23);
		panel.add(rdbtnAufsteigend);
		
		rdbtnAbsteigend = new JRadioButton("Absteigend");
		rdbtnAbsteigend.setBounds(146, 93, 109, 23);
		panel.add(rdbtnAbsteigend);
		
		btneditsort = new JButton("Sortieren");
		btneditsort.setBounds(147, 147, 117, 23);
		panel.add(btneditsort);
		btneditsort.addActionListener(e -> {
			if (rdbtnartist.isSelected()) {
				TitelDB.sortiere('i');
			}
			if (rdbtntitle.isSelected()) {
				TitelDB.sortiere('n');
			}
			if (rdbtnalbum.isSelected()) {
				TitelDB.sortiere('a');
			}
			if (rdbtnyear.isSelected()) {
				TitelDB.sortiere('j');
			}
			if (rdbtngenre.isSelected()) {
				TitelDB.sortiere('g');
			}
			if (rdbtnAbsteigend.isSelected()) {
				Collections.reverse(TitelDB.alleTitel);
			}
			if (comboBoxfilter1.getSelectedItem().equals("Alle Songs")) {
				listall.setListData(TitelDB.get_titelDB_array());   
			}
			else {
				ArrayList<Titel> tmp = new ArrayList<Titel>();
				tmp = TitelDB.getListFilter((String) comboBoxfilter1.getSelectedItem(), comboBoxfilter2.getSelectedItem());
				String[] tmp2 = new String[tmp.size()];
				for (int i = 0; i < tmp.size(); i++) {
					tmp2[i] = tmp.get(i).player_out_bearbeiten();
				}
				listall.setListData(tmp2);
			}
		});
		
		//Grupppierung fuer die radio buttons 
		ButtonGroup groupleft = new ButtonGroup();
		groupleft.add(rdbtnartist);
		groupleft.add(rdbtntitle);
		groupleft.add(rdbtnalbum);
		groupleft.add(rdbtnyear);
		groupleft.add(rdbtngenre);
		ButtonGroup groupright = new ButtonGroup();
		groupright.add(rdbtnAufsteigend);
		groupright.add(rdbtnAbsteigend);
		
		panel_1 = new Panel();
		panel_1.setBackground(UIManager.getColor("TextField.foreground"));
		panel_1.setBounds(289, 0, 3, 181);
		panel.add(panel_1);
		
		lblsort = new JLabel("Sotieren:");
		lblsort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblsort.setBounds(10, 246, 81, 14);
		contentPane.add(lblsort);
		
		lbleditplaylist = new JLabel("Playlist");
		lbleditplaylist.setBounds(115, 68, 46, 14);
		contentPane.add(lbleditplaylist);
		
		lbleditsongs = new JLabel("Song Bibliothek");
		lbleditsongs.setBounds(418, 68, 93, 14);
		contentPane.add(lbleditsongs);
		
		lblsearch = new JLabel("Suchen:");
		lblsearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblsearch.setBounds(304, 246, 81, 14);
		contentPane.add(lblsearch);
		mntmedit.addActionListener(e -> {
				playlistedit.setVisible(true);
			});
		
		/**
		* Inhalt Playlist L??schen.
		*/
		
		playlistdelete = new JFrame();
		playlistdelete.setResizable(false);
		playlistdelete.setVisible(false);
		playlistdelete.setTitle("Playlist - L\u00F6schen");
		playlistdelete.setBounds(100, 100, 400, 335);
		
		menuBar = new JMenuBar();
		playlistdelete.setJMenuBar(menuBar);
		
		mnwindow = new JMenu("Fenster");
		menuBar.add(mnwindow);
		
		mntmclose2 = new JMenuItem("Schlie\u00DFen");
		mnwindow.add(mntmclose2);
		mntmclose2.addActionListener(e -> {
				playlistdelete.setVisible(false);
				});
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		playlistdelete.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblplaylistdelete = new JLabel("Playlist ausw\u00E4hlen:");
		lblplaylistdelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblplaylistdelete.setBounds(123, 22, 121, 18);
		contentPane.add(lblplaylistdelete);
		
		//Alle Playlisten an Combobox ??bergeben
		
		comboBoxplaylistdelete = new JComboBox(Playlist.get_all_plname_string());
		comboBoxplaylistdelete.setBounds(54, 51, 267, 18);
		contentPane.add(comboBoxplaylistdelete);
		
		listdelete = new JList();
		deleteScrollPane = new JScrollPane(listdelete);
		
		deleteScrollPane.setBounds(10, 89, 364, 142);
		listdelete.setBorder(BorderFactory.createLineBorder(Color.black));
		listdelete.setBounds(10, 89, 364, 142);
		contentPane.add(deleteScrollPane); 
	
		btnplaylistdelete = new JButton("Playlist entfernen");
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

		/*JList bekommt Titel der aktuellen Playlist als String[] ??bergeben.
		 * + pr??ft ob es ??berhaupt Playlisten gibt
		 */

		if(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()) == null) {}
		else { listdelete.setListData(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()).get_all_titel_array());
			}

		comboBoxplaylistdelete.addActionListener(e -> {
		    	listdelete.setListData(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()).get_all_titel_array());
		       
		    });


		/*Button bekommt l??schen aufforderung von ausgew??hler Playlist
		 * + ??berpr??ft ob es ??berhaupt Playlisten gibt
		 * 
		 */
	 
			btnplaylistdelete.addActionListener(e -> {
			Playlist.get_current_playlist((String)comboBoxplaylist.getSelectedItem()).get_current_track().player.stop();
			Playlist.delete_playlist((String) comboBoxplaylistdelete.getSelectedItem()); 
			comboBoxplaylistdelete.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			
			if(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()) == null) {
				DefaultListModel model = new DefaultListModel();
				model.clear();
				listdelete.setModel(model);
				}
			else {
				
				listdelete.setListData(Playlist.get_current_playlist((String) comboBoxplaylistdelete.getSelectedItem()).get_all_titel_array());
				
			}	
			comboBoxplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			comboBoxeditplaylist.setModel(new DefaultComboBoxModel(Playlist.get_all_plname_string()));
			});
			
		mntmdelete.addActionListener(e -> {
				
				playlistdelete.setVisible(true);
		});
	}
}
