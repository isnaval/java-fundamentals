package java_oop.advanced.electronics_store_system.customers;

public class BusinessCustomer extends Customer {
	private String companyName;
	private String taxId;
	private double creditLimit;
	private double currentCredit;
	private boolean bulkDiscountEligible;

	public BusinessCustomer(String name, String email, String phone, String address, String companyName, String taxId,
			double creditLimit) {
		super(name, email, phone, address);
		this.companyName = companyName;
		this.taxId = taxId;
		this.creditLimit = creditLimit;
		this.currentCredit = 0.0;
		this.bulkDiscountEligible = true;
	}

	@Override
	public double getDiscount() {
		return 8.0;
	}

	public double getBulkDiscount(int quantity) {
		if (!bulkDiscountEligible)
			return 0.0;

		if (quantity >= 50)
			return 20.0;
		if (quantity >= 20)
			return 15.0;
		if (quantity >= 10)
			return 10.0;
		if (quantity >= 5)
			return 5.0;

		return 0.0;
	}

	public boolean canUseCredit(double amount) {
		return (currentCredit + amount) <= creditLimit;
	}

	public void useCredit(double amount) {
		if (canUseCredit(amount)) {
			currentCredit += amount;
		}
	}

	public void payCredit(double amount) {
		currentCredit = Math.max(0, currentCredit - amount);
	}

	@Override
	public void showCustomerInfo() {
		super.showCustomerInfo();
		System.out.println("🏢 INFORMACIÓN EMPRESARIAL:");
		System.out.println("Empresa: " + companyName);
		System.out.println("NIF: " + taxId);
		System.out.println("Límite de crédito: €" + String.format("%.2f", creditLimit));
		System.out.println("Crédito usado: €" + String.format("%.2f", currentCredit));
		System.out.println("Crédito disponible: €" + String.format("%.2f", creditLimit - currentCredit));
		System.out.println("Descuentos por volumen: " + (bulkDiscountEligible ? "Sí" : "No"));
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getTaxId() {
		return taxId;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public double getCurrentCredit() {
		return currentCredit;
	}

	public boolean isBulkDiscountEligible() {
		return bulkDiscountEligible;
	}
}