package oefening1;

public abstract class Amfibie extends Gewervelden implements IWaterdier {
	/**
	 * 
	 * @param naam
	 * @param lengte
	 * @param type
	 */
	public Amfibie(String naam, int lengte, HuidType type) {
		super(naam, lengte, type);
	}
}
