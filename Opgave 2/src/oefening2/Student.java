package oefening2;

import java.awt.List;

import oefening1.Persoon;

public class Student extends Persoon {

	private String specialisatie;
	
	private int studentennummer;
	
	public Student(String voornaam, String achternaam) {
		super(voornaam, achternaam);
		}
	
	public int getStudentnummer() {
		return this.studentennummer;
	}
	
	public void setStudentnummer(int studentnummer) {
		this.studentennummer = studentnummer;
	}
	
	public String getSpecialisatie() {
		return this.specialisatie;
	}
	
	public void setSpecialisatie(String specialisatie) {
		this.specialisatie = specialisatie;
	}
	
	public String toString() {
		return super.toString() +
				"\n\t\tstudentnummer: " + this.studentennummer + 
				"\n\t\tspecialisatie: " + this.specialisatie;		
	}
	
}
