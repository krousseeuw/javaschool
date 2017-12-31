package passagiers;

import java.util.Date;

public abstract class Passagier implements Comparable<Passagier> {
	private String naam;
	
	private Date opstartdatum;
	
	public Passagier() {
		opstartdatum = new Date();
	}
	
	public Passagier(String naam) {
		this();
		this.naam = naam;
	}
	
	@Override
	public String toString() {
		return naam + " " + this.getClass().getSimpleName();
	}
	
	public abstract void geefSpecifiekeInfo();
	
	public Date getOpstartdatum() {
		return opstartdatum;
	}
	
	@Override
	public int compareTo(Passagier o) {
		return this.naam.compareTo(o.naam);
	}
}
