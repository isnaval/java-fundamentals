package exceptions.custom_exceptions;

public class ReservationNotFoundException extends Exception {

	private String identifier;

	public ReservationNotFoundException(String message, String identifier) {
		super(message);
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
}