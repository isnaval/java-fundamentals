package java_oop.advanced.electronics_store_system.sales;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java_oop.advanced.electronics_store_system.customers.Customer;
import java_oop.advanced.electronics_store_system.employees.Employee;

public class Sale {
	private String saleId;
	private LocalDateTime saleDateTime;
	private Customer customer;
	private Employee employee;
	private List<SaleItem> items;
	private double subtotal;
	private double totalDiscount;
	private double taxPercentage;
	private double taxAmount;
	private double total;
	private PaymentMethod paymentMethod;
	private SaleStatus status;
	private String notes;
	private Receipt receipt;

	public enum SaleStatus {
		PENDING("Pendiente"), COMPLETED("Completada"), CANCELLED("Cancelada"), REFUNDED("Reembolsada");

		private final String description;

		SaleStatus(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	public Sale(String saleId, Customer customer, Employee employee) {
		this.saleId = saleId;
		this.saleDateTime = LocalDateTime.now();
		this.customer = customer;
		this.employee = employee;
		this.items = new ArrayList<>();
		this.taxPercentage = 21.0;
		this.status = SaleStatus.PENDING;
		this.notes = "";
		calculateTotals();
	}

	public void addItem(SaleItem item) {
		items.add(item);
		calculateTotals();

		System.out.printf("✅ Agregado: %s%n", item.toString());
	}

	public void removeItem(SaleItem item) {
		if (items.remove(item)) {
			calculateTotals();
			System.out.printf("❌ Eliminado: %s%n", item.toString());
		}
	}

	public void updateItemQuantity(int itemIndex, int newQuantity) {
		if (itemIndex >= 0 && itemIndex < items.size()) {
			items.get(itemIndex).updateQuantity(newQuantity);
			calculateTotals();
		}
	}

	public void applyGlobalDiscount(double discountPercentage) {
		for (SaleItem item : items) {
			item.applyDiscount(discountPercentage);
		}
		calculateTotals();

		System.out.printf("💰 Descuento aplicado: %.1f%% a toda la venta%n", discountPercentage);
	}

	private void calculateTotals() {
		subtotal = items.stream().mapToDouble(SaleItem::getLineTotal).sum();
		totalDiscount = items.stream().mapToDouble(SaleItem::getDiscountAmount).sum();
		taxAmount = subtotal * (taxPercentage / 100);
		total = subtotal + taxAmount;
	}

	public void completeSale(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
		this.status = SaleStatus.COMPLETED;

		this.receipt = new Receipt(this);

		if (customer != null) {
			StringBuilder purchaseInfo = new StringBuilder();
			for (SaleItem item : items) {
				purchaseInfo.append(item.getQuantity()).append("x ").append(item.getProduct().getModel()).append("; ");
			}
			customer.addPurchase(purchaseInfo.toString(), total);
		}

		System.out.printf("✅ Venta completada: %s - Total: €%.2f%n", saleId, total);
	}

	public void cancelSale(String reason) {
		this.status = SaleStatus.CANCELLED;
		this.notes = "Cancelada: " + reason;

		System.out.printf("❌ Venta cancelada: %s - Razón: %s%n", saleId, reason);
	}

	public void refundSale(String reason) {
		if (status == SaleStatus.COMPLETED) {
			this.status = SaleStatus.REFUNDED;
			this.notes = "Reembolsada: " + reason;

			System.out.printf("💰 Venta reembolsada: %s - Razón: %s%n", saleId, reason);
		}
	}

	public void showSaleDetails() {
		System.out.println("🧾 DETALLE DE LA VENTA:");
		System.out.println("=======================");
		System.out.println("ID Venta: " + saleId);
		System.out.println("Fecha: " + saleDateTime.toLocalDate());
		System.out.println("Hora: " + saleDateTime.toLocalTime());
		System.out.println("Cliente: " + (customer != null ? customer.getName() : "Sin registro"));
		System.out.println("Empleado: " + employee.getName());
		System.out.println("Estado: " + status.getDescription());

		System.out.println("\nArtículos:");
		for (int i = 0; i < items.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, items.get(i).toString());
		}

		System.out.println("\n" + "=".repeat(40));
		System.out.printf("Subtotal: €%.2f%n", subtotal);
		if (totalDiscount > 0) {
			System.out.printf("Descuentos: -€%.2f%n", totalDiscount);
		}
		System.out.printf("IVA (%.1f%%): €%.2f%n", taxPercentage, taxAmount);
		System.out.printf("TOTAL: €%.2f%n", total);

		if (paymentMethod != null) {
			System.out.println("Método de pago: " + paymentMethod.getName());
		}

		if (!notes.isEmpty()) {
			System.out.println("Notas: " + notes);
		}
	}

	// Getters
	public String getSaleId() {
		return saleId;
	}

	public LocalDateTime getSaleDateTime() {
		return saleDateTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public List<SaleItem> getItems() {
		return new ArrayList<>(items);
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public double getTotal() {
		return total;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public String getNotes() {
		return notes;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
		calculateTotals();
	}
}
