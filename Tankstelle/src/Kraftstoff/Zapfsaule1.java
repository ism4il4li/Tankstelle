package Kraftstoff;

import Database.KraftstoffCRUD;

public class Zapfsaule1 {
	


	
	public Zapfsaule1() {
		
		
		
	}
	public static void benzinE10() {
		KraftstoffCRUD.kraftstoffUpdate("BenzinE10");
		
	}
	public static void benzin95() {
		KraftstoffCRUD.kraftstoffUpdate("Benzin95");
		
	}
	public static void benzinSuperPlus() {
		KraftstoffCRUD.kraftstoffUpdate("SuperPlus");
		
	}
	public static void diesel() {
		KraftstoffCRUD.kraftstoffUpdate("Diesel");
		
	}
	public static void truckDiesel() {
		KraftstoffCRUD.kraftstoffUpdate("TruckDiesel");
		
	}
	public static void autogas() {
		KraftstoffCRUD.kraftstoffUpdate("Autogas");
		
	}
	
	

}
