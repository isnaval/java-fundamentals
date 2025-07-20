package exceptions.basic.bank_transaction_chain;

public class Server {
	public String connectToDatabase(String accountNumber, double amount)
			throws ServerErrorException, DatabaseErrorException {

		System.out.println("🖥️ Server: Connecting to database...");

		Database database = new Database();

		try {
			return database.executeTransaction(accountNumber, amount);

		} catch (DatabaseErrorException e) {
			System.out.println("🔄 Server caught database error: " + e.getMessage());
			throw new ServerErrorException("Server experienced connectivity issues");
		}
	}

}
