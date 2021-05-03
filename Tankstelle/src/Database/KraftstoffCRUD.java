package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import Kraftstoff.Tanklager;

public class KraftstoffCRUD {
	
	static String jdbcPath = "jdbc:sqlite:Tankstelle.db";
	static Connection connection;
	static String sql_read = "SELECT * FROM Kraftstoff";
	static String sql_update_Verfuegbar = "UPDATE Kraftstoff SET verfuegbar =? WHERE Name = ? ";
	String sql_update_Liter_Price = "UPDATE Kraftstoff SET Preis =? WHERE Name =? ";
	static Statement stmt;
	static ResultSet result;
	private static String benzinE10_verfuegbar   = "";
	private static String benzin95_verfuegbar   = "";
	private static String superPlus_verfuegbar   = "";
	private static String diesel_verfuegbar      = "";
	private static String truckDiesel_verfuegbar = "";
	private static String autogas_verfuegbar	  = "";
	
	//Tanklager tanklager = new Tanklager();
	
	//-----------------------------Konstruktor
	public KraftstoffCRUD() {
		//sql_read();
		//sql_update_Verfuegbar_BenzinE10();
		
		
		}
	//-----------------------------Konstruktor ende
	/*
	public static String getSql_update_Verfuegbar() {
		return sql_update_Verfuegbar;
	}
	public static void setSql_update_Verfuegbar(String sql_update_Verfuegbar) {
		KraftstoffCRUD.sql_update_Verfuegbar = sql_update_Verfuegbar;
	}
	public static String getBenzinE10_verfuegbar() {
		
		return benzinE10_verfuegbar;
	}
	public static void setBenzinE10_verfuegbar(String benzinE10_verfuegbar) {
		
		KraftstoffCRUD.benzinE10_verfuegbar = benzinE10_verfuegbar;
	}
	public String getBenizin95_verfuegbar() {
		return benizin95_verfuegbar;
	}
	public void setBenizin95_verfuegbar(String benizin95_verfuegbar) {
		this.benizin95_verfuegbar = benizin95_verfuegbar;
	}
	public String getSuperPlus_verfuegbar() {
		return superPlus_verfuegbar;
	}
	public void setSuperPlus_verfuegbar(String superPlus_verfuegbar) {
		this.superPlus_verfuegbar = superPlus_verfuegbar;
	}
	public String getDiesel_verfuegbar() {
		return diesel_verfuegbar;
	}
	public void setDiesel_verfuegbar(String diesel_verfuegbar) {
		this.diesel_verfuegbar = diesel_verfuegbar;
	}
	public String getTruckDiesel_verfuegbar() {
		return truckDiesel_verfuegbar;
	}
	public void setTruckDiesel_verfuegbar(String truckDiesel_verfuegbar) {
		this.truckDiesel_verfuegbar = truckDiesel_verfuegbar;
	}
	public String getAutogas_verfuegbar() {
		return autogas_verfuegbar;
	}
	public void setAutogas_verfuegbar(String autogas_verfuegbar) {
		this.autogas_verfuegbar = autogas_verfuegbar;
	}
	*/
	//-----------------------------Konstruktor ende
	//---------------------------Methode sql_read
	/*
	private  void sql_read() {
		try {//connection, stmt und result müssen in try catchblock sein wegen SQLException
			connection = DriverManager.getConnection(jdbcPath);
			stmt =connection.createStatement();
			result = stmt.executeQuery(sql_read);
			
			while(result.next()) {
				String name = result.getString("Name");
				String PreisProLiter = result.getString("PreisProLiter");
				String verfuegbar = result.getString("verfuegbar");
				
				switch(name) {
				  case "BenzinE10":
					  benzinE10_verfuegbar= verfuegbar;
				    break;
				  case "Benizin95":
					  benizin95_verfuegbar= verfuegbar;
				    break;
				  case "SuperPlus":
					  superPlus_verfuegbar= verfuegbar;
				    break;
				  case "Diesel":
					  diesel_verfuegbar= verfuegbar;
				    break;
				  case "TruckDiesel":
					  truckDiesel_verfuegbar= verfuegbar;
				    break;
				  case "Autogas":
					  autogas_verfuegbar= verfuegbar;
				    break;
		
				}
				
				System.out.println(name+ " | " + PreisProLiter + " | "+ verfuegbar);
				}
			
		}catch(SQLException e){
			System.out.println("VerbindungsFehler sql_read");
			e.printStackTrace();
			
		}
		
		finally {
			try {connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
	}
	*/
	//---------------------------Methode sql_read ende
	//---------------------------Methode sql_update_Verfuegbar
	/*
	private static void sql_update_Verfuegbar_BenzinE10() {
		try {//connection, stmt und result müssen in try catchblock sein wegen SQLException
			connection = DriverManager.getConnection(jdbcPath);
			stmt =connection.createStatement();
			PreparedStatement pstmt = connection.prepareStatement(sql_update_Verfuegbar) ;

			pstmt.setString(1,benzinE10_verfuegbar);
            pstmt.setString(2, "BenzinE10");
            pstmt.executeUpdate();

		}catch(SQLException e){
			System.out.println("VerbindungsFehler sql_update_Verfuegbar");
			e.printStackTrace();
		}finally {
			try {connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	}
	*/
	//---------------------------Methode sql_update_Verfuegbar ende
	public static void kraftstoffUpdate(String kraftstoff) {
		
		try {//connection, stmt und result müssen in try catchblock sein wegen SQLException
			
			
			connection = DriverManager.getConnection(jdbcPath);
			stmt =connection.createStatement();
			//erstmal von Datenbank lesen und Werte holen
			//###---------------------------------------
			result = stmt.executeQuery(sql_read);
			
			while(result.next()) {
				String name = result.getString("Name");
				String PreisProLiter = result.getString("PreisProLiter");
				String verfuegbar = result.getString("verfuegbar");
				
				if(name.equals("BenzinE10")) {
					 benzinE10_verfuegbar= verfuegbar;
					 //System.out.println("benzinE10_verfuegbar: "+benzinE10_verfuegbar);
				}
				else if(name.equals("Benzin95")) {
					 benzin95_verfuegbar= verfuegbar;
					 //System.out.println("benzin95_verfuegbar: "+benzin95_verfuegbar);
				}
				else if(name.equals("SuperPlus")) {
					superPlus_verfuegbar= verfuegbar;
					//System.out.println("superPlus_verfuegbar: "+superPlus_verfuegbar);
				}
				else if(name.equals("Diesel")) {
					diesel_verfuegbar= verfuegbar;
					//System.out.println("diesel_verfuegbar: "+diesel_verfuegbar);
				}
				else if(name.equals("TruckDiesel")) {
					truckDiesel_verfuegbar= verfuegbar;
					//System.out.println("truckDiesel_verfuegbar: "+truckDiesel_verfuegbar);
				}
				else if(name.equals("Autogas")) {
					autogas_verfuegbar= verfuegbar;
					//System.out.println("autogas_verfuegbar: "+autogas_verfuegbar);
				}
			}

			//###--------------------------------------
			PreparedStatement pstmt = connection.prepareStatement(sql_update_Verfuegbar) ;
			////--------------------------------------------------------------------------------
			switch(kraftstoff) {
			  case "BenzinE10":
				  	int benzinE10_verfuegbarToInt = Integer.parseInt(benzinE10_verfuegbar)-1;
				  	benzinE10_verfuegbar= Integer.toString(benzinE10_verfuegbarToInt);
					pstmt.setString(1,benzinE10_verfuegbar);
		            pstmt.setString(2, "BenzinE10");
		            pstmt.executeUpdate();

			    break;
			  case "Benzin95":
				  int benzin95_verfuegbarToInt = Integer.parseInt(benzin95_verfuegbar)-1;
				  benzin95_verfuegbar= Integer.toString(benzin95_verfuegbarToInt);
					pstmt.setString(1,benzin95_verfuegbar);
		            pstmt.setString(2, "Benzin95");
		            pstmt.executeUpdate();
				 
			    break;
			  case "SuperPlus":
				  int superPlus_verfuegbarToInt = Integer.parseInt(superPlus_verfuegbar)-1;
				  superPlus_verfuegbar= Integer.toString(superPlus_verfuegbarToInt);
					pstmt.setString(1,superPlus_verfuegbar);
		            pstmt.setString(2, "SuperPlus");
		            pstmt.executeUpdate();
				  
				
			    break;
			  case "Diesel":
				  int diesel_verfuegbarToInt = Integer.parseInt(diesel_verfuegbar)-1;
				  diesel_verfuegbar= Integer.toString(diesel_verfuegbarToInt);
					pstmt.setString(1,diesel_verfuegbar);
		            pstmt.setString(2, "Diesel");
		            pstmt.executeUpdate();
				  
			    break;
			  case "TruckDiesel":
				  int truckDiesel_verfuegbarToInt = Integer.parseInt(truckDiesel_verfuegbar)-1;
				  truckDiesel_verfuegbar= Integer.toString(truckDiesel_verfuegbarToInt);
					pstmt.setString(1,truckDiesel_verfuegbar);
		            pstmt.setString(2, "TruckDiesel");
		            pstmt.executeUpdate();
				  
			    break;
			  case "Autogas":
				  int autogas_verfuegbarToInt = Integer.parseInt(autogas_verfuegbar)-1;
				  autogas_verfuegbar= Integer.toString(autogas_verfuegbarToInt);
					pstmt.setString(1,autogas_verfuegbar);
		            pstmt.setString(2, "Autogas");
		            pstmt.executeUpdate();
				 
			    break;

			}
			////--------------------------------------------------------------------------------


		}catch(SQLException e){
			System.out.println("VerbindungsFehler sql_update_Verfuegbar");
			e.printStackTrace();
		}finally {
			try {connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}

		
	}
}
