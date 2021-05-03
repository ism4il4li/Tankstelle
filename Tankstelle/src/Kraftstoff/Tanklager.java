package Kraftstoff;

public class Tanklager {
	private static int benzinE10 = 3000;
	private static int benzinE5 = 3000;
	private static int benzinSuperPlus = 3000;
	private static int diesel = 3000;
	private static int dieselLKW = 3000;
	private static int erdgas = 3000;
	private static int autogas = 3000;
	
	public Tanklager() {
		
		
	}

	public static int getBenizinE10() {
		
		return benzinE10;
	}

	public static void setBenizinE10(int benizinE10) {
		benzinE10 =benzinE10- benizinE10;
	}

	public static int getBenizinE5() {
		System.out.println("getBenzinE5: "+ benzinE5);
		return benzinE5;
	}

	public static  void setBenizinE5() {
		benzinE5 -=1;
		System.out.println("setBenzinE5: "+ benzinE5);
	}

	public static int getBenizinSuperPlus() {
		return benzinSuperPlus;
	}

	public static void setBenizinSuperPlus(int benizinSuperPlus) {
		benzinSuperPlus = benizinSuperPlus-1;
	}

	public static int getDiesel() {
		return diesel;
	}

	public static void setDiesel(int diesel) {
		diesel = diesel-1;
	}

	public static int getDieselLKW() {
		return dieselLKW;
	}

	public static void setDieselLKW(int dieselLKW) {
		dieselLKW = dieselLKW-1;
	}

	public static int getErdgas() {
		return erdgas;
	}

	public static void setErdgas(int erdgas) {
		erdgas = erdgas-1;
	}

	public static int getAutogas() {
		return autogas;
	}

	public static void setAutogas(int autogas) {
		autogas = autogas-1;
	}

}
