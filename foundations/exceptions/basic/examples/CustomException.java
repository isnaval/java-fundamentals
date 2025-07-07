package exceptions.basic.examples;

public class CustomException {
	public static void main(String[] args) {

		BankAccount account = new BankAccount(1000);

		try {
			account.withdraw(500);
			System.out.println("Retiro exitoso. Saldo: " + account.getBalance());
			account.withdraw(600);
		} catch (InsufficientFundsException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("Saldo disponible: " + e.getAvailableBalance());
			System.out.println("Monto intentado: " + e.getRequestedAmount());
		}
	}

	public static class InsufficientFundsException extends Exception {
		private double availableBalance;
		private double requestedAmount;

		public InsufficientFundsException(double available, double requested) {
			super("Fondos insuficientes: solicitado " + requested + ", disponible " + available);
			this.availableBalance = available;
			this.requestedAmount = requested;
		}

		public double getAvailableBalance() {
			return availableBalance;
		}

		public double getRequestedAmount() {
			return requestedAmount;
		}
	}

	public static class BankAccount {
		private double balance;

		public BankAccount(double initialBalance) {
			this.balance = initialBalance;
		}

		public void withdraw(double amount) throws InsufficientFundsException {
			if (amount > balance) {
				throw new InsufficientFundsException(balance, amount);
			}
			balance -= amount;
		}

		public double getBalance() {
			return balance;
		}
	}
}
