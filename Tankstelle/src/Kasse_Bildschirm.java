import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Kasse_Bildschirm extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	Connection connection = null;
	private JTextField textSumme;
	private JTable table;
	public Kasse_Bildschirm() {
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
		
		JPanel panel_Tabakwaren = new JPanel();
		layeredPane.add(panel_Tabakwaren, "name_994428879585100");
		panel_Tabakwaren.setLayout(null);
		
		JButton btnTabak2 = new JButton("tabak2");
		btnTabak2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak2.setBounds(182, 92, 89, 23);
		panel_Tabakwaren.add(btnTabak2);
		
		JButton btnTabak1 = new JButton("tabak1");
		btnTabak1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak1.setBounds(182, 126, 89, 23);
		panel_Tabakwaren.add(btnTabak1);
		
		JButton btnTabak4 = new JButton("tabak4");
		btnTabak4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak4.setBounds(182, 11, 89, 23);
		panel_Tabakwaren.add(btnTabak4);
		
		JButton btnTabak3 = new JButton("tabak3");
		btnTabak3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTabak3.setBounds(182, 45, 89, 23);
		panel_Tabakwaren.add(btnTabak3);
		
		JButton btnBlttchen = new JButton("Bl\u00E4ttchen");
		btnBlttchen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBlttchen.setBounds(10, 126, 136, 23);
		panel_Tabakwaren.add(btnBlttchen);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFilter.setBounds(10, 92, 136, 23);
		panel_Tabakwaren.add(btnFilter);
		
		JButton btnZigaretten1 = new JButton("Zigaretten1");
		btnZigaretten1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});

		btnZigaretten1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZigaretten1.setBounds(10, 11, 136, 23);
		panel_Tabakwaren.add(btnZigaretten1);
		
		JButton btnZigaretten2 = new JButton("Zigaretten2");
		btnZigaretten2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZigaretten2.setBounds(10, 45, 136, 23);
		panel_Tabakwaren.add(btnZigaretten2);
		
		JButton btnFeuerzeug = new JButton("Feuerzeug");
		btnFeuerzeug.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFeuerzeug.setBounds(10, 160, 136, 23);
		panel_Tabakwaren.add(btnFeuerzeug);
		
		JPanel panel_Zeitung = new JPanel();
		layeredPane.add(panel_Zeitung, "name_997132808565800");
		panel_Zeitung.setLayout(null);
		
		JButton btnZeitung1 = new JButton("zeitungen");
		btnZeitung1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//---------------------------------------
				try {
					String query="select ProName from Produkte where ProName=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, btnZeitung1.getText());
					
					ResultSet rs = pst.executeQuery();
					/*
					//---------
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
					//---------
					*/
					rs.close();
					pst.close();
					
				}catch(Exception ex) {
					//System.out.println(ex);
					JOptionPane.showMessageDialog(null, ex);
				}
				//-----------------------------------------------------------
			}
		});
		btnZeitung1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung1.setBounds(10, 11, 113, 23);
		panel_Zeitung.add(btnZeitung1);
		
		JButton btnZeitung2 = new JButton("Zeitung2");
		btnZeitung2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung2.setBounds(10, 45, 113, 23);
		panel_Zeitung.add(btnZeitung2);
		
		JButton btnZeitung3 = new JButton("Zeitung3");
		btnZeitung3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung3.setBounds(10, 79, 113, 23);
		panel_Zeitung.add(btnZeitung3);
		
		JButton btnZeitschrift1 = new JButton("Zeitschrift1");
		btnZeitschrift1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift1.setBounds(151, 11, 139, 23);
		panel_Zeitung.add(btnZeitschrift1);
		
		JButton btnZeitung4 = new JButton("Zeitung4");
		btnZeitung4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung4.setBounds(10, 121, 113, 23);
		panel_Zeitung.add(btnZeitung4);
		
		JButton btnZeitung5 = new JButton("Zeitung5");
		btnZeitung5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung5.setBounds(10, 162, 113, 23);
		panel_Zeitung.add(btnZeitung5);
		
		JButton btnZeitung6 = new JButton("Zeitung6");
		btnZeitung6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitung6.setBounds(10, 201, 113, 23);
		panel_Zeitung.add(btnZeitung6);
		
		JButton btnZeitschrift2 = new JButton("Zeitschrift2");
		btnZeitschrift2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift2.setBounds(151, 45, 139, 23);
		panel_Zeitung.add(btnZeitschrift2);
		
		JButton btnZeitschrift3 = new JButton("Zeitschrift3");
		btnZeitschrift3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift3.setBounds(151, 79, 139, 23);
		panel_Zeitung.add(btnZeitschrift3);
		
		JButton btnZeitschrift4 = new JButton("Zeitschrift4");
		btnZeitschrift4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift4.setBounds(151, 121, 139, 23);
		panel_Zeitung.add(btnZeitschrift4);
		
		JButton btnZeitschrift5 = new JButton("Zeitschrift5");
		btnZeitschrift5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift5.setBounds(151, 165, 139, 23);
		panel_Zeitung.add(btnZeitschrift5);
		
		JButton btnZeitschrift6 = new JButton("Zeitschrift6");
		btnZeitschrift6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZeitschrift6.setBounds(151, 201, 139, 23);
		panel_Zeitung.add(btnZeitschrift6);
		
		JPanel panel_Handy = new JPanel();
		layeredPane.add(panel_Handy, "name_997776136678800");
		panel_Handy.setLayout(null);
		
		JButton btnHandy_Anbieter1 = new JButton("Anbieter1");
		btnHandy_Anbieter1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter1.setBounds(10, 11, 122, 23);
		panel_Handy.add(btnHandy_Anbieter1);
		
		JButton btnHandy_Anbieter2 = new JButton("Anbieter2");
		btnHandy_Anbieter2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter2.setBounds(10, 45, 122, 23);
		panel_Handy.add(btnHandy_Anbieter2);
		
		JButton btnHandy_Anbieter3 = new JButton("Anbieter3");
		btnHandy_Anbieter3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter3.setBounds(10, 79, 122, 23);
		panel_Handy.add(btnHandy_Anbieter3);
		
		JButton btnHandy_Anbieter4 = new JButton("Anbieter4");
		btnHandy_Anbieter4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter4.setBounds(10, 113, 122, 23);
		panel_Handy.add(btnHandy_Anbieter4);
		
		JButton btnHandy_Anbieter5 = new JButton("Anbieter5");
		btnHandy_Anbieter5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHandy_Anbieter5.setBounds(10, 147, 122, 23);
		panel_Handy.add(btnHandy_Anbieter5);
		
		JPanel panel_Getraenke = new JPanel();
		layeredPane.add(panel_Getraenke, "name_998221367652500");
		panel_Getraenke.setLayout(null);
		
		JButton btnCola = new JButton("Cola");
		btnCola.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCola.setBounds(10, 11, 89, 23);
		panel_Getraenke.add(btnCola);
		
		JButton btnWasser = new JButton("Wasser");
		btnWasser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnWasser.setBounds(10, 50, 89, 23);
		panel_Getraenke.add(btnWasser);
		
		JButton btnSaft = new JButton("Saft");
		btnSaft.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSaft.setBounds(10, 95, 89, 23);
		panel_Getraenke.add(btnSaft);
		
		JButton btnBier = new JButton("Bier");
		btnBier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBier.setBounds(10, 142, 89, 23);
		panel_Getraenke.add(btnBier);
		
		JButton btnKaffee = new JButton("Kaffee");
		btnKaffee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKaffee.setBounds(10, 191, 89, 23);
		panel_Getraenke.add(btnKaffee);
		
		JButton btnIce_Kaffee = new JButton("Ice-Kaffee");
		btnIce_Kaffee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnIce_Kaffee.setBounds(10, 239, 130, 23);
		panel_Getraenke.add(btnIce_Kaffee);
		
		JPanel panel_Nahrung = new JPanel();
		layeredPane.add(panel_Nahrung, "name_999416457752700");
		panel_Nahrung.setLayout(null);
		
		JButton btnBroetchen = new JButton("Br\u00F6tchen");
		btnBroetchen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBroetchen.setBounds(10, 11, 123, 23);
		panel_Nahrung.add(btnBroetchen);
		
		JButton btnHamburger = new JButton("Hamburger");
		btnHamburger.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHamburger.setBounds(10, 45, 123, 23);
		panel_Nahrung.add(btnHamburger);
		
		JButton btnNutella = new JButton("nutella");
		btnNutella.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNutella.setBounds(10, 82, 123, 23);
		panel_Nahrung.add(btnNutella);
		
		JButton btnMarmelade = new JButton("Marmelade");
		btnMarmelade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMarmelade.setBounds(10, 116, 123, 23);
		panel_Nahrung.add(btnMarmelade);
		
		JButton btnMilch = new JButton("Milch");
		btnMilch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMilch.setBounds(10, 150, 123, 23);
		panel_Nahrung.add(btnMilch);
		
		JPanel panel_Anderes = new JPanel();
		layeredPane.add(panel_Anderes, "name_999941952812000");
		panel_Anderes.setLayout(null);
		
		JButton btnShampoo = new JButton("Shampoo");
		btnShampoo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShampoo.setBounds(10, 46, 118, 23);
		panel_Anderes.add(btnShampoo);
		
		JButton btnDuschgel = new JButton("Duschgel");
		btnDuschgel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDuschgel.setBounds(10, 80, 118, 23);
		panel_Anderes.add(btnDuschgel);
		
		JButton btnKlopapier = new JButton("Klopapier");
		btnKlopapier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKlopapier.setBounds(10, 114, 118, 23);
		panel_Anderes.add(btnKlopapier);
		
		JButton btnBinden = new JButton("Binden");
		btnBinden.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBinden.setBounds(10, 148, 118, 23);
		panel_Anderes.add(btnBinden);
		
		JButton btnTampon = new JButton("Tampon");
		btnTampon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTampon.setBounds(10, 182, 118, 23);
		panel_Anderes.add(btnTampon);
		
		JButton btnZahnbuerste = new JButton("Zahnb\u00FCrste");
		btnZahnbuerste.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZahnbuerste.setBounds(10, 12, 118, 23);
		panel_Anderes.add(btnZahnbuerste);
		
		JButton btnMotoroel = new JButton("Motor\u00F6l");
		btnMotoroel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMotoroel.setBounds(10, 221, 118, 23);
		panel_Anderes.add(btnMotoroel);
		
		JPanel panel_Treibstoff = new JPanel();
		layeredPane.add(panel_Treibstoff, "name_1000678102375400");
		panel_Treibstoff.setLayout(null);
		
		JButton btnLKW_Diesel = new JButton("LKW Diesel");
		btnLKW_Diesel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLKW_Diesel.setBounds(10, 11, 126, 23);
		panel_Treibstoff.add(btnLKW_Diesel);
		
		JButton btnDiesel = new JButton("Diesel");
		btnDiesel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDiesel.setBounds(10, 45, 126, 23);
		panel_Treibstoff.add(btnDiesel);
		
		JButton btnSuperE10 = new JButton("Super E10");
		btnSuperE10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuperE10.setBounds(10, 79, 126, 23);
		panel_Treibstoff.add(btnSuperE10);
		
		JButton btnSuper = new JButton("Super");
		btnSuper.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuper.setBounds(10, 113, 126, 23);
		panel_Treibstoff.add(btnSuper);
		
		JButton btnSuper_Plus = new JButton("Super Plus");
		btnSuper_Plus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuper_Plus.setBounds(10, 147, 126, 23);
		panel_Treibstoff.add(btnSuper_Plus);
		
		JButton btnAdBlue = new JButton("AdBlue");
		btnAdBlue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdBlue.setBounds(10, 181, 126, 23);
		panel_Treibstoff.add(btnAdBlue);
		
		JButton btnAuto_Gas = new JButton("Auto Gas");
		btnAuto_Gas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAuto_Gas.setBounds(10, 215, 126, 23);
		panel_Treibstoff.add(btnAuto_Gas);
		
		JButton btnErdgas = new JButton("Erdgas");
		btnErdgas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnErdgas.setBounds(10, 249, 126, 23);
		panel_Treibstoff.add(btnErdgas);
		
		JButton btnBezahlen = new JButton("Bezahlen");
		btnBezahlen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBezahlen.setBounds(461, 376, 112, 33);
		panel.add(btnBezahlen);
		
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
	
		
		JLabel lblSumme = new JLabel("Summe :");
		lblSumme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSumme.setBounds(247, 377, 71, 31);
		panel.add(lblSumme);
		
		textSumme = new JTextField();
		textSumme.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textSumme.setBounds(328, 376, 123, 33);
		panel.add(textSumme);
		textSumme.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 268, 211);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	//----------------------------------------------------------------------------------------------------------------
	public void insertKasseTable() {
	String sql = "INSERT INTO Kasse (Name,Preis ,Menge,Mwst) VALUES(?,?,?,?);";
	try {
		//String query="select ProName from Produkte where ProName=? ";
		PreparedStatement pst = connection.prepareStatement(sql);
		//pst.setString(1, btnZeitung1.getText());
		
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		/*
		//---------------
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
		//---------------
		 * */
		 
		rs.close();
		pst.close();
		
	}catch(Exception ex) {
		//System.out.println(ex);
		JOptionPane.showMessageDialog(null, "ein fehler ist aufgetreten");
	}
	//-----------------------------------------------------------
	}
	//-----------------------------------------------------------------------------------------------------------------
	public void updateTable() {
	String sql = "select ProName,ProPreis from Produkte";
	try {
		//String query="select ProName from Produkte where ProName=? ";
		PreparedStatement pst = connection.prepareStatement(sql);
		//pst.setString(1, btnZeitung1.getText());
		
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
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
		rs.close();
		pst.close();
		
	}catch(Exception ex) {
		//System.out.println(ex);
		JOptionPane.showMessageDialog(null, "ein fehler ist aufgetreten");
	}
	//-----------------------------------------------------------
	}
}
