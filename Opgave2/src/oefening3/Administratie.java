package oefening3;

import java.awt.im.InputContext;
import java.util.ArrayList;

import oefening1.Persoon;
import oefening2.Administrateur;
import oefening2.Docent;
import oefening2.Student;
import voorbeeld.Input;

public class Administratie {
	public static void main(String[] args) {
		ArrayList<Persoon> personen = new ArrayList<Persoon>();
		String invoer = null;
		do {
			Persoon persoon = null;
			invoer = Input
					.readString("Wil je een student, docent of administrateur invoeren? (S/D/A)");
			
			if(invoer.equalsIgnoreCase("S") || invoer.equalsIgnoreCase("D") || invoer.equalsIgnoreCase("A"))
			{
				String naam = Input.readString("Naam?");
				String voornaam = Input.readString("Voornaam?");
				System.out.println(invoer);
				
				switch(invoer.toUpperCase())
				{
				case "S": persoon = new Student(voornaam, naam);
				break;				
				case "D": persoon = new Docent(voornaam, naam);
				break;
				case "A": persoon = new Administrateur(voornaam, naam);
				break;					
				}
				
				personen.add(persoon);
			}
		} while(!invoer.equalsIgnoreCase(""));
		
		System.out.println(Persoon.getAantalGemaaktePersonen());
		for(Persoon persoon : personen) {
			System.out.println(persoon);
		}
	}
}
