import Database.CreateDB;

public class Main {

	public static void main(String[] args) {
		//Kasse_Bildschirm ks = new Kasse_Bildschirm();
		//ks.setVisible(true);
		CreateDB db = new CreateDB();
		db.create();
		Login_Kasse login = new Login_Kasse();
		login.setVisible(true);
		//MyFrame myFrame = new MyFrame();
		//myFrame.setVisible(true);

	}

}
