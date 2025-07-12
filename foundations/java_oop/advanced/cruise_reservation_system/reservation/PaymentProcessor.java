package java_oop.advanced.cruise_reservation_system.reservation;

public class PaymentProcessor {

	public enum PaymentMethod {
		CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER, CASH
	}

	public enum PaymentStatus {
		PENDING, APPROVED, DECLINED, REFUNDED
	}

	public PaymentStatus processPayment(double amount, PaymentMethod method, String details) {
		System.out.printf("💳 Processing payment of €%.2f using %s%n", amount, method);

		if (amount <= 0) {
			System.out.println("❌ Payment declined: Invalid amount");
			return PaymentStatus.DECLINED;
		}

		if (amount > 10000 && method == PaymentMethod.CASH) {
			System.out.println("❌ Payment declined: Cash limit exceeded");
			return PaymentStatus.DECLINED;
		}

		System.out.println("✅ Payment approved!");
		return PaymentStatus.APPROVED;
	}

	public PaymentStatus refundPayment(double amount, String originalTransactionId) {
		System.out.printf("💰 Processing refund of €%.2f for transaction %s%n", amount, originalTransactionId);

		System.out.println("✅ Refund processed successfully!");
		return PaymentStatus.REFUNDED;
	}

	public boolean validatePaymentDetails(PaymentMethod method, String details) {
		switch (method) {
		case CREDIT_CARD:
		case DEBIT_CARD:
			return details != null && details.length() >= 16;
		case BANK_TRANSFER:
			return details != null && details.contains("IBAN");
		case CASH:
			return true;
		default:
			return false;
		}
	}
}