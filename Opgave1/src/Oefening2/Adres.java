package Oefening2;

import java.awt.Window.Type;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Adres {
	private String straatnaam;
	private int huisnummer;
	private String bus;
	private int postcode;
	private String woonplaats;
	
	public Adres() {
		this.straatnaam = "Defaultlaan";
		this.huisnummer = 2;
		this.bus = null;
		this.postcode = 1000;
		this.woonplaats = "Brussel";
	}
	
	public Adres(String straatnaam, int huisnummer, int postcode, String woonplaats) {
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.bus = null;
		this.postcode = verifyPostcode(postcode);
		this.woonplaats = woonplaats;
	}
	
	public Adres(String straatnaam, int huisnummer, String bus, int postcode, String woonplaats) {
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.bus = bus;
		this.postcode = verifyPostcode(postcode);
		this.woonplaats = woonplaats;
	}
	
	public String getStraatnaam() {
		return this.straatnaam;
	}
	
	public void setStraatnaam(String value) {
		this.straatnaam = value;
	}
	
	public int getHuisnummer() {
		return this.huisnummer;
	}
	
	public void setHuisnummer(int value) {
		this.huisnummer = value;
	}
	
	public String getBus() {
		return this.bus;
	}
	
	public void setBus(String value) {
		this.bus = value;
	}
	
	public int getPostcode() {
		return this.postcode;
	}
	
	public void setPostcode(int value) {
		this.postcode = verifyPostcode(value);
	}
	
	public String getWoonplaats() {
		return this.woonplaats;
	}
	
	public void setWoonplaats(String value) {
		this.woonplaats = value;
	}
	
	public String toString() {
		return straatnaam + " " + huisnummer + " " + ((bus==null) ? "" : "bus " + bus) + "\n" + 
	postcode + " " + woonplaats;
	}
	
	private int verifyPostcode(int nummer) {
		boolean check = nummer>=1000 && nummer <10000;
		if(!check) {
			System.out.println(nummer + " is geen geldig nummer. Default van 1000 ingesteld");
			return 1000;
		}
		return nummer;
	}
	
	public static void main(String str[]) {
		Adres adreswithoutcon = new Adres();
		
		Adres adreswithcorrectcon = new Adres("Koekhoven", 12, 2310, "Rijkevorsel");
		Adres adreswithcorrectcon2 = new Adres("Königsbahn", 7, "B", 4770, "Amel");
		
		Adres adreswithoutcorrectcon = new Adres("Lolbaan", 1, "i", 12, "Bestanistan");
		
		System.out.println(adreswithoutcon);
		System.out.println(adreswithcorrectcon);
		System.out.println(adreswithcorrectcon2);
		System.out.println(adreswithoutcorrectcon);
	}
}
