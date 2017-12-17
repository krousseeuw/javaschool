package opgave2.oefening2;

import java.util.ArrayList;
import opgave2.oefening1.Persoon;


public class Administrateur extends Personeelslid {
	private String departement;
	
	
	public Administrateur(String voornaam, String achternaam) {	
		super(voornaam, achternaam);
		// TODO Auto-generated constructor stub
	}
		
	public String getDepartement() {
		return this.departement;
	}
	
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	protected boolean wijzigBureau(Persoon persoon, Kantoor kantoor) {
		if (persoon instanceof Personeelslid) {
			((Personeelslid)persoon).setKantoor(kantoor);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n\t\tDepartement: " + this.departement;
	}
}