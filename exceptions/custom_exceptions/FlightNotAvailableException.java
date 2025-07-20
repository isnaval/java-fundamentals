package exceptions.custom_exceptions;

public class FlightNotAvailableException extends Exception {

	private String flightCode;

	public FlightNotAvailableException(String message, String flightCode) {
		super(message);
		this.flightCode = flightCode;
	}

	public String getFlightCode() {
		return flightCode;
	}

}
