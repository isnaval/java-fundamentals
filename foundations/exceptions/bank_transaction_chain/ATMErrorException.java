package exceptions.bank_transaction_chain;

public class ATMErrorException extends Exception {
	public ATMErrorException(String message) {
		super(message);
	}
}
