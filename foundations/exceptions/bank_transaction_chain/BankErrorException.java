package exceptions.bank_transaction_chain;

public class BankErrorException extends Exception {
	public BankErrorException(String message) {
		super(message);
	}
}
