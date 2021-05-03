package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.sql.PreparedStatement;

public class Database {
/**
 * von Datenbank lesen
 */
//	static JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	
	private JPanel panel; 
	/*
	public Database( JPanel panel  ) {
		this.panel = panel;
	}
	*/
	public Database( ) {
	
	}
	
	
	public  void read() {
		try {
			String jdbcPath = "jdbc:sqlite:Tankstelle.db";
			Connection connection = DriverManager.getConnection(jdbcPath);
			String createTableKunden = 
					"CREATE TABLE IF NOT EXISTS Kunden (\r\n"
					+ "	id integer PRIMARY KEY,\r\n"
					+ "	Vorname text NOT NULL,\r\n"
					+ "	Nachname text NOT NULL,\r\n"
					+ "	Strasse text NOT NULL,\r\n"
					+ "	Hausnummer text NOT NULL,\r\n"
					+ "	PLZ text NOT NULL,\r\n"
					+ "	Ort text NOT NULL,\r\n"
				
					+ ")";
			Statement statement1 = connection.createStatement();
			ResultSet result1 = statement1.executeQuery(createTableKunden);
			String sql_read = "SELECT * FROM kunden";
			Statement statement2 = connection.createStatement();
			ResultSet result = statement2.executeQuery(sql_read);
			while(result.next()) {
				String name = result.getString("vorname");
				String nachname = result.getString("nachname");
				String email = result.getString("email");
				String password = result.getString("password");
				System.out.println(name+ " | "+ nachname+ " | " + email + " | "+ password);
				//connection.close();
			}
			
		}catch(SQLException e){
			System.out.println("VerbindungsFehler");
			e.printStackTrace();
		}
		
	}
	/**
	 * in Datenbank schreiben
	 */
	
//	static String firstname = Panel.firstnameText.getText();
//	static String e_mail =  Panel.lastnameText.getText();
	/*
		public void write() {
			if( this.panel.getVorname().length() != 0 && this.panel.getLastname().length() != 0 && this.panel.getEmail().length() != 0) {
			try {
				String jdbcUrl = "jdbc:sqlite:src\\user.db";
				Connection connection = DriverManager.getConnection(jdbcUrl);
				
				String sql_write = "INSERT INTO users(vorname,nachname,email,password) VALUES(?,?,?,?)";
				PreparedStatement pstmt = connection.prepareStatement(sql_write) ;
                pstmt.setString(1, this.panel.getFirstname());
                pstmt.setString(2, this.panel.getLastname());
                pstmt.setString(3, this.panel.getEmail());
                pstmt.setString(3, this.panel.getPassword());
                pstmt.executeUpdate();
                this.panel.setText();
                //
				//zum Prüfen
				//bei 1 ist eine Zeile hinzugefügt
				//bei 0 ist nichts hizugefügt
				//
				//int result = statement.executeUpdate(sql_write);
				//System.out.println(result);
			
			}catch(SQLException e){
				System.out.println("VerbindungsFehler");
				e.printStackTrace();
			}
			}else {
				
				 JOptionPane.showMessageDialog(this.panel,"die Felder bitte nicht leer lassen");
				
			}
		}
		*/


}