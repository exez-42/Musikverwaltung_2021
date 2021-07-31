package musikverwaltung;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblwiedergabe = new JLabel("Aktuelle Wiedergabe:");
		lblwiedergabe.setBounds(10, 26, 414, 14);
		getContentPane().add(lblwiedergabe);
		
		JLabel lblsongplaying = new JLabel("Liste - Playlist - Song");
		lblsongplaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblsongplaying.setBounds(10, 51, 414, 14);
		getContentPane().add(lblsongplaying);
		
		JButton btnback = new JButton("");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnback.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Back.png")));
		btnback.setBounds(120, 76, 30, 25);
		getContentPane().add(btnback);
		
		JButton btnplay = new JButton("");
		btnplay.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Play.png")));
		btnplay.setBounds(160, 76, 30, 25);
		getContentPane().add(btnplay);
		
		JButton btnpause = new JButton("");
		btnpause.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Pause.png")));
		btnpause.setBounds(200, 76, 30, 25);
		getContentPane().add(btnpause);
		
		JButton btnfoward = new JButton("");
		btnfoward.setIcon(new ImageIcon(GUI.class.getResource("/Resources/Forward.png")));
		btnfoward.setBounds(240, 76, 30, 25);
		getContentPane().add(btnfoward);
		
		JComboBox<String> comboBoxplaylist = new JComboBox<String>();
		comboBoxplaylist.setBackground(SystemColor.window);
		comboBoxplaylist.setBounds(10, 143, 414, 20);
		getContentPane().add(comboBoxplaylist);
		
		JLabel lblAktuellePlaylist = new JLabel("Aktuelle Playlist");
		lblAktuellePlaylist.setBounds(10, 119, 414, 14);
		contentPane.add(lblAktuellePlaylist);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
