package exceptions.basic.bank_transaction_chain;

public class ServerErrorException extends Exception {
	public ServerErrorException(String message) {
		super(message);
	}
}
