package oefening1;

public abstract class Dier implements Comparable<Dier> {
	protected String geluid;
	private String naam;
	private static int aantal;
	private final int code;
	private int leeftijd;
	public Dier() {
		code = Dier.aantal;
		Dier.aantal++;
		naam = "Joeri";
	}
	public Dier(String naam) {
		this();
		this.naam = naam;
	}
	public abstract String maakGeluid();
}
