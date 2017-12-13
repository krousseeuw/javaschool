package oefening2;

import opgave1.Oefening2.Adres;

public class Kantoor {
	private Adres adres;
	private String gebouw;
	private short verdieping;
	
	public Kantoor(Adres adres, String gebouw, short verdieping) {
		this.adres = adres;
		this.gebouw = gebouw;
		this.verdieping = verdieping;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adres.toString() + "\nGebouw: " + gebouw + "\nVerdieping: " + verdieping; 
	}
}
