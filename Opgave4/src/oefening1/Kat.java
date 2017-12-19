package oefening1;

public class Kat extends Zoogdier {

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 */
	public Kat(String naam, int lengte, HuidType type) {
		super(naam, lengte, type, 3);
	}
	
	@Override
	public String maakGeluid() {
		// TODO Auto-generated method stub
		return "miauw";
	}

}
