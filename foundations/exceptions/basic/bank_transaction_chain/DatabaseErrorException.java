package exceptions.basic.bank_transaction_chain;

public class DatabaseErrorException extends Exception {
	public DatabaseErrorException(String message) {
		super(message);
	}
}