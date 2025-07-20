package java_oop.advanced.electronics_store_system.sales;

public class PaymentMethod {
	private String id;
	private String name;
	private String type;
	private boolean requiresVerification;
	private double processingFee;
	private int processingTimeDays;
	private double maxAmount;
	private boolean isActive;

	public PaymentMethod(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.requiresVerification = false;
		this.processingFee = 0.0;
		this.processingTimeDays = 0;
		this.maxAmount = Double.MAX_VALUE;
		this.isActive = true;
	}

	public static PaymentMethod createCash() {
		PaymentMethod cash = new PaymentMethod("CASH", "Efectivo", "CASH");
		cash.setMaxAmount(2000.0);
		return cash;
	}

	public static PaymentMethod createCreditCard() {
		PaymentMethod creditCard = new PaymentMethod("CREDIT", "Tarjeta de Crédito", "CARD");
		creditCard.setRequiresVerification(true);
		creditCard.setProcessingFee(1.5);
		return creditCard;
	}

	public static PaymentMethod createDebitCard() {
		PaymentMethod debitCard = new PaymentMethod("DEBIT", "Tarjeta de Débito", "CARD");
		debitCard.setRequiresVerification(true);
		debitCard.setProcessingFee(0.8);
		return debitCard;
	}

	public static PaymentMethod createBankTransfer() {
		PaymentMethod transfer = new PaymentMethod("TRANSFER", "Transferencia Bancaria", "TRANSFER");
		transfer.setProcessingTimeDays(1);
		transfer.setProcessingFee(0.5);
		return transfer;
	}

	public static PaymentMethod createDigitalWallet() {
		PaymentMethod digital = new PaymentMethod("DIGITAL", "Billetera Digital", "DIGITAL");
		digital.setRequiresVerification(true);
		digital.setProcessingFee(2.0);
		return digital;
	}

	public boolean canProcessAmount(double amount) {
		return isActive && amount <= maxAmount && amount > 0;
	}

	public double calculateProcessingFee(double amount) {
		return amount * (processingFee / 100);
	}

	public double calculateTotalWithFee(double amount) {
		return amount + calculateProcessingFee(amount);
	}

	public void showPaymentMethodInfo() {
		System.out.println("💳 INFORMACIÓN DEL MÉTODO DE PAGO:");
		System.out.println("==================================");
		System.out.println("Nombre: " + name);
		System.out.println("Tipo: " + type);
		System.out.println("Verificación requerida: " + (requiresVerification ? "Sí" : "No"));
		System.out.printf("Comisión: %.2f%%%n", processingFee);
		System.out.println(
				"Tiempo de procesamiento: " + (processingTimeDays == 0 ? "Inmediato" : processingTimeDays + " días"));
		System.out.printf("Monto máximo: €%.2f%n", maxAmount);
		System.out.println("Estado: " + (isActive ? "Activo" : "Inactivo"));
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public boolean isRequiresVerification() {
		return requiresVerification;
	}

	public double getProcessingFee() {
		return processingFee;
	}

	public int getProcessingTimeDays() {
		return processingTimeDays;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setRequiresVerification(boolean requiresVerification) {
		this.requiresVerification = requiresVerification;
	}

	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}

	public void setProcessingTimeDays(int processingTimeDays) {
		this.processingTimeDays = processingTimeDays;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return String.format("%s (%s) - Comisión: %.1f%%", name, type, processingFee);
	}
}