package oefening2;

public class Docent extends Personeelslid {
	private String specialisatie;
	
	public Docent(String voornaam, String achternaam) {
		super(voornaam, achternaam);
		// TODO Auto-generated constructor stub
	}
	
	public String getSpecialisatie() {
		return this.specialisatie;
	}
	
	public void setSpecialisatie(String specialisatie) {
		this.specialisatie = specialisatie;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n\t\tSpecialisatie: " + this.specialisatie + "\n\t\tKantoor: " + getKantoor().toString() ;
	}
}
