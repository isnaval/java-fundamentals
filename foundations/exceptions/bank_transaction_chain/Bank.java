package exceptions.bank_transaction_chain;

public class Bank {

	public String processTransaction(String accountNumber, double amount)
			throws ATMErrorException, BankErrorException, ServerErrorException, DatabaseErrorException {

		System.out.println("🏛️ Bank: Validating account " + accountNumber + "...");

		if (accountNumber.length() != 5) {
			throw new ATMErrorException("Invalid account number format");

		}

		Server server = new Server();

		try {
			return server.connectToDatabase(accountNumber, amount);

		} catch (ServerErrorException e) {
			System.out.println("🔄 Bank caught server error: " + e.getMessage());
			throw new BankErrorException("Bank cannot process transaction at this time");
		}

	}

}
