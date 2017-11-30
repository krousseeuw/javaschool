package Oefening1;

import java.util.List;
import java.util.ArrayList;

public class Cirkel {
	
	private Kleur kleur;
	private double straal;
	
	//Kleur
	public enum Kleur{
		WIT,
		GEEL,
		ROOD,
		BLAUW,
		ZWART
	}
	
	public Cirkel() {
		this.straal = 0;
		this.kleur = Kleur.WIT;		
	}
	
	public Cirkel(double straal) {
		this.straal = straal;
		this.kleur = Kleur.WIT;		
	}
	
	public Cirkel(Kleur kleur) {
		this.straal = 0;
		this.kleur = kleur;
	}
	
	public Cirkel(Cirkel cirkel) {
		this.straal = cirkel.straal;
		this.kleur = cirkel.kleur;		
	}
	
	public Cirkel(double straal, Kleur kleur) {
		this.straal = straal;
		this.kleur = kleur;		
	}
		
	//tostring
	public String toString()
	{
		return "Cirkel met een straal van " + this.straal +" en de kleur: " + kleur;
	}
	
	//geefomtrek
	public Double geefOmtrek() {
		Double result = 2 * Math.PI * straal;
		return result;
	}
	
	//geefoppervlakte
	public Double geefOppervlakte() {
		Double result = Math.PI * straal * straal;
		return result;
	}
	
	public static void main(String[] args) {
		List<Cirkel> cirkellist = new ArrayList<Cirkel>(5);
		cirkellist.add(new Cirkel());
		cirkellist.add(new Cirkel(2));
		cirkellist.add(new Cirkel(Kleur.BLAUW));
		
		Cirkel cirkeltocopy = new Cirkel(3, Kleur.ROOD);
		Cirkel cirkelcopy = new Cirkel(cirkeltocopy);
		
		cirkellist.add(cirkeltocopy);
		cirkellist.add(cirkelcopy);
		
		for (int i = 0; i < cirkellist.size(); i++) {
		System.out.println("Cirkel: "+(i+1));
		System.out.println(cirkellist.get(i).toString());
		System.out.print("Omtrek: ");
		System.out.println(cirkellist.get(i).geefOmtrek());
		System.out.print("Oppervlakte:");
		System.out.println(cirkellist.get(i).geefOppervlakte());
		System.out.println("---------------------------------------------");
		System.out.println();
	}
}
}
