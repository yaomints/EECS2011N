package A1;

public class InvalidWindowException extends Exception {

	/**
	 *  Throw exception if invariant is not satisfied
	 */
	private static final long serialVersionUID = 1L;
	public InvalidWindowException(String ex) {
		super(ex);
	}
	
}
