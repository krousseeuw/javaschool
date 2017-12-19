package oefening1;

public class Kikker extends Amfibie {

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 */
	public Kikker(String naam, int lengte, HuidType type) {
		super(naam, lengte, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int geefTijdOnderWater() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String maakGeluid() {
		
		return "kwak";
	}

}
