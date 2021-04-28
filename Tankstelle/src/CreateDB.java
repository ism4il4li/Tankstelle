import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
	
	
	
	public  void create() {
		try {
			String jdbcPath = "jdbc:sqlite:Tankstelle.db";
			Connection connection = DriverManager.getConnection(jdbcPath);
			//----------------------------------------------------------
			String createTableKunden = 
					"CREATE TABLE IF NOT EXISTS Kunden ("
					+ "	id integer PRIMARY KEY,"
					+ "	Vorname text NOT NULL,"
					+ "	Nachname text NOT NULL,"
					+ "	Strasse text NOT NULL,"
					+ "	Hausnummer text NOT NULL,"
					+ "	PLZ text NOT NULL,"
					+ "	Ort text NOT NULL,"
					
					+ "Telefon Text )";
				
					
			PreparedStatement pstmt1 = connection.prepareStatement(createTableKunden) ;
			pstmt1.executeUpdate();
		
			//----------------------------------------------------------
			//----------------------------------------------------------
			String createTableBesitzer = 
					"CREATE TABLE IF NOT EXISTS Besitzer ("
					+ "	id integer PRIMARY KEY,"
					+ "	Vorname text NOT NULL,"
					+ "	Nachname text NOT NULL,"
					+ "	Strasse text NOT NULL,"
					+ "	Hausnummer text NOT NULL,"
					+ "	PLZ text NOT NULL,"
					+ "	Ort text NOT NULL,"
					+ "Telefon Text NOT NULL)";
				
					
			PreparedStatement pstmt2 = connection.prepareStatement(createTableBesitzer) ;
			pstmt2.executeUpdate();
		
			//----------------------------------------------------------
			//----------------------------------------------------------
			String createTableMitarbeiter = 
					"CREATE TABLE IF NOT EXISTS Mitarbeiter ("
					+ "	id integer PRIMARY KEY,"
					+ "	Vorname text NOT NULL,"
					+ "	Nachname text NOT NULL,"
					+ "	Strasse text NOT NULL,"
					+ "	Hausnummer text NOT NULL,"
					+ "	PLZ text NOT NULL,"
					+ "	Ort text NOT NULL,"
					+ "Telefon Text NOT NULL)";
				
					
			PreparedStatement pstmt3 = connection.prepareStatement(createTableMitarbeiter) ;
			pstmt3.executeUpdate();
		
			//----------------------------------------------------------
			//----------------------------------------------------------
			String createTableKraftstoff = 
					"CREATE TABLE IF NOT EXISTS Kraftstoff ("
					+ "	Name text NOT NULL,"
					+ "	PreisProLiter float NOT NULL,"
					+ "	verfuegbar int NOT NULL)";
				
				
					
			PreparedStatement pstmt4 = connection.prepareStatement(createTableKraftstoff) ;
			pstmt4.executeUpdate();
		
			//----------------------------------------------------------
			//----------------------------------------------------------
			String createTableAnhaenger = 
					"CREATE TABLE IF NOT EXISTS Anhaenger ("
					+ "	Schildnummer text NOT NULL,"
					+ "	PreisProStunde int NOT NULL,"
					+ "	PreisProTag int NOT NULL,"
					+ "	reserviert int NOT NULL)";// boolean gibt nicht statt desen 0 und 1
				
				
					
			PreparedStatement pstmt5 = connection.prepareStatement(createTableAnhaenger) ;
			pstmt5.executeUpdate();
		
			//----------------------------------------------------------
			
		}catch(SQLException e){
			System.out.println("VerbindungsFehler");
			e.printStackTrace();
		}
		
	}

}
