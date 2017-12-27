package opgave2.oefening1;

import java.util.jar.Attributes.Name;

import opgave1.oefening2.Adres;

public class Persoon {
	private String voornaam;
	private String achternaam;
	private String telefoon;
	private Adres adres;
	private static int aantalGemaaktePersonen;
	
	public Persoon() {
		aantalGemaaktePersonen++;
	}
	
	public Persoon(String voornaam, String achternaam) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		Persoon.aantalGemaaktePersonen++;
	}
	
	public String getVoornaam() {
		return this.voornaam;
	}
	
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
	public String getAchternaam() {
		return this.achternaam;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoon = telefoonnummer;
	}
	
	public String getTelefoonnummer() {
		return this.telefoon;
	}
	
	public String getAdresLine() {
		if(this.adres != null) {
			return adres.toString();
		}
		
		return "Geen adres";
	}
	
	public static int getAantalGemaaktePersonen() {
		return Persoon.aantalGemaaktePersonen;
	}
	
	public String toString() {
		return voornaam + " " + achternaam;
	}
	
	public boolean equals(Persoon persoon) {
		if(this == persoon) {
			return true;
		}
		
		if(persoon.achternaam == this.achternaam)
		{
			if(persoon.voornaam == this.voornaam) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Generates and returns a hashCode based on the achternaam and voornaam fields
	 * 
	 * @return integer hashcode
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achternaam==null)?0:achternaam.hashCode());
		result = prime * result + ((voornaam==null)?0:voornaam.hashCode());
		return result;
	}
	
	public static void main(String[] args) {
		Adres adres1 = new Adres("Sint-Maartenbergstraat", 130, 3581, "Beringen");
		Adres adres2 = new Adres("Kleine Katsweg", 56, 9990, "Maldegem");
		Persoon persoon1 = new Persoon("Yin", "Hui Shang");
		persoon1.setAdres(adres1);
		Persoon persoon2 = new Persoon("Mauricio", "El Arminio");
		persoon2.setAdres(adres1);		
		Persoon persoon3 = new Persoon("Yin", "Shang");
		persoon3.setAdres(adres2);
		Persoon persoon4 = new Persoon("Mauricio", "El Arminio");
		persoon4.setAdres(adres2);
		
		System.out.println(persoon1.toString());
		System.out.println(persoon2.getAdresLine());
		System.out.println(persoon1.toString() + " is gelijk aan " + persoon3.toString() + ": " + persoon1.equals(persoon3));
		System.out.println(persoon1.toString() + " is gelijk aan " + persoon2.toString() + ": " + persoon1.equals(persoon2));
		System.out.println(persoon2.toString() + " is gelijk aan " + persoon4.toString() + ": " + persoon2.equals(persoon4));
		System.out.println("Aantal personen: " + Persoon.getAantalGemaaktePersonen());
	}
}
