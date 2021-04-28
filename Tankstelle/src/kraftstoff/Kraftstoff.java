package kraftstoff;

public class Kraftstoff {
	
	private String name;
	private int preisProLiter;
	private int verfuegbar;
	private int verkauft;
	private static final int MEHRWERTSTEUER = 19;
	public Kraftstoff(String name, int preisProLiter, int verfuegbar, int verkauft) {
		this.name = name;
		this.preisProLiter = preisProLiter;
		this.verfuegbar = verfuegbar;
		this.verkauft = verkauft;
		
		
	}

}
