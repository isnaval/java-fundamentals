package java_oop.advanced.electronics_store_system.inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java_oop.advanced.electronics_store_system.products.Product;

public class Stock {
	private Product product;
	private int currentQuantity;
	private int reservedQuantity;
	private int minimumQuantity;
	private Supplier supplier;
	private LocalDateTime lastRestocked;
	private List<StockMovement> movements;

	public Stock(Product product, int initialQuantity, Supplier supplier) {
		this.product = product;
		this.currentQuantity = initialQuantity;
		this.reservedQuantity = 0;
		this.minimumQuantity = 5;
		this.supplier = supplier;
		this.lastRestocked = LocalDateTime.now();
		this.movements = new ArrayList<>();

		addMovement("INICIAL", initialQuantity, "Stock inicial");
	}

	public boolean reduceQuantity(int quantity) {
		if (currentQuantity >= quantity) {
			currentQuantity -= quantity;
			return true;
		}
		return false;
	}

	public void addQuantity(int quantity) {
		currentQuantity += quantity;
		lastRestocked = LocalDateTime.now();
	}

	public boolean reserveQuantity(int quantity) {
		if (getAvailableQuantity() >= quantity) {
			reservedQuantity += quantity;
			return true;
		}
		return false;
	}

	public void releaseReservation(int quantity) {
		reservedQuantity = Math.max(0, reservedQuantity - quantity);
	}

	public int getAvailableQuantity() {
		return currentQuantity - reservedQuantity;
	}

	public boolean needsRestock() {
		return currentQuantity <= minimumQuantity;
	}

	public int getRecommendedRestockQuantity() {
		if (needsRestock()) {
			return Math.max(50, minimumQuantity * 3) - currentQuantity;
		}
		return 0;
	}

	public void addMovement(String type, int quantity, String reason) {
		movements.add(new StockMovement(type, quantity, reason, LocalDateTime.now()));
	}

	public void showStockDetails() {
		System.out.println("📦 DETALLES DEL STOCK:");
		System.out.println("=====================");
		System.out.println("Producto: " + product.getBrand() + " " + product.getModel());
		System.out.println("Stock actual: " + currentQuantity);
		System.out.println("Stock reservado: " + reservedQuantity);
		System.out.println("Stock disponible: " + getAvailableQuantity());
		System.out.println("Stock mínimo: " + minimumQuantity);
		System.out.println("Proveedor: " + supplier.getName());
		System.out.println("Última reposición: " + lastRestocked);
		System.out.println("¿Necesita reposición? " + (needsRestock() ? "SÍ" : "NO"));

		if (needsRestock()) {
			System.out.println("Cantidad recomendada: " + getRecommendedRestockQuantity());
		}
	}

	public void showMovementHistory() {
		System.out.println("\n📋 HISTORIAL DE MOVIMIENTOS:");
		System.out.println("============================");
		for (StockMovement movement : movements) {
			System.out.printf("%s | %s: %d | %s%n", movement.getDateTime().toLocalDate(), movement.getType(),
					movement.getQuantity(), movement.getReason());
		}
	}

	// Getters y Setters
	public Product getProduct() {
		return product;
	}

	public int getCurrentQuantity() {
		return currentQuantity;
	}

	public int getReservedQuantity() {
		return reservedQuantity;
	}

	public int getMinimumQuantity() {
		return minimumQuantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public LocalDateTime getLastRestocked() {
		return lastRestocked;
	}

	public List<StockMovement> getMovements() {
		return new ArrayList<>(movements);
	}

	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public static class StockMovement {
		private String type;
		private int quantity;
		private String reason;
		private LocalDateTime dateTime;

		public StockMovement(String type, int quantity, String reason, LocalDateTime dateTime) {
			this.type = type;
			this.quantity = quantity;
			this.reason = reason;
			this.dateTime = dateTime;
		}

		// Getters
		public String getType() {
			return type;
		}

		public int getQuantity() {
			return quantity;
		}

		public String getReason() {
			return reason;
		}

		public LocalDateTime getDateTime() {
			return dateTime;
		}
	}
}
