package exceptions.exception_chain_propagation;

@SuppressWarnings("serial")
public class Exception1 extends Exception {
	public Exception1(String errorMessage) {
		super(errorMessage);
	}
}
