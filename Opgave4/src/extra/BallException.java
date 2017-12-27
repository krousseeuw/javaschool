package extra;

public class BallException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3750517084206241696L;

	public BallException(String message) {
		super(message);
	}
	
	public BallException() {
		super("Bal!");
	}
}
