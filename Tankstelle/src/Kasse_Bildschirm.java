
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Produkte.Produkt;


import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Kasse_Bildschirm extends JFrame {

	private JPanel contentPane;

	DefaultTableModel dm;
	String[] colomnName = {"Artikel", "Preis", "Menge", "Mwst"};
	ArrayList<Object[][]> data ;
	private  JTable table;
	

	
	LinkedList<Produkt> warenkorb = new LinkedList<>();
	private float summe=0.0f;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kasse_Bildschirm frame = new Kasse_Bildschirm();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	
	public int countShoppingCart( String produktName ) {
		int cnt = 0;
		
		for( int i = 0; i < this.warenkorb.size(); i++) {
			Produkt produkt = this.warenkorb.get(i);
			if(produkt.getName().equalsIgnoreCase(produktName)) {
				cnt++;
			}	
		};		
		return cnt;
	
	}

	/**
	 * Create the frame.
	 */
	Connection connection = null;
	private JTextField textSumme;
	DecimalFormat df = new DecimalFormat("#.##");
	Produkt produkt;
	public Kasse_Bildschirm() {
		
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		connection = SQLiteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 664, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(293, 11, 361, 343);
		panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		//-----------------------------------------------------------------------------------------------------------------
		//						Tabakwaren
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Tabakwaren = new JPanel();
		layeredPane.add(panel_Tabakwaren, "name_994428879585100");
		panel_Tabakwaren.setLayout(null);
		createColumn();
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTabak2 = new JButton("tabak2");
		
		btnTabak2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				///-------------------------------------------------------
				produkt = new Produkt("tabak2",5.5f,50,19);
				addToWarenkorb();
	
				///-----------------------------------------------------
				
				
				}
		});
		btnTabak2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak2.setBounds(182, 92, 89, 23);
		panel_Tabakwaren.add(btnTabak2);


		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTabak1 = new JButton("tabak1");
		btnTabak1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				///----------------------------------------------------------------------
				produkt = new Produkt("tabak1",4.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------------------------

				}
		});
		btnTabak1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak1.setBounds(182, 126, 89, 23);
		panel_Tabakwaren.add(btnTabak1);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTabak4 = new JButton("tabak4");
		btnTabak4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("tabak4",6f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		btnTabak4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak4.setBounds(182, 11, 89, 23);
		panel_Tabakwaren.add(btnTabak4);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTabak3 = new JButton("tabak3");
		btnTabak3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("tabak3",5,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		

		btnTabak3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak3.setBounds(182, 45, 89, 23);
		panel_Tabakwaren.add(btnTabak3);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnBlaettchen = new JButton("Bl\u00E4ttchen");
		btnBlaettchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Blätchen",0.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		

		btnBlaettchen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBlaettchen.setBounds(10, 126, 136, 23);
		panel_Tabakwaren.add(btnBlaettchen);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("filter",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnFilter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFilter.setBounds(10, 92, 136, 23);
		panel_Tabakwaren.add(btnFilter);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZigaretten1 = new JButton("Zigaretten1");
		btnZigaretten1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zigaretten1",5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZigaretten1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZigaretten1.setBounds(10, 11, 136, 23);
		panel_Tabakwaren.add(btnZigaretten1);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZigaretten2 = new JButton("Zigaretten2");
		btnZigaretten2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zigaretten2",6f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZigaretten2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZigaretten2.setBounds(10, 45, 136, 23);
		panel_Tabakwaren.add(btnZigaretten2);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnFeuerzeug = new JButton("Feuerzeug");
		btnFeuerzeug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Feuerzeug",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnFeuerzeug.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFeuerzeug.setBounds(10, 160, 136, 23);
		panel_Tabakwaren.add(btnFeuerzeug);
		//-----------------------------------------------------------------------------------------------------------------
		//							Zeitung und Zeitschriften
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Zeitung = new JPanel();
		layeredPane.add(panel_Zeitung, "name_997132808565800");
		panel_Zeitung.setLayout(null);
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung1 = new JButton("Zeitung1");
		btnZeitung1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitung1",2.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitung1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung1.setBounds(10, 11, 113, 23);
		panel_Zeitung.add(btnZeitung1);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung2 = new JButton("Zeitung2");
		btnZeitung2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zeitung2",3.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitung2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung2.setBounds(10, 45, 113, 23);
		panel_Zeitung.add(btnZeitung2);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung3 = new JButton("Zeitung3");
		btnZeitung3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zeitung3",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitung3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung3.setBounds(10, 79, 113, 23);
		panel_Zeitung.add(btnZeitung3);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitschrift1 = new JButton("Zeitschrift1");
		btnZeitschrift1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitschrift1",3f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitschrift1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift1.setBounds(151, 11, 139, 23);
		panel_Zeitung.add(btnZeitschrift1);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung4 = new JButton("Zeitung4");
		btnZeitung4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zeitung4",4f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitung4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung4.setBounds(10, 121, 113, 23);
		panel_Zeitung.add(btnZeitung4);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung5 = new JButton("Zeitung5");
		btnZeitung5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zeitung5",5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitung5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung5.setBounds(10, 162, 113, 23);
		panel_Zeitung.add(btnZeitung5);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung6 = new JButton("Zeitung6");
		btnZeitung6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("zeitung6",4.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitung6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung6.setBounds(10, 201, 113, 23);
		panel_Zeitung.add(btnZeitung6);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitschrift2 = new JButton("Zeitschrift2");
		btnZeitschrift2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitschrift2",4f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitschrift2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift2.setBounds(151, 45, 139, 23);
		panel_Zeitung.add(btnZeitschrift2);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitschrift3 = new JButton("Zeitschrift3");
		btnZeitschrift3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitschrift3",5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitschrift3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift3.setBounds(151, 79, 139, 23);
		panel_Zeitung.add(btnZeitschrift3);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitschrift4 = new JButton("Zeitschrift4");
		btnZeitschrift4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitschrift4",4.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitschrift4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift4.setBounds(151, 121, 139, 23);
		panel_Zeitung.add(btnZeitschrift4);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitschrift5 = new JButton("Zeitschrift5");
		btnZeitschrift5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitschrift5",3.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitschrift5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift5.setBounds(151, 165, 139, 23);
		panel_Zeitung.add(btnZeitschrift5);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitschrift6 = new JButton("Zeitschrift6");
		btnZeitschrift6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zeitschrift6",4.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZeitschrift6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift6.setBounds(151, 201, 139, 23);
		panel_Zeitung.add(btnZeitschrift6);
		//-----------------------------------------------------------------------------------------------------------------
		//						Handy-Karten
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Handy = new JPanel();
		layeredPane.add(panel_Handy, "name_997776136678800");
		panel_Handy.setLayout(null);
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHandy_Anbieter1 = new JButton("Anbieter1");
		btnHandy_Anbieter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Anbieter1",20f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnHandy_Anbieter1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter1.setBounds(10, 11, 122, 23);
		panel_Handy.add(btnHandy_Anbieter1);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHandy_Anbieter2 = new JButton("Anbieter2");
		btnHandy_Anbieter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Anbieter2",25f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnHandy_Anbieter2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter2.setBounds(10, 45, 122, 23);
		panel_Handy.add(btnHandy_Anbieter2);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHandy_Anbieter3 = new JButton("Anbieter3");
		btnHandy_Anbieter3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Anbieter3",15f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnHandy_Anbieter3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter3.setBounds(10, 79, 122, 23);
		panel_Handy.add(btnHandy_Anbieter3);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHandy_Anbieter4 = new JButton("Anbieter4");
		btnHandy_Anbieter4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Anbieter4",10f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnHandy_Anbieter4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter4.setBounds(10, 113, 122, 23);
		panel_Handy.add(btnHandy_Anbieter4);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHandy_Anbieter5 = new JButton("Anbieter5");
		btnHandy_Anbieter5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Anbieter5",30f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnHandy_Anbieter5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter5.setBounds(10, 147, 122, 23);
		panel_Handy.add(btnHandy_Anbieter5);
		//-----------------------------------------------------------------------------------------------------------------
		//							Getränke
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Getraenke = new JPanel();
		layeredPane.add(panel_Getraenke, "name_998221367652500");
		panel_Getraenke.setLayout(null);
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnCola = new JButton("Cola");
		btnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Cola",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnCola.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCola.setBounds(10, 11, 89, 23);
		panel_Getraenke.add(btnCola);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnWasser = new JButton("Wasser");
		btnWasser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Wasser",1.2f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnWasser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnWasser.setBounds(10, 50, 89, 23);
		panel_Getraenke.add(btnWasser);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnSaft = new JButton("Saft");
		btnSaft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Saft",1.9f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnSaft.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSaft.setBounds(10, 95, 89, 23);
		panel_Getraenke.add(btnSaft);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnBier = new JButton("Bier");
		btnBier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Bier",2.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnBier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBier.setBounds(10, 142, 89, 23);
		panel_Getraenke.add(btnBier);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnKaffee = new JButton("Kaffee");
		btnKaffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Kaffee",2f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnKaffee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKaffee.setBounds(10, 191, 89, 23);
		panel_Getraenke.add(btnKaffee);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnIce_Kaffee = new JButton("Ice-Kaffee");
		btnIce_Kaffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Ice-Kaffee",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnIce_Kaffee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnIce_Kaffee.setBounds(10, 239, 130, 23);
		panel_Getraenke.add(btnIce_Kaffee);
		//-----------------------------------------------------------------------------------------------------------------
		//								Nahrung
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Nahrung = new JPanel();
		layeredPane.add(panel_Nahrung, "name_999416457752700");
		panel_Nahrung.setLayout(null);
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnBroetchen = new JButton("Br\u00F6tchen");
		btnBroetchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Brötchen",2f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnBroetchen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBroetchen.setBounds(10, 11, 123, 23);
		panel_Nahrung.add(btnBroetchen);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHamburger = new JButton("Hamburger");
		btnHamburger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Hamburger",3.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnHamburger.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHamburger.setBounds(10, 45, 123, 23);
		panel_Nahrung.add(btnHamburger);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnNutella = new JButton("nutella");
		btnNutella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("nutella",3.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnNutella.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNutella.setBounds(10, 82, 123, 23);
		panel_Nahrung.add(btnNutella);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnMarmelade = new JButton("Marmelade");
		btnMarmelade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Marmelade",2.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnMarmelade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMarmelade.setBounds(10, 116, 123, 23);
		panel_Nahrung.add(btnMarmelade);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnMilch = new JButton("Milch");
		btnMilch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Milch",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnMilch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMilch.setBounds(10, 150, 123, 23);
		panel_Nahrung.add(btnMilch);
		//-----------------------------------------------------------------------------------------------------------------
		//									Anderes
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Anderes = new JPanel();
		layeredPane.add(panel_Anderes, "name_999941952812000");
		panel_Anderes.setLayout(null);
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnShampoo = new JButton("Shampoo");
		btnShampoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Shampoo",2.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnShampoo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShampoo.setBounds(10, 46, 118, 23);
		panel_Anderes.add(btnShampoo);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnDuschgel = new JButton("Duschgel");
		btnDuschgel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Duschgel",2.6f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnDuschgel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDuschgel.setBounds(10, 80, 118, 23);
		panel_Anderes.add(btnDuschgel);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnKlopapier = new JButton("Klopapier");
		btnKlopapier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Klopapiere",3.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnKlopapier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKlopapier.setBounds(10, 114, 118, 23);
		panel_Anderes.add(btnKlopapier);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnBinden = new JButton("Binden");
		btnBinden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				 produkt = new Produkt("Binden",4f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnBinden.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBinden.setBounds(10, 148, 118, 23);
		panel_Anderes.add(btnBinden);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTampon = new JButton("Tampon");
		btnTampon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Tampon",3f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnTampon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTampon.setBounds(10, 182, 118, 23);
		panel_Anderes.add(btnTampon);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZahnbuerste = new JButton("Zahnb\u00FCrste");
		btnZahnbuerste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Zahnbürste",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnZahnbuerste.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZahnbuerste.setBounds(10, 12, 118, 23);
		panel_Anderes.add(btnZahnbuerste);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnMotoroel = new JButton("Motor\u00F6l");
		btnMotoroel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Motoröl",18f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnMotoroel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMotoroel.setBounds(10, 221, 118, 23);
		panel_Anderes.add(btnMotoroel);
		//-----------------------------------------------------------------------------------------------------------------
		//							Treibstoff
		//-----------------------------------------------------------------------------------------------------------------
		JPanel panel_Treibstoff = new JPanel();
		layeredPane.add(panel_Treibstoff, "name_1000678102375400");
		panel_Treibstoff.setLayout(null);
		//-----------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnLKW_Diesel = new JButton("LKW Diesel");
		btnLKW_Diesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("LKW Diesel",1.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnLKW_Diesel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLKW_Diesel.setBounds(10, 11, 126, 23);
		panel_Treibstoff.add(btnLKW_Diesel);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnDiesel = new JButton("Diesel");
		btnDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Diesel",1.6f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnDiesel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDiesel.setBounds(10, 45, 126, 23);
		panel_Treibstoff.add(btnDiesel);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnSuperE10 = new JButton("Super E10");
		btnSuperE10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Super E10",1.55f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnSuperE10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuperE10.setBounds(10, 79, 126, 23);
		panel_Treibstoff.add(btnSuperE10);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnSuper = new JButton("Super");
		btnSuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Super 95",1.6f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnSuper.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuper.setBounds(10, 113, 126, 23);
		panel_Treibstoff.add(btnSuper);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnSuper_Plus = new JButton("Super Plus");
		btnSuper_Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Super Plus",1.7f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnSuper_Plus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuper_Plus.setBounds(10, 147, 126, 23);
		panel_Treibstoff.add(btnSuper_Plus);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnAdBlue = new JButton("AdBlue");
		btnAdBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("AdBlue",0.5f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnAdBlue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdBlue.setBounds(10, 181, 126, 23);
		panel_Treibstoff.add(btnAdBlue);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnAuto_Gas = new JButton("Auto Gas");
		btnAuto_Gas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Auto Gas",1.1f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnAuto_Gas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAuto_Gas.setBounds(10, 215, 126, 23);
		panel_Treibstoff.add(btnAuto_Gas);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnErdgas = new JButton("Erdgas");
		btnErdgas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///-----------------------------------------------------
				produkt = new Produkt("Erdgas",1.2f,50,19);
				addToWarenkorb();
				///-----------------------------------------------------
			}
		});
		
		
		btnErdgas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnErdgas.setBounds(10, 249, 126, 23);
		panel_Treibstoff.add(btnErdgas);
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnBezahlen = new JButton("Bezahlen");
		btnBezahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(warenkorb.getLast().getName()+" | "+ warenkorb.getLast().getMenge()+" | "+ warenkorb.getLast().getPreis());
				String filePath ="Rechnung.txt";
				File file = new File(filePath);
				try {
					dm = (DefaultTableModel) table.getModel();
					String artikel,preis,menge,mwst;
					if(dm.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"Warenkorb ist leer!");
					}else {
						for(int i=0;i<dm.getRowCount();i++) {
							artikel=dm.getValueAt(i, 0).toString();
							preis= dm.getValueAt(i, 1).toString();
							menge= dm.getValueAt(i, 2).toString();
							mwst= dm.getValueAt(i, 3).toString();
							String query="insert into Kasse(Name,Preis,Menge,Mwst) values(?,?,?,?)";
							try {
								PreparedStatement pst = connection.prepareStatement(query);
								pst.setString(1, artikel);
								pst.setString(2, preis);
								pst.setString(3, menge);
								pst.setString(4, mwst);
								pst.execute();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
					///----------------------------->>>>>>>>>>>>>>>>>>>TextDatei schreiben
					FileWriter fileWriter = new FileWriter(file);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					//BufferedReader bufferedReader = new BufferedReader(new InputstreamReader(System.in));
					bufferedWriter.newLine();
					String myString1 ="Willkommen zu eurer Tankstelle";
					bufferedWriter.write(myString1);
					bufferedWriter.newLine();bufferedWriter.newLine();
					
					
					String myString2 ="   Artikel     PreisProArtikel        Menge             Mwst";
					
					bufferedWriter.write(myString2);
					
					bufferedWriter.write("\n___________________________________________________________________\n");
					for(int i=0;i<table.getRowCount();i++) {
						for(int j=0; j<table.getColumnCount();j++) {
							
							bufferedWriter.write("  "+table.getValueAt(i, j).toString()+"    ");
							for(int y=0;table.getValueAt(i, j).toString().length()+y<13;y++){
							
									bufferedWriter.write(" ");
									
								}
						}
						bufferedWriter.write("\n___________________________________________________________________\n");
						bufferedWriter.newLine();
						
					}
					bufferedWriter.write("Summe: "+String.format("%.02f", summe)+" €");
					bufferedWriter.newLine();
					bufferedWriter.write("Gute fahrt wünschen wir euch");
					bufferedWriter.close();
					fileWriter.close();
					JOptionPane.showMessageDialog(null, "erfolgreich gesendet");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnBezahlen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBezahlen.setBounds(461, 376, 112, 33);
		panel.add(btnBezahlen);
		//-----------------------------------------------------------------------------------------------------------------
		//						TabakWaren Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTabakwaren = new JButton("Tabakwaren");
		btnTabakwaren.setBounds(10, 225, 139, 23);
		panel.add(btnTabakwaren);
		btnTabakwaren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_Tabakwaren);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnTabakwaren.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//						Getränke Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnGetraenke = new JButton("Getr\u00E4nke");
		btnGetraenke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(panel_Getraenke);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnGetraenke.setBounds(10, 354, 111, 23);
		panel.add(btnGetraenke);
		btnGetraenke.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//							Zeitung und Zeitschriften Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnZeitung = new JButton("Zeitung");
		btnZeitung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_Zeitung);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnZeitung.setBounds(10, 252, 107, 23);
		panel.add(btnZeitung);
		btnZeitung.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//						Nahrung Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnNahrung = new JButton("Nahrung");
		btnNahrung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(panel_Nahrung);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNahrung.setBounds(143, 252, 106, 23);
		panel.add(btnNahrung);
		btnNahrung.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//							Treibstoff Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnTreibstoff = new JButton("Treibstoff");
		btnTreibstoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(panel_Treibstoff);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnTreibstoff.setBounds(160, 320, 123, 23);
		panel.add(btnTreibstoff);
		btnTreibstoff.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//						Handy-Karten Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnHandyGuthaben = new JButton("Handy Guthaben");
		btnHandyGuthaben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_Handy);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnHandyGuthaben.setBounds(10, 286, 165, 23);
		panel.add(btnHandyGuthaben);
		btnHandyGuthaben.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//					Anderes Button
		//-----------------------------------------------------------------------------------------------------------------
		JButton btnAnderes = new JButton("Anderes");
		btnAnderes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(panel_Anderes);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnAnderes.setBounds(10, 320, 123, 23);
		panel.add(btnAnderes);
		btnAnderes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//-----------------------------------------------------------------------------------------------------------------
		//				Summe
		//-----------------------------------------------------------------------------------------------------------------
		
		JLabel lblSumme = new JLabel("Summe :");
		lblSumme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSumme.setBounds(247, 377, 71, 31);
		panel.add(lblSumme);
		
		textSumme = new JTextField();
		textSumme.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textSumme.setBounds(328, 376, 123, 33);
		panel.add(textSumme);
		textSumme.setColumns(10);
		
		
		//JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 268, 211);
		panel.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		/*
		String[] colomnName = {"Artikel", "Preis", "Menge", "Mwst"};
		Object[][] data ={{"tabak1",4.5f,11,19}};
		DefaultTableModel model = new DefaultTableModel(data,colomnName);
		table = new JTable(model);
		*/
		//scrollPane.setViewportView(table);
	}

	//-----------------------------------------------------------------------------------------------------------------
	public void updateTable() {
	String sql = "select Name,Preis from Kasse";
	try {
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		//table.setModel(DbUtils.resultSetToTableModel(rs));
		/*
		//-----------------
		int count = 0;
		while(rs.next()) {
			count++;
			
		}
		if(count==1) {
			JOptionPane.showMessageDialog(null, "login war erfolgreich");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}else if(count >1) {
			JOptionPane.showMessageDialog(null, "doppelt");
		}else {
			JOptionPane.showMessageDialog(null, "Benutzername oder Passwort falsch");
		}
		//-----------------
		*/
		
		rs.close();
		pst.close();
		
	}catch(Exception ex) {
		System.out.println(ex);
		JOptionPane.showMessageDialog(null, ex);
	}
	}
	//-----------------------------------------------------------
	
	
	//----------------------------------------------------------------------------------------------------------------
	public void insertKasseTable() {
		int mwst = 19;
		String sql = "INSERT INTO Kasse (Name,Preis,Menge,Mwst) VALUES(?,?,?,?);";
	try {
		
		PreparedStatement pst = connection.prepareStatement(sql);
		//pst.setString(1, proName);
		//pst.setString(1, proPreis);
		pst.setString(4, String.valueOf(mwst));
		pst.executeUpdate();

		pst.close();
		
	}catch(Exception ex) {
		System.out.println(ex);
		JOptionPane.showMessageDialog(null, "ein fehler ist aufgetreten");
	}
	
	}
	//-----------------------------------------------------------
	private void createColumn() {
		
		//table.setAutoCreateColumnsFromModel(false);
		//
		table.setModel(table.getModel());
		dm = (DefaultTableModel) table.getModel();
		dm.addColumn("Name");
		dm.addColumn("Preis");
		dm.addColumn("Menge");
		dm.addColumn("Mwst");
		//scrollPane.setViewportView(table);
		
		
	}
	private void addRow(String Name,float Preis,int Menge,int mwst) {
		
		dm = (DefaultTableModel) table.getModel();
		String[] arw = {Name,String.valueOf(Preis),String.valueOf(Menge),String.valueOf(mwst)};
		dm.addRow(arw);
		
	}
	//--------------------------------------------------
	private void addToWarenkorb() {
		///-------------------------------------------------------
		
		
		warenkorb.add( produkt );
		int countProdukt = countShoppingCart(produkt.getName());
		
		

        for (int i = 0; i < table.getRowCount(); i++) {
        	
            if (table.getValueAt(i, 0).equals(produkt.getName())) {
            	summe +=produkt.getPreis();
	        	textSumme.setText(String.valueOf(df.format(summe)));

            	table.setValueAt(countProdukt, i, 2);
            		
            	return;
            }
            	   
        }

        addRow(produkt.getName(),produkt.getPreis(),countProdukt,produkt.getMwst());
        summe +=produkt.getPreis();
        textSumme.setText(String.valueOf(df.format(summe)));
		///-----------------------------------------------------
	}
	//----------------------------------------------------
	private void nix() {
		System.out.println("test für gitHub");
	}
}
