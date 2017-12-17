package opgave2.oefening2;

import opgave2.oefening1.Persoon;


public class Personeelslid extends Persoon {
	private Kantoor kantoor;	
	
	public Personeelslid(String voornaam, String achternaam) {
		super(voornaam, achternaam);
		// TODO Auto-generated constructor stub
	}
	
	public Kantoor getKantoor()
	{
		return this.kantoor;
	}
	
	public void setKantoor(Kantoor kantoor) {
		this.kantoor = kantoor;
	}
}
