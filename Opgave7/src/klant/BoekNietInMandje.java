package klant;

public class BoekNietInMandje extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3995372147705838434L;

	public BoekNietInMandje() {
		super("Het boek bevindt zich niet in het mandje!");
	}
}
