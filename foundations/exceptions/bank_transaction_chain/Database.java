package exceptions.bank_transaction_chain;

public class Database {

	public String executeTransaction(String accountNumber, double amount) throws DatabaseErrorException {
		System.out.println("🗄️ Database: Executing transaction...");
		System.out.println("💥 Error! Database not available");

		throw new DatabaseErrorException("Database connection lost");
	}

}
