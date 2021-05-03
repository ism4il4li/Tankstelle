package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLiteConnection {

	Connection conn = null;
	public static Connection dbConnector() {
		
		try {
			String jdbcPath = "jdbc:sqlite:Tankstelle.db";
			Connection conn = DriverManager.getConnection(jdbcPath);
			//JOptionPane.showMessageDialog(null, "Verbindung erfolgreich");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
	}


}