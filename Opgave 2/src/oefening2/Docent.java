package oefening2;

import java.util.ArrayList;

public class Docent extends Personeelslid {
	private String specialisatie;
	private ArrayList<Student> studenten = new ArrayList<Student>();

	public Docent(String voornaam, String achternaam) {
		super(voornaam, achternaam);
		// TODO Auto-generated constructor stub
	}
	
	public void teaches (Student student) {
		this.studenten.add(student);
	}
	
	public ArrayList<Student> getStudenten(){
		return this.studenten;
	}
	
	public void setStudenten(ArrayList<Student> studenten) {
		this.studenten = studenten;
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
