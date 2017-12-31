package vluchten;

public class PassagierReedsAanwezig extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5876063521910327599L;
	
	public PassagierReedsAanwezig() {
		super("Passagier is reeds aanwezig op deze vlucht!");
	}
}