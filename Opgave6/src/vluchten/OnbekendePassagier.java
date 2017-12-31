package vluchten;

public class OnbekendePassagier extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6207444743176343577L;
	
	public OnbekendePassagier() {
		super("Onbekende passagier");
	}
}