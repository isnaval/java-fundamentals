package java_oop.advanced.electronics_store_system.employees;

public class SalesAssociate extends Employee {
	private double salesThisMonth;
	private double commissionRate;
	private int customersSatisfied;

	public SalesAssociate(String name, String employeeId, double baseSalary, int experienceYears) {
		super(name, employeeId, baseSalary, "Ventas", experienceYears);
		this.salesThisMonth = 0.0;
		this.commissionRate = 0.03;
		this.customersSatisfied = 0;
	}

	@Override
	public double calculateSalary() {
		double commission = salesThisMonth * commissionRate;
		double experienceBonus = baseSalary * 0.02 * experienceYears;
		return baseSalary + commission + experienceBonus;
	}

	@Override
	public void showResponsibilities() {
		System.out.println("📋 RESPONSABILIDADES:");
		System.out.println("- Atender a los clientes");
		System.out.println("- Realizar ventas");
		System.out.println("- Mantener el área de ventas ordenada");
		System.out.println("- Procesar pagos");
		System.out.println("- Recomendar productos");
	}

	public void recordSale(double amount) {
		salesThisMonth += amount;
		customersSatisfied++;
	}

	public void resetMonthlySales() {
		salesThisMonth = 0.0;
		customersSatisfied = 0;
	}

	// Getters específicos
	public double getSalesThisMonth() {
		return salesThisMonth;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public int getCustomersSatisfied() {
		return customersSatisfied;
	}
}