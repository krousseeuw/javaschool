package oefening3;

import opgave2.oefening1.Persoon;

public class Volmachthouder extends Persoon implements Comparable<Volmachthouder>  {

	public Volmachthouder() {
		// TODO Auto-generated constructor stub
	}
	
	public Volmachthouder(String naam, String achternaam) {
		super(naam, achternaam);
	}
	
	@Override
	public int compareTo(Volmachthouder o) {
		return this.getAchternaam().compareTo(o.getAchternaam());
	}

}
