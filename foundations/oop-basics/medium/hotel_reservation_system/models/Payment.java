package java_oop.medium.hotel_reservation_system.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
	private final String id;
	private final String reservationId;
	private double amount;
	private PaymentMethod paymentMethod;
	private PaymentStatus status;
	private LocalDateTime paymentDate;
	private String transactionReference;
	private String notes;

	public enum PaymentMethod {
		CASH("Efectivo"), CREDIT_CARD("Tarjeta de crédito"), DEBIT_CARD("Tarjeta de débito"),
		BANK_TRANSFER("Transferencia bancaria"), PAYPAL("PayPal"), OTHER("Otro");

		private final String displayName;

		PaymentMethod(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

	public enum PaymentStatus {
		PENDING("Pendiente"), COMPLETED("Completado"), FAILED("Fallido"), REFUNDED("Reembolsado"),
		PARTIALLY_REFUNDED("Parcialmente reembolsado");

		private final String displayName;

		PaymentStatus(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

	public Payment(String reservationId, double amount, PaymentMethod paymentMethod) {
		this.id = UUID.randomUUID().toString();
		this.reservationId = reservationId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = PaymentStatus.PENDING;
		this.paymentDate = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public String getReservationId() {
		return reservationId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return String.format("Payment[id=%s, reservation=%s, amount=%.2f, method=%s, status=%s]", id, reservationId,
				amount, paymentMethod.getDisplayName(), status.getDisplayName());
	}
}