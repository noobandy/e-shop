package in.anandm.eshop.accountservice.service;

public class EmailAlreadyInUseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyInUseException(String message) {
		super(message);
		
	}

	
}
