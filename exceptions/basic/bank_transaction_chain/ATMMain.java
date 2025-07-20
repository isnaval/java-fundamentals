package exceptions.basic.bank_transaction_chain;

public class ATMMain {
	public static void main(String[] args) {
		System.out.println("🏦 ===== CAJERO AUTOMÁTICO =====");
		System.out.println("💳 Iniciando transacción...\n");

		Bank bank = new Bank();

		try {
			String result = bank.processTransaction("02345", 100.00);
			System.out.println("✅ " + result);
		} catch (ATMErrorException e) {
			System.out.println("🚨 ATM Error: " + e.getMessage());

		} catch (BankErrorException e) {
			System.out.println("🚨 Bank Error: " + e.getMessage());

		} catch (ServerErrorException e) {
			System.out.println("🚨 Server Error: " + e.getMessage());

		} catch (DatabaseErrorException e) {
			System.out.println("🚨 Database Error: " + e.getMessage());
		}

		System.out.println("\n🏁 Transaction finished.");
	}

}
