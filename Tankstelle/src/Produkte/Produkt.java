package Produkte;

public class Produkt {
	private String name;
	private float  preis;
	private int  menge;
	private int mwst;
	/**
	 * 
	 * @param name :String
	 * @param preis :float
	 * @param menge :int
	 * @param mwst :int
	 */
	public Produkt(String name,float preis,int menge,int mwst) {
		this.name = name;
		this.preis=preis;
		this.menge = menge;
		this.mwst = mwst;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public int getMwst() {
		return mwst;
	}

	public void setMwst(int mwst) {
		this.mwst = mwst;
	}

}
