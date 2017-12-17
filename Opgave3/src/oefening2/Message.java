package oefening2;

import java.util.Date;

import org.omg.PortableInterceptor.ObjectReferenceTemplate;

import java.util.Calendar;

import opgave2.oefening1.Persoon;

public abstract class Message {
	
	private final Date postdatum;
	
	private Persoon persoon;
	
	protected Date uiterste;
	
	protected Message() {
		postdatum = Calendar.getInstance().getTime();
	}
	
	protected Message(Date arguiterste, Persoon issuer) {
		this();
		setPersoon(issuer);
		uiterste = arguiterste;
	}

	public void setPersoon(Persoon issuer) {
		this.persoon = issuer;		
	}

	public Persoon getPersoon() {
		// TODO Auto-generated method stub
		return persoon;
	}

	/**
	 * Deze methode mag niet de echte pointer naar het Date object van postdatum
	 * teruggeven, vandaar de clone
	 * 
	 * @return een kopie van de postdatum
	 */
	public Date getPostdatum() {
		return (Date) postdatum.clone();
	}
	
	/**
	 * We maken hier een Object return type van, omdat nu nog absoluut niet
	 * duidelijk is wat het return type van een message zou kunnen zijn.
	 * 
	 * @return de inhoud van het bericht, als java.lang.Object
	 */
	public abstract Object read();
}
