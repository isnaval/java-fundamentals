package java_oop.advanced.electronics_store_system.sales;

import java_oop.advanced.electronics_store_system.products.Product;

public class SaleItem {
	private Product product;
	private int quantity;
	private double unitPrice;
	private double discountPercentage;
	private double discountAmount;
	private double lineTotal;
	private String notes;

	public SaleItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = product.getPrice();
		this.discountPercentage = 0.0;
		this.discountAmount = 0.0;
		this.notes = "";
		calculateLineTotal();
	}

	public SaleItem(Product product, int quantity, double customPrice) {
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = customPrice;
		this.discountPercentage = 0.0;
		this.discountAmount = 0.0;
		this.notes = "";
		calculateLineTotal();
	}

	public void applyDiscount(double discountPercentage) {
		this.discountPercentage = discountPercentage;
		this.discountAmount = (unitPrice * quantity) * (discountPercentage / 100);
		calculateLineTotal();
	}

	public void applyFixedDiscount(double discountAmount) {
		this.discountAmount = discountAmount;
		this.discountPercentage = (discountAmount / (unitPrice * quantity)) * 100;
		calculateLineTotal();
	}

	private void calculateLineTotal() {
		double subtotal = unitPrice * quantity;
		lineTotal = subtotal - discountAmount;
	}

	public void updateQuantity(int newQuantity) {
		this.quantity = newQuantity;
		calculateLineTotal();
	}

	public void updateUnitPrice(double newPrice) {
		this.unitPrice = newPrice;
		calculateLineTotal();
	}

	public double getSubtotal() {
		return unitPrice * quantity;
	}

	public void showItemDetails() {
		System.out.println("🛒 DETALLE DEL ARTÍCULO:");
		System.out.println("========================");
		System.out.println("Producto: " + product.getBrand() + " " + product.getModel());
		System.out.println("Cantidad: " + quantity);
		System.out.printf("Precio unitario: €%.2f%n", unitPrice);
		System.out.printf("Subtotal: €%.2f%n", getSubtotal());

		if (discountAmount > 0) {
			System.out.printf("Descuento (%.1f%%): -€%.2f%n", discountPercentage, discountAmount);
		}

		System.out.printf("Total línea: €%.2f%n", lineTotal);

		if (!notes.isEmpty()) {
			System.out.println("Notas: " + notes);
		}
	}

	// Getters y Setters
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return String.format("%dx %s %s - €%.2f", quantity, product.getBrand(), product.getModel(), lineTotal);
	}
}