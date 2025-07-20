package exceptions.exception_chain_propagation;

@SuppressWarnings("serial")
public class Exception2 extends Exception {

	public Exception2(String errorMessage) {
		super(errorMessage);
	}
}
