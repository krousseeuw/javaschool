package opgave2.oefening2;

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
	
	public static void main(String[] args) {
		Adres adres = new Adres("Tienkampstraat", 1, "A", 3650, "Dilsen-Stokkem");
		Kantoor kantoor = new Kantoor(adres, "B", (short) 2);
		Student student1 = new Student("Freya", "Cresent");
		Student student2 = new Student("Richard", "Villiers");
		Student student3 = new Student("Bege", "Capone");
		Docent docent = new Docent("Lwaxana", "Troi");
		docent.teaches(student1);
		docent.teaches(student2);
		docent.teaches(student3);
		docent.setKantoor(kantoor);
		System.out.println("Docent: " + docent.toString());
		for (Student student : docent.getStudenten()) {
			System.out.println(student.toString());
		}
		Administrateur administrateur = new Administrateur("Zidane", "Tribal");
		
	}
}
